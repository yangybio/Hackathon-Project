package modelTest;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item testItem;

    @BeforeEach
    public void runbefore(){
        testItem = new Item();
    }

    @Test
    public void testGetDate(){
        assertEquals("",testItem.getDate());
    }

    @Test
    public void testSetDate(){
        testItem.setDate("09-22");
        assertEquals("09-22",testItem.getDate());
    }

    @Test
    public void testGetItemName(){
        assertEquals("",testItem.getItemName());
    }

    @Test
    public void testSetItemName(){
        testItem.setItemName("Book");
        assertEquals("Book",testItem.getItemName());
    }

    @Test
    public void testGetRecordMoney(){
        assertEquals(0.0,testItem.getMoney());
    }

    @Test
    public void testSetRecordMoney(){
        testItem.setMoney(9.8);
        assertEquals(9.8,testItem.getMoney());
    }
    @Test
    public void testCheckDate(){
        String time1 = "13-35";
        String time2 = "12-21";
        String time3 = "1221";
        assertFalse(testItem.checkValidDate(time1));
        assertTrue(testItem.checkValidDate(time2));
        assertFalse(testItem.checkValidDate(time3));

    }

}
