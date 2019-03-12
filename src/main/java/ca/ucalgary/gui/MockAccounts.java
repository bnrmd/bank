package ca.ucalgary.gui;
/**
 * Mock Accounts
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
public class MockAccounts extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
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
		
		//Set actions for menu bar other than accounts
		//to be put into handler class later
		//Budget Button
		btnBudget.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				BudgetGUI myBudgetGUI = new BudgetGUI();
				try {
					myBudgetGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
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
        root.setTop(new Label("Accounts: To be integrated"));
  		Scene scene = new Scene(root,384,683);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
