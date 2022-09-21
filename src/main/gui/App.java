package gui;


import javax.swing.*;

public class App {
    public static void main(String[] args)  {
        JFrame frame = new TotalFrame("CORONAVIRUS HISTORICAL DATA !!");
        frame.setSize(900,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
