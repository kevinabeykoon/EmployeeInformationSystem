import java.util.Random;

/**
 * 
 */

/**
 * @author Tahoor Sheikh
 * Date: May,2023
 * Description: program will contain employee information name, address, phone number,
 * employee ID, employee type, date of hiring yyyy/mm/dd annual earnings
 * ID should contain 12 characters, 7 randonly generated, 3 letters from last name and 2 lettes from first name
 * class contains access methods for each attribute and a method to calculate and update annual earings 
 *
 */
public class Employee {

	/**
	 * Private variables for employee information
	 */
	private String first_name;
	private String Last_name;
	private String address;
	private String phone_number;
	private String employee_ID;
	private String hire_date;
	private char type;
	private double annual_earnings;

	/**
	 * Default constuctor
	 */
	public Employee() {
		this.first_name = "";
		this.Last_name = "";
		this.address = "";
		this.phone_number = "";
		this.employee_ID = "";
		this.hire_date = "";
		this.type = 0;
		this.annual_earnings = 0;
	}
	
	public String wrongdelete() {
		String output = "s";

		output += this.getFirst_name()+ " " 
				+this.getLast_name() + " lives at "
				+this.getAddress() + ".\n Their number is "
				+this.getPhone_number() + ".\n Their ID is "
				+this.getEmployee_ID() + ".\n They were hired on "
				+this.getHire_date() + ".\n They are a "
				+ this.getType();
		
		output+= "Their total annual earnings is " + this.getAnnual_earnings();
		//
		return output;
	}
	
	/**
	 * Method to generate a ID
	 */
	public String generateID() {
		Random ID = new Random();
		String ID_num = "";
		for(int i = 0; i < 7;i++) {
			ID_num = ID_num + ID.nextInt(9); // generate 7 random numbers from 0-9
		}
		if (getFirst_name().length() > 2 && getLast_name().length() > 3) { // if first name is longer then 2 characters and last name is longer then 3 characters

			for(int i = 0; i < 2;i++) {
				ID_num = ID_num + getFirst_name().charAt(i); // add first 2 letters of first name to id
			}

			for(int i = 0; i < 3;i++) {
				ID_num = ID_num + getLast_name().charAt(i); // add first 3 letters of last name to id
			}
			return ID_num; // return id
		}
		
		else if (getFirst_name().length() < 2 && getLast_name().length() > 3) { // if first name is less then 2 charecters and last name is longer then 3 characters
			ID_num = ID_num + getFirst_name().charAt(0) + "0"; // add the first character of name and 'o' to replace missing character

			for(int i = 0; i < 3;i++) {
				ID_num = ID_num + getLast_name().charAt(i); // add first 3 letters of last name to id
			}
			return ID_num; // return id
		}
		
		else if (getFirst_name().length() > 2 && getLast_name().length() < 3) {// if first name is longer then 2 characters and last name is shorter than 3 characters
			for(int i = 0; i < 2;i++) {
				ID_num = ID_num + getFirst_name().charAt(i);// add first 2 letters of first name to id
			}
			
			if (getLast_name().length() == 2) {
				for(int i = 0; i < 2;i++) {
					ID_num = ID_num + getLast_name().charAt(i);// if last name is 2 characters add those 2 characters and 'o'
				}
				ID_num = ID_num + "0";

			}
			else if(getLast_name().length() == 1) {
				ID_num = ID_num + getLast_name().charAt(0) + "00"; // if last name is 1 character add that character to id and 'oo'
			}
			return ID_num; // return id
		}
		
		else { // else first name and last name is too short
			ID_num = ID_num + getFirst_name().charAt(0) + "0"; // add the first character of name and 'o' to replace missing character

			if (getLast_name().length() == 2) {
				for(int i = 0; i < 2;i++) {
					ID_num = ID_num + getLast_name().charAt(i);// if last name is 2 characters add those 2 characters and 'o'
				}
				ID_num = ID_num + "0";

			}
			else if(getLast_name().length() == 1) {
				ID_num = ID_num + getLast_name().charAt(0) + "00";// if last name is 1 character add that character to id and 'oo'
			}
			return ID_num; //return id
		}
	}
	/**
	 * Method to update annual earnings 
	 */
	public double annual_earnings(double add_earning,double bonus) {
		annual_earnings = add_earning + (add_earning * bonus);
		return annual_earnings;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return Last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}


	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the employee_ID
	 */
	public String getEmployee_ID() {
		return employee_ID;
	}

	/**
	 * @param employee_ID the employee_ID to set
	 */
	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
	}

	/**
	 * @return the hire_date
	 */
	public String getHire_date() {
		return hire_date;
	}

	/**
	 * @param hire_date the hire_date to set
	 */
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}
	/**
	 * @return the annual_earnings
	 */
	public double getAnnual_earnings() {
		return annual_earnings;
	}
	/**
	 * @param annual_earnings the annual_earnings to set
	 */
	public void setAnnual_earnings(double annual_earnings) {
		this.annual_earnings = annual_earnings;
	}
	
	/**
	 * @param annual_earnings the annual_earnings to set
	 */
	public void calculateEarnings(double annual_earnings) {
		this.annual_earnings = annual_earnings;
	}
	/**
	 * Method list:
	 * public Employee()
	 * public String generateID()
	 * public double annual_earnings(double add_earning)
	 * public String getFirst_name()
	 * public void setFirst_name(String first_name)
	 * public String getLast_name()
	 * public void setLast_name(String last_name)
	 * public String getAddress()
	 * public void setAddress(String address)
	 * public String getPhone_number()
	 * public void setPhone_number(String phone_number)
	 * public String getEmployee_ID()
	 * public void setEmployee_ID(String employee_ID)
	 * public String getHire_date() 
	 * public void setHire_date(String hire_date)
	 * public char getType()
	 * public void setType(char type)
	 * public double getAnnual_earnings()
	 * public void setAnnual_Earnings(double annual_earnings)
	 */

	/**
	 * Self-testing main method
	 */
	public static void main(String[] args) {
		Employee name = new Employee(); // Create new object

		// Testing ID method---------------------------------------------------------------------------------------------------------------

		name.setFirst_name("Tahoor"); // Set first name

		name.setLast_name("Sheikh"); // Set last name

		name.setEmployee_ID(name.generateID()); // call method to generate employee ID

		System.out.println("The ID is: " + name.getEmployee_ID()); // print employee ID
		
		//--------------------------------------------------------------------------------------------------------------------------------
		
		name.setFirst_name("T"); // Set first name

		name.setLast_name("Sheikh"); // Set last name

		name.setEmployee_ID(name.generateID()); // call method to generate employee ID

		System.out.println("The ID is: " + name.getEmployee_ID()); // print employee ID
		
		//----------------------------------------------------------------------------------------------------------------------------------
		
		name.setFirst_name("Tahoor"); // Set first name

		name.setLast_name("Sh"); // Set last name

		name.setEmployee_ID(name.generateID()); // call method to generate employee ID

		System.out.println("The ID is: " + name.getEmployee_ID()); // print employee ID
		
		//----------------------------------------------------------------------------------------------------------------------------------
		name.setFirst_name("T"); // Set first name

		name.setLast_name("S"); // Set last name

		name.setEmployee_ID(name.generateID()); // call method to generate employee ID

		System.out.println("The ID is: " + name.getEmployee_ID()); // print employee ID

		// Testing annual earings method---------------------------------------------------------------------------------------------------

		double salary = 100000; // yearly salary 
		double bonus = 0.1;

		name.annual_earnings(salary,bonus);

		System.out.println(name.getAnnual_earnings());

		// Testing setters and getters-----------------------------------------------------------------------------------------------------

		name.setFirst_name("Rahoor"); // Set first name

		name.setLast_name("Kheikh"); // Set last name

		System.out.println(name.getFirst_name()); // print first name

		System.out.println(name.getLast_name()); // print last name

		// --------------------------------------------------------------------------------------------------------------------------------

		name.setAddress("16 Customeline Drive");

		System.out.println(name.getAddress()); 

		name.setAddress("61 Customeline Drive");

		System.out.println(name.getAddress()); 

		// --------------------------------------------------------------------------------------------------------------------------------

		name.setPhone_number("416-821-5921");

		System.out.println(name.getPhone_number()); 

		name.setPhone_number("567-9087-6547");

		System.out.println(name.getPhone_number()); 

		// --------------------------------------------------------------------------------------------------------------------------------

		name.setHire_date("2024/06/23");

		System.out.println(name.getHire_date()); 

		name.setHire_date("2025/07/25");

		System.out.println(name.getHire_date()); 

		// --------------------------------------------------------------------------------------------------------------------------------

		name.setType('M');

		System.out.println(name.getType()); 

		name.setType('E');

		System.out.println(name.getType()); 

		// --------------------------------------------------------------------------------------------------------------------------------
	}

}
