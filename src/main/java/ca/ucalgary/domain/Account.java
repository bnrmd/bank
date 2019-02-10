package ca.ucalgary.domain;

import java.util.Objects;
import java.util.UUID;

/**
 * This Account class represents the amount of money for this account type.
 */
public class Account {
    private UUID id; // Represents a Unique ID to identify an account
    private double balance; // Represents the current funds on this account
    private String type; // What kind of type of account it is (Saving, Chequing)

    public Account() {
        this.balance = 0.0;
        this.id = UUID.randomUUID();
        this.type = "CHEQUING";
    }

    public Account(String type) {
        this.balance = 0.0;
        this.id = UUID.randomUUID();
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                id.equals(account.id) &&
                type.equals(account.type);
    }

    // Used to speed up Java collections management
    // e.g. List<Account>
    @Override
    public int hashCode() {
        return Objects.hash(id, balance, type);
    }

    public UUID getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
