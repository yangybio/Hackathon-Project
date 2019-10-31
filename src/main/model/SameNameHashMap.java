package model;

import java.util.HashMap;
import java.util.Map;

public class SameNameHashMap {
    private Map<Item, ItemList> itemMap;

    public SameNameHashMap() {
        itemMap = new HashMap<Item, ItemList>();
    }

    public void addItem(Item newItem) {
        if (!itemMap.containsKey(newItem)) {
            ItemList newItemList = new ItemList();
            newItemList.insert(newItem);
            itemMap.put(newItem, newItemList);
        } else {
            ItemList tempoList = itemMap.get(newItem);
            tempoList.insert(newItem);
        }
    }

    public ItemList getList(Item i) {
        return itemMap.get(i);
    }

//    public void printItemDateAndMoney(Item item) {
//        System.out.println("The date and money for " + item.getItemName());
//        for (Item i : itemMap.get(item).getItemList()) {
//            System.out.println(i.getDate() + " " + i.getMoney());
//        }
//    }
}
