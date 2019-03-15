package ca.ucalgary.gui;
import ca.ucalgary.domain.Budget;

import ca.ucalgary.gui.accounts.MockAccounts;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;


public class BudgetGUI extends Application{
	private Budget forGUI = new Budget(1000);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		launch(args);
	}
	/**
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		BorderPane root = new BorderPane();
		
		//bottom bar using hbox
		
		HBox menuBar = new HBox();
		Button btnInvest = new Button("Invest");
		Button btnBudget = new Button("Budget");
		Button btnGoals = new Button("Goals");
		Button btnAccounts = new Button("Accounts");
		
		btnAccounts.setMinSize(96,68);
		btnBudget.setMinSize(96,68);
		btnGoals.setMinSize(96,68);
		btnInvest.setMinSize(96,68);
		
		menuBar.getChildren().add(btnAccounts);
		menuBar.getChildren().add(btnBudget);
		menuBar.getChildren().add(btnGoals);
		menuBar.getChildren().add(btnInvest);
		menuBar.setAlignment(Pos.CENTER);
		root.setBottom(menuBar);
		
		
		//set title
		Label title = new Label("Budget");
		root.setTop(title);
		
		//show the budget
		String displayBudget = forGUI.toString();
		Label displayInWindow = new Label(displayBudget);
		root.setLeft(displayInWindow);
		
		//show the add button
		Button addBtn = new Button("Add Expense");
		AddExpenseButtonHandler addHandle = new AddExpenseButtonHandler(forGUI,displayInWindow);
		addBtn.setOnAction(addHandle);
		VBox addButton = new VBox();
		addButton.getChildren().add(addBtn);
		addButton.setAlignment(Pos.BOTTOM_RIGHT);
		root.setRight(addButton);
		
		// Menu Bar - btnInvest
        btnInvest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				InvestGUI myInvestGUI = new InvestGUI();
				try {
					myInvestGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
		//Menu bar btnAccounts
        btnAccounts.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MockAccounts myAccountsGUI = new MockAccounts();
				try {
					myAccountsGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
        
      //Goals Button
      		btnGoals.setOnAction(new EventHandler<ActionEvent>() {
      			@Override
      			public void handle(ActionEvent event) {
      				MockGoalsGUI myGoalsGUI = new MockGoalsGUI();
      				try {
      					myGoalsGUI.start(primaryStage);
      				} catch (Exception e) {
      					// TODO Auto-generated catch block
      					e.printStackTrace();
      				}
      			}
      		});
		Scene scene = new Scene(root,384,683);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}