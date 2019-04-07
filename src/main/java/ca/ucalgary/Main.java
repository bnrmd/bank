package ca.ucalgary;

import ca.ucalgary.gui.BankApplication;
import ca.ucalgary.tui.CLI;

public class Main {

    public static void main(String args[]){
        if (args.length == 0){
            CLI.main(args);
        } else if (args[0].equals("tui")){
            CLI.main(args);
        } else if (args[0].equals("gui")){
            BankApplication.main(args);
        } else {
            System.out.println("Invalid parameters");
        }
    }
}
