package ca.ucalgary.gui.customer;

import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.BankService;
import ca.ucalgary.services.CustomerService;
import ca.ucalgary.services.RepositoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    private Customer customer;
    private CustomerService customerService = new CustomerService();
    private AccountService accountService = new AccountService();
    private RepositoryService repositoryService = new RepositoryService();
    private String str;
    public Label accountInfo;
    public Label name;
    public TableView accountsTable;
    public TableColumn accountIdColumn;
    public TableColumn accountTypeColumn;
    public TableColumn accountBalanceColumn;
    public TableColumn accountViewButtonColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void addAccount(ActionEvent event) {
        Account account = accountService.createAccount();
        accountService.deposit(account.getId(), 999);
        customer.addAccountId(account.getId());
        repositoryService.saveAllRepositories();
        setTable();
        accountInfo.setText(account.getId().substring(0,8).toUpperCase() + "\n" +
                            account.getBalance() + "\n" +
                            account.getType());
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
        setName(customer.getFirstName() + " " + customer.getLastName() + "!");
        setTable();
    }

    public void setString(String str){
        this.str = str;
        System.out.println(str);
        this.accountInfo.setText(str);
    }

    public void setName(String name){
        this.name.setText(name);
    }

    public void setTable(){
        accountsTable.getItems().clear();
        accountIdColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("type"));
        accountBalanceColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("balance"));
        List<Account> accountList = accountService.getAllAccountsByIds(customer.getCustomerAccountIds());
        for(Account account : accountList){
            System.out.println("*** ACC: " + account.getId());
            accountsTable.getItems().add(account);
        }
    }

}
