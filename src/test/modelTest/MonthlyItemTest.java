package modelTest;

import model.MonthlyItem;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonthlyItemTest extends ItemTest{


    @BeforeEach
    public void runbefore() {
        testItem = new MonthlyItem();
    }

    @Override
    public void testSetItemName() {
        testItem.setItemName("Book");
        assertEquals("Book_Paid_Monthly.", testItem.getItemName());
    }

    @Override
    public void testNextpay() throws ParseException {
        testItem.setDate("2019-10-03");
        String s = testItem.nextMonthPay();
        assertEquals("2019-11-03",s);
    }
}
