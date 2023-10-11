/**
 * 
 */

/**
 * @author Tahoor Sheikh
 * Date: May,2023
 * Description: is an Employee containing an annual salary, the amount in sales
 * in dollars completed in a year, a sales commission of 6.5% of the total annual sales and a
 * method to calculate and update their annual earnings. Note: The sales commission percentage
 * could change from time to time. It should be changeable through a method that can be called
 * upon
 *
 */
public class SalesEmployee extends Employee{

	/**
	 * private variables
	 */
	private double annual_salary;
	private double sales;
	private double sales_commission;

	public SalesEmployee() {
		super();
		this.annual_salary = 0;
		this.sales = 0;
		this.sales_commission = 0.065;

	}
	/**
	 * Method to calculate annual earnings
	 */
	public void calculateEarnings() {
		this.setAnnual_earnings(annual_salary+ sales * sales_commission);
		System.out.println(0+ sales * sales_commission + "ss");
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
	 * @return the sales
	 */
	public double getSales() {
		return sales;
	}
	/**
	 * @param sales the sales to set
	 */
	public void setSales(double sales) {
		this.sales = sales;
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
	 * Method list
	 * public SalesEmployee(Employee employee)
	 * public double commission_earnings(double sales,double sales_commission)
	 * public double getAnnual_salary()
	 * public void setAnnual_salary(double annual_salary)
	 * public double getSales()
	 * public void setSales(double sales)
	 * public double getSales_commission()
	 * public void setSales_commission(double sales_commission)
	 */

	/**
	 * Self testing main method
	 */
	public static void main(String[] args) {
		//		Employee SE = new Employee();
		//		SalesEmployee SalesEmployee = new SalesEmployee(SE);
		//
		//		// testing earnings method-----------------------------------------------------------------------------------------------------------
		//		SalesEmployee.setSales(1000000);
		//
		//		SalesEmployee.setAnnual_salary(SalesEmployee.commission_earnings(SalesEmployee.getSales(),SalesEmployee.getSales_commission()));
		//
		//		System.out.println(SalesEmployee.getAnnual_salary());
		//
		//		SalesEmployee.setSales_commission(0.10);
		//
		//		SalesEmployee.setAnnual_salary(SalesEmployee.commission_earnings(SalesEmployee.getSales(),SalesEmployee.getSales_commission()));
		//
		//		System.out.println(SalesEmployee.getAnnual_salary());
		//
		//		
		//		
		//
		//

	}

}
