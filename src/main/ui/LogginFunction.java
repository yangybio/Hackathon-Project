package ui;


import model.Item;

import java.io.IOException;
import java.util.Scanner;


public class LogginFunction {

    public Scanner scanner = new Scanner(System.in);

    public LogginFunction() throws IOException {
        String function = "";
        RecordMoney m = new RecordMoney();
        while (true) {
            System.out.println("Please select the function");
            System.out.println("(1 for Expense Management; 2 for Overview;  3 for quit):");
            function = scanner.nextLine();
            Item newItem = new Item();
            if (function.equals("3")) {
                break;
            }
            if (function.equals("1")) {
                System.out.println("You selected to Manage your expense");
                m.processMoney(newItem);
            }
            if (function.equals("2")) {
                System.out.println("You selected to review the money spent today");
                m.presentMoney();

            } else {
                System.out.println("Please enter number 1,2 or 3.");
            }
        }
    }
}



