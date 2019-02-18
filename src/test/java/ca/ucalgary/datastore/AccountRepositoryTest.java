package ca.ucalgary.datastore;

import ca.ucalgary.domain.Account;

import ca.ucalgary.datastore.AccountRepository;

import org.junit.Assert;
import org.junit.Test;

public class AccountRepositoryTest {

    //private static AccountRepository accountRepository = new AccountRepository();
    @Test
    public void createAccount_withValidAccountType(){
        // ARRANGE
        Account account = new Account("SAVINGS");
        // ACT
        AccountRepository.addAccount(account);
        // ASSERT
        Account a = AccountRepository.getAccount(account.getId());
        Assert.assertEquals("SAVINGS", a.getType());
        Assert.assertEquals(0.0, a.getBalance(), 0.001);
    }

    @Test
    public void deleteAccount_whenAccountExists(){
        // ARRANGE
        Account account = new Account("SAVINGS");
        // ACT
        AccountRepository.addAccount(account);
        // ASSERT
        Account a = AccountRepository.getAccount(account.getId());
        Assert.assertNotNull(a);
        Assert.assertEquals(account.getId(),a.getId());
        String accountId = a.getId();
        // ACT
        AccountRepository.printAllAccounts();
        System.out.println("Account ID: " + accountId);

        AccountRepository.deleteAccount(accountId);
        // ASSERT
        /*
        try {
            AccountRepository.getAccount(accountId);
        }catch(RuntimeException e){
            Assert.assertEquals("This account ID does not exist and cannot be returned: " + accountId, e.getMessage());
        }
        */

    }
}
