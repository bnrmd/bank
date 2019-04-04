package ca.ucalgary.domain;

//Imports
import java.text.DecimalFormat;

/**
 * Goals Class
 * allows user to set future goals
 * @author Salim
 */
public class Goal {

	// Declare Instance Variables
	private String name, timePeriod;
	private double amount;
	int timePeriodInput, timePeriodDays;
	
	/**
	 * Default Constructor
	 */
	public Goal() {
		
		// initialize instance variables
		name = "none";
		timePeriod = "";
		amount = 0.0;
		timePeriodInput = 0;
		timePeriodDays = 0;
	}
	
	/**
	 * Set Goal Name
	 * @param name
	 */
	public void setGoalName(String name) {
		this.name = name;
	}
	
	/**
	 * Set Time Period
	 * @param name
	 */
	public void setTimePeriod(String name) {
		this.timePeriod = name;
	}
	
	/**
	 * Set Goal Amount
	 * @param amount
	 */
	public void setGoalAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Set Time Period Input
	 * @param timePeriodInput
	 */
	public void setTimePeriodInput(int timePeriodInput) {
		this.timePeriodInput = timePeriodInput;
	}
	
	/**
	 * Set Time Period Days
	 * @param days
	 */
	public void setTimePeriodDays(int days) {
		this.timePeriodDays = days;
	}
	
	/**
	 * Display Goal
	 * @return String
	 */
	public String toString() {
		DecimalFormat df2 = new DecimalFormat(".##");
		String string = "-------------------myGoal-------------------\n";
		string += "Goal: " + name + "\n";
		string += "Amount: $" + df2.format(amount) + "\n";
		string += "Time Period: " + timePeriodInput + " " + timePeriod + "\n\n";
		string += "Yearly Savings: $" + df2.format((amount/timePeriodDays) * 365) + "\n";
		string += "Monthly Savings: $" + df2.format((amount/timePeriodDays) * 30) + "\n";
		string += "Weekly Savings: $" + df2.format((amount/timePeriodDays) * 7) + "\n";
		string += "Daily Savings: $" + df2.format(amount/timePeriodDays);
		return string;
	}
	
}