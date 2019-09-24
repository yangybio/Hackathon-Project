package model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private List<Item> itemSummary;

    //MODIFIES:This
    //EFFECT: Initialize the ItemList
    public ItemList() {
        itemSummary = new ArrayList<>();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemlist
    public void insert(Item newItem) {
        itemSummary.add(newItem);
    }

    public List<Item> getItemList() {
        return itemSummary;
    }

}
