package gui;

import gui.tool.AddItemFunction;
import gui.tool.AddItemListener;
import gui.tool.DetailEvent;
import gui.tool.OverviewListener;
import model.Item;
import model.ItemList;
import model.exception.MoneyException;
import network.YnabUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainFrame extends JFrame {
    private FunctionPanel panel;
    private JScrollPane scrollPane;
    private Font lableFont = new Font("Roboto", Font.PLAIN, 14);


    public MainFrame(String name) throws IOException, MoneyException {
        super(name);

        //set Layout
        setLayout(new BorderLayout());


        // Create Swing component
        scrollPane = new JScrollPane();
        JList list = new JList();
        JButton importBt = new JButton("Import credit card transaction");
        JButton deleteBt = new JButton("Delete");
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);
        Dimension size = getPreferredSize();
        size.width = 500;
        scrollPane.setPreferredSize(size);
        panel = new FunctionPanel();
        AddItemFunction itemPanel = new AddItemFunction();
        panel.add(itemPanel);
        panel.function.add(importBt);
        panel.function.add(deleteBt);
        importBt.setForeground(new Color(120, 221, 176));
        importBt.setFont(lableFont);
        deleteBt.setForeground(new Color(120, 221, 176));
        deleteBt.setFont(lableFont);

        itemPanel.addDetailListener(new AddItemListener() {
            @Override
            public void addItemOccurred(DetailEvent event) {
                Item i = event.getNewAddItem();
                Item[] data = new Item[1];
                data[0] = i;
                list.setListData(data);
            }
        });

        panel.addDetailListener(new OverviewListener() {
            @Override
            public void overviewOccurred(DetailEvent event) {
                ItemList listData = event.getItemList();
                Item[] data = new Item[listData.size()];
                for (int i = 0; i < listData.size(); i++) {
                    data[i] = (listData.getItemList()).get(i);
                }
                list.setListData(data);
            }
        });

        importBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemList itemList = new ItemList();
                try {
                    itemList.getData("savedFile.txt");
                    YnabUser n = new YnabUser();
                    itemList.insert(n.newCreditItem());
                    itemList.record("savedFile.txt");
                    Item[] data = new Item[1];
                    data[0] = n.newCreditItem();
                    list.setListData(data);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = list.getSelectedIndex();
                ItemList itemList = new ItemList();
                try {
                    itemList.getData("savedFile.txt");
                    itemList.getItemList().remove(n);
                    itemList.record("savedFile.txt");
                    Item[] data = new Item[itemList.size()];
                    for (int i = 0; i < itemList.size(); i++) {
                        data[i] = (itemList.getItemList()).get(i);
                    }
                    list.setListData(data);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //add Swing component
        Container c = getContentPane();
        c.add(scrollPane, BorderLayout.EAST);
        c.add(panel,BorderLayout.WEST);
    }
}
