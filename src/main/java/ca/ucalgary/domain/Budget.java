package ca.ucalgary.domain;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Budget {
	
	private double income;
	private List<Expense> expenses = new ArrayList<Expense>();
	
	//constructors
	/**
	 * Dummy constructor for json file to load
	 */
	public Budget() {};
	/**
	 * Budget Constructor with income
	 * @param income
	 */
	public Budget(double income){
		this.income = income;
	}
	/**
	 * Budget Constructor with budget
	 * @param toCopy
	 */
	public Budget(Budget toCopy){
		this.income = toCopy.getIncome();
		this.expenses = toCopy.getExpenses();
	}
	public Budget(double income, List<Expense> expenses) {
		this.income = income;
		this.expenses = (ArrayList<Expense>) expenses;
	}
	//setters
	/**
	 * Set an Income for your budget
	 * @param toSet
	 */
	public void setIncome(double toSet) {
		this.income = toSet;
	}
	public void setExpenses(ArrayList<Expense> expense) {
		this.expenses=expense;
	}
	//takes amount of dollars for expense
	/**
	 * Add an expense to the budget with an amount
	 * @param name
	 * @param amount
	 */
	public void addExpense(String name, double amount){
		Expense toAdd = new Expense(name,amount);
		expenses.add(toAdd);	
	}
	//getters
	/**
	 * Get the income
	 * @param none
	 * @return income of budget
	 */
	public double getIncome(){
		return income;
	}
	/**
	 * Get a specific expense
	 * @param str
	 * @return the expense
	 */
	public Expense getExpense(String str){
		for (Expense x : expenses){
			if (x.getName().equalsIgnoreCase(str))
				return x;
		}
		throw new RuntimeException("Entered expense does not exist");
		
	}
	/**
	 * Get the left over income of the budget
	 * @return Leftover income
	 */
	public double LeftoverIncome() {
		double leftOver = this.income;
		for (Expense x : expenses)
			leftOver -= x.getAmountPerMonth();
		return leftOver;
	}
	/**
	 * Get the total expenses
	 * @return total expenses
	 */
	public double totalCostInDollars() {
		double total = 0.0;
		for (Expense x: expenses) {
			total += x.getAmountPerMonth();
		}
		return total;
	}
	/**
	 * getAllExpenses
	 * Returns all the expenses in a budget
	 * @return all expenses as ArrayList<Expense>
	 */
	public List<Expense> getExpenses(){
		return expenses;
	}
	//methods
	/**
	 * 
	 * @param cost of expense to add
	 * @return if there is enough money as boolean
	 */
	public boolean hasEnoughMoneyToAdd(double cost) {
		if (this.LeftoverIncome() >= cost)
			return true;
		else return false;
	}
	
	/**
	 * 
	 */
	public boolean nameUsed(String name) {
		for (Expense x: this.getExpenses()) {
			if (x.getName().equalsIgnoreCase(name))
				return true;
		}return false;
	}
	/**
	 * toString
	 * @return budget as string
	 */
	public String toString(){
		String str = "";
		for (Expense x : expenses){
			str += x.getName() + ": $" + x.getAmountPerMonth() + "\n";
		}
		str += "Total Expenses: " + this.totalCostInDollars() + "\n";
		str += "Total Left: " + this.LeftoverIncome();
		return str;
	}
	
	public int removeExpense(String name) {
		int count = 0;
		for (Expense x:expenses) {
			if (x.getName().equalsIgnoreCase(name)) {
				expenses.remove(count);
				return 1;
			}
		}
		return -1;
	}
}
