package panels;

import main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class PropViewer extends JPanel {
    MainFrame frame;
    JTable table;

    public PropViewer(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout());
        initTable();
        this.add(table);
    }

    private void initTable() {
        String[] cols = {"Name", "X", "Y", "Option"};

        table = new JTable(2, 4);

    }

    public void addEntry(JComponent component) {
        JTable table = new JTable();

    }
}
