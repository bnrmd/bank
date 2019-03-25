package ca.ucalgary.gui;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.customer.CustomerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BankApplicationController implements Initializable {
    private Customer customer;
    private Stage primaryStage;
    @FXML
    private AnchorPane body;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

//
//    @FXML
//    private void goToLogin(ActionEvent event) throws Exception{
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
//        Parent loginParent = (Parent)loader.load();
//        LoginController controller = loader.<LoginController>getController();
//        controller.setMessage("Hello");
//        Scene loginScene = new Scene(loginParent);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(loginScene);
//        window.show();
//    }

    @FXML
    public void accountButton(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/accounts-theme2.fxml"));
        Parent customerParent = (Parent)loader.load();
        CustomerController controller = loader.<CustomerController>getController();
        controller.populateForm(BankApplication.getCustomer());
        controller.setString("Accounts");
        body.getChildren().setAll(customerParent);
    }

   // @FXML
    public FXMLLoader changeBody(String fxmlScene) throws Exception{
        FXMLLoader loader = new FXMLLoader((BankApplicationController.class.getResource(fxmlScene)));
        Parent accountParent = (Parent)loader.load();
        body.getChildren().setAll(accountParent);
        return loader;
    }

}
