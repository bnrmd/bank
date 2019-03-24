package ca.ucalgary.gui.login;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.BankApplicationController;
import ca.ucalgary.gui.customer.CustomerController;
import ca.ucalgary.services.BankService;
import ca.ucalgary.services.RepositoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private BankService bankService = new BankService();
    private Customer customer = null;
    private String message;
    private RepositoryService recoveredService = new RepositoryService();
    private Stage primaryStage;

    public TextField firstName;
    public TextField lastName;
    public TextField emailSignUp;
    public PasswordField passwordSignUp;
    public TextField emailSignIn;
    public PasswordField passwordSignIn;
    public Label testLabel;
    public AnchorPane main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstName.setText(message);
    }

    @FXML
    private void signUp() throws Exception{
        if(verifySignUpFields()) {
            customer = bankService.signUpCustomer(firstName.getText(), lastName.getText(), emailSignUp.getText(), passwordSignUp.getText());
            recoveredService.saveAllRepositories();
            System.out.println(customer);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/accounts.fxml"));
            Parent customerParent = (Parent) loader.load();
            CustomerController controller = loader.<CustomerController>getController();
            controller.setCustomer(customer);
            controller.setString("Done from sign up button");

            //BankApplicationController bankController = loader.<BankApplicationController>getController();
            //bankController.setCustomer(customer);

            main.getChildren().setAll(customerParent);
        } else {
            System.out.println("Not all fields entered.");
        }
    }

    private boolean verifySignUpFields(){
        return !(firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty() || emailSignUp.getText().trim().isEmpty() || passwordSignUp.getText().trim().isEmpty());
    }

    @FXML
    private void signIn(ActionEvent event) throws Exception{
        if(verifySignInFields()) {
            customer = bankService.signIn(emailSignIn.getText(), passwordSignIn.getText());
            if (customer != null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/accounts.fxml"));
                Parent customerParent = (Parent) loader.load();
                CustomerController controller = loader.<CustomerController>getController();
                controller.setCustomer(customer);
                controller.setString("Done from sign in button");

                //BankApplicationController bankController = loader.<BankApplicationController>getController();
                // bankController.setCustomer(customer);

                main.getChildren().setAll(customerParent);
            } else {
                System.out.println("Invalid Credentials.");
            }
        }
    }

    private boolean verifySignInFields(){
        return !(emailSignIn.getText().trim().isEmpty() || passwordSignIn.getText().trim().isEmpty());
    }


    public void setMessage(String message){
        this.message = message;
        testLabel.setText(message);
        System.out.println(message);
    }
}
