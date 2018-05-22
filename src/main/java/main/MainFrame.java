package main;

import panels.ControlPanel;
import panels.DesignPanel;
import panels.PropViewer;
import panels.SerializerView;

import javax.swing.*;
import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public ControlPanel controlPanel;
    public DesignPanel designPanel;
    public SerializerView serializerView;
    public PropViewer propViewer;
    public String XML_FILE = "out.xml";

    public ArrayList<JComponent> objects = new ArrayList<>();

    public MainFrame() {
        super("Swing Designer");
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
        serializerView = new SerializerView(this);
        propViewer = new PropViewer(this);

        init();
    }


    public static void main(String[] args) {
        MainFrame m = new MainFrame();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(designPanel, BorderLayout.CENTER);
        getContentPane().add(serializerView, BorderLayout.SOUTH);
        getContentPane().add(propViewer, BorderLayout.EAST);
        pack();
        this.setVisible(true);
    }

    public void storeObjects() {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(XML_FILE)));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: While Creating or Opening the File " + XML_FILE);
        }

        encoder.writeObject(objects);

        encoder.close();
    }

    public void loadObjects() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new FileInputStream(XML_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<JComponent> newObjects = (ArrayList<JComponent>) decoder.readObject();

        objects = newObjects;
        for (JComponent o : objects) {
            designPanel.addFixedComponent(o);
        }
    }


    public void addObject(JComponent comp) {
        objects.add(comp);
    }

}
