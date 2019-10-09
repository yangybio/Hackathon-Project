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

    //MODIFIES:This
    //EFFECT: Set the date of the item
    @Override
    public void setDate(String date) {
        this.date = date;
    }

    //MODIFIES:This
    //EFFECT: Set the name of the item
    @Override
    public void setItemName(String name) {
        this.itemName = name;
    }

}
