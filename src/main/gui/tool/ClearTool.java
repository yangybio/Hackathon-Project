package gui.tool;

import gui.FunctionPanel;
import model.ItemList;
import model.exception.MoneyException;
import ui.ProcessMoney;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClearTool extends Tool {
    private ProcessMoney process;

    public ClearTool(JComponent parent) throws IOException, MoneyException {
        super(parent);
        process = new ProcessMoney();
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Clear data");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    process.clear();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
