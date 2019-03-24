package ca.ucalgary.gui.customer;

import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.Customer;
import ca.ucalgary.gui.BankApplication;
import ca.ucalgary.gui.BankApplicationController;
import ca.ucalgary.gui.accounts.AccountDetailsController;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.CustomerService;
import ca.ucalgary.services.RepositoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    private Customer customer;
    private CustomerService customerService = new CustomerService();
    private AccountService accountService = new AccountService();
    private RepositoryService repositoryService = new RepositoryService();
    private String str;
    @FXML private AnchorPane main;
    public Label accountInfo;
    public Label name;
    public TableView accountsTable;
    public TableColumn accountIdColumn;
    public TableColumn accountTypeColumn;
    public TableColumn accountBalanceColumn;
    public TableColumn accountId;
    public ComboBox accountType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void addAccount() {
        String accountTypeString;
        if(accountType.getValue() != null){
            accountTypeString = accountType.getValue().toString();
        } else {
            accountTypeString = "Savings";
        }
        Account account = accountService.createAccount(accountTypeString.toUpperCase());
        //accountService.deposit(account.getId(), 0);
        customer.addAccountId(account.getId());
        repositoryService.saveAllRepositories();
        updateAccountsTable();
        /*
        accountInfo.setText(account.getId().substring(0,8).toUpperCase() + "\n" +
                            account.getBalance() + "\n" +
                            account.getType());
                            */
        accountInfo.setText(accountTypeString + " Account " + account.getId().substring(0,8).toUpperCase() + " Created");
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void populateForm(Customer customer){
        this.customer = customer;
        setName(customer.getFirstName() + " " + customer.getLastName() + "!");
        updateAccountsTable();
    }

    public void setString(String str){
        this.str = str;
        System.out.println(str);
        this.accountInfo.setText(str);
    }

    public void setName(String name){
        this.name.setText(name);
    }

    public void updateAccountsTable(){
        accountsTable.getItems().clear();
        accountIdColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("accountNo"));
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("type"));
        accountBalanceColumn.setCellValueFactory(new PropertyValueFactory<Account,String>("balance"));
        accountId.setCellValueFactory(new PropertyValueFactory<Account,String>("id"));
        List<Account> accountList = accountService.getAllAccountsByIds(customer.getCustomerAccountIds());
        for(Account account : accountList){
            accountsTable.getItems().add(account);
        }
    }

    public void getSelectedRow() throws Exception{
        TablePosition cell = (TablePosition)accountsTable.getSelectionModel().getSelectedCells().get(0);
        System.out.println(((Account)accountsTable.getItems().get(cell.getRow())).getId());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/account-details.fxml"));
        Parent accountDetailsParent = (Parent) loader.load();
        AccountDetailsController controller = loader.<AccountDetailsController>getController();
        controller.setAccount(accountService.getAccount(((Account)accountsTable.getItems().get(cell.getRow())).getId()));
        controller.setCustomer(customer);
        controller.setLabels();
        controller.setAccountTransactions();
        main.getChildren().setAll(accountDetailsParent);
    }

}
