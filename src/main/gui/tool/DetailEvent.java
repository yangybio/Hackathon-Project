package gui.tool;

import model.Item;
import model.ItemList;
import model.exception.MoneyException;

import java.io.IOException;
import java.util.EventObject;

public class DetailEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param actionListener
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    private ItemList itemList;

    public DetailEvent(Object source, Item i) throws IOException, MoneyException {
        super(source);
        itemList = new ItemList();
        itemList.getData("savedFile.txt");
        itemList.insert(i);
        itemList.record("savedFile.txt");
    }

    public DetailEvent(Object source) throws IOException, MoneyException {
        super(source);
        itemList = new ItemList();
        itemList.getData("savedFile.txt");
    }

    public Item getNewAddItem() {
        return itemList.getItemList().get(itemList.size() - 1);
    }
}
