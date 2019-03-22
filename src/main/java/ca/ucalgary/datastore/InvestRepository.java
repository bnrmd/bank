package ca.ucalgary.datastore;

// Imports
import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// InvestRepository CLass
public class InvestRepository {
	
	// Declare Instance Variables 
	private ArrayList<String> stocksList, symbolsList;
	private File portfolioFile;
	
	// Constructor
	public InvestRepository() {
		
		// initialize instance variables
		stocksList = new ArrayList<String>();
		symbolsList = new ArrayList<String>();
		portfolioFile = null;
		
		// declare variables 
		String url;
	    String ticker, name;
	    double price, change, percentChange;    
		
		// initialize variables 
	    url = "https://shares.telegraph.co.uk/indices/summary/index/MCX";
        ticker = "";
        name = "";
        price = 0.0;
        change = 0.0;
        percentChange = 0.0;
        
        // obtain information from the website 
        try {
            
            // declare & initialize document 
            Document document;
            document = Jsoup.connect(url).get();
            
            // iterate through table 
            for (Element row : document.select("table.tablesorter.full tr")) {
                
                // the first row is empty
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;  // continue
                } 
                
                // after the first row 
                else {
                	
                	// get live info from wesite
                    ticker = row.select("td:nth-of-type(1)").text();
                    name = row.select("td:nth-of-type(2)").text();
                    price = Double.parseDouble(row.select("td.right:nth-of-type(3)").text().replace(",", ""));
                    change = Double.parseDouble(row.select("td:nth-of-type(4)").text());
                    percentChange = Double.parseDouble(row.select("td:nth-of-type(5)").text());
                 
                    // add to stocksList
                    stocksList.add(ticker + "," + name + "," + price + "," + change + "," + percentChange);
                    
                    // add to symbolsList
                    symbolsList.add(ticker);
                }
            }
            
            // open portfolio file
            try {
				portfolioFile = new File("src/main/resources/data-stores/invest-repository.txt");
			} catch (Exception e) {
				System.out.println("invest-repository.txt doesn't exist");
			}
            
        } 
        
        // catch error
        catch (Exception ex) {
            System.out.println("Error! Obtaining stocks from website failed.");  //ex.printStackTrace();
        }
		
	}
	
	// getStocksList
	public ArrayList<String> getStocksList() {      
        return stocksList;      
	}

	// getSymbolsList
	public ArrayList<String> getSymbolsList() {
        return symbolsList;      	
	}
	
	// getPortfolioList
	public ArrayList<String> getPortfolioList() {
		
		// declare variables
		ArrayList<String> portfolioList;
		Scanner StocksScanner;
		String line;
		
		// initialize variables
		portfolioList = new ArrayList<String>();
		StocksScanner = null;
		line = "";
		
		// open txt file
		try {
			StocksScanner = new Scanner(portfolioFile);
		} catch (Exception e) {
			System.out.println("Error with StocksScanner!");
		}
		
		// add to stocks list
		while(StocksScanner.hasNext()) {
			line = StocksScanner.nextLine();
			portfolioList.add(line);
		}
		
		return portfolioList;
	}

	/**
	 * add stock to portfolio
	 * @param symbol, amount
	 */
	public void addStock(String symbol, int amount) {
		
		// declare variables
		FileWriter PortfolioWriter;
		
		// initialize variables	
		PortfolioWriter = null;
		
		// get portfolio file
		try {
			PortfolioWriter = new FileWriter(portfolioFile, true);
		} catch (Exception e) {
			System.out.println("Portfolio.txt doesn't exist");
		}		
		
		// add stock to portfolio
		try {
			if(portfolioFile.length() != 0) {
				PortfolioWriter.write("\n");
			}
			PortfolioWriter.write(symbol + ";" + String.valueOf(amount));
			PortfolioWriter.close();
		} catch (IOException e) {
			System.out.println("Error! Could not add stock to portfolio.");
		}
	
		
	}

	// check stocks exists 
	public boolean checkStocksExists(String symbol) {
		return getSymbolsList().contains(symbol);
	}
	
}
