package gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Manage yoru expense!"));

        JLabel date = new JLabel("Date: ");
        JLabel money = new JLabel("Money: ");
        JLabel itemName = new JLabel("Name: ");
        JButton overview = new JButton("Overview.");
        JButton importCard = new JButton("Import card balance.");
        JButton clear = new JButton("Clear history data");
        JButton newItem = new JButton("Add new item");
        JLabel function = new JLabel("Another Function: ");
        JLabel note = new JLabel("yyyy-mm-dd");

        JTextField dateField = new  JTextField(10);
        JTextField moneyField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // First Column


        gc.weighty = 3;
        gc.gridx = 0;
        gc.gridy = 1;
        add(date, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(note, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(money, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(itemName, gc);

        //second Column
        gc.gridx = 1;
        gc.gridy = 1;
        add(dateField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(moneyField, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        add(nameField, gc);

        gc.weighty = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 4;
        add(newItem,gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(function,gc);

        gc.gridx = 1;
        gc.gridy = 7;
        add(overview, gc);

        gc.gridx = 1;
        gc.gridy = 8;
        add(importCard, gc);

        gc.gridx = 1;
        gc.gridy = 9;
        add(clear, gc);

    }
}
