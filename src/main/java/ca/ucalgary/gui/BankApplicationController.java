package ca.ucalgary.gui;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.customer.CustomerController;
import ca.ucalgary.gui.budget.BudgetController;
import ca.ucalgary.gui.profile.ProfileController;
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
    @FXML private AnchorPane body;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    @FXML
    public void accountButton(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/accounts.fxml"));
        Parent customerParent = (Parent)loader.load();
        CustomerController controller = loader.<CustomerController>getController();
        controller.populateForm(BankApplication.getCustomer());
        controller.setString("Accounts");
        body.getChildren().setAll(customerParent);
    }

    @FXML
    public void budgetButton(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Budget.fxml"));
        Parent budgetParent = (Parent)loader.load();
        //BudgetController controller = loader.<CustomerController>getController();

        body.getChildren().setAll(budgetParent);
    }
    
    // Invest Button
    @FXML
    public void investButton(ActionEvent event) throws Exception{
    	InvestGUI myInvest = new InvestGUI();
    	myInvest.start(primaryStage);
    }

    @FXML
    public void profileButton(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/profile.fxml"));
        Parent profileParent = (Parent)loader.load();
        ProfileController controller = loader.<ProfileController>getController();
        //controller.setCustomer(BankApplication.getCustomer());
        controller.setProfile(BankApplication.getCustomer());
        body.getChildren().setAll(profileParent);
    }

   // @FXML
    public FXMLLoader changeBody(String fxmlScene) throws Exception{
        FXMLLoader loader = new FXMLLoader((BankApplicationController.class.getResource(fxmlScene)));
        Parent accountParent = (Parent)loader.load();
        body.getChildren().setAll(accountParent);
        return loader;
    }

}
