package ca.ucalgary.datastore;

import ca.ucalgary.domain.AccountTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountTransactionRepository {

    private static Map<String, AccountTransaction> accountTransactions = new HashMap<>();

    public static void addAccountTransaction(AccountTransaction accountTransaction){
        accountTransactions.put(accountTransaction.getId(), accountTransaction);
    }

    public static AccountTransaction getAccountTransaction(String accountTransactionId){
        return accountTransactions.get(accountTransactionId);
    }

    public static List<AccountTransaction> getAllAccountTransactions(String accountId) {
        return accountTransactions.values()
                            .stream()
                            .filter(accountTransaction -> accountTransaction.getAccountId().equals(accountId))
                            .collect(Collectors.toList());
    }

    public static List<AccountTransaction> getAllTransactionsOfAllAccounts(){
        return accountTransactions.values().stream().collect(Collectors.toList());
    }
}
