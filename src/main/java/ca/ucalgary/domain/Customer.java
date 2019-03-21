package ca.ucalgary.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("accountIds")
    private List<String> accountIds = new ArrayList<>();

    public Customer(){
        // not used
    }

    public Customer(String firstName, String lastName, String email){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAccountId(String accountId){
        accountIds.add(accountId);
    }

    public void removeAccountId(String accountId){
        accountIds.remove(accountId);
    }

    public List<String> getCustomerAccountIds(){
        // make a copy of list
        return accountIds;
    }

    public boolean accountIdExists(String accountId){
        // return true/false depending on if acc exists
        return accountIds.contains(accountId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accountIds=" + accountIds +
                '}';
    }
}
