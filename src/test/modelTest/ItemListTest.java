package modelTest;

import model.DailyAddedItem;
import model.Item;
import model.ItemList;
import model.exception.MoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemListTest {
    private ItemList testList;

    @BeforeEach
    public void runbefore() {
        testList = new ItemList();
    }

    @Test
    public void testInsertItem() {
        DailyAddedItem addDailyAddedItem = new DailyAddedItem();
        testList.insert(addDailyAddedItem);
        assertEquals(1, testList.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, testList.size());
        DailyAddedItem addDailyAddedItem = new DailyAddedItem();
        int number = 10;
        for (int i = 0; i < number; i++) {
            testList.insert(addDailyAddedItem);
        }
        assertEquals(number, testList.size());
    }

    @Test
    public void testGetItemList() {
        ItemList newItemList = new ItemList();
        assertEquals(newItemList.getItemList(), testList.getItemList());
    }

    @Test
    public void testRecordNGetData() throws IOException, MoneyException {
        DailyAddedItem newDailyAddedItem = new DailyAddedItem();
        newDailyAddedItem.setDate("2010-10-01");
        newDailyAddedItem.setItemName("test");
        newDailyAddedItem.setMoney(10.0);
        testList.insert(newDailyAddedItem);
        testList.record("testFile.txt");
        ItemList newItemList = new ItemList();
        newItemList.getData("testFile.txt");
        Item testDailyAddedItem = (newItemList.getItemList()).get(0);
        assertEquals(newDailyAddedItem.getDate(), testDailyAddedItem.getDate());
        assertEquals(newDailyAddedItem.getItemName(), testDailyAddedItem.getItemName());
        assertEquals(newDailyAddedItem.getMoney(), testDailyAddedItem.getMoney());
    }

    @Test
    public void testClear() throws IOException, MoneyException {
        testList.clearData("testFile.txt");
        ItemList newList = new ItemList();
        newList.getData("testFile.txt");
        assertTrue(newList.getItemList().isEmpty());
    }
}
