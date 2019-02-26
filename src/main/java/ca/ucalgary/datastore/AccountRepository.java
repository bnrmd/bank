package ca.ucalgary.datastore;

import ca.ucalgary.domain.Account;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountRepository {

    // String = key, Account = object
    private static Map<String,Account> store = new HashMap<>(); // String is the UUID (Identifier of an Account)

    public static Account addAccount(Account account){
        store.put(account.getId(), account);

        return account;
    }

    public static Account getAccount(String accountId) {
        if(store.containsKey(accountId)){
            return store.get(accountId);
        }

        throw new RuntimeException("This account ID does not exist and cannot be returned: " + accountId);
    }

    public static void deleteAccount(String accountId) {
        if(store.containsKey(accountId)){
            store.remove(accountId);
            return;
        }

        throw new RuntimeException("This account ID does not exist and cannot be deleted: " + accountId);
    }

    public static Account updateAccount(String accountId, double balance) {
        if(store.containsKey(accountId)){
            Account accountToUpdate = store.get(accountId);
            accountToUpdate.setBalance(balance);

            return accountToUpdate;
        }

        throw new RuntimeException("This account ID does not exist and cannot be updated: " + accountId);
    }

    public static Account updateAccount(String accountId, String type) {
        if(store.containsKey(accountId)) {
            Account accountToUpdate = store.get(accountId);
            accountToUpdate.setType(type);

            return accountToUpdate;
        }

        throw new RuntimeException("This account ID does not exist and cannot be updated: " + accountId);
    }

    public static Account updateAccount(String accountId, double balance, String type) {
        if(store.containsKey(accountId)) {
            Account accountToUpdate = store.get(accountId);
            accountToUpdate.setBalance(balance);
            accountToUpdate.setType(type);

            return accountToUpdate;
        }

        throw new RuntimeException("This account ID does not exist and cannot be updated: " + accountId);
    }

    public List<Account> getAllAccounts(){
        return store.values().stream().collect(Collectors.toList());
    }

    public static void printAllAccounts(){
        store.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));
    }
}

