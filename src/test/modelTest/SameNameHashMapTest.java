package modelTest;

import model.DailyAddedItem;
import model.Item;
import model.ItemList;
import model.SameNameHashMap;
import model.exception.MoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SameNameHashMapTest {
    private SameNameHashMap testList;
    private ItemList list;

    @BeforeEach
    public void runbefore() throws MoneyException {
        testList = new SameNameHashMap();
        list = new ItemList();
        Item newItem1 = new DailyAddedItem();
        newItem1.setDate("2010-10-01");
        newItem1.setItemName("test");
        newItem1.setMoney(5.0);
        Item newItem2 = new DailyAddedItem();
        newItem2.setDate("2010-12-21");
        newItem2.setItemName("test");
        newItem2.setMoney(10.0);
        list.getItemList().add(newItem1);
        list.getItemList().add(newItem2);
    }

    @Test
    public void testAddItem()throws Exception{
        for (Item i: list.getItemList()){
            testList.addItem(i);
        }
        Item newItem2 = new DailyAddedItem();
        newItem2.setDate("2010-12-21");
        newItem2.setItemName("test");
        newItem2.setMoney(10.0);
        ItemList testOne = testList.getList(newItem2);
        assertEquals(2,testOne.getItemList().size());
    }



}
