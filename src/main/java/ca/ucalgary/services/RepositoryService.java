package ca.ucalgary.services;

import ca.ucalgary.datastore.AccountRepository;
import ca.ucalgary.domain.Account;
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
            //List<Account> accountsIn = Collections.emptyList();
            //accountsIn = mapper.readValue(JSON, new TypeReference<List<Account>>(){});
            //accountsIn.forEach(account -> System.out.println(account));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreAllRepositories(){
        // Read from account-repository.json and use mapper to transform it into a list of accounts
        // Take the list of accounts and create a map of String, Account
        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String JSON = "";
            // Read the file into the JSON string

            List<Account> accounts = mapper.readValue(getFile("data-stores/account-repository.json"), new TypeReference<List<Account>>(){});

            accounts.forEach(account -> System.out.println(account));
            AccountRepository.setAllAccounts(accounts);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private File getFile(String path) throws URISyntaxException {
        URL url = AccountRepository.class.getClassLoader().getResource(path);
        Path location = Paths.get(url.toURI());
        return location.toFile();
    }

}
