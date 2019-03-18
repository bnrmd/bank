import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Registration extends Application {
	
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
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        TextField textField = new TextField();
        DatePicker datePicker = new DatePicker();
        RadioButton radioButton = new RadioButton();
        RadioButton radioButton0 = new RadioButton();
        RadioButton radioButton1 = new RadioButton();
        RadioButton radioButton2 = new RadioButton();
        TextField textField0 = new TextField();
        TextField textField1 = new TextField();
        Label label7 = new Label();
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
        label.setText("REGISTRATION FORM");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ffdb92"));
        label.setFont(new Font("Corbel", 25.0));

        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setLayoutY(115.0);
        label0.setPrefHeight(28.0);
        label0.setPrefWidth(146.0);
        label0.setText("   Account Details");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#0000007f"));
        label0.setUnderline(true);
        label0.setFont(new Font("Corbel", 20.0));

        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setLayoutX(14.0);
        label1.setLayoutY(143.0);
        label1.setPrefHeight(78.0);
        label1.setPrefWidth(129.0);
        label1.setText("Account Type:");
        label1.setFont(new Font("Corbel", 14.0));

        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setLayoutX(17.0);
        label2.setLayoutY(221.0);
        label2.setPrefHeight(78.0);
        label2.setPrefWidth(129.0);
        label2.setText("Account Name:");
        label2.setFont(new Font("Corbel", 14.0));

        label3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label3.setLayoutX(17.0);
        label3.setLayoutY(299.0);
        label3.setPrefHeight(78.0);
        label3.setPrefWidth(129.0);
        label3.setText("Date of Birth:");
        label3.setFont(new Font("Corbel", 14.0));

        label4.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label4.setLayoutX(17.0);
        label4.setLayoutY(377.0);
        label4.setPrefHeight(78.0);
        label4.setPrefWidth(129.0);
        label4.setText("Gender:");
        label4.setFont(new Font("Corbel", 14.0));

        label5.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label5.setLayoutX(17.0);
        label5.setLayoutY(455.0);
        label5.setPrefHeight(78.0);
        label5.setPrefWidth(129.0);
        label5.setText("Nationality:");
        label5.setFont(new Font("Corbel", 14.0));

        label6.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label6.setLayoutX(17.0);
        label6.setLayoutY(533.0);
        label6.setPrefHeight(78.0);
        label6.setPrefWidth(146.0);
        label6.setText("Citizenship I.D.:");
        label6.setFont(new Font("Corbel", 14.0));

        textField.setLayoutX(163.0);
        textField.setLayoutY(248.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(174.0);

        datePicker.setLayoutX(163.0);
        datePicker.setLayoutY(326.0);

        radioButton.setLayoutX(267.0);
        radioButton.setLayoutY(173.0);
        radioButton.setMnemonicParsing(false);
        radioButton.setText("Savings");
        radioButton.setFont(new Font("Corbel", 14.0));

        radioButton0.setLayoutX(163.0);
        radioButton0.setLayoutY(173.0);
        radioButton0.setMnemonicParsing(false);
        radioButton0.setText("Chequing");
        radioButton0.setFont(new Font("Corbel", 14.0));

        radioButton1.setLayoutX(169.0);
        radioButton1.setLayoutY(407.0);
        radioButton1.setMnemonicParsing(false);
        radioButton1.setText("Male");
        radioButton1.setFont(new Font("Corbel", 14.0));

        radioButton2.setLayoutX(268.0);
        radioButton2.setLayoutY(407.0);
        radioButton2.setMnemonicParsing(false);
        radioButton2.setText("Female");
        radioButton2.setFont(new Font("Corbel", 14.0));

        textField0.setLayoutX(163.0);
        textField0.setLayoutY(443.0);
        textField0.setPrefHeight(25.0);
        textField0.setPrefWidth(174.0);
        textField0.setText("Other, please specify");
        textField0.setFont(new Font("Corbel", 12.0));

        textField1.setLayoutX(163.0);
        textField1.setLayoutY(560.0);
        textField1.setPrefHeight(25.0);
        textField1.setPrefWidth(174.0);

        label7.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label7.setLayoutX(169.0);
        label7.setLayoutY(455.0);
        label7.setPrefHeight(78.0);
        label7.setPrefWidth(129.0);
        label7.setText("CAN");
        label7.setFont(new Font("Corbel", 14.0));

        button.setLayoutX(234.0);
        button.setLayoutY(611.0);
        button.setMnemonicParsing(false);
        button.setText("Communication Details");

        Window.getChildren().add(pane);
        Window.getChildren().add(pane0);
        Window.getChildren().add(label);
        Window.getChildren().add(label0);
        Window.getChildren().add(label1);
        Window.getChildren().add(label2);
        Window.getChildren().add(label3);
        Window.getChildren().add(label4);
        Window.getChildren().add(label5);
        Window.getChildren().add(label6);
        Window.getChildren().add(textField);
        Window.getChildren().add(datePicker);
        Window.getChildren().add(radioButton);
        Window.getChildren().add(radioButton0);
        Window.getChildren().add(radioButton1);
        Window.getChildren().add(radioButton2);
        Window.getChildren().add(textField0);
        Window.getChildren().add(textField1);
        Window.getChildren().add(label7);
        Window.getChildren().add(button);
        
        primaryStage.setScene(new Scene(Window, 384, 683));
        primaryStage.show();

    }
}

