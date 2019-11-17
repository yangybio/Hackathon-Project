package gui;

import gui.tool.*;
import model.exception.MoneyException;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FunctionPanel extends JPanel {
    private List<Tool> tools;
    private EventListenerList listenerList = new EventListenerList();

    public FunctionPanel() throws IOException, MoneyException {
        Dimension size = getPreferredSize();
        size.width = 400;
        setPreferredSize(size);
        tools = new ArrayList<>();

        AddItemFunction panel = new AddItemFunction();
        setLayout(new BorderLayout());
        this.add(panel);
        JPanel function = new JPanel();
        function.setLayout(new GridLayout(0, 1));
        function.setSize(new Dimension(0, 0));
        function.setBorder(BorderFactory.createTitledBorder("Other Function!"));
        initialTools(function);
        this.add(function, BorderLayout.SOUTH);
    }

    public void initialTools(JPanel p) throws IOException, MoneyException {
        Tool tool1 = new OverviewTool(p);
        Tool tool2 = new ImportTool(p);
        Tool tool3 = new ClearTool(p);
        tools.add(tool1);
        tools.add(tool2);
        tools.add(tool3);
    }
}

