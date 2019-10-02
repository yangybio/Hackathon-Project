package modelTest;

import model.Item;
import model.ItemList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    @Test
    public void testRecordNGetData() throws IOException {
        Item newItem = new Item();
        newItem.setDate("10-01");
        newItem.setItemName("test");
        newItem.setMoney(0.0);
        testList.insert(newItem);
        testList.record("testFile.txt");
        ItemList newItemList = new ItemList();
        newItemList.getData("testFile.txt");
        Item testItem = (newItemList.getItemList()).get(0);
        assertEquals(newItem.getDate(), testItem.getDate());
        assertEquals(newItem.getItemName(), testItem.getItemName());
        assertEquals(newItem.getMoney(), testItem.getMoney());
    }
}
