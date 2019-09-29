package ui;

import model.Item;
import model.ItemList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RecordMoney {
    private double money;
    public Scanner scanner = new Scanner(System.in);
    private ItemList summary;

    //MODIFIES:This
    //EFFECT: Initialize the Money
    public RecordMoney() throws IOException {
        summary = new ItemList();
        summary.getData();
        money = 0.0;
        for (Item i : summary.getItemList()) {
            setMoney(i);
        }
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
    public void processMoney(Item newItem) throws IOException {
        enterDate(newItem);
        System.out.println("Please enter the money you spent at " + newItem.getDate());
        newItem.setRecordMoney(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter what your money spent for:");
        newItem.setItemName(scanner.nextLine());
        System.out.println("You spent " + newItem.getRecordMoney() + " at " + newItem.getDate());
        System.out.println("for " + newItem.getItemName());
        summary.insert(newItem);
        summary.record();
        setMoney(newItem);
    }

    public void enterDate(Item newItem) {
        System.out.println("Please enter the date you spent the money(mmdd):");
//        String time = scanner.nextLine();
//        int month = Integer.parseInt(time.substring(0, 2));
//        int day = Integer.parseInt(time.substring(2));
//        if (1<=month<=12 && <=day<=)
        newItem.setDate(scanner.nextLine());

    }

    //EFFECT: Present the total money spent and summary of recorded items
    public void presentMoney() {
        presentTotalMoney();
        presentSummary();
    }

    //EFFECT: print out the total money spent
    public void presentTotalMoney() {
        System.out.println("You spent " + money + " totally.");
    }

    //EFFECT: Print out the summary of recorded items (money, data and name)
    public void presentSummary() {
        for (Item i : summary.getItemList()) {
            System.out.println("Date: " + i.getDate());
            System.out.println("Item: " + i.getItemName());
            System.out.println("Money: " + i.getRecordMoney());
            System.out.println("----------------------------");
        }
    }
}

