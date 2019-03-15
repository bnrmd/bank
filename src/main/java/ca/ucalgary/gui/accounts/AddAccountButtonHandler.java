package ca.ucalgary.gui.accounts;

import ca.ucalgary.domain.Account;
import ca.ucalgary.gui.accounts.AccountWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class AddAccountButtonHandler implements EventHandler<ActionEvent>{
	Account account;
	Label display;
	/**
	 *
	 * @param account
	 * @param display
	 */
	public AddAccountButtonHandler(Account account, Label display){
		this.account = account;
		this.display = display;
	}
	
	@Override
	public void handle(ActionEvent event){
		AccountWindow ew = new AccountWindow(account, display);
		
		ew.start(AccountWindow.classStage);
	}
}