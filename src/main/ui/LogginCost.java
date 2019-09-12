package ui;


import java.util.Scanner;

public class LogginCost {
    private Scanner scanner;
    private double money;


    private LogginCost() {
        scanner = new Scanner(System.in);
        processMoney();
    }

    private void processMoney() {
        money = 0.0;
        System.out.println("Please enter the money you spent today:");
        money = Double.parseDouble(scanner.nextLine());
        presentmoney(money);

    }


    private void presentmoney(double money) {
        System.out.println("You spent " + money + " today.");
    }

    public static void main(String[] args) {
        new LogginCost();
    }
}

