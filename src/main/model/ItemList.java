package model;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ItemList implements NewList, RecordThings,ReloadThings {
    private List<DailyAddedItem> dailyAddedItemSummary;

    //MODIFIES:This
    //EFFECT: Initialize the ItemList
    public ItemList() {
        dailyAddedItemSummary = new ArrayList<>();
    }

    @Override
    public int size() {
        return dailyAddedItemSummary.size();
    }

    //MODIFIES:This
    //EFFECT: add the new item to itemList
    @Override
    public void insert(DailyAddedItem newDailyAddedItem) {
        dailyAddedItemSummary.add(newDailyAddedItem);
    }

    //EFFECT: Return the itemSummary of the item list
    public List<DailyAddedItem> getItemList() {
        return dailyAddedItemSummary;
    }


    @Override
    public void record(String file) throws IOException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        for (DailyAddedItem i : dailyAddedItemSummary) {
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
            DailyAddedItem addDailyAddedItem = new DailyAddedItem();
            addDailyAddedItem.setDate(partsOfLine.get(0));
            addDailyAddedItem.setItemName(partsOfLine.get(1));
            addDailyAddedItem.setMoney(Double.parseDouble(partsOfLine.get(2)));
            dailyAddedItemSummary.add(addDailyAddedItem);
        }
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
