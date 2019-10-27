package model;

import model.exception.MoneyException;
import model.exception.TimeFormException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Item {
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
    public void setDate(String date) {
        this.date = date;
    }

    //EFFECT: Return the date of the item
    public String getItemName() {
        return itemName;
    }

    //MODIFIES:This
    //EFFECT: Set the name of the item
    public abstract void setItemName(String name);

    //EFFECT: Return the Money of the item

    public double getMoney() {
        return money;
    }

    //REQUIRES: recordNumber is larger than 0
    //MODIFIES:This
    //EFFECT: Set the money of the item

    public void setMoney(double recordNumber) throws MoneyException {
        if (recordNumber <= 0.0) {
            throw new MoneyException("Negative Money!!");
        } else {
            this.money = recordNumber;
        }
    }

    public String itemToString() {
        String recordString = date + " " + itemName + " " + Double.toString(money);
        return recordString;
    }

    @SuppressWarnings("checkstyle:EmptyBlock")
    public boolean checkValidDate(String time) throws TimeFormException {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.setLenient(false);
            d = sdf.parse(time);
            return true;
        } catch (ParseException e) {
            throw new TimeFormException("Wrong format of time!!");
        }
    }

    public abstract String nextMonthPay() throws ParseException;

    public String getMonth() {
        String month = date.substring(0, 7);
        return month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return itemName.equals(item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
}
