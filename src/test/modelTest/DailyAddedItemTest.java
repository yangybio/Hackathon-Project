package modelTest;
import model.DailyAddedItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DailyAddedItemTest extends ItemTest {

    @BeforeEach
    public void runbefore() {
        testDailyAddedItem = new DailyAddedItem();
    }


    @Override
    @Test
    public void testSetItemName(){
        testDailyAddedItem.setItemName("Book");
        assertEquals("Book", testDailyAddedItem.getItemName());
    }

    @Override
    public void testNextpay() throws ParseException {
        testDailyAddedItem.setDate("2019-10-03");
        String s = testDailyAddedItem.nextMonthPay();
        assertEquals("",s);
    }

}
