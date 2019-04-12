//DELETE
package ca.ucalgary.gui;

import ca.ucalgary.domain.Budget;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BudgetMenuGUI extends Application{
	private Budget budget;
	private Label display;
	
	static Stage classStage = new Stage();
	
	public BudgetMenuGUI(Budget budget, Label label) {
		this.budget = budget;
		display = label;
	}
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args){
		launch(args);
	}
	/**
	 * start
	 * @param primaryStage
	 */
	public void start(Stage primaryStage){
		classStage = primaryStage;
		
		//just an HBox that has a couple flow panes
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		
		//button to add the expense
		Button addExpense = new Button("Add Expense");
		addExpense.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				classStage.setScene(expenseButton());
			}
		});
		root.getChildren().add(addExpense);
		
		//button to change income
		Button setIncome = new Button("Set Income");
		setIncome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				classStage.setScene(addIncomeButton());
			}
		});
		root.getChildren().add(setIncome);
		
		//button to remove expense
		Button removeIncome = new Button("Remove Expense");
		removeIncome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				classStage.setScene(removeExpense());
			}
		});
		root.getChildren().add(removeIncome);
		
		//Display in window
		Scene scene = new Scene(root,300,200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Scene addIncomeButton() {
		VBox root = new VBox();
		
		//Set income button and field
		TextField incomeEnter = new TextField("Enter Income");
		root.getChildren().add(incomeEnter);
		
		//button to add income
		Button setIncome = new Button("Set");
		setIncome.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				double incomeToAdd = Double.parseDouble(incomeEnter.getText());
				if (incomeToAdd > budget.totalCostInDollars()) {
						budget.setIncome(incomeToAdd);
						display.setText(budget.toString());
						classStage.close();
				}else if (incomeToAdd < 0) {
					root.getChildren().clear();
					root.getChildren().add(new Label("Income cannot be negative"));
					Button close = new Button("Ok");
					close.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
					root.getChildren().add(close);
				} else {
					root.getChildren().clear();
					root.getChildren().add(new Label("Income lower than total expenses.\nContinue?"));
					Button no = new Button("No");
					no.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
					Button yes = new Button("Yes");
					yes.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							budget.setIncome(incomeToAdd);
							display.setText(budget.toString());
							classStage.close();
						}
					});
				}
					
			}
		});
		root.getChildren().add(setIncome);
		Scene scene = new Scene(root,300,200);
		return scene;
	}
	
	
	public Scene expenseButton() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		//Name of expense and field to input
		HBox getName = new HBox();
		getName.setAlignment(Pos.CENTER);
		TextField nameEnter = new TextField("Enter expense name");
		nameEnter.setPrefWidth(125);
		getName.getChildren().add(new Label("Expense Name: "));
		getName.getChildren().add(nameEnter);
		root.getChildren().add(getName);
		
		//get the amount
		HBox getAmmount = new HBox();
		getAmmount.setAlignment(Pos.CENTER);
		TextField amntEnter = new TextField("Enter expense cost");
		amntEnter.setPrefWidth(100);
		getAmmount.getChildren().add(new Label("Amount: "));
		getAmmount.getChildren().add(amntEnter);
		root.getChildren().add(getAmmount);
		
		//button to add the expense
		Button addExpense = new Button("Add");
		addExpense.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				double expenseAmount = Double.parseDouble(amntEnter.getText());
				if (expenseAmount > 0 && budget.hasEnoughMoneyToAdd(expenseAmount)) {
					budget.addExpense(nameEnter.getText(),Double.parseDouble(amntEnter.getText()));
					display.setText(budget.toString());
					classStage.close();
				} else if (expenseAmount > 0) { //only runs if there is not enough money to add
					root.getChildren().clear();
					root.getChildren().add(new Label("Not enough income to add expense"));
					Button close = new Button("Okay");
					close.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
					root.getChildren().add(root);
				} else {
					root.getChildren().clear();
					root.getChildren().add(new Label("Expense cannot be negative"));
					Button close = new Button("Okay");
					close.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
				}
			}
		});
		root.getChildren().add(addExpense);
		Scene scene = new Scene(root, 300, 200);
		return scene;

	}
	
	public Scene removeExpense() {
		
		VBox root = new VBox();
		TextField field = new TextField("Enter Expense Name");
		root.getChildren().add(field);
		//remove button
		Button remove = new Button("Remove");
		remove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String toRemove = field.getText();
				if (budget.removeExpense(toRemove) < 0) {
					root.getChildren().clear();
					root.getChildren().add(new Label("Expense does not exist"));
					Button close = new Button("Okay");
					close.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
					root.getChildren().add(close);
				} else {
					root.getChildren().clear();
					root.getChildren().add(new Label("Expense Deleted"));
					display.setText(budget.toString());
					Button close = new Button("Close");
					close.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							classStage.close();
						}
					});
					root.getChildren().add(close);
				}	
			}
		});
		root.getChildren().add(remove);
		Scene scene = new Scene(root,300,200);
		return scene;
	}
}
