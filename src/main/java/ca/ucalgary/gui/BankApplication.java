package ca.ucalgary.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/bank.fxml"));
        Parent content = (Parent)fxmlLoader.load();
        Scene loginScene = new Scene(content);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}
