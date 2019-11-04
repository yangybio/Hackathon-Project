package model;

public enum PayCategory {
    Food, GENERAL, Utilities, CLOTH, HOUSING;
    private ItemList itemList = new ItemList();


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
