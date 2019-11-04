package ui;

import model.ItemList;

import java.io.IOException;

public class ClearAll {
    private ItemList emptylist;

    public ClearAll() {
        emptylist = new ItemList();
    }

    public void clearData() throws IOException {
        emptylist.record("savedFile.txt");
    }
}
