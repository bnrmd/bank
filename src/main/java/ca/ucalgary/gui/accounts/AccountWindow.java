package ca.ucalgary.gui.accounts;

import ca.ucalgary.domain.Account;
import ca.ucalgary.services.AccountService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountWindow extends Application{
	AccountService service = new AccountService();
	Account account;
	Label display;
	static Stage classStage = new Stage();
	/**
	 * AccountWindow constructor
	 * @param account
	 * @param display
	 */
	public AccountWindow(Account account, Label display){
		this.account = account;
		this.display = display;
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
	@Override
	public void start(Stage primaryStage){
		classStage = primaryStage;
		
		//just an HBox that has a couple flow panes
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		//Name of expense and field to imput
		HBox getName = new HBox();
		getName.setAlignment(Pos.CENTER);
		TextField typeEnter = new TextField("Enter Account Type");
		typeEnter.setPrefWidth(125);
		getName.getChildren().add(new Label(" placeholder text "));
		getName.getChildren().add(typeEnter);
		root.getChildren().add(getName);
		
		//get the amount
		HBox getAmmount = new HBox();
		getAmmount.setAlignment(Pos.CENTER);
		TextField amntEnter = new TextField("Enter Initial Balance");
		amntEnter.setPrefWidth(100);
		getAmmount.getChildren().add(new Label("Amount: "));
		getAmmount.getChildren().add(amntEnter);
		root.getChildren().add(getAmmount);
		
		//button to add the expense
		Button addAccount = new Button("Add");
		addAccount.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				account = service.createAccount();
				account.setBalance(Double.parseDouble(amntEnter.getText()));

				//budget.addExpense(nameEnter.getText(),Double.parseDouble(amntEnter.getText()));
				display.setText("ID: " + account.getId().substring(0,8).toUpperCase() + "\nBalance: " + account.getBalance() + "\nType: " + account.getType()
				+ "\n\n" + service.getAllAccounts());
				primaryStage.close();
			}
		});
		root.getChildren().add(addAccount);
		
		//Display in window
		Scene scene = new Scene(root,300,200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}