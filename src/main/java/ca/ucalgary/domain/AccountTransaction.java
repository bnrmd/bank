package ca.ucalgary.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Representation of an audit trail of all the operations done on an account domain object
 */
public class AccountTransaction {
    private String id; // Identify individual transactions
    private String accountId; // Identify account
    private String type; // Type of a transaction, e.g. 'Deposit', 'Withdraw', or 'Create'
    private double amount; // Amount of money to be part of this transaction, if any
    private String status; // To represent if the transaction was successful, or failed
    private LocalDateTime txDate; // Transaction date/time

    private AccountTransaction(){
        /* REMINDER: We should never create an empty transaction */
    }

    /**
     * 
     * @param accountId	 UUID in String format of an account
     * @param type	type of account (SAVINGS, CHEQUING)
     * @param amount	amount to initialize for account (in dollars)
     */
    public AccountTransaction(String accountId, String type, double amount){
        this.id = UUID.randomUUID().toString();
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.status = "PENDING"; // Whenever you create a transaction the transaction is not completed yet
        this.txDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransaction)) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                id.equals(that.id) &&
                accountId.equals(that.accountId) &&
                type.equals(that.type) &&
                status.equals(that.status) &&
                txDate.equals(that.txDate);
    }

    /**
     * @return	hash for an account
     */
    @Override
    public int hashCode() {
    	/* used to speed up Java collections management
         * e.g. List<Account> */
        return Objects.hash(id, accountId, type, amount, status, txDate);
    }

    /**
     * @return	status for transaction
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status	set status for a transaction
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return	the id of a transaction
     */
    public String getId() {
        return id;
    }

    /**
     * @return	an account id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return	type of transaction (withdrawal, deposit)
     */
    public String getType() {
        return type;
    }

    /**
     * @return	amount of money (dollars) in a transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return	date / time of transaction
     */
    public LocalDateTime getTxDate() {
        return txDate;
    }
}
