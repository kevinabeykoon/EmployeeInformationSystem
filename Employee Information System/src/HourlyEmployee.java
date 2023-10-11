/**
 * 
 */

/**
 * @author Tahoor Sheikh
 * Date: May,2023
 * Description: is an Employee containing an hourly rate and hours worked as
 * attributes and a method to calculate and update their annual earnings. The maximum number
 * of weeks worked in a year must not exceed 48 weeks. You can assume that each week has 7
 * days, however every hour worked over 40 hours per week must be paid overtime at 1.5 times
 * the hourly rate.
 */
public class HourlyEmployee extends Employee{

	/**
	 * private varibles
	 */
	private double hourly_rate;
	private double hours_worked;
	private double weeks_worked;
	private double annual_salary;

	/**
	 * Default constructor
	 */
	public HourlyEmployee( ) {
		super();
		this.hourly_rate = 0;
		this.hours_worked = 0;
		this.weeks_worked = 0;
		this.annual_salary = 0;
	}

	/**
	 * Method to calculte annual earnings based on weeks worked
	 * 
	 * 8 hours per day
	 * 5 days per week
	 * 40 hours per week
	 * 48 weeks per year
	 * 
	 */
	public  void calculateEarnings() {
		double weekly_earnings = 0;
		double annual_earnings_calc = 0;
		if (weeks_worked <= 48) {
			if (hours_worked <= 40) {
				weekly_earnings = hourly_rate * hours_worked;
				annual_earnings_calc = weekly_earnings * weeks_worked;
			}
			else if (hours_worked > 40) {
				weekly_earnings = hourly_rate * 40 + hourly_rate * 1.5 * (hours_worked-40);
				annual_earnings_calc = weekly_earnings * weeks_worked;			
			}
		}
		 this.setAnnual_earnings(annual_earnings_calc);
		 System.out.println(annual_earnings_calc);
	}
	/**
	 * @return the hourly_rate
	 */
	public double getHourly_rate() {
		return hourly_rate;
	}

	/**
	 * @param hourly_rate the hourly_rate to set
	 */
	public void setHourly_rate(double hourly_rate) {
		this.hourly_rate = hourly_rate;
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

	/**
	 * @return the weeks_worked
	 */
	public double getWeeks_worked() {
		return weeks_worked;
	}

	/**
	 * @param weeks_worked the weeks_worked to set
	 */
	public void setWeeks_worked(double weeks_worked) {
		this.weeks_worked = weeks_worked;
	}
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
	/**
	 * Method list
	 * public HourlyEmployee(Employee employee)
	 * public double HourlyEmployee_salary_calculator(double hourly_rate,double hours_worked,double weeks_worked)
	 * public double getHourly_rate()
	 * public void setHourly_rate(double hourly_rate)
	 * public double getHours_worked()
	 * public void setHours_worked(double hours_worked)
	 * public double getWeeks_worked()
	 * public void setWeeks_worked(double weeks_worked)
	 * public double getAnnual_salary()
	 * public void setAnnual_salary(double annual_salary)
	 * 
	 */

	/**
	 * Self testing main method
	 */
	public static void main(String[] args) {
//		Employee HE = new Employee();
//		HourlyEmployee hourlyEmployee = new HourlyEmployee(HE);
//		
//		// testing salary calculator-----------------------------------------------------------------------------------------------
//		hourlyEmployee.setHourly_rate(20);
//		hourlyEmployee.setHours_worked(40);
//		hourlyEmployee.setWeeks_worked(48);
//		
//		hourlyEmployee.setAnnual_salary(hourlyEmployee.HourlyEmployee_salary_calculator(hourlyEmployee.getHourly_rate(),hourlyEmployee.getHours_worked(),
//				hourlyEmployee.getWeeks_worked()));
//		
//		System.out.println(hourlyEmployee.getAnnual_salary());
//		
//		hourlyEmployee.setHourly_rate(30);
//		hourlyEmployee.setHours_worked(50);
//		hourlyEmployee.setWeeks_worked(40);
//		
//		hourlyEmployee.setAnnual_salary(hourlyEmployee.HourlyEmployee_salary_calculator(hourlyEmployee.getHourly_rate(),hourlyEmployee.getHours_worked(),
//				hourlyEmployee.getWeeks_worked()));
//		
//		System.out.println(hourlyEmployee.getAnnual_salary());
//		// testing setters and getters----------------------------------------------------------------------------------------------
//		
//		System.out.println(hourlyEmployee.getHourly_rate() + " " + hourlyEmployee.getHours_worked() + " " + hourlyEmployee.getWeeks_worked());
//		
//		hourlyEmployee.setAnnual_salary(100000);
//		
//		System.out.println(hourlyEmployee.getAnnual_salary());
//		

	}

}
