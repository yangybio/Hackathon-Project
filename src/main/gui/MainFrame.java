package gui;

import gui.tool.OutputToText;
import model.exception.MoneyException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;

public class MainFrame extends JFrame {
    private FunctionPanel panel;


    public MainFrame(String name) throws IOException, MoneyException {
        super(name);

        //set Layout
        setLayout(new BorderLayout());

        // Create Swing component
        JTextArea textArea = new JTextArea(20,33);
        OutputToText out = new OutputToText(textArea);
        PrintStream printStream = new PrintStream(out);
        PrintStream standardOut = System.out;
        PrintStream standardErr = System.err;
        System.setOut(printStream);
        System.setErr(printStream);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output window!"));


        panel = new FunctionPanel();

        //add Swing component
        Container c = getContentPane();
        c.add(scrollPane, BorderLayout.EAST);
        c.add(panel,BorderLayout.WEST);
    }
}
