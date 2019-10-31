//package modelTest;
//
//import model.*;
//import model.exception.MoneyException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class TimeTrackerTest {
//    private TimeTracker testList;
//    private ItemList list;
//
//    @BeforeEach
//    public void runbefore() throws MoneyException {
//        testList = new TimeTracker();
//        list = new ItemList();
//        Item newItem1 = new DailyAddedItem();
//        newItem1.setDate("2010-10-01");
//        newItem1.setItemName("test1");
//        newItem1.setMoney(5.0);
//        Item newItem2 = new DailyAddedItem();
//        newItem2.setDate("2010-10-01");
//        newItem2.setItemName("test2");
//        newItem2.setMoney(10.0);
//        list.insert(newItem1);
//        list.insert(newItem2);
//    }
//
//    @Test
//    public void testAddItem()throws Exception{
//        for (Item i: list.getItemList()){
//            testList.addItem(i);
//        }
//        Item newItem2 = new DailyAddedItem();
//        newItem2.setDate("2010-10-01");
//        newItem2.setItemName("test");
//        newItem2.setMoney(10.0);
//        ItemList testOne = testList.getItemsThisMonth("2010-10");
//        assertEquals(2,testOne.getItemList().size());
//    }
//
//
//
//}
