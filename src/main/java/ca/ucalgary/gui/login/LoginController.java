package ca.ucalgary.gui.login;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.BankApplicationController;
import ca.ucalgary.gui.accounts.AccountController;
import ca.ucalgary.gui.customer.CustomerController;
import ca.ucalgary.services.BankService;
import ca.ucalgary.services.RepositoryService;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


    public TextField firstName;
    public TextField lastName;
    public TextField emailSignUp;
    public PasswordField passwordSignUp;
    public TextField emailSignIn;
    public PasswordField passwordSignIn;
    public Label testLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        firstName.setText(message);

    }
    @FXML
    private void signUp(ActionEvent event) throws Exception{
        customer = bankService.signUpCustomer(firstName.getText(), lastName.getText(), emailSignUp.getText(), passwordSignUp.getText());
        //recoveredService.saveAllRepositories();
        if(customer!=null){
            AnchorPane mainPane = FXMLLoader.load(getClass().getResource("/bank.fxml"));
            FilteredList<Node> filteredList = mainPane.getChildren().filtered(node -> node.getId().equals("body"));
            Node body = filteredList.get(0);
            AnchorPane b = (AnchorPane)body;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/customer.fxml"));
            Parent customerLayout = (Parent)loader.load();
            b.getChildren().setAll(customerLayout);
            //FXMLLoader loader = BankApplicationController.changeBody("/customer.fxml");
            // setting default scene to Accounts page
            CustomerController controller = loader.getController();
            controller.setCustomer(customer);
        }
    }

    @FXML
    private void signIn(ActionEvent event) throws Exception{
        customer = bankService.signIn(emailSignIn.getText(),passwordSignIn.getText());
        if(customer!=null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
            Parent loginParent = (Parent)loader.load();
            LoginController controller = loader.<LoginController>getController();
            controller.setMessage("Hello");
            Scene loginScene = new Scene(loginParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        }

    }

    public void setMessage(String message){
        this.message = message;
        testLabel.setText(message);
        System.out.println(message);
    }
}
