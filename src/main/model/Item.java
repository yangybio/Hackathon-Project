package model;

public class Item implements Category {
    private String date;
    private String itemName;
    private double recordMoney;

    //MODIFIES:THIS
    //EFFECT: Initiate a new item
    public Item() {
        date = "";
        itemName = "";
        recordMoney = 0.0;
    }

    //EFFECT: Return the date of the item
    public String getDate() {
        return date;
    }

    //MODIFIES:This
    //EFFECT: Set the date of the item
    public void setDate(String date) {
        this.date = date;
    }

    //EFFECT: Return the date of the item
    public String getItemName() {
        return itemName;
    }

    //MODIFIES:This
    //EFFECT: Set the name of the item
    public void setItemName(String name) {
        this.itemName = name;
    }

    //EFFECT: Return the Money of the item
    public double getRecordMoney() {
        return recordMoney;
    }

    //REQUIRES: recordNumber is larger than 0
    //MODIFIES:This
    //EFFECT: Set the money of the item
    public void setRecordMoney(double recordNumber) {
        this.recordMoney = recordNumber;
    }

    public String itemToString() {
        String recordString = date + " " + itemName + " " + Double.toString(recordMoney);
        return recordString;
    }
}
