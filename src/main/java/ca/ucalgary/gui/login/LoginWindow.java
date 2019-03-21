package ca.ucalgary.gui.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class LoginWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL urlTest = new File("src/main/java/ca/ucalgary/gui/login/login.fxml").toURL();
        Parent content = FXMLLoader.load(urlTest);
        Scene loginScene = new Scene(content);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}
