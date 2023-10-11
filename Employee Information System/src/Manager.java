/**
 * 
 */

/**
 * @author Tahoor Sheikh
 * Date: May 2023
 * Description: Program will extend from employee class and will contain containing an annual salary, an annual bonus and
 * performance rating as attributes and a method that calculates and updates their annual
 * earnings based on an annual salary and a bonus. The bonus is dependent on a percentage based
 * on performance ratings
 *
 */
public class Manager extends Employee{

	/**
	 * private variables
	 */
	private double annual_salary;
	private String performance_rating;

	private double rate_1;
	private double rate_2;
	private double rate_3;
	private double currentBonus;

	

	/**
	 * Default constructor 
	 */
	public Manager() {
		super();
		this.annual_salary = 0;
		this.performance_rating = "";

		this.rate_1 = 0.015;
		this.rate_2 = 0.03;
		this.rate_3 = 0.1;
		this.currentBonus = 0;
	}
	


	public void calculateEarnings() {
		double calculatedEarnings = 0;
		performance_rating_calculator();
	
		calculatedEarnings =  annual_salary + annual_salary*currentBonus;
		
		this.setAnnual_earnings(calculatedEarnings);
	}
	
	/**
	 * Method to calculate performance raiting
	 * 
	 * MAO = Met all objectives - rate 1
	 * ESO = Exceeded some objectives - rate 2
	 * EAO = Exceeded all objectives - rate 3
	 * 
	 */
	public void performance_rating_calculator() {
		if (performance_rating.equals("MA")) { // check if met all objectives 
			currentBonus = rate_1; // return rate 1
		}
		else if (performance_rating.equals("ES")) { // check if exceeded some objectives
			currentBonus = rate_2; // return rate 2
		}
		else if (performance_rating.equals("EA")) { // check if exceeded all objecttives
			currentBonus = rate_3;// return rate 3
		}
	}
	/**
	 * Method to change bonus percentages
	 */
	public void rate_change(double Rate_1,double Rate_2,double Rate_3) {
		this.setRate_1(Rate_1);
		this.setRate_2(Rate_2);
		this.setRate_3(Rate_3);
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
	 * @return the performance_rating
	 */
	public String getPerformance_rating() {
		return performance_rating;
	}


	/**
	 * @param performance_rating the performance_rating to set
	 */
	public void setPerformance_rating(String performance_rating) {
		this.performance_rating = performance_rating;
	}


	/**
	 * @return the currentBonus
	 */
	public double getCurrentBonus() {
		return currentBonus;
	}


	/**
	 * @param currentBonus the currentBonus to set
	 */
	public void setCurrentBonus(double currentBonus) {
		this.currentBonus = currentBonus;
	}


	/**
	 * @return the rate_1
	 */
	public double getRate_1() {
		return rate_1;
	}
	/**
	 * @param rate_1 the rate_1 to set
	 */
	public void setRate_1(double rate_1) {
		this.rate_1 = rate_1;
	}
	/**
	 * @return the rate_2
	 */
	public double getRate_2() {
		return rate_2;
	}
	/**
	 * @param rate_2 the rate_2 to set
	 */
	public void setRate_2(double rate_2) {
		this.rate_2 = rate_2;
	}
	/**
	 * @return the rate_3
	 */
	public double getRate_3() {
		return rate_3;
	}
	/**
	 * @param rate_3 the rate_3 to set
	 */
	public void setRate_3(double rate_3) {
		this.rate_3 = rate_3;
	}
	/**
	 * Method list
	 * public Manager()
	 * public double performance_raitng(String obj)
	 * public void rate_change(double Rate_1,double Rate_2,double Rate_3)
	 * public double getAnnual_salary()
	 * public void setAnnual_salary(double annual_salary)
	 * public double getAnnual_bonus()
	 * public void setAnnual_bonus(double annual_bonus)
	 * public double getPerformance_rating()
	 * public void setPerformance_rating(double performance_rating)
	 */

	/**
	 * Self testing main method 
	 */
	public static void main(String[] args) {
//		Employee m = new Employee();
//		//Manager manager = new Manager(m);
//
//		// testing performance raiting method----------------------------------------------------------------------------------------
//		manager.setAnnual_salary(100000);
//
//		manager.setAnnual_bonus(manager.performance_raitng_calculator("MAO"));
//
//		manager.setAnnual_earnings(manager.annual_earnings(manager.getAnnual_salary(), manager.getAnnual_bonus()));
//
//		System.out.println(manager.getAnnual_earnings());
//
//		manager.setAnnual_bonus(manager.performance_raitng_calculator("ESO"));
//
//		manager.setAnnual_earnings(manager.annual_earnings(manager.getAnnual_salary(), manager.getAnnual_bonus()));
//
//		System.out.println(manager.getAnnual_earnings());
//
//		manager.setAnnual_bonus(manager.performance_raitng_calculator("EAO"));
//
//		manager.setAnnual_earnings(manager.annual_earnings(manager.getAnnual_salary(), manager.getAnnual_bonus()));
//
//		System.out.println(manager.getAnnual_earnings());
//
//		// testing rate change method-------------------------------------------------------------------------------------------------
//
//		manager.rate_change(0.1,0.2,0.3);
//
//		System.out.println(manager.getRate_1() + " " + manager.getRate_2() + " " + manager.getRate_3());
//
//		// testing setters and getters------------------------------------------------------------------------------------------------
//
//		manager.setPerformance_rating(0.1);
//
//		System.out.println(manager.getPerformance_rating());
//
//		manager.setPerformance_rating(0.2);
//
//		System.out.println(manager.getPerformance_rating());
//

	}

}
