package model;

public class Item implements Money {
    private String date;
    private String itemName;
    private double money;

    //MODIFIES:THIS
    //EFFECT: Initiate a new item
    public Item() {
        date = "";
        itemName = "";
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
    @Override
    public double getMoney() {
        return money;
    }

    //REQUIRES: recordNumber is larger than 0
    //MODIFIES:This
    //EFFECT: Set the money of the item
    @Override
    public void setMoney(double recordNumber) {
        this.money = recordNumber;
    }

    public String itemToString() {
        String recordString = date + " " + itemName + " " + Double.toString(money);
        return recordString;
    }
}
