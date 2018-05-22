package panels;


import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W = 800, H = 600;
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                Object obj = e.getSource();
                System.out.println(obj.toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void addAtRandomLocation(JComponent comp) {

        try {
            Random rand = new Random();
            int x = rand.nextInt(W - 1);
            int y = rand.nextInt(H - 1);
            int w = comp.getPreferredSize().width;
            int h = comp.getPreferredSize().height;
            comp.setBounds(x, y, w, h);
            comp.setToolTipText(comp.getClass().getName());
            this.add(comp);
            frame.repaint();
            frame.addObject(comp);
        }
        catch (NullPointerException e)
        {
            System.out.println("Null dynamic object!");
        }
    }

    public void addFixedComponent(JComponent comp) {
        this.add(comp);
        frame.repaint();
    }
}
