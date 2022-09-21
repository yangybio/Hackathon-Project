package gui.tool;


import gui.tool.dataRequire.APIHandler;
import gui.tool.dataRequire.OverallResult;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UpperLeftPanel extends JPanel {
    JLabel date;
    JButton meme;
    JLabel area;
    String itemCate;
    JTextField dateField;
    JComboBox areaField;
    JLabel cateField;
    JButton getInfo;
    JSpinner time;
    JComboBox category;
    private Font lableFont = new Font("Roboto", Font.TRUETYPE_FONT, 14);
    EventListenerList listenerList = new EventListenerList();

    public UpperLeftPanel() {
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Coronavirus Historical Data !!"));
        setDate();
        initial();
        itemCate = "";
        setLayout(new GridBagLayout());
        setEverything();
        setListener();
    }

    private void initial() {
        String[] categories = {"Confirmed Cases", "Suspected Cases", "Deaths", "Cured"};
        String[] areaCat = {"Overall","Wuhan","Northeast","Northwest","Southeast","Southwest"};
        date = new JLabel("Date: ");
        area = new JLabel("Area: ");
        meme = new JButton(new ImageIcon("/Users/apple/IdeaProjects/hackathon/corona.png"));
        cateField = new JLabel("Category: ");
        dateField = new JTextField(10);
        areaField = new JComboBox(areaCat);
        area.setFont(lableFont);
        date.setFont(lableFont);
        cateField.setFont(lableFont);
        getInfo = new JButton("Search for ...");
        getInfo.setForeground(new Color(233, 63, 51));
        getInfo.setFont(lableFont);
        category = new JComboBox(categories);
//        category.setEditable(true);
    }




    private void setLable() {
        setBasicItem();
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 4;
    }

    private void setBasicItem() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 1;
        add(date, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridy = 2;
        add(area, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        add(cateField, gc);
    }

    private void setBasicField() {
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 1;
        gc.gridy = 1;
        add(time, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        add(areaField, gc);
        gc.gridx = 1;
        gc.gridy = 3;
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
        add(getInfo, gc);
        gc.gridx = 2;
        gc.gridy = 5;
        add(meme,gc);
    }

    private void setListener() {
        getInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String askDate = parseDate();
                APIHandler API = new APIHandler();
                OverallResult overall = null;
                try {
                    overall = API.getOverallResult();
                } catch (IOException ex) {
                    ex.printStackTrace();
//                    todo robust
                }
                Date d1 = new Date();
                ArrayList<Date> a1 = null;

                try {
                    String cri = (String) category.getSelectedItem();
                    fireGetResultEvent(new DetailEvent(this, overall,cri,askDate));
                } catch (ParseException ex) {
                    ex.printStackTrace();
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
        meme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame memeFrame = new JFrame();
                JLabel memeLable = new JLabel(new ImageIcon("/Users/apple/IdeaProjects/hackathon/meme.jpg"));
                memeFrame.add(memeLable);
                memeFrame.setSize(1000,520);
                memeFrame.setVisible(true);
            }
        });
    }

    private void updateCate(String cate) {
        itemCate = cate;
    }


    private String parseDate() {
        Date d = (Date) time.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        return date;
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

    private void fireGetResultEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == GetResultListener.class) {
                ((GetResultListener) listeners[i + 1]).getResult(event);
            }
        }
    }

    public void addDetailListener(GetResultListener listener) {
        this.listenerList.add(GetResultListener.class, listener);
    }
}
