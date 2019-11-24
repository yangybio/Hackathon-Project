package gui;

import gui.tool.AddItemListener;
import gui.tool.DetailEvent;
import gui.tool.OverviewListener;
import model.exception.MoneyException;
import ui.ProcessMoney;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FunctionPanel extends JPanel {
    private JButton overviewBt;
    private JButton clearBt;
    private JButton importBt;
    private ProcessMoney process;
    public JPanel function;
    public EventListenerList listenerList = new EventListenerList();

    public FunctionPanel() throws IOException, MoneyException {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        setLayout(new BorderLayout());
        function = new JPanel();
        function.setLayout(new GridLayout(0, 1));
        function.setSize(new Dimension(0, 0));
        function.setBorder(BorderFactory.createTitledBorder("Other Function!"));
        initialTools(function);
        this.add(function, BorderLayout.SOUTH);
    }

    public void initialTools(JPanel p) {
        initialOverview();
        p.add(overviewBt);
        initialClear();
        p.add(clearBt);
    }

    private void initialOverview() {
        overviewBt = new JButton("Overview");
        overviewBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fireOverviewEvent(new DetailEvent(this));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initialClear() {
        clearBt = new JButton("Clear");
        clearBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    process = new ProcessMoney();
                    process.clear();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public void addDetailListener(OverviewListener listener) {
        this.listenerList.add(OverviewListener.class, listener);
    }

    public void fireOverviewEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == OverviewListener.class) {
                ((OverviewListener) listeners[i + 1]).overviewOccurred(event);
            }
        }
    }
}

