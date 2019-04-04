package ca.ucalgary.domain;

// Imports 
import java.util.Scanner;
import ca.ucalgary.domain.Budget;
import ca.ucalgary.domain.Invest;
import ca.ucalgary.domain.RegistrationForm;
import ca.ucalgary.domain.Goal;
import ca.ucalgary.services.BankService;

/**
 * BankApplication
 * Contains control/menu methods 
 */
public class Bank {
	
	// Declare Variable
	private static BankService bankService = new BankService();
	
	/**
	 * Sign-In Selected Method
	 */
	public static Customer SignInSelected() {
		
		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Sign-In");
		System.out.println("--------------------------------------------");
		
		// username and password
		Scanner input =  new Scanner(System.in);
		System.out.print("Enter Email: ");
		String email = input.nextLine();
		System.out.print("Enter Password: ");
		String password = input.nextLine();

		Customer customer = bankService.signIn(email,password);

		if (customer == null){
			System.out.println("Invalid Credentials");
			SignInSelected();
		}
		
		//input.close(;

		return customer;

	}
		
	/**
	 * Sign-Up Selected Method
	 */
	public static void SignUpSelected() {
		
		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Sign-Up");
		System.out.println("--------------------------------------------");
		
		// call RegistrationForm class
		RegistrationForm.main(null);  
		
		// call Menu method
		//Menu();
	}
	
	/**
	 * Account Selected Method
	 */
	public static void AccountSelected(Customer customer) {

		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Account");
		//System.out.println("--------------------------------------------");
		
		// run CLI class
		AccountCLI myCLI = new AccountCLI();
		myCLI.processAccountsFor(customer);
	}

	/**
	 * Budget Selected Method
	 */
	public static void BudgetSelected() {
		// message
		System.out.println("\n--------------------------------------------");
		System.out.println("                   Budget");
		//run CLI
		BudgetCLI budgetCLI = new BudgetCLI();
		budgetCLI.main(null);
	}
	
	/**
	 * Goals Selected Method
	 */
	public static void GoalsSelected() {
		
		// declare variables 
		Goal myGoal;
		Scanner input ;
		String userSelection, userInput;
		int time;
		boolean run;

		// initialize variables
		myGoal = new Goal();
		input = new Scanner(System.in);  
		userSelection = "";
		userInput = "";
		time = 0;
		run = true;

		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                    Goal");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Set Goal  [2] Set Time Period  [3] View Goal  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// set goal;
				System.out.print("\nEnter Goal Name: ");
				userInput = input.nextLine();
				myGoal.setGoalName(userInput);
				System.out.print("Enter Goal Amount: ");
				userInput = input.nextLine();
				myGoal.setGoalAmount(Double.valueOf(userInput));
				break;
				
			case "2":
				// set time period
				System.out.print("\nSelect Time Period: [y = Years, m = Months, w = Weeks, d = Days] ");
				userInput = input.nextLine();
				switch (userInput) {
				case "y":
					time = 365;
					myGoal.setTimePeriod("Years");
					break;
				case "m":
					time = 30;
					myGoal.setTimePeriod("Months");
					break;
				case "w":
					time = 7;
					myGoal.setTimePeriod("Weeks");
					break;
				case "d":
					time = 1;
					myGoal.setTimePeriod("Days");
					break;
				default:
					break;
				}
				System.out.print("Enter Time Period: ");
			    userInput = input.nextLine();
			    myGoal.setTimePeriodInput(Integer.parseInt(userInput));
				myGoal.setTimePeriodDays(Integer.parseInt(userInput) * time);
				break;
				
			case "3":
				// view goal
				System.out.println("\n" + myGoal.toString());
				break;
				
			case "q":
				run = false;
				break;
				
			default:  // will never run
				break;
			}
			
		}
		
		//input.close(;

	}

	/**
	 * Invest Selected Method
	 */
	public static void InvestSelected() {
		
		// declare variables 
		Invest myInvest;
		Scanner input ;
		String userSelection;
		boolean run;

		// initialize variables
		myInvest = new Invest();
		input = new Scanner(System.in);  
		userSelection = "";
		run = true;

		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                   Invest");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Search Stock  [2] View All Stocks  [3] View Portfolio  [4] Invest  [q] Quit \n");

			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("3")||userSelection.equals("4")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// call SearchStock method
				myInvest.SearchStock();
				break;
				
			case "2":
				// call ViewAllStocks method
				myInvest.ViewAllStocks();
				break;
				
			case "3":
				// call ViewPortfolio method
				myInvest.ViewPortfolio();
				break;
				
			case "4":
				// call InvestSelected method
				myInvest.InvestSelected();
				break;
				
			case "q":
				run = false;
				break;
				
			default:  // will never run
				break;
			}
			
		}
		
		//input.close(;

	}

	/**
	 * save data to JSon file
	 */
	public void SaveDataStoreToFile(){
	}

}
