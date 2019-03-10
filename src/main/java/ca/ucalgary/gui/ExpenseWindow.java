package ca.ucalgary.gui;

import ca.ucalgary.domain.Budget;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ExpenseWindow extends Application{
	Budget budget;
	Label display;
	static Stage classStage = new Stage();
	public ExpenseWindow(Budget budget, Label display){
		this.budget = budget;
		this.display = display;
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
	public void start(Stage primaryStage){
		classStage = primaryStage;
		
		//just an HBox that has a couple flow panes
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		//Name of expense and field to imput
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
			budget.addExpense(nameEnter.getText(),Double.parseDouble(amntEnter.getText()));
			display.setText(budget.toString());
			primaryStage.close();
			}
		});
		root.getChildren().add(addExpense);
		
		//Display in window
		Scene scene = new Scene(root,300,200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}