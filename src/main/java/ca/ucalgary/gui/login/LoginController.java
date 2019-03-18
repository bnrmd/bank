package ca.ucalgary.gui.login;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.BankService;
import ca.ucalgary.services.RepositoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private BankService bankService = new BankService();
    private Customer customer = null;
    private String message;
    private RepositoryService recoveredService = new RepositoryService();


    public TextField firstName;
    public TextField lastName;
    public TextField emailSignUp;
    public PasswordField passwordSignUp;
    public Label testLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstName.setText(message);

    }
    @FXML
    private void signUp(ActionEvent event) throws Exception{
        System.out.println("Sign Up");
        System.out.println(firstName.getText());
        System.out.println(lastName.getText());
        System.out.println(emailSignUp.getText());
        System.out.println(passwordSignUp.getText());
        customer = bankService.signUpCustomer(firstName.getText(), lastName.getText(), emailSignUp.getText(), passwordSignUp.getText());
        recoveredService.saveAllRepositories();
    }

    public void setMessage(String message){
        this.message = message;
        testLabel.setText(message);
        System.out.println(message);
    }
}
