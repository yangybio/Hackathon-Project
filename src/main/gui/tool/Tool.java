package gui.tool;

import gui.FunctionPanel;
import model.ItemList;
import model.exception.MoneyException;


import javax.swing.*;
import java.io.IOException;
import java.util.EventObject;

public abstract class Tool {
    protected JButton button;
    protected ItemList list;

    public Tool(JComponent parent) {
        list = new ItemList();
        createButton(parent);
        addToParent(parent);
        addListener();
    }

    protected abstract void createButton(JComponent parent);

    // EFFECTS: adds a listener for this tool
    protected abstract void addListener();

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public void addToParent(JComponent parent) {
        parent.add(button);
    }

}

