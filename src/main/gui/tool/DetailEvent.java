package gui.tool;

import model.Item;
import model.ItemList;
import model.exception.MoneyException;

import java.io.IOException;
import java.util.EventObject;

public class DetailEvent extends EventObject {
    private ItemList itemList;

    public DetailEvent(Object source, Item i)  {
        super(source);
        itemList = new ItemList();
        try {
            itemList.getData("savedFile.txt");
            itemList.insert(i);
            itemList.record("savedFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MoneyException e) {
            e.printStackTrace();
        }
    }

    public DetailEvent(Object source) {
        super(source);
        itemList = new ItemList();
        try {
            itemList.getData("savedFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MoneyException e) {
            e.printStackTrace();
        }
    }

    public Item getNewAddItem() {
        return itemList.getItemList().get(itemList.size() - 1);
    }

    public ItemList getItemList() {
        return itemList;
    }
}
