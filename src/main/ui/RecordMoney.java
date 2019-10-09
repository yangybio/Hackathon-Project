package ui;

import model.*;

import java.io.IOException;
import java.util.Scanner;

public class RecordMoney implements Money {
    private double money;
    public Scanner scanner = new Scanner(System.in);
    private ItemList summary;

    //MODIFIES:This
    //EFFECT: Initialize the Money
    public RecordMoney() throws IOException {
        summary = new ItemList();
        summary.getData("savedFile.txt");
        money = 0.0;
        for (Item i : summary.getItemList()) {
            setMoney(i.getMoney());
        }
    }

    //EFFECT: return the money
    public double getTotalMoney() {
        return money;
    }

    //MODIFIES:This
    //EFFECT: Set the money
    public void setMoney(double m) {
        money = m + money;
    }

    //MODIFIES:This and newItem
    //EFFECT: Record the date, money and category for newItem
    public void processMoney() throws IOException {
        System.out.println("Does this item need to be paid monthly? ");
        System.out.println("Enter 1 for yes, 0 for no");
        String p = scanner.nextLine();
        if (p.equals("0")) {
            processDItem();
        }
        if (p.equals("1")) {
            System.out.println("Enter how many times you need to pay:");
            int times = Integer.parseInt(scanner.nextLine());
            processMItem(times);
        }

    }

    public void process(Item newItem) {
        enterDate(newItem);
        System.out.println("Please enter the money you spent at " + newItem.getDate());
        newItem.setMoney(Double.parseDouble(scanner.nextLine()));
        System.out.println("Please enter what your money spent for (use _ instead of space):");
        newItem.setItemName(scanner.nextLine());
        System.out.println("You spent " + newItem.getMoney() + " at " + newItem.getDate());
        System.out.println("for " + newItem.getItemName());
    }

    public void processDItem() throws IOException {
        Item newDailyAddedItem = new DailyAddedItem();
        process(newDailyAddedItem);
        summary.insert(newDailyAddedItem);
        summary.record("savedFile.txt");
        setMoney(newDailyAddedItem.getMoney());
    }

    public void processMItem(int times) throws IOException {
        Item newMItem = new MonthlyItem();
        process(newMItem);
        for (int i = 0; i < times; i++) {
            summary.insert(newMItem);
        }
        summary.record("savedFile.txt");
        setMoney(newMItem.getMoney());
    }

    public void enterDate(Item newDailyAddedItem) {
        System.out.println("Please enter the date you spent the money(mm-dd):");
        while (true) {
            String time = scanner.nextLine();
            if (newDailyAddedItem.checkValidDate(time)) {
                newDailyAddedItem.setDate(time);
                break;
            } else {
                System.out.println("Invalid Date, please enter again!");
            }
        }
    }

//    public boolean checkValidDate(String time) {
//        Date d = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
//        try {
//            sdf.setLenient(false);
//            d = sdf.parse(time);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }

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
            System.out.println("Money: " + i.getMoney());
            System.out.println("----------------------------");
        }
    }

    @Override
    public double getMoney() {
        return money;
    }
}

