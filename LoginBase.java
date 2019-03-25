import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class LoginBase extends Application {
	
	public static void main(String[] args) {
	    launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// WINDOW TITLE
		primaryStage.setTitle("My BankApplication");
		Pane Window = new Pane();
	
        Pane pane = new Pane();
        Pane pane0 = new Pane();
        Label label = new Label();
        Label label0 = new Label();
        Label label1 = new Label();
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button button = new Button();

        pane.setLayoutY(-1.0);
        pane.setPrefHeight(88.0);
        pane.setPrefWidth(384.0);
        pane.setStyle("-fx-background-color: #cd5c5c;");

        pane0.setLayoutY(-1.0);
        pane0.setPrefHeight(88.0);
        pane0.setPrefWidth(97.0);
        pane0.setStyle("-fx-background-color: #b22222;");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(97.0);
        label.setLayoutY(27.0);
        label.setPrefHeight(28.0);
        label.setPrefWidth(287.0);
        label.setText("Login");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ffdb92"));
        label.setFont(new Font("Corbel", 25.0));

        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setLayoutX(14.0);
        label0.setLayoutY(143.0);
        label0.setPrefHeight(60.0);
        label0.setPrefWidth(129.0);
        label0.setText("Client I.D.:");
        label0.setFont(new Font("Corbel", 14.0));

        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setLayoutX(17.0);
        label1.setLayoutY(216.0);
        label1.setPrefHeight(60.0);
        label1.setPrefWidth(129.0);
        label1.setText("Password:");
        label1.setFont(new Font("Corbel", 14.0));

        textField.setLayoutX(163.0);
        textField.setLayoutY(161.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(174.0);

        passwordField.setLayoutX(164.0);
        passwordField.setLayoutY(234.0);
        passwordField.setPrefHeight(25.0);
        passwordField.setPrefWidth(174.0);

        button.setLayoutX(292.0);
        button.setLayoutY(276.0);
        button.setMnemonicParsing(false);
        button.setText("Login");
        button.setFont(new Font("Corbel", 12.0));

        Window.getChildren().add(pane);
        Window.getChildren().add(pane0);
        Window.getChildren().add(label);
        Window.getChildren().add(label0);
        Window.getChildren().add(label1);
        Window.getChildren().add(textField);
        Window.getChildren().add(passwordField);
        Window.getChildren().add(button);
        
        primaryStage.setScene(new Scene(Window, 384, 683));
        primaryStage.show();

    }
}
