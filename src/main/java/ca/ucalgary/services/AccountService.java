package ca.ucalgary.services;

import ca.ucalgary.datastore.AccountRepository;
import ca.ucalgary.datastore.AccountTransactionRepository;
import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.AccountTransaction;

import java.util.List;

/**
 * AccountService
 * Exposes actions applied onto an account
 * Such as: create, update, delete, withdraw, deposit...
 */
public class AccountService {

    private static AccountRepository accountRepository = new AccountRepository();

    public Account createAccount() {
        Account account = new Account();
        accountRepository.addAccount(account);
        AccountTransaction accountTransaction = new AccountTransaction(account.getId(),"CREATE",account.getBalance());
        AccountTransactionRepository.addAccountTransaction(accountTransaction);

        return account;
    }

    public Account createAccount(String type) {
        Account account = new Account(type);
        accountRepository.addAccount(account);
        AccountTransaction accountTransaction = new AccountTransaction(account.getId(),"CREATE",account.getBalance());
        AccountTransactionRepository.addAccountTransaction(accountTransaction);

        return account;
    }

    public Account createAccount(String type, double balance) {
        Account account = new Account(type);
        account.setBalance(balance);
        accountRepository.addAccount(account);
        AccountTransaction accountTransaction = new AccountTransaction(account.getId(),"CREATE",account.getBalance());
        AccountTransactionRepository.addAccountTransaction(accountTransaction);

        return account;
    }

    public Account getAccount(String accountId) {
        return accountRepository.getAccount(accountId);
    }

    public void deleteAccount(String accountId) {
        Account a = AccountRepository.getAccount(accountId);
        AccountTransaction accountTransaction = new AccountTransaction(accountId,"DELETE", a.getBalance());
        AccountTransactionRepository.addAccountTransaction(accountTransaction);

        accountRepository.deleteAccount(accountId);
    }

    public Account updateAccount(String accountId, String type) {
        return accountRepository.updateAccount(accountId, type);
    }

    public Account deposit(String accountId, double amount){
        // Step 1: Fetch the account POJO from datastore
        // Step 2: Create a new account transaction of type deposit
        // Step 3: Update the account POJO amount balance
        // Step 4: Save the account balance back into the datastore
        // Step 5: Update the account transaction status to success or failure
        // Step 6: Save the account transaction to the datastore
        Account account = accountRepository.getAccount(accountId);
        double finalBalance = account.getBalance() + amount;
        AccountTransaction accountTransaction = new AccountTransaction(account.getId(),"DEPOSIT",amount);
        AccountTransactionRepository.addAccountTransaction(accountTransaction);

        return accountRepository.updateAccount(accountId, finalBalance);
    }

    public Account withdraw(String accountId, double amount){
        Account account = accountRepository.getAccount(accountId);
        if(amount <= account.getBalance()) {
            double finalBalance = account.getBalance() - amount;
            AccountTransaction accountTransaction = new AccountTransaction(account.getId(),"WITHDRAW",amount);
            AccountTransactionRepository.addAccountTransaction(accountTransaction);

            return accountRepository.updateAccount(accountId, finalBalance);
        } else {
            throw new RuntimeException("Not enough funds.");
        }
    }

    public List<AccountTransaction> getAllAccountTransactions(String accountId){
        return AccountTransactionRepository.getAllAccountTransactions(accountId);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.getAllAccounts();
    }
}
