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
public class EmployeeRecord {

	/**
	 * Private variables for employee information
	 */
	private String first_name;
	private String last_name;
	private String address;
	private String phone_number;
	private String employee_ID;
	private String hire_date;
	private char type;
	private String rating;
	private double annual_salary;
	private double annual_earnings;
	private double bonus;
	private double hourly_wage;
	private double hours_worked;
	private double weeks_worked;
	private double sales_amount;
	/**
	 * @return the annual_salary
	 */
	public double getAnnual_salary() {
		return annual_salary;
	}

	/**
	 * @param annual_salary the annual_salary to set
	 */
	public void setAnnual_salary(double annual_salary) {
		this.annual_salary = annual_salary;
	}


	private double sales_commission;



	/**
	 * Default constuctor
	 */
	public EmployeeRecord() {
		this.first_name = "";
		this.last_name = "";
		this.address = "";
		this.phone_number = "";
		this.employee_ID = "";
		this.hire_date = "";
		this.type = 'a';
		//this.annual_earnings = 0;

	}

	/**
	 * Method to generate a ID
	 */
	public String generateID() {
		Random ID = new Random();
		String ID_num = "";

		for(int i = 0; i < 7;i++) {
			ID_num = ID_num + ID.nextInt(9);
		}

		if(getFirst_name().length()>=2) {
			for(int i = 0; i < 2;i++) {
				ID_num = ID_num + getFirst_name().charAt(i);
			}
		}
		else {
			System.out.println("f");
			ID_num = ID_num + getFirst_name();
		}

		if(getLast_name().length()>=3) {
			for(int i = 0; i < 3;i++) {
				ID_num = ID_num + getLast_name().charAt(i);
			}
		}
		else {
			System.out.println("l");
			ID_num = ID_num + getLast_name();
		}
		return ID_num;

	}
	//	/**
	//	 * Method to update annual earnings 
	//	 */
	//	
	//	public double annual_earnings(double add_earning,double bonus) {
	//		annual_earnings = add_earning + (add_earning * bonus);
	//		return annual_earnings;
	//	}

	/**
	 * @return the weeks_worked
	 */
	public double getWeeks_worked() {
		return weeks_worked;
	}

	public void decideAndSetRating(double leastManagerBonus,  double middleManagerBonus,  double maxManagerBonus) {

		if(rating.equals("MA")) {
			bonus = leastManagerBonus ;
		}
		else if(rating.equals("ES")) {
			bonus = middleManagerBonus;
		}
		else if(rating.equals("EA")) {
			bonus = maxManagerBonus;
		}

	}
	/**
	 * @param weeks_worked the weeks_worked to set
	 */
	public void setWeeks_worked(double weeks_worked) {
		this.weeks_worked = weeks_worked;
	}

	/**
	 * @return the sales_amount
	 */
	public double getSales_amount() {
		return sales_amount;
	}

	/**
	 * @param sales_amount the sales_amount to set
	 */
	public void setSales_amount(double sales_amount) {
		this.sales_amount = sales_amount;
	}

	/**
	 * @return the sales_commission
	 */
	public double getSales_commission() {
		return sales_commission;
	}

	/**
	 * @param sales_commission the sales_commission to set
	 */
	public void setSales_commission(double sales_commission) {
		this.sales_commission = sales_commission;
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
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	//	/**
	//	 * @return the annual_earnings
	//	 */
	//	public double getAnnual_earnings() {
	//		return annual_earnings;
	//	}
	//	/**
	//	 * @param annual_earnings the annual_earnings to set
	//	 */
	//	public void setAnnual_earnings(double annual_earnings) {
	//		this.annual_earnings = annual_earnings;
	//	}

	/**
	 * Method to populate the data. Assumes the format
	 * Student name, student ID, address, average
	 */
	public void processRecord(String record) {
		String word[]; 
		word = record.split("/"); //splits input string using "/"
		this.first_name = word[0];
		this.last_name = word[1]; //assigns elements to private data 
		this.address = word[2];
		this.phone_number = word[3]; 
		this.employee_ID = this.generateID();
		this.hire_date = word[4];

		//this.type = word[6].charAt(0);

		if(this.type == 'h') {
			this.hourly_wage =  Double.parseDouble(word[5]);
			this.hours_worked =  Double.parseDouble(word[6]);
			this.weeks_worked = Double.parseDouble(word[7]);
		}

		else if(this.type == 'm') {
			//this.annual_earnings = Double.parseDouble(word[5]);
			this.annual_salary = Double.parseDouble(word[5]);
			this.rating = (word[6]);
		}

		if(this.type == 's') {
			//this.annual_earnings = Double.parseDouble(word[5]);
			this.annual_salary = Double.parseDouble(word[5]);
			this.sales_amount = Double.parseDouble(word[6]);
			this.sales_commission = Double.parseDouble(word[7]);

		}
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the hourly_wage
	 */
	public double getHourly_wage() {
		return hourly_wage;
	}

	/**
	 * @param hourly_wage the hourly_wage to set
	 */
	public void setHourly_wage(double hourly_wage) {
		this.hourly_wage = hourly_wage;
	}

	/**
	 * @return the hours_worked
	 */
	public double getHours_worked() {
		return hours_worked;
	}

	/**
	 * @param hours_worked the hours_worked to set
	 */
	public void setHours_worked(double hours_worked) {
		this.hours_worked = hours_worked;
	}

	@Override
	public String toString() {
		return "EmployeeRecord [first_name=" + first_name + ", Last_name=" + last_name + ", address=" + address
				+ ", phone_number=" + phone_number + ", employee_ID=" + employee_ID + ", hire_date=" + hire_date
				+ ", type=" + type + ", annual_salary=" + annual_salary + "]";
	}

	public String toStringUserFriendly() {
		String output = "";

		output = this.getFirst_name()+ " " 
				+this.getLast_name() + " lives at "
				+this.getAddress() + ".\n Their number is "
				+this.getPhone_number() + ".\n Their ID is "
				+this.getEmployee_ID() + ".\n They were hired on "
				+this.getHire_date() + ".\n They are a ";

		if(this.getType() == 'm') {	
			output += " manager.\n Their rating is ";
			if(this.getRating().equals("MA")) {
				output += " meets expections. ";
			}
			if(this.getRating().equals("ES")) {
				output += " exceeds some expections.";
			}
			if(this.getRating().equals("EA")) {
				output += " exceeds all expections.  ";
			}

		}
		if(this.getType() == 'h') {	
			output += "hourly employee."
					+"\nThey work for $" + this.getHourly_wage() + " an hour for "
					+this.getHours_worked() + " hours a week.\nThey also worked "+ this.getWeeks_worked() 
					+ " weeks for a year";
		}
		
		if(this.getType() == 's') {
			output += "sales employee."
					+"\nThey work for $" + this.getAnnual_salary() + " a year. They sold items worth $"
					+this.getSales_amount() + " for a commsion of " + +this.getSales_commission()*100 + "%";
		}
		if(this.getType() == 's' || this.getType() == 'm') {	
			output+= "\nTheir annual salary is $" + this.getAnnual_salary();
			}
		
		output+="\nTheir total annual earnings is $" + this.getAnnual_earnings();
		//
		return output;
	}


	/**
	 * Method list:
	 * public EmployeeRecord()
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
	 * Self-testing main method
	 */
	public static void main(String[] args) {
		EmployeeRecord name = new EmployeeRecord(); // Create new object

		// Testing ID method----------------------------------------------------------

		name.setFirst_name("Tahoor"); // Set first name

		name.setLast_name("Sheikh"); // Set last name

		name.setEmployee_ID(name.generateID()); // call method to generate employee ID

		System.out.println("The ID is: " + name.getEmployee_ID()); // print employee ID

		// Testing annual earings method----------------------------------------------

		double salary = 100000; // yearly salary 
		double bonus = 0.1;

		//		name.annual_earnings(salary,bonus);
		//
		//		System.out.println(name.getAnnual_earnings());

		// Testing setters and getters------------------------------------------------

		name.setFirst_name("Rahoor"); // Set first name

		name.setLast_name("Kheikh"); // Set last name

		System.out.println(name.getFirst_name()); // print first name

		System.out.println(name.getLast_name()); // print last name

		// ---------------------------------------------------------------------------

		name.setAddress("16 Customeline Drive");

		System.out.println(name.getAddress()); 

		name.setAddress("61 Customeline Drive");

		System.out.println(name.getAddress()); 

		// ---------------------------------------------------------------------------

		name.setPhone_number("416-821-5921");

		System.out.println(name.getPhone_number()); 

		name.setPhone_number("567-9087-6547");

		System.out.println(name.getPhone_number()); 

		// ---------------------------------------------------------------------------

		name.setHire_date("2024/06/23");

		System.out.println(name.getHire_date()); 

		name.setHire_date("2025/07/25");

		System.out.println(name.getHire_date()); 

		// ---------------------------------------------------------------------------

		name.setType('M');

		System.out.println(name.getType()); 

		name.setType('E');

		System.out.println(name.getType()); 

		// ---------------------------------------------------------------------------
	}

}