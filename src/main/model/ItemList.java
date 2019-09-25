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

    public int size() {
        return itemSummary.size();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemList
    public void insert(Item newItem) {
        itemSummary.add(newItem);
    }

    //EFFECT: Return the itemSummary of the item list
    public List<Item> getItemList() {
        return itemSummary;
    }

}
