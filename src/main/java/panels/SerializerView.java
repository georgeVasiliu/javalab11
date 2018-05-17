package panels;

import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SerializerView extends JPanel {
    private JButton loadBtn = new JButton("Load");
    private JButton storeBtn = new JButton("store");
    private MainFrame frame;

    public SerializerView(MainFrame frame) {
        this.frame = frame;
        init();
        triggerListeners();
    }

    private void init() {
        this.setLayout(new FlowLayout());
        this.add(loadBtn);
        this.add(storeBtn);
    }

    private void triggerListeners() {
        storeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.storeObjects();
            }
        });

        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.loadObjects();
            }
        });
    }

}
