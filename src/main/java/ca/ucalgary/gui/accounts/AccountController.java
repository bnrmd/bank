package ca.ucalgary.gui.accounts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {

    @FXML private TextField initialDeposit;
    @FXML private ChoiceBox<String> accountType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void createAccount(ActionEvent event) throws Exception{
        String type = accountType.getValue();
        double balance = Double.parseDouble(initialDeposit.getText());
    }

}
