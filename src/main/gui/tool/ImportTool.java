package gui.tool;

import model.DailyAddedItem;
import model.Item;
import model.exception.MoneyException;
import network.YnabUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ImportTool extends Tool {

    public ImportTool(JComponent parent) {
        super(parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Import credit card balance");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    list.getData("savedFile.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
                YnabUser n = new YnabUser();
                list.insert(n.newCreditItem());
                try {
                    list.record("savedFile.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
