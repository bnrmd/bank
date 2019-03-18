package ca.ucalgary.gui.accounts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class AccountWindowFXML extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/account.fxml"));
        Parent content = (Parent)fxmlLoader.load();
        Scene loginScene = new Scene(content);
        primaryStage.setScene(loginScene);
        primaryStage.show();

    }
}
