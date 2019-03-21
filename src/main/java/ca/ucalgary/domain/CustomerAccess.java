package ca.ucalgary.domain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class CustomerAccess {

    // this customer access is representation of keeping track of the user login
    private static String salt = "somesalt";
    private String id;
    private String customerId;
    private String email;
    private String hash;

    public CustomerAccess(){

    }

    public CustomerAccess(String customerId, String email, String password){
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.email = email;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String pwd = password + salt;
            byte[] h = digest.digest(pwd.getBytes(StandardCharsets.UTF_8));
            this.hash = Base64.getEncoder().encodeToString(h);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyCredentials(String email, String password) {
        String hashed;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String pwd = password + salt;
            byte[] h = digest.digest(pwd.getBytes(StandardCharsets.UTF_8));
            hashed = Base64.getEncoder().encodeToString(h);

            return this.email.equals(email) && this.hash.equals(hashed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}
