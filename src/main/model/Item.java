package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Item implements Money {
    protected String date;
    protected String itemName;
    protected double money;
    protected int state;

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
    public abstract void setDate(String date);

    //EFFECT: Return the date of the item
    public String getItemName() {
        return itemName;
    }

    //MODIFIES:This
    //EFFECT: Set the name of the item
    public abstract void setItemName(String name);

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

    public boolean checkValidDate(String time) {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        try {
            sdf.setLenient(false);
            d = sdf.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
