package gui.tool;

import model.DailyAddedItem;
import model.Item;
import model.ItemList;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddItemFunction extends JPanel {
    JLabel date;
    JLabel money;
    String itemCate;
    JLabel itemName;
    JTextField dateField;
    JTextField moneyField;
    JTextField nameField;
    JLabel cateField;
    JButton addNewItem;
    Item newItem;
    ItemList itemList;
    JSpinner time;
    JComboBox category;
    Color lableColor = new Color(22, 133, 254);
    Color textColor = new Color(233, 55, 40);
    private Font lableFont = new Font("Roboto", Font.TRUETYPE_FONT, 14);
    EventListenerList listenerList = new EventListenerList();

    public AddItemFunction() {
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Manage your expense!"));
        setDate();
        initial();
        itemCate = "";
        setLableColor();
        setTextColor();
        setLayout(new GridBagLayout());
        setEverything();
        setListener();
        newItem = null;
    }

    private void initial() {
        String[] categories = {"FOOD", "GENERAL", "UTILITIES", "CREDIT", "HOUSING"};
        date = new JLabel("Date: ");
        money = new JLabel("Money: ");
        itemName = new JLabel("Name: ");
        cateField = new JLabel("Category: ");
        dateField = new JTextField(10);
        moneyField = new JTextField(10);
        nameField = new JTextField(10);
        money.setFont(lableFont);
        date.setFont(lableFont);
        itemName.setFont(lableFont);
        cateField.setFont(lableFont);
        addNewItem = new JButton("Add new item");
        addNewItem.setForeground(new Color(233, 157, 104));
        addNewItem.setFont(lableFont);
        category = new JComboBox(categories);
        category.setEditable(true);
    }

    private void setTextColor() {
        moneyField.setForeground(textColor);
        nameField.setForeground(textColor);
        dateField.setForeground(textColor);
    }

    private void setLableColor() {
        date.setForeground(lableColor);
        money.setForeground(lableColor);
        itemName.setForeground(lableColor);
        cateField.setForeground(lableColor);
    }

    private void setLable() {
        setBasicItem();
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 5;
    }

    private void setBasicItem() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 1;
        add(itemName, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridy = 2;
        add(date, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        add(money, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        add(cateField, gc);
    }

    private void setBasicField() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 1;
        gc.gridy = 1;
        add(nameField, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        add(time, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        add(moneyField, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        add(category, gc);

    }

    private void setEverything() {
        setLable();
        setBasicField();
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.weighty = 10;
        gc.gridx = 1;
        gc.gridy = 5;
        add(addNewItem, gc);
    }

    private void setListener() {
        addNewItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Item output = null;
                output = processItem();
                if (!(output == null)) {
                    fireAddItemEvent(new DetailEvent(this, output));
                }
            }
        });
        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cate = (String) category.getSelectedItem();
                updateCate(cate);
            }
        });
    }

    private void updateCate(String cate) {
        itemCate = cate;
    }

    private Item processItem() {
        String name = nameField.getText();
        String date = parseDate();
        double money = Double.parseDouble(moneyField.getText());
        if (money < 0) {
            dealMoney();
        } else {
            newItem = new DailyAddedItem(date, name, money);
            newItem.toPayMethod(itemCate);
            try {
                itemList = new ItemList();
                itemList.getData("savedFile.txt");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return newItem;
    }

    private String parseDate() {
        Date d = (Date) time.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        return date;
    }

    private void dealMoney() {
        JFrame error = new JFrame("Error");
        error.setSize(300, 200);
        JLabel errorlable = new JLabel("Negative money!!");
        errorlable.setForeground(new Color(233, 42, 30));
        errorlable.setFont(new Font("Roboto", Font.TRUETYPE_FONT, 24));
        error.add(errorlable,BorderLayout.CENTER);
        error.setVisible(true);
    }

    private void setDate() {
        SpinnerModel model;
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -100);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 200);
        Date latestDate = calendar.getTime();
        model = new SpinnerDateModel(initDate,
                earliestDate,
                latestDate,
                Calendar.YEAR);
        time = new JSpinner(model);
        time.setEditor(new JSpinner.DateEditor(time, "yyyy-MM-dd"));
    }

    private void fireAddItemEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == AddItemListener.class) {
                ((AddItemListener) listeners[i + 1]).addItemOccurred(event);
            }
        }
    }

    public void addDetailListener(AddItemListener listener) {
        this.listenerList.add(AddItemListener.class, listener);
    }

    public void removeListener(AddItemListener listener) {
        this.listenerList.remove(AddItemListener.class, listener);
    }
}
