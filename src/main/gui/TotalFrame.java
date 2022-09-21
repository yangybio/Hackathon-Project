package gui;

import gui.tool.GetResultListener;
import gui.tool.DetailEvent;
import gui.tool.OverviewListener;
import gui.tool.UpperLeftPanel;

import javax.swing.*;
import java.awt.*;


public class TotalFrame extends JFrame {
    private String result;
    private JPanel leftPanel;
    private TextPanel textPanel;
    private RightPanel rightPanel;
    private Font lableFont = new Font("Roboto", Font.PLAIN, 14);


    public TotalFrame(String name) {
        super(name);

        //set Layout
        setLayout(new BorderLayout());


        // Create Swing component
        leftPanel = new JPanel();
        UpperLeftPanel itemPanel = new UpperLeftPanel();
        textPanel = new TextPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weighty = 2;
        gc.gridx = 0;
        gc.gridy = 1;
        leftPanel.add(itemPanel, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        leftPanel.add(textPanel, gc);


//right panel
        rightPanel = new RightPanel();



        itemPanel.addDetailListener(new GetResultListener() {
            @Override
            public void getResult(DetailEvent event) {
                result = event.getData();
                textPanel.text.setText("");
                textPanel.text.append(result);
            }
        });



//        importBt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        deleteBt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });

        //add Swing component
        Container c = getContentPane();
        c.add(rightPanel, BorderLayout.EAST);
        c.add(leftPanel, BorderLayout.WEST);
    }
}
