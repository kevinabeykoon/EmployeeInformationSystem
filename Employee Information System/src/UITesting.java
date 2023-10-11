/*
 * Author: Kevin Abeykoon
 * Dtae: May 2023
 * Description: This is a tester class.
 * 				For this GUI most of the testing can only be done through
 * 				exploring the GUI. So its hard to test it through code alone
 * 				
 */
public class UITesting {

/*
 * Self testing main method
 */
	public static void main(String[] args) {
	
		UserInterface ui = new UserInterface();
		
		Manager[]  mtest = new Manager[10];
		HourlyEmployee[]  htest = new HourlyEmployee[10];
		SalesEmployee[]  stest = new SalesEmployee[10];
		
		System.out.println(mtest.length +" " + htest.length + " " + stest.length);
		ui.increaseManagerSize(11);
		ui.increaseHourlySize(11);
		ui.increaseSalesSize(11);
		System.out.println(mtest.length +" " + htest.length + " " + stest.length);
		
		System.out.println(ui.searchArrays("0"));
		
		//These methods cannot be tested by code alone,
		// i tested each of them with the GUI
		// and they all worked
		ui.recalculateAllEarnings();
		ui.refreshArrays();
		ui.refreshTable();
		
		

	}

}
