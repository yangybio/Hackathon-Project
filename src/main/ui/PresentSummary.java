package ui;

import model.Item;
import model.ItemList;
import model.exception.MoneyException;

import java.io.IOException;

public class PresentSummary {
    private ItemList summary;

    public PresentSummary() throws IOException, MoneyException {
        summary = new ItemList();
        summary.getData("savedFile.txt");
    }

    //EFFECT: present the money record so far
    public void presentMoney() {
        presentTotalMoney();
        presentSummary();
    }

    //EFFECT: print out the total money spent
    public void presentTotalMoney() {
        System.out.println("-->You spent " + summary.getTotalMoney() + " totally.");
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
}
