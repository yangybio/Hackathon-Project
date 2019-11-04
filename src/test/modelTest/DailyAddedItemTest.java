package modelTest;
import model.DailyAddedItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DailyAddedItemTest extends ItemTest {

    @BeforeEach
    public void runbefore() {
        testItem = new DailyAddedItem();
    }


    @Override
    @Test
    public void testSetItemName(){
        testItem.setItemName("Book");
        assertEquals("Book", testItem.getItemName());
    }

    @Override
    public void testNextpay() throws ParseException {
        testItem.setDate("2019-10-03");
        String s = testItem.nextMonthPay();
        assertEquals("",s);
    }



}
