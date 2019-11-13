package model;

import model.exception.MoneyException;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class ItemList extends Observable implements RecordThings, ReloadThings {
    private List<Item> itemSummary;
    private double money;


    //MODIFIES:This
    //EFFECT: Initialize the ItemList
    public ItemList() {
        itemSummary = new ArrayList<>();
        money = 0.0;
        addObserver(new MoneyObserver());
    }


    public int size() {
        return itemSummary.size();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemList

    public void insert(Item newDailyAddedItem) {
        itemSummary.add(newDailyAddedItem);
        money = money + newDailyAddedItem.getMoney();
        setChanged();
        notifyObservers(newDailyAddedItem);
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
                this.itemSummary.add(addDailyAddedItem);
                money = money + addDailyAddedItem.getMoney();
            }
        }
    }

    public void clearData(String file) throws IOException {
        ItemList emptyList = new ItemList();
        emptyList.record(file);
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public double getTotalMoney() {
        return money;
    }


}
