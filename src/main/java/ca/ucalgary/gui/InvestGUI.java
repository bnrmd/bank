package ca.ucalgary.gui;

// Imports 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * InvestGUI
 * Invest Graphical User Interface
 */
public class InvestGUI extends Application {
	
	// Main Method
	public static void main(String[] args) {
		launch(args);
	}
	
	// Start Method
	@Override
	public void start(Stage primaryStage) {

        // root layout
        BorderPane main = new BorderPane();

        // top layout
        Pane top = new Pane();
        Label txtAppName = new Label("Invest");
        top.getChildren().add(txtAppName);

        // center layout
        // UNIQUE FOR EACH FEATURE

        // bottom menu layout
        HBox bottom = new HBox();
        Button btnAccount = new Button("Account");
        Button btnBudget = new Button("Budget");
        Button btnGoals = new Button("Goals");
        Button btnInvest = new Button("Invest");

        btnAccount.setMinSize(96, 68);
        btnBudget.setMinSize(96, 68);
        btnGoals.setMinSize(96, 68);
        btnInvest.setMinSize(96, 68);

        bottom.getChildren().addAll(btnAccount, btnBudget, btnGoals, btnInvest);

        // set main layout
        main.setTop(top);
        main.setBottom(bottom);

        // set stage
        primaryStage.setTitle("myBank");
        primaryStage.setScene(new Scene(main, 768/2, 1366/2));  // most popular screen resolution: 1366x768
        primaryStage.show();
    }

}
