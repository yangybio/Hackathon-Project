package model;

public enum PayCategory {
    Food, GENERAL, Utilities, CLOTH, HOUSING;
    private ItemList itemList;

    public void addItem(Item i) {
        if (!itemList.contains(i)) {
            itemList.insert(i);
            i.setPayTo(this);
        }
    }

    public ItemList getList() {
        return itemList;
    }
}
