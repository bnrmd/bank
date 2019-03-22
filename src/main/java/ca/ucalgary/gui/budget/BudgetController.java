package ca.ucalgary.gui.budget;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ucalgary.datastore.BudgetRepository;
import ca.ucalgary.domain.Budget;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class BudgetController implements Initializable{
	private BudgetRepository br = new BudgetRepository();
	private Budget budget = br.loadBudget();
	
	@FXML
	Button editBudgetButton;
	@FXML
	Label expenseLabel;
	
	//menu scene 
	@FXML
	AnchorPane menu;
	@FXML
	Button removeExpenseButton;
	@FXML
	Button addExpenseButton;
	@FXML
	Button editIncomeButton;
	
	
	@FXML
	private void openMenu(ActionEvent event) throws Exception {
		System.out.print("button works");
		
	}
	
	@FXML
	private void addExpense(ActionEvent event) throws Exception{
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		expenseLabel.setText(budget.toString());
	}
}
