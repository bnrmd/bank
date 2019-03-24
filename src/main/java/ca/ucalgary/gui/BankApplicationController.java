package ca.ucalgary.gui;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.customer.CustomerController;
import ca.ucalgary.gui.login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BankApplicationController implements Initializable {
    private Customer customer;
    private Stage primaryStage;
    @FXML
    private Button goTo;
    @FXML
    private Button changeSceneButton;
    @FXML
    private AnchorPane body;
    public TextField firstName;
    public TextField lastName;
    @FXML
    public TextField emailSignUp;
    public PasswordField passwordSignUp;
    public TextField emailSignIn;
    public PasswordField passwordSignIn;
    public Label testLabel;
    public Button signUpButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    @FXML
    private void goToLogin(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent loginParent = (Parent)loader.load();
        LoginController controller = loader.<LoginController>getController();
        controller.setMessage("Hello");
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    public void testButton(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/accounts.fxml"));
        Parent loginParent = (Parent)loader.load();
        CustomerController controller = loader.<CustomerController>getController();
        //controller.setCustomer(customer);
        controller.setString("Hello World");
        body.getChildren().setAll(loginParent);
    }

    @FXML
    private void accountScene(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader((getClass().getResource("/account.fxml")));
        Parent accountParent = (Parent)loader.load();
        body.getChildren().setAll(accountParent);
    }

   // @FXML
    public FXMLLoader changeBody(String fxmlScene) throws Exception{
        FXMLLoader loader = new FXMLLoader((BankApplicationController.class.getResource(fxmlScene)));
        Parent accountParent = (Parent)loader.load();
        body.getChildren().setAll(accountParent);
        return loader;
    }

}
