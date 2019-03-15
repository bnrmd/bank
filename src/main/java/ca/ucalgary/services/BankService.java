package ca.ucalgary.services;

import ca.ucalgary.domain.Customer;
import ca.ucalgary.domain.CustomerAccess;

public class BankService {

    private CustomerService customerService = new CustomerService();
    private CustomerAccessService customerAccessService = new CustomerAccessService();

    public Customer signUpCustomer(String firstName, String lastName, String email, String password){
        Customer customer = customerService.createCustomer(firstName,lastName,email);
        customerAccessService.createCustomerAccess(customer.getId(),email,password);

        return customer;
    }

    public Customer signIn(String email, String password){
        CustomerAccess customerAccess = null;
        Customer customer = null;
        try {
            customerAccess = customerAccessService.authenticate(email, password);
            customer = customerService.getCustomerById(customerAccess.getCustomerId());
        } catch(Exception e){

        }
        return customer;
    }

}
