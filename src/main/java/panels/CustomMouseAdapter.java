package panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseAdapter extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed on my component!");
    }
}
