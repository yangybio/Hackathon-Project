package model;

public class MonthlyItem extends Item {

    public MonthlyItem() {
        super();
        state = 1;
    }


    @Override
    public void setItemName(String name) {
        this.itemName = name + "_Paid_Monthly.";
    }
}
