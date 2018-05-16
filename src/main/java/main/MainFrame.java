package main;

import panels.ControlPanel;
import panels.DesignPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public ControlPanel controlPanel;
    public DesignPanel designPanel;

    public MainFrame() {
        super("Swing Designer");
        init();
    }

    public static void main(String[] args) {

    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(designPanel, BorderLayout.CENTER);
        pack();
    }

}
