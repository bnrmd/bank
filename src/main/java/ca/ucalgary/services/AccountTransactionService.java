package ca.ucalgary.services;

import ca.ucalgary.datastore.AccountTransactionRepository;
import ca.ucalgary.domain.AccountTransaction;

import java.util.List;

public class AccountTransactionService {
	/**
	 * 
	 * @return every transaction for every account within the database
	 */
    public List<AccountTransaction> getAllTransactionsOfAllAccounts(){
        return AccountTransactionRepository.getAllTransactionsOfAllAccounts();
    }
}
