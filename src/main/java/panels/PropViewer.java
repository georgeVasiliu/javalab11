package panels;


import main.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class PropViewer extends JPanel {
    MainFrame frame;
    JTable table;
    Object[] dummy = {"Object", "X", "Y", "Property"};

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

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Object");
        model.addColumn("X");
        model.addColumn("Y");
        model.addColumn("Property");


        model.addRow(dummy);


    }

    public void emptyTable() {
        try {
            table.removeAll();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(dummy);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Nothing to clean in table.");
        }
    }

    public void describeComponent(Object[] desc) {
        try {
            Object[] props = {desc[0], desc[1], desc[2], desc[3]};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(props);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Need 4 arguments for table insert");
            e.printStackTrace();
        }


    }

    public void addEntry(JComponent component) {
        JTable table = new JTable();

    }
}
