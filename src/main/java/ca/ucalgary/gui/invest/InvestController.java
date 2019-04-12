package ca.ucalgary.gui.invest;

// Imports 
import ca.ucalgary.datastore.InvestRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

/**
 * Invest Controller Class
 * controller class for invest fxml
 */
public class InvestController{
	
	// Declare Variables
	//InvestRepository myInvestRepository = 
	
	// Declare Menu Scene Variables
	@FXML
	AnchorPane homePane;
	@FXML
	Button btnSS;
	@FXML
	Button btnVAS;
	@FXML
	Button btnVP;
	@FXML
	Button btnI;
	
	// Declare SearchStock Variables
	@FXML
	AnchorPane searchPane;
	@FXML
	TextField getSearch;
	@FXML
	Button btnSearch;
	@FXML
	Label result;
	@FXML
	Button btnBSS;
	
	// Declare ViewAllStocks Variables
	@FXML
	AnchorPane viewPane;
	@FXML
	ScrollPane resultPane;
	@FXML
	Button btnBVAS;
	
	
	// Declare PortfolioMethod Variables
	@FXML
	AnchorPane portfolioPane;
	@FXML
	Label lblMyPortfolio;
	@FXML
	Button btnBP;
	
	// Declare InvestMethod Variables
	@FXML
	AnchorPane buyPane;
	@FXML
	TextField getStock;
	@FXML
	TextField getAmount;
	@FXML
	Button btnPurchase;
	@FXML
	Label txtNotification;
	@FXML
	Button btnBBS;
	
	/**
	 * Back button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void BackS(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/InvestMain.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		searchPane.getChildren().clear();
		searchPane.getChildren().addAll(toMenu );
	}
	@FXML
	private void BackV(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/InvestMain.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		viewPane.getChildren().clear();
		viewPane.getChildren().addAll(toMenu);
	}
	@FXML
	private void BackP(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/InvestMain.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		portfolioPane.getChildren().clear();
		portfolioPane.getChildren().addAll(toMenu);
	}
	@FXML
	private void BackI(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/InvestMain.fxml"));
		Parent toMenu = (Parent)fxmlLoader.load();
		buyPane.getChildren().clear();
		buyPane.getChildren().addAll(toMenu);
	}
	
	/**
	 * SearchStock button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void SearchStock(ActionEvent event) throws IOException{
		Parent view2 = FXMLLoader.load(getClass().getResource("/SearchStock.fxml"));
		Scene scene2 = new Scene(view2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
		
		/*
		FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("SearchStock.fxml"));
		Parent parent = (Parent)fxmlLoader.load();
		homePane.getChildren().clear();
		homePane.getChildren().addAll(parent);*/
		
	}
	
	/**
	 * ViewStocks button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void ViewStocks(ActionEvent event) throws IOException{
		Parent view2 = FXMLLoader.load(getClass().getResource("/ViewStocks.fxml"));
		Scene scene2 = new Scene(view2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
	
		// declare variables
		Label resultView; 
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		resultPane = new ScrollPane();
		resultView = new Label();
		myInvestRepository = new InvestRepository();
		line = new String[5];
		txtString = "";
		
		// display all stocks
		for (String stock : myInvestRepository.getStocksList()) {
			line = stock.split(",");
			txtString += line[0] + " - " + line[1] + "\n";
		}
		
		//System.out.println(txtString);
		
		resultView.setText(txtString);
		resultPane.setContent(resultView);
		
	}
	
	/**
	 * Portfolio button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void Portfolio(ActionEvent event) throws IOException{
		
		// declare variables
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		myInvestRepository = new InvestRepository();
		line = new String[2];
		txtString = "";
		
		// display all stocks in portfolio
		for (String stock : myInvestRepository.getPortfolioList()) {
			line = stock.split(";");
			txtString += line[0] + ": " + line[1] + " Shares \n";
		}
		
		if (myInvestRepository.getPortfolioList().size() == 0) {
			txtString = "none.";
		}
		
		System.out.println(txtString);
		
		lblMyPortfolio = new Label();
		lblMyPortfolio.setText(txtString);
		
		
		Parent view2 = FXMLLoader.load(getClass().getResource("/Portfolio.fxml"));
		Scene scene2 = new Scene(view2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
		
		/*
		try {
			PortfolioMethod(event);
		} catch (Exception e) {
			//
		}*/
	}
	
	/**
	 * BuyStocks button
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void BuyStocks(ActionEvent event) throws IOException{
		Parent view2 = FXMLLoader.load(getClass().getResource("/BuyStocks.fxml"));
		
		Scene scene2 = new Scene(view2);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
	}
	
	/**
	 * Search method
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void SearchMethod(ActionEvent event) throws Exception{
		
		// declare variables	
		InvestRepository myInvestRepository;
		String[] line;
		String userInput, textViewText;  
		
		// initialize variables
		myInvestRepository = new InvestRepository();
		line = new String[9];
		userInput = "";
		textViewText = "";
		
		// get symbol
		userInput = getSearch.getText();
		
		// check symbol
		if (myInvestRepository.checkStocksExists(String.valueOf(userInput))) {
			
			// display info
			for (String stock : myInvestRepository.getStocksList()) {
				line = stock.split(",");
				
				if (line[0].equals(userInput)) {
					
					textViewText += "\nName: " + line[1];
					textViewText += "\nSymbol: " + line[0];
					textViewText += "\nExchange: LSE";
					textViewText += "\nPrice: " + line[2];
					textViewText += "\nChange: " + line[3];
					textViewText += "\nPercentage Change: " + line[4] + "%";
					
					result.setText(textViewText);
				}
			}
			
		} else {
			result.setText("Stock is Not Available.");
		}
	}
	
	/**
	 * View method
	 * @param event
	 * @throws Exception
	 */
	private void ViewMethod(ActionEvent event) throws Exception{
		
		// declare variables
		Label result; 
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		result = new Label();
		myInvestRepository = new InvestRepository();
		line = new String[5];
		txtString = "";
		
		// display all stocks
		for (String stock : myInvestRepository.getStocksList()) {
			line = stock.split(",");
			txtString += line[0] + " - " + line[1] + "\n";
		}
		
		result.setText(txtString);
		resultPane.setContent(result);
		
	}
	
	/**
	 * Portfolio method
	 * @param event
	 * @throws Exception
	 */
	private void PortfolioMethod(ActionEvent event) throws Exception{
		
		// declare variables
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		myInvestRepository = new InvestRepository();
		line = new String[2];
		txtString = "";
		
		// display all stocks in portfolio
		for (String stock : myInvestRepository.getPortfolioList()) {
			line = stock.split(";");
			txtString += line[0] + ": " + line[1] + " Shares \n";
		}
		
		if (myInvestRepository.getPortfolioList().size() == 0) {
			txtString = "none.";
		}
		
		lblMyPortfolio.setText(txtString);
	}
	
	/**
	 * Invest method
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void InvestMethod(ActionEvent event) throws Exception{
		
		// declare variable
		InvestRepository myInvestRepository;
		String userInput; 
		int num;
				
		// initialize variable
		myInvestRepository = new InvestRepository();
		userInput = "";
		num = 0;
		
		// get symbol
		userInput = getStock.getText();
		
		// check symbol
		if (myInvestRepository.checkStocksExists(String.valueOf(userInput))) {
			try {
				num = Integer.parseInt(getAmount.getText());
				myInvestRepository.addStock(String.valueOf(userInput), num);
				txtNotification.setText("You have purchased " + num + " shares of " + String.valueOf(userInput) + ".");
			} catch (Exception e) {
				txtNotification.setText("Must Enter a Valid Number of Shares.");
			}
		} else {
			txtNotification.setText("Stock is Not Available.");
		}
		
	}
	
}