package ca.ucalgary.domain;

import ca.ucalgary.domain.Expense;

//package ca.ucalgary.domain;

public class Expense{
	
	private String name;
	private int percentOfIncome;
	private double amountOfIncomeCAD;
	
	//constructors
	public Expense(String name, int percent, double income){
		this.name = name;
		this.percentOfIncome = percent;
		this.amountOfIncomeCAD = income*(percent/100.0);
	}
	
	public Expense(String name, double amount){
		this.name = name;
		this.amountOfIncomeCAD = amount;
	}
	
	public Expense(Expense toCopy){
		this.name = toCopy.getName();
		this.percentOfIncome = toCopy.getPercent();
		this.amountOfIncomeCAD = toCopy.getDollars();
	}
	
	//setters
	public void setPercent(int percent){
		this.percentOfIncome = percent;
	}
	
	public void setAmountPerMonth(double amount){
		this.amountOfIncomeCAD = amount;
	}
	
	//getters
	public String getName(){
		String name = this.name;
		return name;
	}
	
	public int getPercent(){
		int percent = this.percentOfIncome;
		return percent;
	}
	
	public double getDollars(){
		double dollars = this.amountOfIncomeCAD;
		return dollars;
	}
	
}
