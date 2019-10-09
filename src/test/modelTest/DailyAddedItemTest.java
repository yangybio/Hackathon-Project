package modelTest;
import model.DailyAddedItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DailyAddedItemTest extends ItemTest {

    @Override
    @Test
    public void testSetDate(){
        testDailyAddedItem.setDate("09-22");
        assertEquals("09-22", testDailyAddedItem.getDate());
    }

    @Override
    @Test
    public void testSetItemName(){
        testDailyAddedItem.setItemName("Book");
        assertEquals("Book", testDailyAddedItem.getItemName());
    }

}
