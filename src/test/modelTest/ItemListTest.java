package modelTest;

import model.Item;
import model.ItemList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemListTest {
    private ItemList testList;
    @BeforeEach
    public void runbefore(){
        testList = new ItemList();
    }
    @Test
    public void testInsertItem(){
        Item addItem = new Item();
        testList.insert(addItem);
        assertEquals(1,testList.size());
    }
}
