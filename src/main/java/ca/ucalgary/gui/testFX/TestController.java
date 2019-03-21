package ca.ucalgary.gui.testFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class TestController implements Initializable{
	@FXML
	private Button button;
	
	@FXML
	private void switchScene(ActionEvent event) throws Exception{
		System.out.print("Works");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
