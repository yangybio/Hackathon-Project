package modelTest;

import model.DailyAddedItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class ItemTest {
    protected DailyAddedItem testDailyAddedItem;

    @BeforeEach
    public void runbefore(){
        testDailyAddedItem = new DailyAddedItem();
    }

    @Test
    public void testGetDate(){
        assertEquals("", testDailyAddedItem.getDate());
    }

    @Test
    public abstract void testSetDate();

    @Test
    public void testGetItemName(){
        assertEquals("", testDailyAddedItem.getItemName());
    }

    @Test
    public abstract void testSetItemName();

    @Test
    public void testGetRecordMoney(){
        assertEquals(0.0, testDailyAddedItem.getMoney());
    }

    @Test
    public void testSetRecordMoney(){
        testDailyAddedItem.setMoney(9.8);
        assertEquals(9.8, testDailyAddedItem.getMoney());
    }

//    @Test
//    public void testCheckDate(){
//        String time1 = "13-35";
//        String time2 = "12-21";
//        String time3 = "1221";
//        assertFalse(testDailyAddedItem.checkValidDate(time1));
//        assertTrue(testDailyAddedItem.checkValidDate(time2));
//        assertFalse(testDailyAddedItem.checkValidDate(time3));
//    }
}
