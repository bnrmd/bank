package ca.ucalgary.gui;
import ca.ucalgary.domain.Budget;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;


public class BudgetGUI extends Application{
	private Budget forGUI = new Budget(1000);
	Scene scene;
	public static void main(String[] args){
		launch(args);
	}
	
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
		
		
		scene = new Scene(root,384,683);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}