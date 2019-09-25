package ui;


import model.Item;

import java.util.Scanner;


public class LogginFunction {

    public Scanner scanner = new Scanner(System.in);

    public LogginFunction() {
        String function = "";
        MoneySpent m = new MoneySpent();
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
            } else {
                System.out.println("You selected to review the money spent today");
                m.presentMoney();
            }
        }
    }
}



