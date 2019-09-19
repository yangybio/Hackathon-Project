package ui;


import java.util.Scanner;


public class LogginFunction {

    public Scanner scanner = new Scanner(System.in);

    public LogginFunction() {
        String function = "";
        MoneySpent m = new MoneySpent();
        while (true) {
            System.out.println("Please select the function");
            System.out.println("(1 for Login money you spend; 2 for Sum of money you speed; 3 for quit):");
            function = scanner.nextLine();
            if (function.equals("3")) {
                break;
            }
            if (function.equals("1")) {
                System.out.println("You selected to login money you spent today");
                processMoney(m);
            } else {
                System.out.println("You selected to review the money spent today");
                presentmoney(m);
            }
        }
    }

//    private void LogginCost() {
//        scanner = new Scanner(System.in);
//        processMoney();
//    }

    private void processMoney(MoneySpent m) {
        System.out.println("Please enter the money you spent today:");
        m.setMoney(m.getMoney() + Double.parseDouble(scanner.nextLine()));
    }


    private void presentmoney(MoneySpent m) {
        System.out.println("You spent " + m.getMoney() + " today.");
    }

    public static void main(String[] args) {
        new LogginFunction();
    }
}



