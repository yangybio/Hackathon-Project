package gui.tool;

import model.exception.MoneyException;
import ui.PresentSummary;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OverviewTool extends Tool {
    private EventListenerList listenerList = new EventListenerList();
    public OverviewTool(JComponent parent) throws IOException, MoneyException {
        super(parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Overview");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ActionListener() {
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

    public void fireOverviewEvent(DetailEvent event) {
        Object[] listeners = listenerList.getListenerList();

        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == AddItemListener.class) {
                ((AddItemListener) listeners[i + 1]).addItemOccurred(event);
            }
        }
    }
}

