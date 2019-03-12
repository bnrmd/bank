package ca.ucalgary.gui;

// Imports 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * InvestGUI
 * Invest Graphical User Interface
 */
public class InvestGUI extends Application implements EventHandler<ActionEvent> {
	
	// Variables
	Button btnSearch, btnView, btnPortfolio, btnMyInvest;
	private ArrayList<String> StocksSymbolList, myStocks;
	private File StocksFile;
	private Scanner StocksScanner;	
	
	/**
	 * Constructor
	 */
	public InvestGUI() {
		
		// initialize instance variables
		this.StocksSymbolList = new ArrayList<String>();
		this.myStocks = new ArrayList<String>();
		
		// declare variables
		String[] line;
		String symbol;
		
		// initialize variables
		line = new String[9];
		symbol = "";
		
		// check Stocks.txt exists 
		try {
			this.StocksFile = new File("Stocks.txt");
			this.StocksScanner = new Scanner(this.StocksFile);
		} catch (Exception e) {
			//System.out.println("Stocks.txt doesn't exist");
		}
		
		// add all stocks symbols to StocksList
		while(this.StocksScanner.hasNext()) {
			line = this.StocksScanner.nextLine().split(";");
			symbol = line[0];
			this.StocksSymbolList.add(symbol);
			line = new String[9];  // erase array
		}
		
	}	
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Start method
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		
        // top layout
        Pane top = new Pane();
        
        Label txtFeatureName = new Label("Invest");
        txtFeatureName.setStyle("-fx-font-size: 45;");
        
        top.getChildren().add(txtFeatureName);

        // center layout
        VBox center = new VBox();
        
        btnSearch = new Button("Search Stock");
        btnView = new Button("View All Stocks");
        btnPortfolio = new Button("View Portfolio");
        btnMyInvest = new Button("Invest");
        
        btnSearch.setMinSize(230, 68);
        btnView.setMinSize(230, 68);
        btnPortfolio.setMinSize(230, 68);
        btnMyInvest.setMinSize(230, 68);
        
        btnSearch.setOnAction(this);
        btnView.setOnAction(this);
        btnPortfolio.setOnAction(this);
        btnMyInvest.setOnAction(this);       
        
        center.getChildren().addAll(btnSearch, btnView, btnPortfolio, btnMyInvest);
        center.setSpacing(20);
        center.setAlignment(Pos.CENTER);        
        
        // bottom menu layout
        HBox bottom = new HBox();
        
        Button btnAccount = new Button("Account");
        Button btnBudget = new Button("Budget");
        Button btnGoals = new Button("Goals");
        Button btnInvest = new Button("Invest");

        btnGoals.setMinSize(96, 68);
        btnAccount.setMinSize(96, 68);
        btnBudget.setMinSize(96, 68);
        btnInvest.setMinSize(96, 68);
        
        btnBudget.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) {
				BudgetGUI myBudgetGUI = new BudgetGUI();
				try {
					myBudgetGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        );
        
        bottom.getChildren().addAll(btnAccount, btnBudget, btnGoals, btnInvest);

        // set main layout
        BorderPane main = new BorderPane();
        
        main.setTop(top);
        main.setCenter(center);
        main.setBottom(bottom);

        // set stage
        primaryStage.setTitle("myBank");
        primaryStage.setScene(new Scene(main, 384, 683)); 
        primaryStage.show();
        
    }
	
	/**
	 * Handle method
	 * @param event
	 */
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource()==btnSearch) {
			SearchMethod();
		} else if (event.getSource()==btnView) { 
			ViewMethod();
		} else if (event.getSource()==btnPortfolio) { 
			PortfolioMethod();
		} else if (event.getSource()==btnMyInvest) { 
			InvestMethod();
		}
	}	
	
	/**
	 * Search method
	 */
	public void SearchMethod() {
		
		// Horiz
		HBox horiz = new HBox();
		
		TextField getSearch = new TextField();
		getSearch.setPrefWidth(100); 
		Button btnSearch = new Button("Go");
		
		horiz.getChildren().addAll(getSearch, btnSearch);
		horiz.setAlignment(Pos.CENTER);
		
		// Verti
		VBox verti = new VBox();
		
		Label result = new Label();
		
		verti.getChildren().add(new Label("Search Stock"));
		verti.getChildren().add(horiz);
		verti.getChildren().add(result);
		verti.setAlignment(Pos.TOP_CENTER);
		verti.setSpacing(15);
		
		// Go
		btnSearch.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) {
					// declare variables					
					String[] line;
					String input, rs, symbol, name, price, sector, ex, in, em, fo, co;
					
					// initialize variables
					line = new String[9];
					symbol = "";
					name = "";
					price = "";
					sector = "";
					ex = "";
					in = "";
					em = "";
					fo = "";
					co = "";	
					rs = "";
					
					// check input
					input = getSearch.getText();

					if (StocksSymbolList.contains(input)) {
						
						// check file
						try {
							StocksFile = new File("Stocks.txt");
							StocksScanner = new Scanner(StocksFile);
						} catch (Exception e) {
							result.setText("Stocks.txt doesn't exist");
						}
						
						// display info
						while(StocksScanner.hasNext()) {
							line = StocksScanner.nextLine().split(";");
							symbol = line[0];
							if (symbol.equals(input)) {
								name = line[1];
								price = line[2];
								sector = line[3];
								ex = line[4];
								in = line[5];
								em = line[6];
								fo = line[7];
								co = line[8];
							
								rs += "\nName: " + name;
								rs += "\nSymbol: " + symbol;
								rs += "\nPrice: " + price;
								rs += "\nExchange: " + ex;
								rs += "\nSector: " + sector;
								rs += "\nIndustry: " + in;
								rs += "\nEmployees: " + em;
								
								result.setText(rs);
							}
						
							line = new String[9];  // erase array
						}
						
					} else {
						result.setText("No Match.");
					}
						
				}
			}	
		);
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}

	/**
	 * View all stocks method
	 */
	public void ViewMethod() {
		
		// declare variables
		VBox verti; 
		Label result; 
		String[] line;
		String symbol, name, rs;
		
		// initialize variables
		verti = new VBox();
		result = new Label();
		line = new String[9];
		symbol = "";
		name = "";	
		rs = "";
		
		// check file
		try {
			this.StocksFile = new File("Stocks.txt");
			this.StocksScanner = new Scanner(this.StocksFile);
		} catch (Exception e) {
			result.setText("Stocks.txt doesn't exist");
		}
		
		// display all stocks
		while(this.StocksScanner.hasNext()) {
			line = this.StocksScanner.nextLine().split(";");
			symbol = line[0];
			name = line[1];
			rs += "\n " + symbol + " - " + name;
			line = new String[9];  // erase array
		}
		
		result.setText(rs);
		
		verti.getChildren().add(new Label("View All Stocks"));
		verti.getChildren().add(result);
		verti.setAlignment(Pos.TOP_CENTER);
		verti.setSpacing(15);		
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}
	
	/**
	 * Portfolio method
	 */
	public void PortfolioMethod() {
		
		String rs;
		rs = "";
		
		int even = 0;
		for (int i=0; i<myStocks.size()/2; i++) {
			rs += myStocks.get(even+1) + " shares of " + myStocks.get(even) + ". \n";
			even += 2;
		}
		
		if (rs.equals("")) {
			rs = "none.";
		}
		
		VBox verti = new VBox();

		verti.getChildren().add(new Label("My Portfolio"));
		verti.getChildren().add(new Label(rs));
		verti.setAlignment(Pos.TOP_CENTER);
		verti.setSpacing(15);		
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}
		
	/**
	 * Invest method
	 */
	public void InvestMethod() {
		
		// Verti
		VBox verti = new VBox();
		
		TextField getStock, getAmount;
		Button btnPurchase;
		Label txtNotification;
		
		getStock = new TextField("Enter symbol");
		getStock.setPrefWidth(100); 
		getAmount = new TextField("Enter amount");
		getAmount.setPrefWidth(100); 
		btnPurchase = new Button ("Purchase");
		txtNotification = new Label();
		
		verti.getChildren().add(new Label("Invest"));
		verti.getChildren().addAll(getStock, getAmount, btnPurchase, txtNotification);
		verti.setAlignment(Pos.TOP_CENTER);
		verti.setSpacing(15);
		
		// Go
		btnPurchase.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) {
					// declare variables
					String input, symbol, noti;
					int num;
					
					// initialize variables
					input = "";
					symbol = "";
					noti = "";
					num = 0;
					
					// get symbol
					input = getStock.getText();
					
					// check symbol
					if (StocksSymbolList.contains(input)) {
						symbol = String.valueOf(input);
						myStocks.add(input);
						num = Integer.parseInt(getAmount.getText());
						myStocks.add(String.valueOf(num));
						noti += "You have purchased " + num + " shares of " + symbol + ".";
						txtNotification.setText(noti);
					} else {
						txtNotification.setText("Stock Symbol is Not Available.");
					}
						
				}
			}	
		);
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}
	
}
