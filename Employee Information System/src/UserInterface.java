import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Author: Kevin Abeykoon
 * Date: May 11, 2023
 * 	Description: A GUI that allows user to create	
 * 				employee records, enter personal info
 * Method List:
 * 				1. public void recalculateAllEarnings() -> This method recalculates all the earnings of the 
 * 															employees and managers
 * 
 * 				2. public void refreshArrays()          -> This method gets rid of empty spots in arrays by 
 *														   shifting the objects down
 *
 *				3. public int searchArrays(String ID)   -> This method searches all the object arrays for the ID
 *
 *				4. public void refreshTable() 			-> This method refreshes the table after changes to the data
 *
 *				5. public void increaseManagerSize(int newAmountOfIndexes ) 
 *						-> This method increases the max size of the manager array
 *
 *				6. public void increaseHourlySize(int newAmountOfIndexes )
 *						-> This method increases the max size of the hourly employee array
 *
 *				7. public void increaseSalesSize(int newAmountOfIndexes )
 *						-> This method increases the max size of the sales employee array
 *
 *				8. public UserInterface()               -> Constructor to build window
 *
 *				9. public void actionPerformed(ActionEvent e) -> Method to deal with events
 *
 *				10. public static void main(String[] args) -> Main method
 *
 * Citations:
 *			1. https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 *
 * 			
 */

public class UserInterface extends JFrame implements ActionListener{

	//Private data
	EmployeeList employeeList;

	TextPicture title;
	JTextArea outputArea;

	Manager[] managerArray;;
	HourlyEmployee[] hourlyEmployeeArray;;
	SalesEmployee[] salesEmployeeArray;;

	int managerSize, hourlySize, salesSize;
	double currentSalesBonus = 0;
	double maxManagerBonus , middleManagerBonus, leastManagerBonus;

	JButton addBtn, editBtn , removeBtn, sortBtn, searchBtn, bonusBtn,exitBtn ;
	DefaultTableModel dtable;
	JTable jtable;
	JScrollPane scrollPane;

	/*
	 * This method recalculates all the earnings of the employees
	 * and managers. 
	 */
	public void recalculateAllEarnings() {
		//For the manager objects, this sets all the possible bonuses
		// then it calculates the earning
		for(int i  = 0; i < managerSize; i ++) {
			managerArray[i].setRate_1(leastManagerBonus);
			managerArray[i].setRate_2(middleManagerBonus);
			managerArray[i].setRate_3(maxManagerBonus);
			managerArray[i].calculateEarnings();
		}

		//For Hourly Employee
		for(int i  = 0; i < hourlySize; i ++) {
			hourlyEmployeeArray[i].calculateEarnings();
		}

		//For Sales Employee
		for(int i  = 0; i < salesSize; i ++) {
			salesEmployeeArray[i].setSales_commission(currentSalesBonus);
			salesEmployeeArray[i].calculateEarnings();
		}

		// This puts the information into the list
		for(int i  = 0; i < employeeList.getSize(); i ++) {
			//Manager
			if(employeeList.getList()[i].getType() == 'm') {
				employeeList.getList()[i].decideAndSetRating( leastManagerBonus, middleManagerBonus, maxManagerBonus);
				employeeList.getList()[i].setAnnual_earnings(managerArray[i].getAnnual_earnings());
			}
			//Hourly Employee
			else if(employeeList.getList()[i].getType() == 'h') {
				employeeList.getList()[i].setAnnual_earnings(hourlyEmployeeArray[i].getAnnual_earnings());
			}
			//Sales Employee
			else if(employeeList.getList()[i].getType() == 's') {
				employeeList.getList()[i].setSales_commission(currentSalesBonus);
				employeeList.getList()[i].setAnnual_earnings(salesEmployeeArray[i].getAnnual_earnings());
			}
		}
	}


	/*
	 * This method gets rid of empty spots in arrays by shifting the
	 * objects down
	 */
	public void refreshArrays() {
		//Initialing data
		Manager[] newManager = new Manager[managerSize];
		HourlyEmployee[] newHourly = new HourlyEmployee[hourlySize];
		SalesEmployee[] newSales = new SalesEmployee[salesSize];

		//For Manager class, if the first name is not blank
		// then include that record in the new array
		for(int i  = 0; i < managerSize; i ++) {
			if(!managerArray[i].getFirst_name().equals("")) {
				newManager[i] = managerArray[i];
			}
		}

		//For Hourly Employee class
		for(int i  = 0; i < hourlySize; i ++) {
			if(!hourlyEmployeeArray[i].getFirst_name().equals("")) {
				newHourly[i] = hourlyEmployeeArray[i];
			}
		}

		//For Sales Employee class
		for(int i  = 0; i < salesSize; i ++) {
			if(!salesEmployeeArray[i].getFirst_name().equals("")) {
				newSales[i] = salesEmployeeArray[i];
			}
		}

		//Creates a new array the length of the shorted array
		managerArray = new Manager[newManager.length];
		hourlyEmployeeArray = new HourlyEmployee[newHourly.length];
		salesEmployeeArray = new SalesEmployee[newSales.length];

		//sets the old data to the new arrays
		managerArray = newManager;
		hourlyEmployeeArray = newHourly;
		salesEmployeeArray = newSales;

		managerSize = newManager.length;
		hourlySize = newHourly.length;
		salesSize = newSales.length;
	}

	/*
	 * this method searches all the object arrays for the ID
	 */
	public int searchArrays(String ID) {
		//Searches Manager
		for(int i  = 0; i < managerSize; i ++) {
			if(managerArray[i].getEmployee_ID().equals(ID)) {
				return i;
			}
		}
		//Searches Hourly
		for(int i  = 0; i < hourlySize; i ++) {
			if(hourlyEmployeeArray[i].getEmployee_ID().equals(ID)) {
				return i;
			}
		}
		//Searches sales
		for(int i  = 0; i < salesSize; i ++) {
			if(salesEmployeeArray[i].getEmployee_ID().equals(ID)) {
				return i;
			}
		}

		return -1; //If ID not found
	}

	/*
	 * This method refreshes the table after changes to the data
	 */
	public void refreshTable() {
		dtable.setRowCount(0); //Gets rid of rows
		String[] newrecordString = new String[7];
		
		//Creating string[] to insert into table
		for(int i =0; i < employeeList.getSize();i++) {
			newrecordString[0] =	employeeList.getList()[i].getFirst_name();
			newrecordString[1] =		employeeList.getList()[i].getLast_name();
			newrecordString[2] =		employeeList.getList()[i].getAddress();
			newrecordString[3] =		employeeList.getList()[i].getPhone_number();
			newrecordString[4] =		employeeList.getList()[i].getEmployee_ID();
			newrecordString[5] =		String.valueOf(employeeList.getList()[i].getType());
			newrecordString[6] =	employeeList.getList()[i].getHire_date();
			dtable.insertRow(i,newrecordString );// inserts into table
		}
	}

	/*
	 * This method increases the max size of the manager array
	 */
	public void increaseManagerSize(int newAmountOfIndexes ) {
		if(newAmountOfIndexes>managerArray.length) {
			Manager[] tempList = new Manager[newAmountOfIndexes];
			//Transports the old data to the new list
			for(int i =0; i< managerArray.length; i++) {
				tempList[i] = managerArray[i];
			}
			managerArray = tempList;
		}
	}

	/*
	 * This method increases the max size of the hourly employee array
	 */
	public void increaseHourlySize(int newAmountOfIndexes ) {
		if(newAmountOfIndexes>hourlyEmployeeArray.length) {
			HourlyEmployee[] tempList = new HourlyEmployee[newAmountOfIndexes];
			//Transports the old data to the new list
			for(int i =0; i< hourlyEmployeeArray.length; i++) {
				tempList[i] = hourlyEmployeeArray[i];
			}
			hourlyEmployeeArray = tempList;
		}
	}

	/*
	 * This method increases the max size of the sales employee array
	 */
	public void increaseSalesSize(int newAmountOfIndexes ) {
		if(newAmountOfIndexes>salesEmployeeArray.length) {
			SalesEmployee[] tempList = new SalesEmployee[newAmountOfIndexes];
			//Transports the old data to the new list
			for(int i =0; i< salesEmployeeArray.length; i++) {
				tempList[i] = salesEmployeeArray[i];
			}
			salesEmployeeArray = tempList;
		}
	}

	/*
	 * Constructor to build window
	 */
	public UserInterface() {
		super("Employee Tracking Program");
		setSize(1000,700);
		setLayout(null);

		//Initializing all variables
		String columnName[]={"First Name","Last Name","Address","Phone Number", "ID Number", "Employee Type", "Date of Hiring"};        
		String[][] tableArray = new String[0][7];
		title = new TextPicture("Employee Tracking Application", 150, 50);
		outputArea = new  JTextArea();
		outputArea.setEditable(false);

		dtable = new DefaultTableModel(tableArray,columnName);
		jtable = new JTable(dtable);
		scrollPane = new JScrollPane(jtable);
		scrollPane.setBounds(20, 100, 950, 200);
		managerArray = new Manager[10];
		hourlyEmployeeArray = new HourlyEmployee[10];
		salesEmployeeArray = new SalesEmployee[10];
		employeeList = new EmployeeList();
		
		managerSize =0;
		hourlySize = 0;
		salesSize = 0;

		currentSalesBonus = 0;
		maxManagerBonus = 0;
		middleManagerBonus =0;
		leastManagerBonus=0;

		addBtn = new JButton("Add Employee");
		editBtn = new JButton("Edit Information");
		removeBtn = new JButton("Remove Employee");
		sortBtn = new JButton("Sort Information");
		searchBtn = new JButton("Search Information");
		bonusBtn = new JButton("Edit Bonus Values");
		exitBtn = new JButton("Exit");

		
		//Setting bounds to components
		outputArea.setBounds(200, 315, 600, 150);

		title.setBounds(20, 5, 900, 200);
		title.setFont(new Font("Georgia", Font.BOLD, 40));
		title.setColor(Color.BLACK);

		addBtn.setBounds(70, 500, 150,30);
		editBtn.setBounds(300, 500,150,30);
		removeBtn.setBounds(530, 500,150,30);
		sortBtn.setBounds(760, 500,150,30);

		searchBtn.setBounds(200, 560,150,30);
		bonusBtn.setBounds(630, 560,150,30);
		exitBtn.setBounds(420,620,150,30);

		
		//adding buttons to JFrame
		add(addBtn);
		add(editBtn);
		add(removeBtn);
		add(sortBtn);
		add(searchBtn);
		add(bonusBtn);
		add(exitBtn);
		
		add(title);
		add(outputArea);
		add(scrollPane);

		
		//adding acitonlistener
		addBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		sortBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		bonusBtn.addActionListener(this);
		editBtn.addActionListener(this);

		getContentPane().setBackground(new Color(199,223,255)); // changes bg colour

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/*
	 * Method to deal with events
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if(e.getSource() == addBtn ) {
			//Initializing variables
			char type = 'c';
			String input ="";
			String newRecordString ="";
			EmployeeRecord newRecord = new EmployeeRecord();
			
			//Prompts for type of employee
			do {
				input = JOptionPane.showInputDialog(null, "What type of employee?\n"+
						"Enter 'm' for manager\n"+
						"Enter 'h' for hourly employee\n"+
						"Enter 's' for sales employee");
				if(!input.equals("")) {
					type = (input).charAt(0);
				}
			}
			while(type != 'm' && type != 'h' && type != 's');

			newRecord.setType(type);

			//If manager type
			if(newRecord.getType() == 'm') {
				newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
						"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Annual Salary/Rating"+
						"\nFor rating, enter 'MA' for meeting expectations,"
						+"\nenter 'ES' for exceeded some expectations"
						+"\nenter 'EA' for exceeded all expectations",
						"John/Smith/Canada/1231231234/010100/123456/EA");

				//Proccess data and puts it into the manager array and list
				newRecord.processRecord(newRecordString);
				employeeList.add(newRecord);

				increaseManagerSize(managerSize+1); // Increases the size by one to accommodate for the addition
				managerArray[managerSize] = new Manager();
				managerArray[managerSize].setFirst_name(newRecord.getFirst_name());
				managerArray[managerSize].setLast_name(newRecord.getLast_name());
				managerArray[managerSize].setAddress(newRecord.getAddress());
				managerArray[managerSize].setPhone_number(newRecord.getPhone_number());
				managerArray[managerSize].setEmployee_ID(newRecord.getEmployee_ID());
				managerArray[managerSize].setHire_date(newRecord.getHire_date());
				managerArray[managerSize].setAnnual_salary(newRecord.getAnnual_salary());
				managerArray[managerSize].setPerformance_rating(String.valueOf(newRecord.getRating()));
				managerArray[managerSize].calculateEarnings(); // Calculating earnings
				employeeList.getList()[employeeList.getSize()-1].setAnnual_earnings(managerArray[managerSize].getAnnual_earnings());
				managerSize++;// Increasing the size 

			}
			//If hourly type
			else if(newRecord.getType() == 'h') {
				newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
						"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Hourly Wage/Hours Worked per Week/Weeks Worked per Year",
						"Prince/Eric/Under the Sea/9987372/010100/13.5/40/48");

				
				//Proccess data and puts it into the hourly array and list
				newRecord.processRecord(newRecordString);
				employeeList.add(newRecord);

				increaseHourlySize(hourlySize+1);// Increases the size by one to accommodate for the addition
				hourlyEmployeeArray[hourlySize] = new HourlyEmployee();
				hourlyEmployeeArray[hourlySize].setType('h');
				hourlyEmployeeArray[hourlySize].setFirst_name(newRecord.getFirst_name());
				hourlyEmployeeArray[hourlySize].setLast_name(newRecord.getLast_name());
				hourlyEmployeeArray[hourlySize].setAddress(newRecord.getAddress());
				hourlyEmployeeArray[hourlySize].setPhone_number(newRecord.getPhone_number());
				hourlyEmployeeArray[hourlySize].setEmployee_ID(newRecord.getEmployee_ID());
				hourlyEmployeeArray[hourlySize].setHire_date(newRecord.getHire_date());

				hourlyEmployeeArray[hourlySize].setHourly_rate(newRecord.getHourly_wage());
				hourlyEmployeeArray[hourlySize].setHours_worked(newRecord.getHours_worked());
				hourlyEmployeeArray[hourlySize].setWeeks_worked(newRecord.getWeeks_worked());

				hourlyEmployeeArray[hourlySize].calculateEarnings();

				System.out.println(hourlyEmployeeArray[hourlySize].getAnnual_earnings());
				employeeList.getList()[employeeList.getSize()-1].setAnnual_earnings(hourlyEmployeeArray[hourlySize].getAnnual_earnings());

				hourlySize++; // Increases size by one
			}
			// If type is sales
			else if(newRecord.getType() == 's') {
				newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
						"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Annual Earnings/Sales Amount in $/Sales Commision",
						"Joe/Mama/Ohio/234234/2342342/100100/500/0.4");

				// Proccesses data and then puts it into the sales array and list
				newRecord.processRecord(newRecordString);
				employeeList.add(newRecord);

				increaseSalesSize(salesSize+1); // Increases the size by one to accommodate for the addition
				salesEmployeeArray[salesSize] = new SalesEmployee();
				salesEmployeeArray[salesSize].setType('h');
				salesEmployeeArray[salesSize].setFirst_name(newRecord.getFirst_name());
				salesEmployeeArray[salesSize].setLast_name(newRecord.getLast_name());
				salesEmployeeArray[salesSize].setAddress(newRecord.getAddress());
				salesEmployeeArray[salesSize].setPhone_number(newRecord.getPhone_number());
				salesEmployeeArray[salesSize].setEmployee_ID(newRecord.getEmployee_ID());
				salesEmployeeArray[salesSize].setHire_date(newRecord.getHire_date());

				salesEmployeeArray[salesSize].setAnnual_salary(newRecord.getAnnual_salary());
				salesEmployeeArray[salesSize].setSales(newRecord.getSales_amount());
				salesEmployeeArray[salesSize].setSales_commission(newRecord.getSales_commission());

				salesEmployeeArray[salesSize].calculateEarnings();

				employeeList.getList()[employeeList.getSize()-1].setAnnual_earnings(salesEmployeeArray[salesSize].getAnnual_earnings());
				salesSize++; // Increases the size by one
			}


			employeeList.increaseMaxSize(employeeList.getList().length +1); // Increases the size of the list

			refreshTable(); 

			// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< REMOVE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		}
		if(e.getSource() == removeBtn ) {
			//Initialzing variables
			// Prompts for a ID to search for
			String IDToRemove = JOptionPane.showInputDialog(null,"Who do you want to remove? By ID.");
			int index = employeeList.linearSearch(IDToRemove, 'i'); // Searches for the index
			
			//If found
			if(index>=0) {
				//Removes the data from both list and array
				//If a manager
				if(employeeList.getList()[index].getType() =='m') {
					for(int i  = 0; i <managerSize ; i++) {
						if(managerArray[i].getEmployee_ID().equals(IDToRemove)) {
							managerArray[i] = new Manager();
						}
					}
					managerSize--;
				}
				//If a sales employee
				else if(employeeList.getList()[index].getType() =='s') {
					for(int i  = 0; i <salesSize ; i++) {
						if(salesEmployeeArray[i].getEmployee_ID().equals(IDToRemove)) {
							salesEmployeeArray[i] = new SalesEmployee();
						}
					}
					salesSize--;
				}
				//If a hourly employee
				else if(employeeList.getList()[index].getType() =='h') {
					for(int i  = 0; i <hourlySize ; i++) {
						if(hourlyEmployeeArray[i].getEmployee_ID().equals(IDToRemove)) {
							hourlyEmployeeArray[i] = new HourlyEmployee();
						}
					}
					hourlySize--;
				}
				employeeList.remove(employeeList.getList()[index]);
				
				//Refreshing
				refreshArrays();
				refreshTable();
			}
			//If not found
			else {
				outputArea.setText("Remove Unsuccesful!");
			}

		}
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SEARCH >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if(e.getSource() == searchBtn ) {
			//Initializng variables
			//Prompts for the ID
			String IDToSearch = JOptionPane.showInputDialog(null,"Who do you want to search? By ID.");
			int index = employeeList.linearSearch(IDToSearch, 'i'); //Finds the index
			String output="failed";
			
			//If found
			if(index>=0) {
				//Display the user friendly message about the employee
				output = employeeList.getList()[index].toStringUserFriendly();
				outputArea.setText(output);
			}
			//If not found
			else {
				outputArea.setText("Search Unsuccesful!");
			}


		}

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< EDIT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if(e.getSource() == editBtn ) {
			//Initializng variables
			//Prompts for the ID
			String IDToSearch = JOptionPane.showInputDialog(null,"Who do you want to edit? By ID.");
			int index = employeeList.linearSearch(IDToSearch, 'i'), arrayIndex =0;
			String newRecordString = "";
			EmployeeRecord newRecord =  new EmployeeRecord();

			//If found
			if(index>=0) {
				arrayIndex = searchArrays(IDToSearch); // Search index in arrays
				System.out.println(arrayIndex + " id "+ IDToSearch);
				
				//If manager
				if(employeeList.getList()[index].getType() == 'm') {
					
					//Prompts user for new information
					do {
						newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
								"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Annual Salary/Rating"+
								"\nFor rating, enter 'MA' for meeting expectations,"
								+"\nenter 'ES' for exceeded some expectations"
								+"\nenter 'EA' for exceeded all expectations",
								"John/Smith/Canada/1231231234/010100/123456/EA");

					}while(newRecordString.equals(""));

					newRecord.setType('m');
					newRecord.processRecord(newRecordString); 

					//Puts information in to list
					employeeList.getList()[index] = newRecord;
					employeeList.getList()[index].setEmployee_ID(IDToSearch);
					employeeList.getList()[index].setType('m');

					// puts information in array
					managerArray[arrayIndex] = new Manager();
					managerArray[arrayIndex].setFirst_name(newRecord.getFirst_name());
					managerArray[arrayIndex].setLast_name(newRecord.getLast_name());
					managerArray[arrayIndex].setAddress(newRecord.getAddress());
					managerArray[arrayIndex].setPhone_number(newRecord.getPhone_number());
					managerArray[arrayIndex].setEmployee_ID(IDToSearch);
					managerArray[arrayIndex].setHire_date(newRecord.getHire_date());
					managerArray[arrayIndex].setAnnual_salary(newRecord.getAnnual_salary());
					managerArray[arrayIndex].setPerformance_rating(String.valueOf(newRecord.getRating()));
					
					recalculateAllEarnings(); //Recalculates
				}
				
				//If a hourly employee
				if(employeeList.getList()[index].getType() == 'h') {
					//Prompts user for new information
					do {
						newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
								"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Hourly Wage/Hours Worked per Week/Weeks Worked per Year",
								"Prince/Eric/Under the Sea/9987372/010100/13.5/40/32");

					}while(newRecordString.equals(""));

					newRecord.setType('h');
					newRecord.processRecord(newRecordString);

					// puts information into list
					employeeList.getList()[index] = newRecord;
					employeeList.getList()[index].setEmployee_ID(IDToSearch);
					employeeList.getList()[index].setType('h');

					//Puts information into array
					hourlyEmployeeArray[arrayIndex] = new HourlyEmployee();
					hourlyEmployeeArray[arrayIndex].setFirst_name(newRecord.getFirst_name());
					hourlyEmployeeArray[arrayIndex].setLast_name(newRecord.getLast_name());
					hourlyEmployeeArray[arrayIndex].setAddress(newRecord.getAddress());
					hourlyEmployeeArray[arrayIndex].setPhone_number(newRecord.getPhone_number());
					hourlyEmployeeArray[arrayIndex].setEmployee_ID(IDToSearch);
					hourlyEmployeeArray[arrayIndex].setHire_date(newRecord.getHire_date());
					hourlyEmployeeArray[arrayIndex].setHourly_rate(newRecord.getHourly_wage());
					hourlyEmployeeArray[arrayIndex].setHours_worked(newRecord.getHours_worked());
					hourlyEmployeeArray[arrayIndex].setWeeks_worked(newRecord.getWeeks_worked());

					recalculateAllEarnings(); // Recalculates
				}

				if(employeeList.getList()[index].getType() == 's') {
					//Prompts user for new information
					do {
						newRecordString = JOptionPane.showInputDialog(null, "Enter Info:\n"+
								"First Name/Last Name/Address/PhoneNumber/Date of Hiring/Annual Earnings/Sales Amount in $/Sales Commision",
								"Joe/Mama/Ohio/234234/2342342/100100/500/0.4");

					}while(newRecordString.equals(""));

					
					newRecord.setType('s');
					newRecord.processRecord(newRecordString);

					// puts information into list
					employeeList.getList()[index] = newRecord;
					employeeList.getList()[index].setEmployee_ID(IDToSearch);
					employeeList.getList()[index].setType('s');

					//Puts information into array
					salesEmployeeArray[arrayIndex] = new SalesEmployee();
					salesEmployeeArray[arrayIndex].setFirst_name(newRecord.getFirst_name());
					salesEmployeeArray[arrayIndex].setLast_name(newRecord.getLast_name());
					salesEmployeeArray[arrayIndex].setAddress(newRecord.getAddress());
					salesEmployeeArray[arrayIndex].setPhone_number(newRecord.getPhone_number());
					salesEmployeeArray[arrayIndex].setEmployee_ID(IDToSearch);
					salesEmployeeArray[arrayIndex].setHire_date(newRecord.getHire_date());
					salesEmployeeArray[arrayIndex].setAnnual_salary(newRecord.getAnnual_salary());
					salesEmployeeArray[arrayIndex].setSales(newRecord.getSales_amount());
					salesEmployeeArray[arrayIndex].setSales_commission(newRecord.getSales_commission());

					recalculateAllEarnings(); //Recalculates
				}
				
				outputArea.setText("Edit Succesful!"); //Displays message
				refreshTable(); 
			}
			//If unsuccesfull
			else {
				outputArea.setText("Edit Unsuccesful!");
			}

		}
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< EXIT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		//Exits the program
		if(e.getSource() == exitBtn ) {
			System.exit(0);
		}
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< SORT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		//Sorts array by last name
		if(e.getSource() == sortBtn) {
			employeeList.insertionSort();
			refreshTable();
		}
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< BONUS CHANGE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if(e.getSource() == bonusBtn ) {
			//Initializng variables
			char option = 'k',  bonusOption = 'x';
			String input = "";
			
			//prompts for which bonus theyd like to change
			do {
				option = (JOptionPane.showInputDialog(null, "To change the bonus values for managers, enter m\n"
						+ "To change the bonus values for sales employees, enter s"
						+ "To exit, enter x")).charAt(0);

			}while(option != 'x' && option != 'm' && option != 's');

			//if the they chose manager option
			if(option =='m') {
				//prompts for the exact type of manager bonus
				do {
					bonusOption = (JOptionPane.showInputDialog(null, "To change the bonus value for meeting all objectives, enter m\n"
							+ "To change the bonus values for exceeding some objectives, enter s"
							+ "To change the bonus values for exceeding all objectives, enter a")).charAt(0);

				}while(bonusOption != 'a' && bonusOption != 'm' && bonusOption != 's');

				input = JOptionPane.showInputDialog(null, "Enter your new bonus value. In decimal form.");

				//Sets the new value
				if( bonusOption =='a') {
					maxManagerBonus= Double.parseDouble(input);
				}
				else if(bonusOption =='s') {
					middleManagerBonus = Double.parseDouble(input);
				}
				else if (bonusOption =='m') {
					leastManagerBonus = Double.parseDouble(input);
				}

			}
			//If sales option was chcosen
			else if(option =='s') {
				input = JOptionPane.showInputDialog(null, "Enter your new sales commision value. In decimal form.");

				currentSalesBonus= Double.parseDouble(input);


			}
			recalculateAllEarnings(); // recalculates
		}
	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		// Calls constructor
		new UserInterface();
	}
}
