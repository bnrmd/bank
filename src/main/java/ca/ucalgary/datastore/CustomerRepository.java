package ca.ucalgary.datastore;

import ca.ucalgary.domain.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerRepository {

    private static Map<String,Customer> store = new HashMap<>();

    public static Customer addCustomer(Customer customer){
        store.put(customer.getId(),customer);

        return customer;
    }

    public static Customer getCustomer(String customerId){
        if(store.containsKey(customerId)){
            return store.get(customerId);
        }

        throw new RuntimeException("This customer ID does not exist: " + customerId);
    }

    public static void deleteCustomer(String customerId) {
        if(store.containsKey(customerId)){
            store.remove(customerId);
            return;
        }

        throw new RuntimeException("This customer ID does not exist and cannot be deleted: " + customerId);
    }

    public static List<Customer> getAllCustomers(){
        return store.values().stream().collect(Collectors.toList());
    }

    public static void setAllCustomers(List<Customer> customers){
        store = customers.stream().collect(Collectors.toMap(Customer::getId,customer -> customer));
    }

    /* used to print all accounts */
    public static void printAllCustomers(){
        store.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));
    }
}
