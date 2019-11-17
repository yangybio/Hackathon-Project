package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private OutputPanel panel;


    public MainFrame(String name) {
        super(name);

        //set Layout
        setLayout(new BorderLayout());


        // Create Swing component
        JTextArea textArea = new JTextArea();
        panel = new OutputPanel();



        //add Swing component
        Container c = getContentPane();
        c.add(textArea, BorderLayout.EAST);
        c.add(panel,BorderLayout.WEST);

    }
}
