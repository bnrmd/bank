package ca.ucalgary.domain;

// Imports 
import java.io.*;
import java.util.*;

/**
 * Invest class
 * allows users to invest in the stocks
 */
public class Invest {
	
	// Instance Variables
	private ArrayList<String> StocksSymbolList, myStocks;
	private File StocksFile;
	private Scanner StocksScanner;

	/**
	 *  Constructor
	 */
 	public Invest() {
		
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
			System.out.println("Stocks.txt doesn't exist");
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
	 *  Search Stock Method
	 */
	public void SearchStock() {
		
		// declare variables
		String[] line;
		String symbol, name, price, sector, ex, in, em, fo, co;
		Scanner input;
		String userInput;
		
		// initialize variables
		input = new Scanner(System.in);
		userInput = "";
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
		
		// get symbol
		System.out.print("\nEnter Stock Symbol: ");
		userInput = input.nextLine();
		
		// check symbol
		if (this.StocksSymbolList.contains(userInput)) {
			
			// check file
			try {
				this.StocksFile = new File("Stocks.txt");
				this.StocksScanner = new Scanner(this.StocksFile);
			} catch (Exception e) {
				System.out.println("Stocks.txt doesn't exist");
			}
			
			// display info
			while(this.StocksScanner.hasNext()) {
				line = this.StocksScanner.nextLine().split(";");
				symbol = line[0];
				if (symbol.equals(userInput)) {
					name = line[1];
					price = line[2];
					sector = line[3];
					ex = line[4];
					in = line[5];
					em = line[6];
					fo = line[7];
					co = line[8];
				
					System.out.println("\nName: " + name);
					System.out.println("Symbol: " + symbol);
					System.out.println("Price: " + price);
					System.out.println("Exchange: " + ex);
					System.out.println("Sector: " + sector);
					System.out.println("Industry: " + in);
					System.out.println("Employees: " + em);
					//System.out.println("Founded: " + fo);
					//System.out.println("Company Info: " + co);
				}
			
				line = new String[9];  // erase array
			}
			
		} else {
			System.out.println("Stock Symbol is Not Available.");
		}
		
	}
	
	/**
	 *  View All Stocks Method
	 */
	public void ViewAllStocks() {
		
		// declare variables
		String[] line;
		String symbol, name;
		
		// initialize variables
		line = new String[9];
		symbol = "";
		name = "";
		
		// check file
		try {
			this.StocksFile = new File("Stocks.txt");
			this.StocksScanner = new Scanner(this.StocksFile);
		} catch (Exception e) {
			System.out.println("Stocks.txt doesn't exist");
		}
		
		// display all stocks
		System.out.println("\n--------------Available Stocks--------------");
		
		while(this.StocksScanner.hasNext()) {
			line = this.StocksScanner.nextLine().split(";");
			symbol = line[0];
			name = line[1];
			System.out.println(symbol + " - " + name);
			line = new String[9];  // erase array
		}

	}
	
	/**
	 *  View Portfolio Method
	 */
	public void ViewPortfolio() {
		System.out.println("\n-----------------myPortfolio----------------");
		int even = 0;
		for (int i=0; i<myStocks.size()/2; i++) {
			System.out.println(myStocks.get(even+1) + " shares of " + myStocks.get(even) + ".");
			even += 2;
		}
	}
	
	/**
	 *  Invest Selected Method
	 */
	public void InvestSelected() {
		
		// declare variables
		Scanner input;
		String userInput, symbol;
		int num;
		
		// initialize variables
		input = new Scanner(System.in);
		userInput = "";
		symbol = "";
		num = 0;
		
		// get symbol
		System.out.print("\nEnter Stock Symbol: ");
		userInput = input.nextLine();
		
		// check symbol
		if (this.StocksSymbolList.contains(userInput)) {
			symbol = String.valueOf(userInput);
			this.myStocks.add(userInput);
			System.out.print("Enter Number of Shares: ");
			num = Integer.parseInt(input.nextLine());
			this.myStocks.add(String.valueOf(num));
			System.out.println("You have purchased " + num + " shares of " + symbol + ".");
		} else {
			System.out.println("Stock Symbol is Not Available.");
		}
		
	}

	/**
	 * return myStocks
	 * @return myStocks
	 */
	public ArrayList<String> getMyStoks() {
		return this.myStocks;
	}
		
	/**
	 * add to stocks to portfolio
	 * @param symbol, amount
	 */
	public void addStock(String symbol, int amount) {
		this.myStocks.add(symbol);
		this.myStocks.add(String.valueOf(amount));
	}
}
