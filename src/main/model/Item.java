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
    private PayCategory payTo;

    public Item() {
        date = "";
        itemName = "";
        payTo = new PayCategory();
    }

    public Item(String date, String itemName, double m) {
        this.setDate(date);
        this.setItemName(itemName);
        try {
            this.setMoney(m);
        } catch (MoneyException e) {
            System.out.printf("Negative Money!!");
        }
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

    //MODIFIES:This
    //EFFECT: Set the payTo of the item
    public void setPayTo(PayCategory pay) {
        if (!(payTo == pay)) {
            if (!(payTo == null)) {
                removePayMethod();
            }
        }
        payTo = pay;
        pay.addItem(this);
    }

    //MODIFIES:This
    //EFFECT: remove the payTo of the item
    public void removePayMethod() {
        if (!(payTo == null)) {
            payTo.removeItem(this);
            payTo = null;
        }
    }

    //MODIFIES:This
    //EFFECT: Set the payTo of the item
    public void toPayMethod(String s) {
        payTo = new PayCategory();
        if (s.equals("FOOD")) {
            payTo.setCategory(PayCategory.Category.FOOD);
        }
        if (s.equals("CREDIT")) {
            payTo.setCategory(PayCategory.Category.CREDIT);
        }
        if (s.equals("HOUSING")) {
            payTo.setCategory(PayCategory.Category.HOUSING);
        }
        if (s.equals("UTILITIES")) {
            payTo.setCategory(PayCategory.Category.UTILITIES);
        }
        if (s.equals("GENERAL")) {
            payTo.setCategory(PayCategory.Category.GENERAL);
        }
    }

    //EFFECT: return the payTo of the item
    public PayCategory getPayTo() {
        return payTo;
    }

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

    //EFFECT: return the string
    public String itemToString() {
        String recordString = payTo.getString() + " " + date + " " + itemName + " " + Double.toString(money);
        return recordString;
    }

    //EFFECT: return true if date is valid; false otherwise
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

    //EFFECT: return the date of next month pay
    public abstract String nextMonthPay() throws ParseException;

    //EFFECT: redefine equal
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


    @SuppressWarnings("checkstyle:OperatorWrap")
    @Override
    public String toString() {
        return  payTo.getString() +  " -->"
                + " Date= " + date + "  "
                + " Name= " + itemName + "  "
                + " Money= " + money
                + "!";
    }
}
