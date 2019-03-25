<<<<<<< HEAD
package ca.ucalgary.gui;

//Imports 
import ca.ucalgary.datastore.InvestRepository;
import ca.ucalgary.gui.accounts.MockAccounts;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * InvestGUI class
 * GUI for the Invest class
 */
public class InvestGUI extends Application implements EventHandler<ActionEvent> {
	
	// Declare (Instance) Variables
	Button btnSearch, btnView, btnPortfolio, btnMyInvest;
	
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
        //Budget Button
        btnBudget.setOnAction(new EventHandler<ActionEvent>() {
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
		});
      //Goals Button
  		btnGoals.setOnAction(new EventHandler<ActionEvent>() {
  			@Override
  			public void handle(ActionEvent event) {
  				MockGoalsGUI myGoalsGUI = new MockGoalsGUI();
  				try {
  					myGoalsGUI.start(primaryStage);
  				} catch (Exception e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		});
  		//Menu bar btnAccounts
        btnAccount.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MockAccounts myAccountsGUI = new MockAccounts();
				try {
					myAccountsGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
        
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
		
		// Go button is pressed
		btnSearch.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) {
					
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
							//System.out.println(line);  // remove
							if (line[0].equals(userInput)) {
								//System.out.println(line);  // remove
								textViewText += "\nName: " + line[1];
								textViewText += "\nSymbol: " + line[0];
								textViewText += "\nExchange: LSE";
								textViewText += "\nPrice: £" + line[2];
								textViewText += "\nChange: " + line[3];
								textViewText += "\nPercentage Change: " + line[4] + "%";
								
								result.setText(textViewText);
							}
						}
						
					} else {
						result.setText("Stock is Not Available.");
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
		ScrollPane resultPane;
		Label result; 
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		verti = new VBox();
		resultPane = new ScrollPane();
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
		
		verti.getChildren().add(new Label("Available Stocks"));
		verti.getChildren().add(resultPane);
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
		
		VBox verti = new VBox();

		verti.getChildren().add(new Label("My Portfolio"));
		verti.getChildren().add(new Label(txtString));
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
		
		// declare variable
		InvestRepository myInvestRepository;
		
		// initialize variable
		myInvestRepository = new InvestRepository();
		
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
					
					// delcare variables (nested class)
					String userInput; 
					int num;
					
					// initialize variables (nested class) 
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
		);
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}
	
}
=======
package ca.ucalgary.gui;

//Imports 
import ca.ucalgary.datastore.InvestRepository;
import ca.ucalgary.gui.accounts.MockAccounts;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * InvestGUI class
 * GUI for the Invest class
 */
public class InvestGUI extends Application implements EventHandler<ActionEvent> {
	
	// Declare (Instance) Variables
	Button btnSearch, btnView, btnPortfolio, btnMyInvest;
	
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
        //Budget Button
        btnBudget.setOnAction(new EventHandler<ActionEvent>() {
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
		});
      //Goals Button
  		btnGoals.setOnAction(new EventHandler<ActionEvent>() {
  			@Override
  			public void handle(ActionEvent event) {
  				MockGoalsGUI myGoalsGUI = new MockGoalsGUI();
  				try {
  					myGoalsGUI.start(primaryStage);
  				} catch (Exception e) {
  					// TODO Auto-generated catch block
  					e.printStackTrace();
  				}
  			}
  		});
  		//Menu bar btnAccounts
        btnAccount.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				MockAccounts myAccountsGUI = new MockAccounts();
				try {
					myAccountsGUI.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
        
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
		
		// Go button is pressed
		btnSearch.setOnAction(new EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event) {
					
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
							//System.out.println(line);  // remove
							if (line[0].equals(userInput)) {
								//System.out.println(line);  // remove
								textViewText += "\nName: " + line[1];
								textViewText += "\nSymbol: " + line[0];
								textViewText += "\nExchange: LSE";
								textViewText += "\nPrice: £" + line[2];
								textViewText += "\nChange: " + line[3];
								textViewText += "\nPercentage Change: " + line[4] + "%";
								
								result.setText(textViewText);
							}
						}
						
					} else {
						result.setText("Stock is Not Available.");
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
		ScrollPane resultPane;
		Label result; 
		InvestRepository myInvestRepository;
		String[] line;
		String txtString;
		
		// initialize variables
		verti = new VBox();
		resultPane = new ScrollPane();
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
		
		verti.getChildren().add(new Label("Available Stocks"));
		verti.getChildren().add(resultPane);
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
		
		VBox verti = new VBox();

		verti.getChildren().add(new Label("My Portfolio"));
		verti.getChildren().add(new Label(txtString));
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
		
		// declare variable
		InvestRepository myInvestRepository;
		
		// initialize variable
		myInvestRepository = new InvestRepository();
		
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
					
					// delcare variables (nested class)
					String userInput; 
					int num;
					
					// initialize variables (nested class) 
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
		);
		
		// stage
		Stage searchWindow = new Stage();
		searchWindow.setScene(new Scene(verti, 300, 400));
		searchWindow.show();
	}
	
}
>>>>>>> master
