package gui.tool;

import model.exception.MoneyException;
import ui.PresentSummary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OverviewTool extends Tool {
    private PresentSummary present;

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
                    present = new PresentSummary();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (MoneyException ex) {
                    ex.printStackTrace();
                }
                present.presentMoney();
            }
        });
    }
}
