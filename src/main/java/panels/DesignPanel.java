package panels;

import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W = 800, H = 600;
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
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
        }
        catch (NullPointerException e)
        {
            System.out.println("Null dynamic object!");
        }
    }
}
