package ca.ucalgary.tui;

import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.AccountTransaction;
import ca.ucalgary.services.AccountService;
import ca.ucalgary.services.AccountTransactionService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CLI {

    private AccountService accountService = new AccountService();
    private AccountTransactionService accountTransactionService = new AccountTransactionService();

    public static void main(String args[]){
        CLI cli = new CLI();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Account account = null;
        
        boolean run = true;
        while (run) {
            System.out.println("--------------------------------------------\n" +
                               "[1] create an account    [4] display all transactions    [7] display every transaction ever     |     amount of accounts:        " + cli.getNumberOfAccounts() + "\n" +
                               "[2] deposit              [5] display all accounts        [8]                                    |     current account id:        " + cli.getAccountIdIfExists(account) + "\n" +
                               "[3] withdraw             [6] switch account              [q] quit                               |     current account balance:   " + cli.getAccountBalIfExists(account) +"\n");
            
			// selection 
            System.out.print("Enter Selection: ");
            String operation = scanner.nextLine();
           
			while (!(operation.equals("1")||operation.equals("2")||operation.equals("3") ||operation.equals("4") 
					||operation.equals("5")||operation.equals("6")||operation.equals("7")||operation.equals("8") 
					||operation.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				operation = scanner.nextLine();
			}

            switch (operation) {
                case "1":
                    account = cli.create();
                    System.out.println("Account created: " + account.getId());
                    break;
                case "2":
                    System.out.println("How much do you want to deposit?");
                    String depositAmount = scanner.nextLine();
                    cli.deposit(account, Double.parseDouble(depositAmount));
                    System.out.println("Deposited " + depositAmount + ". New balance: " + account.getBalance());
                    break;
                case "3":
                    System.out.println("How much do you want to withdraw?");
                    String withdrawAmount = scanner.nextLine();
                    cli.withdraw(account, Double.parseDouble(withdrawAmount));
                    System.out.println("Withdrew " + withdrawAmount + ". New balance: " + account.getBalance());
                    break;
                case "4":
                    cli.displayAllTransactions(account);
                    break;
                case "5":
                    cli.showAccounts();
                    break;
                case "6":
                    cli.showAccounts();
                    System.out.println("Enter the first n characters of the account's ID:");
                    String accountIdPart = scanner.nextLine();
                    account = cli.findAccount(cli.accountService.getAllAccounts(), accountIdPart);
                    break;
                case "7":
                    cli.displayAllTransactionsOfAllAccounts();
                    break;
                case "q":
                    run = false;
                    break;
                default: // will never run
                    break;
            }
        }
    }

    public Account create(){
        return accountService.createAccount();
    }

    public void deposit(Account account, double amount){
        accountService.deposit(account.getId(), amount);
    }

    public void withdraw(Account account, double amount){
        accountService.withdraw(account.getId(), amount);
    }

    public void displayAllTransactions(Account account){
        accountService.getAllAccountTransactions(account.getId())
                    .stream()
                    .sorted(Comparator.comparing(AccountTransaction::getTxDate))
                    .forEach(accountTransaction -> System.out.println(accountTransaction));
    }

    public void showAccounts(){
        accountService.getAllAccounts()
                .forEach(account -> System.out.println(account));
    }

    public int getNumberOfAccounts(){
        return accountService.getAllAccounts().size();
    }

    private Account findAccount(List<Account> accounts, String accountIdPart) {
        return accounts.stream().filter(account -> account.getId().startsWith(accountIdPart))
                .findFirst().orElseThrow(() -> new RuntimeException("Account not found."));
    }

    private String getAccountIdIfExists(Account account){
        if (account != null) return account.getId();
        else return null;
    }

    private double getAccountBalIfExists(Account account){
        if (account != null) return account.getBalance();
        else return 0.0;
    }

    public void displayAllTransactionsOfAllAccounts(){
        accountTransactionService.getAllTransactionsOfAllAccounts()
                                .stream().sorted(Comparator.comparing(AccountTransaction::getTxDate))
                                .forEach(accountTransaction -> System.out.println(accountTransaction));
    }
}
