package panels;

import reflect.ReflectUtils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseAdapter extends MouseAdapter {

    private JComponent comp;

    public CustomMouseAdapter(JComponent comp) {
        this.comp = comp;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("You pressed on my component!");

        Object[] args = ReflectUtils.getProps(comp);
        PropViewer.describeComponent(args);

    }
}
