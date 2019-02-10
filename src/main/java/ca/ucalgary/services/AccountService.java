package ca.ucalgary.services;

import ca.ucalgary.domain.Account;

import java.util.UUID;

public class AccountService {
    public Account deposit(UUID accountId, double amount){
        // Step 1: Fetch the account POJO from datastore
        // Step 2: Create a new account transaction of type deposit
        // Step 3: Update the account POJO amount balance
        // Step 4: Save the account balance back into the datastore
        // Step 5: Update the account transaction status to success or failure
        // Step 6: Save the account transaction to the datastore
    }
}
