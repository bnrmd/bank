package ca.ucalgary.gui;
import ca.ucalgary.domain.Budget;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class AddExpenseButtonHandler implements EventHandler<ActionEvent>{
	Budget budget;
	Label display;
	/**
	 * 
	 * @param budget
	 * @param display
	 */
	public AddExpenseButtonHandler(Budget budget, Label display){
		this.budget = budget;
		this.display = display;
	}
	
	@Override
	public void handle(ActionEvent event){
		ExpenseWindow ew = new ExpenseWindow(budget, display);
		
		ew.start(ExpenseWindow.classStage);
	}
}