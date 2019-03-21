package ca.ucalgary.datastore;


import ca.ucalgary.domain.Account;
import ca.ucalgary.domain.Budget;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class BudgetRepository {
	
	
	public void saveBudget(Budget toSave) {
		try {
		//ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			ObjectMapper objectMapper = new ObjectMapper();
			String JSON = objectMapper.writeValueAsString(toSave);
			System.out.println(JSON);
		try {
			File budgetStore = getFile("data-stores/budget-repository.json");
			objectMapper.writeValue(budgetStore,toSave);
		} catch(IOException e){
			e.printStackTrace();
		}
		/*try {
			 File budgetStore = new File("data-stores/budget-repository.json");
		        Files.write(budgetStore.toPath(), objectMapper.writeValueAsBytes(toSave), new OpenOption[]{StandardOpenOption.TRUNCATE_EXISTING});
		}catch (IOException e) {
			e.printStackTrace();
		}*/ catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	public Budget loadBudget() {
		try {
			//ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			ObjectMapper objectMapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			//File budgetLoad = getFile("data-stores/budget-repository.json");
			Scanner scanner = new Scanner(getFile(""));
			String json = scanner.useDelimiter("\\A").next();
			List<Budget> list = objectMapper.readValue(json, new TypeReference<List<Budget>>(){});
			Budget budget = new Budget(list.get(0));
			return budget;
		}catch(Exception e) {
			e.printStackTrace();
			return new Budget(0);
		}
		
	}
	public File getFile(String path) throws URISyntaxException {
		URL url = Budget.class.getClassLoader().getResource("data-stores/budget-repository.json");
		
		Path location = Paths.get(url.toURI());
		return location.toFile();
	}
}
