package gui;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new MainFrame("Expense Management - Chaoyu");
        frame.setSize(800,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
