package ui;



import model.exception.MoneyException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class LogginFunction {

    public Scanner scanner = new Scanner(System.in);

    public LogginFunction() throws IOException, ParseException, MoneyException {
        String function = "";
        ProcessMoney m = new ProcessMoney();
        PresentSummary p;
        while (true) {
            System.out.println("Please select the function");
            System.out.println("1-Add Expenses|2-Overview|3-import card transaction|4-clear|5-quit :");

            function = scanner.nextLine();
            if (function.equals("5")) {
                break;
            }
            if (function.equals("1")) {
                System.out.println("You selected to Manage your expense");
                m.processMoney();
            }
            if (function.equals("2")) {
                System.out.println("You selected to review the money spent.");
                p = new PresentSummary();
                p.presentMoney();
            }
            if (function.equals("4")) {
                m.clear();
            }
            if (function.equals("3")) {
                m.addRBCardBalance();
            } else {
                System.out.println("Please enter number 1,2 or 3.");
            }
        }
    }
}



