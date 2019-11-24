package modelTest;

import model.DailyAddedItem;
import model.Item;
import model.MonthlyItem;
import model.PayCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PayMethodTest {
    private PayCategory testPay;
    private Item item1;
    private Item item2;


    @BeforeEach
    public void runbefore() {
        testPay = new PayCategory();
        item1 = new DailyAddedItem("2019-11-03", "test1", 10.0);
        item2 = new MonthlyItem("2019-11-03", "test2", 10.0);
    }


    @Test
    public void testSetCategory() {
        assertEquals(PayCategory.Category.FOOD,testPay.getCategory());
    }

    @Test
    public void testAddNewDifferentItem() {

        assertEquals(0, testPay.getList().size());
        assertFalse(testPay.getList().contains(item1));
        assertFalse(testPay.getList().contains(item2));
        testPay.addItem(item1);
        testPay.addItem(item2);
        assertTrue(testPay.getList().contains(item1));
        assertTrue(testPay.getList().contains(item2));
        assertEquals(2, testPay.getList().size());
    }

    @Test
    public void testAddSameItem () {
        assertEquals(0, testPay.getList().size());
        assertFalse(testPay.getList().contains(item1));
        testPay.addItem(item1);
        testPay.addItem(item1);
        assertTrue(testPay.getList().contains(item1));
        assertEquals(1, testPay.getList().size());
    }


    @Test
    public void testRemoveItem() {
        testPay.addItem(item1);
        testPay.addItem(item2);
        assertTrue(testPay.getList().contains(item1));
        assertTrue(testPay.getList().contains(item2));
        testPay.removeItem(item2);
        assertEquals(1, testPay.getList().size());
        assertTrue(testPay.getList().contains(item1));
        assertFalse(testPay.getList().contains(item2));
        testPay.removeItem(item1);
        assertEquals(0, testPay.getList().size());
        assertFalse(testPay.getList().contains(item1));
    }
}
