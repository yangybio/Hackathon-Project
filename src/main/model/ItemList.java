package model;

import model.exception.MoneyException;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ItemList implements RecordThings, ReloadThings {
    private List<Item> itemSummary;
    private double money;

    //MODIFIES:This
    //EFFECT: Initialize the ItemList
    public ItemList() {
        itemSummary = new ArrayList<>();
        money = 0.0;
    }


    public int size() {
        return itemSummary.size();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemList

    public void insert(Item newDailyAddedItem) {
        itemSummary.add(newDailyAddedItem);
        money = money + newDailyAddedItem.getMoney();
    }

    //EFFECT: Return the itemSummary of the item list
    public List<Item> getItemList() {
        return itemSummary;
    }

    public Boolean contains(Item i) {
        return itemSummary.contains(i);
    }

    @Override
    public void record(String file) throws IOException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        for (Item i : itemSummary) {
            lines.add(i.itemToString());
        }
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }

    @Override
    public void getData(String file) throws IOException, MoneyException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        if (!lines.isEmpty()) {
            for (String line : lines) {
                ArrayList<String> partsOfLine = splitOnSpace(line);
                Item addDailyAddedItem = new DailyAddedItem();
                addDailyAddedItem.setDate(partsOfLine.get(0));
                addDailyAddedItem.setItemName(partsOfLine.get(1));
                addDailyAddedItem.setMoney(Double.parseDouble(partsOfLine.get(2)));
//            itemSummary.add(addDailyAddedItem);
                this.insert(addDailyAddedItem);
            }
        }
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public double getTotalMoney() {
        return money;
    }
}
