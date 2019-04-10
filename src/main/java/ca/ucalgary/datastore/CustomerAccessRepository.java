package ca.ucalgary.datastore;

import ca.ucalgary.domain.CustomerAccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerAccessRepository {

    private static Map<String, CustomerAccess> store = new HashMap<>();

    /**
     *
     * @param customerAccess
     * @return
     */
    public static CustomerAccess addCustomerAccess(CustomerAccess customerAccess){
        store.put(customerAccess.getEmail(),customerAccess);

        return customerAccess;
    }

    /**
     *
     * @param customerAccessId
     * @return
     */
    public static CustomerAccess getCustomerAccess(String customerAccessId){
        if(store.containsKey(customerAccessId)){
            return store.get(customerAccessId);
        }

        throw new RuntimeException("This customer access ID does not exist: " + customerAccessId);
    }

    /**
     *
     * @param customerAccessId
     */
    public static void deleteCustomerAccess(String customerAccessId) {
        if(store.containsKey(customerAccessId)){
            store.remove(customerAccessId);
            return;
        }

        throw new RuntimeException("This customer access ID does not exist and cannot be deleted: " + customerAccessId);
    }

    /**
     * used to print all accounts
     */
    public static void printAllCustomers(){
        store.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));
    }


    /**
     *
     * @param email
     * @param password
     * @return
     */
    public static CustomerAccess getAccessFor(String email, String password) {
        CustomerAccess customerAccess = null;
        boolean isVerified = false;
        if(store.containsKey(email)){
            customerAccess = store.get(email);
            isVerified = customerAccess.verifyCredentials(email,password);
        }
        if(isVerified) {
            return customerAccess;
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }

    /**
     *
     * @return
     */
    public static List<CustomerAccess> getAllCustomerAccess(){
        return store.values().stream().collect(Collectors.toList());
    }

    /**
     *
     * @param customerAccesses
     */
    public static void setAllCustomerAccess(List<CustomerAccess> customerAccesses){
        store = customerAccesses.stream().collect(Collectors.toMap(CustomerAccess::getEmail,customerAccess -> customerAccess));
    }
}
