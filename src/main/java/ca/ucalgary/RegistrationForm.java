package ca.ucalgary;
import java.util.Scanner;
import java.io.Console;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.util.Random;


public class RegistrationForm {
	
	// E-MAIL VALIDATION
	public static boolean isValid(String Email) 
    { 
        String EmailRegex = ("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$") ; 
		
        Pattern pat = Pattern.compile(EmailRegex); 
        if (Email == null) 
            return false; 
        return pat.matcher(Email).matches(); 
    } 
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Console console = System.console();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		String AccountType, AccountName, Gender, NationalID, Address, City, Province, 
		ZipCode, PhoneNo, Email, Education, MaritalStatus, Occupation, Signature, 
		ClientID, Password, ConfirmPassword, Passcode, ConfirmPasscode; 
		int Age, RandomNumer;
		boolean Income;
				
		// WELCOME
		boolean done4 = false;
		while (!done4) {                                        
			System.out.println("Account Type: C - Chequing || S - Saving \n");                                       
			AccountType = scan.nextLine().toUpperCase();                                        
			switch (AccountType) {
			   case "C" :
			     System.out.println("");
				 System.out.println("--- CHEQUINGS ACCOUNT --- \n");                                      
				 done4 = true;
				 continue;
			   
			   case "S" :
				 System.out.println("");
				 System.out.println("--- SAVINGS ACCOUNT --- \n");                                       
				 done4 = true;
				 continue;
				 
			   default :
			     System.out.println("");
				 System.out.println("Please select from the options below:");
				
			 }    
		  }
		  
		System.out.println("i. Account Details \n");
		
		// ACCOUNT NAME
		System.out.print("Account Name: ");
		AccountName = scan.nextLine();
		
		while(!AccountName.matches("^[a-zA-Z ]+$") || (AccountName.isEmpty()) || (AccountName.equals(" ")) || (AccountName.equals("  "))){
			if ((AccountName.isEmpty()) || (AccountName.equals(" ")) || (AccountName.equals("  "))){
				System.out.println("Field should not be left blank. \n");
				System.out.print("Account Name: ");
				AccountName = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid name! \n");
				System.out.print("Account Name: ");
				AccountName = scan.nextLine();
			}
		}
		
		// AGE
		System.out.println("-");
		System.out.print("Age: ");
		Age = input.nextInt();
		while((Age < 18) || (Age > 125)) {
			
			if (Age < 18){
				System.out.println("You have to be atleast 18 to open a bank account!");
				System.out.println("");
			}
			
			else if (Age > 125){
				System.out.println("Age not possible!");
				System.out.println("");
			}
	
			System.out.print("Age: ");
			Age = input.nextInt();
		}
		
		// GENDER
		System.out.println("-");
		boolean done = false;
		while (!done) {                                        
			System.out.println("Gender: M - Male || F - Female || O - Other \n");                                       
			Gender = scan.nextLine().toUpperCase();                                        
			switch (Gender) {
			   case "M" :
				 done = true;
				 continue;
			   
			   case "F" :
				 done = true;
				 continue;
				 
			   case "O" :
			     System.out.println("");
			     System.out.print("Please Specify: ");
				 Gender = scan.nextLine().toUpperCase();
				 done = true;
				 continue;
				 
			   default :
			     System.out.println("");
				 System.out.println("Please select from the options below:");
				
			 }    
		  } 
		
		// NATIONALITY
		System.out.println("-");
		System.out.println("Nationality: CAN");
		
		// NATIONAL I.D.
		System.out.println("-");
		System.out.print("National I.D. (9 Digit Numeric): ");
		NationalID = scan.nextLine();
		while((!NationalID.matches("[0-9]+")) || (NationalID.length() != 9) || (NationalID.isEmpty()) || (NationalID.equals(" ")) || (NationalID.equals("  "))){
			
			if ((NationalID.isEmpty()) || (NationalID.equals(" ")) || (NationalID.equals("  "))){
				System.out.println("Field should not be left blank. \n");
				System.out.print("National I.D. (9 Digit Numeric): ");
				NationalID = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid numeric 9 Digit National I.D. number. \n");
				System.out.print("National I.D. (9 Digit Numeric): ");
				NationalID = scan.nextLine();
			}
		}
		
		System.out.println("");
		System.out.println("ii. Communication Details \n");

		// PERMANENT ADDRESS
		System.out.print("Permanent Address: ");
		Address = scan.nextLine();
		while ((Address.isEmpty()) || (Address.equals(" ")) || (Address.equals("  "))) {
			System.out.println("Field should not be left blank. \n");
			System.out.print("Permanent Address: ");
			Address = scan.nextLine();
		}
		
		// CITY
		System.out.println("-");
		System.out.print("City: ");
		City = scan.nextLine();
		while(!City.matches("^[a-zA-Z ]+$") || (City.equals(" ")) || (City.equals("  ")) || (City.isEmpty())){
			
			if ((City.equals(" ")) || (City.equals("  ")) || (City.isEmpty())) {
				System.out.println("Field should not be left blank. \n");
				System.out.print("City: ");
				City = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid city name. \n");
				System.out.print("City: ");
				City = scan.nextLine();
			}
		}
		
		// PROVINCE
		System.out.println("-");
		System.out.print("Province: ");
		Province = scan.nextLine();
		while(!Province.matches("^[a-zA-Z ]+$") || (Province.equals(" ")) || (Province.equals("  ")) || (Province.isEmpty())){
			
			if ((Province.equals(" ")) || (Province.equals("  ")) || (Province.isEmpty())) {
				System.out.println("Field should not be left blank. \n");
				System.out.print("Province: ");
				Province = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid Province name. \n");
				System.out.print("Province: ");
				Province = scan.nextLine();
			}
		}
		
		// COUNTRY
		System.out.println("-");
		System.out.println("Country: Canada");
		
		// ZIP CODE
		System.out.println("-");
		System.out.print("Zip Code: ");
		ZipCode = scan.nextLine();
		while((ZipCode.length() != 6) || (ZipCode.isEmpty()) || (ZipCode.equals(" ")) || (ZipCode.equals("  "))){
			
			if ((ZipCode.isEmpty()) || (ZipCode.equals(" ")) || (ZipCode.equals("  "))) {
				System.out.println("Field should not be left blank. \n");
				System.out.print("ZipCode: ");
				ZipCode = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid 6 Digit Zip Code. \n");
				System.out.print("Zip Code: ");
				ZipCode = input.next();
			}
		}
		
		// PHONE NO.
		System.out.println("-");
		System.out.print("Phone No.: +1 ");
		PhoneNo = scan.nextLine();
		while((!PhoneNo.matches("[0-9]+")) || (PhoneNo.length() != 10) || (PhoneNo.isEmpty()) || (PhoneNo.equals(" ")) || (PhoneNo.equals("  "))){
			
			if ((PhoneNo.isEmpty()) || (PhoneNo.equals(" ")) || (PhoneNo.equals("  "))) {
				System.out.println("Field should not be left blank. \n");
				System.out.print("Phone No.: +1 ");
				PhoneNo = scan.nextLine();
			}
			else {
				System.out.println("Please enter your 10 Digit phone number. \n");
				System.out.print("Phone No.: +1 ");
				PhoneNo = scan.nextLine();
			}
		}
		
		// E-MAIL
		System.out.println("-");
		System.out.print("E-Mail: ");
        Email = scan.nextLine();
        while (!isValid(Email) || (Email.isEmpty()) || (Email.equals(" ")) || (Email.equals("  "))) {
        	
        	if ((Email.isEmpty()) || (Email.equals(" ")) || (Email.equals("  "))) {
        		System.out.println("Field should not be left blank. \n");
				System.out.print("E-Mail: ");
				Email = scan.nextLine();
        	}
        	else if (!isValid(Email)){
				System.out.println("Please enter a valid e-mail. \n");
				System.out.print("E-Mail: ");
				Email = scan.nextLine();
			}
			else if(isValid(Email)){
				continue;
			}
		}
		
		System.out.println("");
		System.out.println("iii. Personal Details \n");
		
		// EDUCATIONAL DETAILS
		boolean done2 = false;
		while (!done2) {                                        
			System.out.println("Educational Details: U - Undergraduate || G - Graduate || P - Post Graduate || O - Other");                                       
			Education = scan.nextLine().toUpperCase();                                        
			switch (Education) {
			   case "U" :
				 //System.out.println("Undergraduate");                                      
				 done2 = true;
				 continue;
			   
			   case "G" :
				 //System.out.println("Graduate");                                       
				 done2 = true;
				 continue;
				 
			   case "P" :
				 //System.out.println("Post Graduate");                                       
				 done2 = true;
				 continue;
				 
			   case "O" :
			     System.out.print("Please Specify: ");
				 Education = scan.nextLine();
				 done2 = true;
				 continue;
				 
			   default:
				 System.out.println("");
				 System.out.println("Please select from the options below:");
				
			 }    
		  }
		  
		// MARITAL STATUS
		System.out.println("-");
		boolean done3 = false;
		
		while (!done3) {                                        
			System.out.println("Marital Status: M - Married || S - Single || O - Other");                                       
			MaritalStatus = scan.nextLine().toUpperCase();                                        
			switch (MaritalStatus) {
			   case "M" :
				 //System.out.println("Married");                                      
				 done3 = true;
				 continue;
			   
			   case "S" :
				 //System.out.println("Single");                                       
				 done3 = true;
				 continue;
				 
			   case "O" :
			     System.out.print("Please Specify: ");
				 MaritalStatus = scan.nextLine();
				 done3 = true;
				 continue;
				 
			   default:
			     System.out.println("");
				 System.out.println("Please select from the options below:");
				
			 }    
		  }
		  
		// OCCUPATION
		System.out.println("-");
		System.out.print("Occupation: ");
		Occupation = scan.nextLine();
		  while(!Occupation.matches("^[a-zA-Z ]+$") || (Occupation.isEmpty()) || (Occupation.equals(" ")) || (Occupation.equals("  "))){
			
			if ((Occupation.isEmpty()) || (Occupation.equals(" ")) || (Occupation.equals("  "))) {
				System.out.println("Field should not be left blank. \n");
				System.out.print("Occupation: ");
				Occupation = scan.nextLine();
			}
			else {
				System.out.println("Please enter a valid Occupation. \n");
				System.out.print("Occupation: ");
				Occupation = scan.nextLine();
			}
		}
		
		System.out.println("");
		System.out.println("iv. Verification \n");
		
		// INITIAL DEPOSIT
		
		// SIGNATURE
		System.out.print("Signature (Initials): ");
		Signature = scan.nextLine();
		while ((Signature.isEmpty()) || (Signature.equals(" ")) || (Signature.equals("  "))) {
			System.out.println("Field should not be left blank. \n");
			System.out.print("Signature (Initials): ");
			Signature = scan.nextLine();
		}
		
		// CLIENT I.D.
		System.out.println("-");
		RandomNumer = rand.nextInt(10000) + 10000;
		ClientID = "D" + RandomNumer;
		System.out.println("Client I.D.: " + ClientID);
		
		// SET PASSWORD
		System.out.println("-");
		System.out.print("Password: ");
		Password = input.next();
		System.out.print("Confirm Password: ");
		ConfirmPassword = input.next();
		while((!Password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) || (!ConfirmPassword.equals(Password))){
			
			if (!ConfirmPassword.equals(Password)) {
				System.out.println("Passwords do not match! \n");
				System.out.print("Password: ");
				Password = input.next();
				System.out.print("Confirm Password: ");
				ConfirmPassword = input.next();	
			}
			else if (!Password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
				System.out.println("Password should be of 8 characters in length "
						+ "and should contain atleast one Uppercase letter, lowercase letter, number and special character. \n");
				System.out.print("Password: ");
				Password = input.next();
				System.out.print("Confirm Password: ");
				ConfirmPassword = input.next();
			}
		}

		// SET PASSCODE (4 DIGIT)
		System.out.println("-");
		System.out.print("Passcode (4 Digit Numeric): ");
		Passcode = input.next();
		System.out.print("Confirm Passcode: ");
		ConfirmPasscode = input.next();
		while((!Passcode.matches("[0-9]+")) || (Passcode.length() != 4) || (!ConfirmPasscode.equals(Passcode))){
			
			if (!ConfirmPasscode.equals(Passcode)) {
				System.out.println("Passcodes do not match! \n");
				System.out.print("Passcode: ");
				Passcode = input.next();
				System.out.print("Confirm Passcode: ");
				ConfirmPasscode = input.next();
			}
			else {
				System.out.println("Please enter a numeric 4 Digit Passcode. \n");
				System.out.print("Passcode: ");
				Passcode = input.next();
				System.out.print("Confirm Passcode: ");
				ConfirmPasscode = input.next();
			}
		}
		
		System.out.println("Thank you for opening your account with us! \n");
		
		

	}
}