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
            System.out.println("(1 for Expense Management; 2 for Overview;  3 for quit):");
            function = scanner.nextLine();
            if (function.equals("3")) {
                break;
            }
            if (function.equals("1")) {
                System.out.println("You selected to Manage your expense");
                m.processMoney();
            }
            if (function.equals("2")) {
                System.out.println("You selected to review the money spent today");
                p = new PresentSummary();
                p.presentMoney();

            } else {
                System.out.println("Please enter number 1,2 or 3.");
            }
        }
    }
}



