package ca.ucalgary.services;

import ca.ucalgary.datastore.CustomerAccessRepository;
import ca.ucalgary.domain.CustomerAccess;

public class CustomerAccessService {

    /**
     * @return an customerAccess that has been created and added to the CustomerAccessRepository
     */
    public CustomerAccess createCustomerAccess(String customerId, String email, String password) {
        CustomerAccess customerAccess = new CustomerAccess(customerId,email,password);
        CustomerAccessRepository.addCustomerAccess(customerAccess);

        return customerAccess;
    }

    public CustomerAccess getCustomerAccessById(String customerId){
        return CustomerAccessRepository.getCustomerAccess(customerId);
    }

    public CustomerAccess authenticate(String email, String password){
        return CustomerAccessRepository.getAccessFor(email, password);
    }

}
