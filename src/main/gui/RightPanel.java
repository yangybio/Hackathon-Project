package gui;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    public RightPanel() {

        Dimension size = getPreferredSize();
        size.width = 500;
        this.setPreferredSize(size);

    }

    @Override
    protected void paintComponent(Graphics g) {
        String fileName = "/Users/apple/IdeaProjects/hackathon/chinaMap.png";
        ImageIcon newIcon = new ImageIcon(fileName);
        super.paintComponent(g);
        g.drawImage(newIcon.getImage(), 0, 0, null);
    }
}
