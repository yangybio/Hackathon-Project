package model;

import java.util.Scanner;

public class MoneySpent {
    private double money;
    public Scanner scanner = new Scanner(System.in);
    private ItemList summary;

    //MODIFIES:This
    //EFFECT: Initialize the Money
    public MoneySpent() {
        money = 0.0;
        summary = new ItemList();
    }

    //EFFECT: return the money
    public double getTotalMoney() {
        return money;
    }

    //MODIFIES:This
    //EFFECT: Set the money
    public void setMoney(Item item) {
        money = item.getRecordMoney() + money;
    }

    //MODIFIES:This and newItem
    //EFFECT: Record the date, money and category for newItem
    public void processMoney(Item newItem) {
        System.out.println("Please enter the date you spent the money(mm/dd):");
        newItem.setDate(scanner.nextLine());
        System.out.println("Please enter the money you spent at " + newItem.getDate());
        newItem.setRecordMoney(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter what your money spent for:");
        newItem.setItemName(scanner.nextLine());
        System.out.println("You spent " + newItem.getRecordMoney() + " at " + newItem.getDate());
        System.out.println("for " + newItem.getItemName());
        summary.insert(newItem);
        money = money + newItem.getRecordMoney();
    }

    public void presentMoney() {
        presentTotalMoney();
        presentSummary();
    }

    //EFFECT: print out the total money spent
    public void presentTotalMoney() {
        System.out.println("You spent " + money + " totally.");
    }

    public void presentSummary() {
        for (Item i : summary.getItemList()) {
            System.out.println("Date: " + i.getDate());
            System.out.println("Item: " + i.getItemName());
            System.out.println("Money: " + i.getRecordMoney());
            System.out.println("----------------------------");
        }
    }
}

