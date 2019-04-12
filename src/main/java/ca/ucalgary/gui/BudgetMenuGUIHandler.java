//DELETE
package ca.ucalgary.gui;
import ca.ucalgary.domain.Budget;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BudgetMenuGUIHandler implements EventHandler<ActionEvent>{
	private Budget budget;
	private Label label;
	/**
	 * 
	 * @param budget
	 * @param display
	 */
	public BudgetMenuGUIHandler(Budget budget, Label label){
		this.budget = budget;
		this.label = label;
	}
	
	@Override
	public void handle(ActionEvent event){
		BudgetMenuGUI ew = new BudgetMenuGUI(budget,label);
		ew.start(BudgetMenuGUI.classStage);
	}
}