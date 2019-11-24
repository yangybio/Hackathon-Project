package gui.tool;

import model.exception.MoneyException;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.IOException;

public class OverviewPanel extends JPanel {
    private JScrollPane scrollPane;
    private EventListenerList listenerList = new EventListenerList();


    public OverviewPanel() throws IOException, MoneyException {

        scrollPane = new JScrollPane();
        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);
//        ItemList listData = new ItemList();
//        listData.getData("savedFile.txt");
//        Item[] data = new Item[listData.size()];
//        for (int i = 0; i < listData.size(); i++) {
//            data[i] = (listData.getItemList()).get(i);
//        }
//        list.setListData(data);
    }


    public void addDetailListener(AddItemListener addItemListener) {
        this.listenerList.add(AddItemListener.class,addItemListener);
    }
}



