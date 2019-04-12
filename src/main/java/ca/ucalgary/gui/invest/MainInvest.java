package ca.ucalgary.gui.invest;

// Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * MainInvest class
 * main class for invest gui
 */
public class MainInvest extends Application {

	/**
	 * start
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("InvestMain.fxml"));
		primaryStage.setTitle("Bank");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
