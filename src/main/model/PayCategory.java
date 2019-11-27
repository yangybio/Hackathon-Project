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

    //MODIFIES:this
    //EFFECT: set the category of this to c
    public void setCategory(Category c) {
        category = c;
    }

    //EFFECT: return the category
    public Category getCategory() {
        return category;
    }

    //EFFECT: get the string of category
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

    //MODIFIES:this
    //EFFECT: add new item into itemlist of this pay category
    public void addItem(Item i) {
        if (!this.itemList.contains(i)) {
            if (!(i.getPayTo() == null)) {
                i.removePayMethod();
            }
            itemList.getItemList().add(i);
            i.setPayTo(this);
        }
    }

    //EFFECT: return the itemList
    public ItemList getList() {
        return itemList;
    }

    //MODIFIES:this
    //EFFECT: remove item i from itemlist of this pay category
    public void removeItem(Item i) {
        if (itemList.contains(i)) {
            itemList.getItemList().remove(i);
            i.removePayMethod();
        }
    }

}
