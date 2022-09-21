package gui;

import gui.tool.DetailEvent;
import gui.tool.GetResultListener;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JScrollPane {
    public JTextArea text = new JTextArea();

    public TextPanel() {
        this.setViewportView(text);
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 150;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Result:"));
    }

    public void addDetailListener(GetResultListener listener) {
        this.listenerList.add(GetResultListener.class, listener);
    }

    public String changeName() {
        return ("idf/ni kfjdkfjdkfjd/n "
                + "fdjk" + "/n" + "djfkdjfkdjf/n" + "/n"
                + "fjdk/nfjdkfjdkfjf/n" + "/n");
    }
}
