package ca.ucalgary.services;

import ca.ucalgary.datastore.AccountRepository;
import ca.ucalgary.datastore.AccountTransactionRepository;
import ca.ucalgary.datastore.CustomerAccessRepository;
import ca.ucalgary.datastore.CustomerRepository;
import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.AccountTransaction;
import ca.ucalgary.domain.Customer;
import ca.ucalgary.domain.CustomerAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class RepositoryService {

    public void saveAllRepositories(){
        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Account> accounts = AccountRepository.getAllAccounts();
            String JSON = mapper.writeValueAsString(accounts);
            System.out.println(JSON);

            // Write String to file
            try {
                // Writing to a file
                //mapper.writeValue(getFile("data-stores/account-repository.json"), JSON );
                File accountStore = getFile("data-stores/account-repository.json");
                Files.write(accountStore.toPath(), mapper.writeValueAsBytes(accounts), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});

            } catch (IOException e) {
                e.printStackTrace();
            }

            List<AccountTransaction> accountTransactions = AccountTransactionRepository.getAllAccountTransactions();
            JSON = mapper.writeValueAsString(accountTransactions);
            System.out.println(JSON);

            // Write String to file
            try {
                // Writing to a file
                //mapper.writeValue(getFile("data-stores/account-repository.json"), JSON );
                File accountTransactionsStore = getFile("data-stores/accounttransactions-repository.json");
                Files.write(accountTransactionsStore.toPath(), mapper.writeValueAsBytes(accountTransactions), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});

            } catch (IOException e) {
                e.printStackTrace();
            }

            List<Customer> customers = CustomerRepository.getAllCustomers();
            JSON = mapper.writeValueAsString(customers);
            System.out.println(JSON);

            // Write String to file
            try {
                // Writing to a file
                //mapper.writeValue(getFile("data-stores/account-repository.json"), JSON );
                File customerStore = getFile("data-stores/customer-repository.json");
                Files.write(customerStore.toPath(), mapper.writeValueAsBytes(customers), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});

            } catch (IOException e) {
                e.printStackTrace();
            }

            List<CustomerAccess> customerAccess = CustomerAccessRepository.getAllCustomerAccess();
            JSON = mapper.writeValueAsString(customerAccess);
            System.out.println(JSON);

            // Write String to file
            try {
                // Writing to a file
                //mapper.writeValue(getFile("data-stores/account-repository.json"), JSON );
                File customerAccessStore = getFile("data-stores/customeraccess-repository.json");
                Files.write(customerAccessStore.toPath(), mapper.writeValueAsBytes(customerAccess), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});

            } catch (IOException e) {
                e.printStackTrace();
            }
            //List<Account> accountsIn = Collections.emptyList();
            //accountsIn = mapper.readValue(JSON, new TypeReference<List<Account>>(){});
            //accountsIn.forEach(account -> System.out.println(account));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreAllRepositories(){
        /* Read from account-repository.json and use mapper to transform it into a list of accounts
           Take the list of accounts and create a map of String, Account */
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            String JSON = "";
            // Read the file into the JSON string

            List<Account> accounts = mapper.readValue(getFile(""), new TypeReference<List<Account>>(){});

            accounts.forEach(account -> System.out.println(account));
            AccountRepository.setAllAccounts(accounts);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            String JSON = "";
            // Read the file into the JSON string

            List<AccountTransaction> accountTransactions = mapper.readValue(getFile(""), new TypeReference<List<AccountTransaction>>(){});

            accountTransactions.forEach(accountTransaction -> System.out.println(accountTransaction));
            AccountTransactionRepository.setAllAccountTransactions(accountTransactions);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            String JSON = "";
            // Read the file into the JSON string

            List<Customer> customers = mapper.readValue(getFile(""), new TypeReference<List<Customer>>(){});

            customers.forEach(customer -> System.out.println(customer));
            CustomerRepository.setAllCustomers(customers);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            String JSON = "";
            // Read the file into the JSON string

            List<CustomerAccess> customerAccesses = mapper.readValue(getFile(""), new TypeReference<List<CustomerAccess>>(){});

            customerAccesses.forEach(customerAccess -> System.out.println(customerAccess));
            CustomerAccessRepository.setAllCustomerAccess(customerAccesses);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param path the path of the file location
     * @return the location of file in File format
     * @throws URISyntaxException
     */
    public File getFile(String path) throws URISyntaxException {
        //URL testurl = AccountRepository.class.getResource("data-stores/account-repository.json");
        //System.out.println("Current location: " + testurl.getPath());
        /*URL testurl = AccountRepository.class.getResource("/data-stores/account-repository.json");
        System.out.println("Current location: " + testurl.getPath());
        URL url = AccountRepository.class.getResource("/resources/data-stores/account-repository.json");
        Path location = Paths.get(url.toURI());*/

        URL url = AccountRepository.class.getClassLoader().getResource(path);
        Path location = Paths.get(url.toURI());
        return location.toFile();
    }

}
