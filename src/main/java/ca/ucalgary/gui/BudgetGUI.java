package ca.ucalgary.gui;
import ca.ucalgary.domain.Budget;
import ca.ucalgary.datastore.BudgetRepository;

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

/*
 * Things to add:
 * set income
 * remove expense
 * error checking for (adding expense negative, income pos/neg)
*/

public class BudgetGUI extends Application{
	private BudgetRepository saveLoad = new BudgetRepository();
	private Budget forGUI = saveLoad.loadBudget();
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
	public void start(Stage primaryStage){
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
		Button menuBtn = new Button("Menu");
		BudgetMenuGUIHandler addHandle = new BudgetMenuGUIHandler(forGUI,displayInWindow);
		menuBtn.setOnAction(addHandle);
		VBox addButton = new VBox();
		addButton.getChildren().add(menuBtn);
		addButton.setAlignment(Pos.BOTTOM_RIGHT);
		root.setRight(addButton);
		
		// Menu Bar - btnInvest
        btnInvest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				saveLoad.saveBudget(forGUI);
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
				saveLoad.saveBudget(forGUI);
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
      				saveLoad.saveBudget(forGUI);
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