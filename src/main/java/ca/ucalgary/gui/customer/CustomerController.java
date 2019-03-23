package ca.ucalgary.gui.customer;

import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.BankService;
import ca.ucalgary.services.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    private Customer customer;
    private CustomerService customerService = new CustomerService();
    private AccountService accountService = new AccountService();

    public Label accountInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void addAccount(ActionEvent event) {
        Account account = accountService.createAccount();
        accountService.deposit(account.getId(), 999);
        customer.addAccountId(account.getId());
        accountInfo.setText(account.getId().substring(0,8).toUpperCase() + "\n" +
                            account.getBalance() + "\n" +
                            account.getType());
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

}
