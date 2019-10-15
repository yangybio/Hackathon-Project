package modelTest;

import model.DailyAddedItem;
import model.exception.MoneyException;
import model.exception.TimeFormException;
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
    public void testSetRecordMoney()  {
        try {
            testDailyAddedItem.setMoney(9.8);
            assertEquals(9.8, testDailyAddedItem.getMoney());
        } catch (MoneyException e) {
            fail("Shouldn't catch the exception.");
        }
    }

    @Test
    public void testWrongMoneySet(){
        try {
            testDailyAddedItem.setMoney(-9.8);
            fail("Should cathe the negative money exception ");
        } catch (MoneyException e) {
            //expected
        }
    }

    @Test
    public void testSetCorrectDate(){
        try{
            assertTrue(testDailyAddedItem.checkValidDate("2019-10-10"));
        } catch (TimeFormException e){
            fail("Shouldn't catch the wrong time exception.");
        }
    }

    @Test
    public void testSetWrongDate(){
        try{
            testDailyAddedItem.checkValidDate("19-18-34");
            fail("Should catch the exception.");
        } catch (TimeFormException e){
            //expected 
        }
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
