package model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private List<Item> itemSummary;

    public ItemList() {
        itemSummary = new ArrayList<>();
    }

    public void insert(Item newItem) {
        itemSummary.add(newItem);
    }

    public void presentItem() {
        for (Item i : itemSummary) {
            System.out.println("Date: " + i.getDate());
            System.out.println("Item: " + i.getItemName());
            System.out.println("Money: " + i.getRecordMoney());
            System.out.println("----------------------------");
        }
    }

}
