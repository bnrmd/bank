package ca.ucalgary.gui.profile;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.CustomerService;
import ca.ucalgary.services.RepositoryService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private Customer customer;
    @FXML
    private AnchorPane main;
    public Label name;
    public Label fname;
    public Label lname;
    public Label clientId;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    /**
     * sets the profile stage of the application with the user's information
     * @param c context customer
     */
    @FXML
    public void setProfile(Customer c){
        this.fname.setText(c.getFirstName());
        this.lname.setText(c.getLastName());
        this.clientId.setText(c.getEmail());
    }

    /**
     * setter for customer
     * @param customer
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}