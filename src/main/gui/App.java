package gui;

import model.exception.MoneyException;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, MoneyException {
        JFrame frame = new MainFrame("Expense Management - Chaoyu");
        frame.setSize(900,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
