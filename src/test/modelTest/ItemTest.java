package modelTest;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        testItem.setDate("0922");
        assertEquals("0922",testItem.getDate());
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

}
