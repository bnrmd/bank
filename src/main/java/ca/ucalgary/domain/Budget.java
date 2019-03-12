package ca.ucalgary.domain;
import java.util.ArrayList;
import java.util.Scanner;
public class Budget {
	
	private double income;
	private ArrayList<Expense> expenses = new ArrayList<Expense>();
	
	//constructors
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
		this.expenses = toCopy.getAllExpenses();
	}
	//setters
	/**
	 * Add an expense to the budget
	 * @param name
	 * @param percent
	 */
	public void addExpense(String name, int percent){
		double leftOver = this.getLeftoverIncome();
		if (leftOver <= (this.income * (percent/100.0))) {
			Scanner x = new Scanner(System.in);
			System.out.println("No income left for new expense. Continue? [y] or [n]");
			String cont = x.next();
			if (!cont.equals("y") && !cont.equals("n")) {
				System.out.println("Please enter valid command");
				cont = x.next();
			}
			else if (cont.equals("y")) {
				Expense toAdd = new Expense(name,percent,this.income);
				expenses.add(toAdd);
			}
		}else {
			Expense toAdd = new Expense(name,percent,this.income);
			expenses.add(toAdd);
		}
		
	}
	/**
	 * Set an Income for your budget
	 * @param toSet
	 */
	public void setIncome(double toSet) {
		this.income = toSet;
	}
	
	//takes amount of dollars for expense
	/**
	 * Add an expense to the budget with an amount
	 * @param name
	 * @param amount
	 */
	public void addExpense(String name, double amount){
		double leftOver = this.getLeftoverIncome();
		if (leftOver <= amount) {
			Scanner x = new Scanner(System.in);
			System.out.println("No income left for new expense. Continue? [y] or [n]");
			String cont = x.next();
			if (!cont.equals("y") && !cont.equals("n")) {
				System.out.println("Please enter valid command");
				cont = x.next();
			}
			else if (cont.equals("y")) {
				Expense toAdd = new Expense(name,amount);
				expenses.add(toAdd);
			}
		} else {
			Expense toAdd = new Expense(name,amount);
			expenses.add(toAdd);
		}
			
	}
	//getters
	/**
	 * Get the income
	 * @param none
	 * @return income of budget
	 */
	public double getIncome(){
		double income = this.income;
		return income;
	}
	/**
	 * Get a specific expense
	 * @param str
	 * @return the expense
	 */
	public Expense getExpense(String str){
		Expense copy  = null;
		for (Expense x : expenses){
			if (x.getName().equalsIgnoreCase(str))
				copy = new Expense(x);
		}
		if (copy == null)
			return null;
		else return copy;
	}
	/**
	 * Get the left over income of the budget
	 * @return Leftover income
	 */
	public double getLeftoverIncome() {
		double leftOver = this.income;
		for (Expense x : expenses)
			leftOver -= x.getDollars();
		return leftOver;
	}
	/**
	 * Get the total expenses
	 * @return total expenses
	 */
	public double getTotalExpenses() {
		double total = 0.0;
		for (Expense x: expenses) {
			total += x.getDollars();
		}
		return total;
	}
	/**
	 * getAllExpenses
	 * Returns all the expenses in a budget
	 * @return all expenses as ArrayList<Expense>
	 */
	public ArrayList<Expense> getAllExpenses(){
		ArrayList<Expense> toReturn = new ArrayList<Expense>();
		toReturn = expenses;
		return toReturn;
	}
	//methods
	/**
	 * toString
	 * @return budget as string
	 */
	public String toString(){
		String str = "";
		for (Expense x : expenses){
			str += x.getName() + ": $" + x.getDollars() + "\n";
		}
		str += "Total Expenses: " + this.getTotalExpenses() + "\n";
		str += "Total Left: " + this.getLeftoverIncome();
		return str;
	}
}
