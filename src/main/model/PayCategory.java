package model;

public class PayCategory {

    private Category category;
    private ItemList itemList;

    public enum Category {
        Food, GENERAL, Utilities, CLOTH, HOUSING
    }

    public PayCategory() {
        category = null;
        itemList = new ItemList();
    }

    public void setCategory(Category c) {
        category = c;
    }

    public Category getCategory() {
        return category;
    }

    public void addItem(Item i) {
        if (!this.itemList.contains(i)) {
            if (!(i.getPayTo() == null)) {
                i.removePayMethod();
            }
            this.itemList.insert(i);
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
