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

	/**
	 *
	 * @param accountId account id
	 * @return all transactions of account based on id
	 */
	public List<AccountTransaction> getAllTransactions(String accountId){
    	return AccountTransactionRepository.getAllAccountTransactions(accountId);
	}
}
