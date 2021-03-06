package panels;

import main.MainFrame;
import reflect.ReflectUtils;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");
    private final JLabel errorLabel = new JLabel("");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        errorLabel.setVisible(false);
        add(classNameLabel);
        add(classNameField);
        add(textLabel);
        add(textField);
        add(createButton);
        createButton.addActionListener(e -> {
            JComponent comp = createDynamicComponent(classNameField.getText());
            setComponentText(comp, textField.getText());
            frame.designPanel.addAtRandomLocation(comp);
        });
    }

    private JComponent createDynamicComponent(String className) {
        Object object = null;
        try {
            object = ReflectUtils.getInstanceOf(className);
        } catch (Exception e) {
            if (!errorLabel.isVisible()) {
                errorLabel.setText("Can not create instance of " + className + " !");
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> errorLabel.setVisible(true));
            }
        }

        if (object == null) {
            try {
                Object loadedObj = ReflectUtils.getInstanceFromJar("/Users/cojocarudragos/PA/privateButton/target/privateButton-1.0-SNAPSHOT.jar", className);
                object = loadedObj;
            } catch (Exception e) {
                System.out.println("failed to load button from jar.");
                e.printStackTrace();
            }
        }

        return (JComponent) object;
    }

    private void setComponentText(JComponent comp, String text) {
        try
        {
            ReflectUtils.setTextOnComponent(comp, text);
        }
        catch (Exception e)
        {
            System.out.println("Failed to set default text.");
            e.printStackTrace();
        }
    }
}
