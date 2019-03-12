package ca.ucalgary.domain;
/**
 * Expense
 */
import ca.ucalgary.domain.Expense;

//package ca.ucalgary.domain;

public class Expense{
	
	private String name;
	private int percentOfIncome;
	private double amountOfIncomeCAD;
	/**
	 * Constructor
	 * @param name
	 * @param percent
	 * @param income
	 */
	//constructors
	public Expense(String name, int percent, double income){
		this.name = name;
		this.percentOfIncome = percent;
		this.amountOfIncomeCAD = income*(percent/100.0);
	}
	/**
	 * Constructor
	 * @param name
	 * @param amount
	 */
	public Expense(String name, double amount){
		this.name = name;
		this.amountOfIncomeCAD = amount;
	}
	/**
	 * Constructor
	 * @param toCopy
	 */
	public Expense(Expense toCopy){
		this.name = toCopy.getName();
		this.percentOfIncome = toCopy.getPercent();
		this.amountOfIncomeCAD = toCopy.getDollars();
	}
	//setters
	/**
	 * setPercent
	 * sets how much the expense is worth based on percent
	 * @param percent
	 */
	public void setPercent(int percent){
		this.percentOfIncome = percent;
	}
	/**
	 * Set how much an expense costs per month based on a dollar amount
	 * @param amount
	 */
	public void setAmountPerMonth(double amount){
		this.amountOfIncomeCAD = amount;
	}
	
	//getters
	/**
	 * getName
	 * 
	 * @return expense name as string
	 */
	public String getName(){
		String name = this.name;
		return name;
	}
	/**
	 * getPercent
	 * what percent of income the expense is
	 * @return integer percent
	 */
	public int getPercent(){
		int percent = this.percentOfIncome;
		return percent;
	}
	/**
	 * getDollars
	 * how much an expense is worth in dollars
	 * @return dollars as double
	 */
	public double getDollars(){
		double dollars = this.amountOfIncomeCAD;
		return dollars;
	}
	
}
