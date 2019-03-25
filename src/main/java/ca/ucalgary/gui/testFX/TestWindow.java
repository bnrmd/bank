package ca.ucalgary.gui.testFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Test.fxml"));
		Parent content = (Parent)fxmlLoader.load();
		Scene testScene = new Scene(content);
		primaryStage.setScene(testScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
