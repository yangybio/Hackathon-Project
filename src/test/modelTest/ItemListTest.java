package modelTest;

import model.Item;
import model.ItemList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemListTest {
    private ItemList testList;

    @BeforeEach
    public void runbefore() {
        testList = new ItemList();
    }

    @Test
    public void testInsertItem() {
        Item addItem = new Item();
        testList.insert(addItem);
        assertEquals(1, testList.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, testList.size());
        Item addItem = new Item();
        int number = 10;
        for (int i = 0; i < number; i++) {
            testList.insert(addItem);
        }
        assertEquals(number, testList.size());
    }

    @Test
    public void testGetItemList() {
        ItemList newItemList = new ItemList();
        assertEquals(newItemList.getItemList(), testList.getItemList());
    }
}
