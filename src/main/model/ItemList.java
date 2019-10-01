package model;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ItemList implements NewList, RecordThings,ReloadThings {
    private List<Item> itemSummary;

    //MODIFIES:This
    //EFFECT: Initialize the ItemList
    public ItemList() {
        itemSummary = new ArrayList<>();
    }

    @Override
    public int size() {
        return itemSummary.size();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemList
    @Override
    public void insert(Item newItem) {
        itemSummary.add(newItem);
    }

    //EFFECT: Return the itemSummary of the item list
    public List<Item> getItemList() {
        return itemSummary;
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
    public void getData(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Item addItem = new Item();
            addItem.setDate(partsOfLine.get(0));
            addItem.setItemName(partsOfLine.get(1));
            addItem.setMoney(Double.parseDouble(partsOfLine.get(2)));
            itemSummary.add(addItem);
        }
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
