package modelTest;

import model.Item;
import model.PayCategory;
import model.exception.MoneyException;
import model.exception.TimeFormException;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class ItemTest {
    protected Item testItem;




    @Test
    public void testGetDate(){
        assertEquals("", testItem.getDate());
    }

    @Test
    public void testSetDate(){
        testItem.setDate("2019-09-22");
        assertEquals("2019-09-22", testItem.getDate());
    }

    @Test
    public void testGetItemName(){
        assertEquals("", testItem.getItemName());
    }

    @Test
    public abstract void testSetItemName();

    @Test
    public void testGetRecordMoney(){
        assertEquals(0.0, testItem.getMoney());
    }

    @Test
    public void testSetRecordMoney()  {
        try {
            testItem.setMoney(9.8);
            assertEquals(9.8, testItem.getMoney());
        } catch (MoneyException e) {
            fail("Shouldn't catch the exception.");
        }
    }

    @Test
    public void testWrongMoneySet(){
        try {
            testItem.setMoney(-9.8);
            fail("Should cathe the negative money exception ");
        } catch (MoneyException e) {
            //expected
        }
    }

    @Test
    public void testSetCorrectDate(){
        try{
            assertTrue(testItem.checkValidDate("2019-10-10"));
        } catch (TimeFormException e){
            fail("Shouldn't catch the wrong time exception.");
        }
    }

    @Test
    public void testSetWrongDate(){
        try{
            testItem.checkValidDate("19-18-34");
            fail("Should catch the exception.");
        } catch (TimeFormException e){
            //expected
        }
    }

    @Test
    public abstract void testNextpay() throws ParseException;

    @Test
    public void testSetPay(){
        assertEquals(null,testItem.getPayTo());
        testItem.setPayTo(PayCategory.Food);
        assertTrue(PayCategory.Food.getList().contains(testItem));
        testItem.setPayTo(PayCategory.CLOTH);
        assertFalse(PayCategory.Food.getList().contains(testItem));
        assertTrue(PayCategory.CLOTH.getList().contains(testItem));
        testItem.setPayTo(PayCategory.HOUSING);
        assertTrue(PayCategory.HOUSING.getList().contains(testItem));
        testItem.setPayTo(PayCategory.Utilities);
        assertTrue(PayCategory.Utilities.getList().contains(testItem));
    }

    @Test
    public void testToPayMethod(){
        testItem.toPayMethod("1");
        assertEquals(PayCategory.Food,testItem.getPayTo());
        testItem.toPayMethod("2");
        assertEquals(PayCategory.CLOTH,testItem.getPayTo());
        testItem.toPayMethod("3");
        assertEquals(PayCategory.HOUSING,testItem.getPayTo());
        testItem.toPayMethod("4");
        assertEquals(PayCategory.Utilities,testItem.getPayTo());
        testItem.toPayMethod("5");
        assertEquals(PayCategory.GENERAL,testItem.getPayTo());
    }


}
