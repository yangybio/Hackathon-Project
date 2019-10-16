package modelTest;

import model.MonthlyItem;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyItemTest extends ItemTest{


    @BeforeEach
    public void runbefore() {
        testDailyAddedItem = new MonthlyItem();
    }

    @Override
    public void testSetItemName() {
        testDailyAddedItem.setItemName("Book");
        assertEquals("Book_Paid_Monthly.", testDailyAddedItem.getItemName());
    }

    @Override
    public void testNextpay() throws ParseException {
        testDailyAddedItem.setDate("2019-10-03");
        assertEquals("2019-11-03",testDailyAddedItem.nextMonthPay());
    }
}
