package ca.ucalgary.tui;

/**
 * G02 T07
 * CLI
 */

// Imports
import java.util.Scanner;
/*
import ca.ucalgary.domain.Budget;
import ca.ucalgary.domain.Invest;
import ca.ucalgary.domain.RegistrationForm;
import ca.ucalgary.domain.Goal;
*/
import ca.ucalgary.domain.Bank;

/**
 * CLI
 * Command Line Interface
 */
public class CLI {
	
	// Main Method
	public static void main(String[] args) {
		
		// declare variables 
		Scanner input;
		String userSelection;
	
		// initialize variables
		input = new Scanner(System.in);  
		userSelection = "";
		
		while (true) {
			
			// welcome message
			System.out.println("--------------------------------------------");
			System.out.println("            Welcome to myMoney!");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Sign-In  [2] Sign-Up  [q] Quit \n");
			
			// selection 
			System.out.print("Enter Selection: ");
			userSelection = input.nextLine();
			
			while (!(userSelection.equals("1")||userSelection.equals("2")||userSelection.equals("q"))) {
				// invalid input
				System.out.println("Invalid Input! Try again... \n");
				System.out.print("Enter Selection: ");
				userSelection = input.nextLine();
			}
			
			switch (userSelection) {
			
			case "1":
				// call SignInSelected method
				Bank.SignInSelected();
				Menu();
				break;

			case "2":
				// call SignUpSelected method
				Bank.SignUpSelected();
				Menu();
				break;
			
			case "q":
				System.out.println("\nHave a Nice Day!");
				System.exit(1);

			default:  // will never run 
				break;
			}
			
		}
				
	}
	
	// Menu Method
	public static void Menu() {
		
		// declare variables 
		Scanner input ;
		String userSelection;
		boolean run;
		
		// initialize variables
		input = new Scanner(System.in);  
		userSelection = "";
		run = true;
		
		// menu
		while (run) {
			
			// message
			System.out.println("\n--------------------------------------------");
			System.out.println("                   Menu");
			System.out.println("--------------------------------------------");
			System.out.println("[1] Account  [2] Budget  [3] Goal  [4] Invest  [q] Quit \n");

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
				// call AccountSelected method
				Bank.AccountSelected();
				break;

			case "2":
				// call BudgetSelected method
				Bank.BudgetSelected();
				break;
				
			case "3":
				// call GoalsSelected method
				Bank.GoalsSelected();
				break;
				
			case "4":
				// call InvestSelected method
				Bank.InvestSelected();
				break;
			
			case "q":
				System.out.println();
				run = false;
				break;

			default:  // will never run
				break;
			}
		}
	}
	
}

