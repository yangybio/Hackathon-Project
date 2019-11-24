package model;

public class PayCategory {

    private Category category;
    private ItemList itemList;

    public enum Category {
        FOOD, GENERAL, UTILITIES, CREDIT, HOUSING
    }

    public PayCategory() {
        category = Category.FOOD;
        itemList = new ItemList();
    }

    public void setCategory(Category c) {
        category = c;
    }

    public Category getCategory() {
        return category;
    }

    public String getString() {
        switch (category) {
            case FOOD:
                return "FOOD";
            case CREDIT:
                return "CREDIT";
            case GENERAL:
                return "GENERAL";
            case HOUSING:
                return "HOUSING";
            default:
            case UTILITIES:
                return "UTILITIES";
        }
    }


    public void addItem(Item i) {
        if (!this.itemList.contains(i)) {
            if (!(i.getPayTo() == null)) {
                i.removePayMethod();
            }
            itemList.getItemList().add(i);
            i.setPayTo(this);
        }
    }

    public ItemList getList() {
        return itemList;
    }

    public void removeItem(Item i) {
        if (itemList.contains(i)) {
            itemList.getItemList().remove(i);
            i.removePayMethod();
        }
    }

}
