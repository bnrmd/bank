package ca.ucalgary.gui.accounts;

import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.AccountTransaction;
import ca.ucalgary.domain.Customer;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.AccountTransactionService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class AccountDetailsController implements Initializable {
    private Account account;
    private AccountService accountService = new AccountService();
    private AccountTransactionService accountTransactionService = new AccountTransactionService();
    private Customer customer;
    @FXML
    private AnchorPane main;
    public Label accountNoText;
    public Label typeText;
    public Label balanceText;
    public TextField withdrawAmount;
    public TextField depositAmount;
    public Button withdrawButton;
    public Button depositButton;
    public TableColumn transactionColumn;
    public TableColumn typeColumn;
    public TableColumn amountColumn;
    public TableColumn dateColumn;
    public TableView transactionTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLabels(){
        if(account!=null){
            accountNoText.setText(account.getAccountNo());
            typeText.setText(account.getType());
            balanceText.setText(String.valueOf(account.getBalance()));
        } else {
            accountNoText.setText("Account is null");
        }
    }

    @FXML
    public void withdrawAction(ActionEvent event){
        try {
            double amount = Double.parseDouble(withdrawAmount.getText());
            accountService.withdraw(account.getId(), amount);
            setLabels();
            setAccountTransactions();
        } catch (Exception e){
            System.out.println("Not enough funds");
        }
    }

    @FXML
    public void depositAction(ActionEvent event){
        double amount = Double.parseDouble(depositAmount.getText());
        accountService.deposit(account.getId(),amount);
        setLabels();
        setAccountTransactions();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAccountTransactions(){
        List<AccountTransaction> accountTransactions = accountTransactionService.getAllTransactions(account.getId());
        transactionTable.getItems().clear();
        transactionColumn.setCellValueFactory(new PropertyValueFactory<AccountTransaction,String>("transactionNo"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<AccountTransaction,String>("type"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<AccountTransaction,String>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<AccountTransaction,String>("txDateFormat"));
        for(AccountTransaction tx : accountTransactions){
            transactionTable.getItems().add(tx);
        }
    }
    
    public Account getAccount() {
    	return this.account;
    }
    
}