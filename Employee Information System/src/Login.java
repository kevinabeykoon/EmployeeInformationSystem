import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JTextField;

/*
 * @Author: Kevin Abeykoon
 * Date: May 16, 2023
 * Description: A login screen for the Employee Tracking Program. 
 * 				You can only login with the credintials:
 * 				Username: Bob
 * 				Password: School123
 * Method list:
 * 			1.public Login()                                   -> Constructor
 * 			2. public void actionPerformed(ActionEvent e)  -> Deals with events
 * 			3. public void closeWindow() 					-> Closes the login window and opens the next window
 * 			4. public static void main(String[] args)		-> Main method
 * 
 * 			class Keychecker()  
 * 								1.public void keyPressed(KeyEvent event) - > Deals with key events
 * 
 * Citations:
 * 			1.// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
 * 			2. //https://docs.oracle.com/javase/7/docs/api/javax/swing/JPasswordField.html#:~:text=JPasswordField%20is%20a%20lightweight%20component,section%20in%20The%20Java%20Tutorial.
 * 			3. // https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
 */

public class Login extends JFrame implements ActionListener{

	//Declaration of variables
	JPanel welcomeMessage = new JPanel(); 
	JPanel welcomeButtons = new JPanel(); 
	JTextField usernameField = new JTextField(6);
	
	JPasswordField passwordField = new JPasswordField(6); 
	JFrame welcomeScreen = new JFrame();
	JLabel username = new JLabel("Username: "); 
	JLabel password = new JLabel("Password: ");
	String usernameStr = "Bob", passwordStr = "School123", usernameInput = "", passwordInput = ""; 

	JButton enterInfo = new JButton("Enter");
	
	JLabel bglabel = new JLabel (); 
	JLabel companyName = new JLabel ("Employee Information Tracking Database");
	JPanel companyNamePanel =  new JPanel(); 
	
	/*
	 * Constructor
	 */
	public Login() {
		super("Login"); 
		welcomeScreen.setResizable(false); 
		welcomeScreen.setSize(700,684); //Setting the size of the JFrame

		//Adding components to button panel
		welcomeButtons.add(username); 
		welcomeButtons.add(usernameField); 
		welcomeButtons.add(password); 
		welcomeButtons.add(passwordField); 
		welcomeButtons.add(enterInfo);
		bglabel.setIcon(new ImageIcon("loginPicture.png")); // Sets the label to have a gif


		Font myFont = new Font("Sans Serif", Font.BOLD, 30); 
		companyName.setFont(myFont); 
		
		welcomeMessage.setBackground(new Color(208,228,228)); 
		welcomeMessage.add(companyName,BorderLayout.CENTER); 
		welcomeMessage.add(bglabel,BorderLayout.NORTH); 
		welcomeScreen.add(welcomeButtons, BorderLayout.SOUTH);
		welcomeScreen.add(welcomeMessage,BorderLayout.NORTH);

		
		passwordField.addKeyListener(new Keychecker()); //This adds a KeyListener object so check if the user enters the data using the "RETURN" key on the keyboard
		enterInfo.addActionListener(this); 
		
		welcomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeScreen.setVisible(true); 
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//If the user presses the enter button then call the closeWindow() function
		if(e.getSource() == enterInfo) { 
			closeWindow();
		}
	}

	/*
	 * Method to close window
	 */
	public void closeWindow() {
		passwordInput = String.valueOf(passwordField.getPassword()); //Reads and stores the entered usernam. getPassword() is needed for JPasswordField
		usernameInput = usernameField.getText();//Reads and stores the entered password

		//Only if the user enters something in both fields does the window close and move on
		if(usernameStr.equals(usernameInput)&&passwordStr.equals(passwordInput)) {
			welcomeScreen.dispose(); //Closes the screen
			new UserInterface();// Calls the Options() class and creates an object
		}
		//If incorrect login attemp
		else {
			JOptionPane.showMessageDialog(null, "Incorrect login details!");
		}
	}

	/*
	 * Method to deal with key events
	 */
	class Keychecker extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent event) {
			//If the user presses the enter key then...
			if(event.getKeyChar()==KeyEvent.VK_ENTER) {
				//If the user enters anything in both username and password fields, call the closeWindow() function
				if(String.valueOf(passwordField.getPassword())!=""||usernameField.getText()!="") {
					closeWindow(); 
				}
			}
		}
	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		new Login(); // Calls the constructor
	}
}
