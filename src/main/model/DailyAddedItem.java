package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyAddedItem extends Item {

    //MODIFIES:THIS
    //EFFECT: Initiate a new item
    public DailyAddedItem() {
        super();
        state = 0;
    }

    public DailyAddedItem(String date, String name, double m) {
        super(date, name, m);
        state = 0;
    }

    //MODIFIES:This
    //EFFECT: Set the name of the item
    @Override
    public void setItemName(String name) {
        this.itemName = name;
    }

    @Override
    public String nextMonthPay() throws ParseException {
        return "";
    }

}
