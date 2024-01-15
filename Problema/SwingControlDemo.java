package Problema;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class SwingControlDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public SwingControlDemo() {
        prepareGUI();
    }//aaa
    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showTextFieldDemo();
        swingControlDemo.showCheckBoxDemo();
        swingControlDemo.showRadioButtonDemo();
        swingControlDemo.showColorChooserDemo();
        swingControlDemo.showSpinnerDemo();
        swingControlDemo.showComboboxDemo();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(1, 5));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showTextFieldDemo() {
        headerLabel.setText("Control in action: JTextField");
        JLabel namelabel = new JLabel("Name: ", JLabel.RIGHT);
        final JTextField userText = new JTextField(6);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Username " + userText.getText();
                statusLabel.setText(data);
            }
        });
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.add(namelabel);
        textPanel.add(userText);
        controlPanel.add(textPanel);
    }
    private void showCheckBoxDemo() {
        headerLabel.setText("Control in action: CheckBox");
        final JCheckBox chkLabel = new JCheckBox();
        chkLabel.setMnemonic(KeyEvent.VK_C);
        chkLabel.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Label Checkbox: " +
                        (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        checkBoxPanel.add(new JLabel("Label: ")); // Add label before checkbox
        checkBoxPanel.add(chkLabel);
        controlPanel.add(checkBoxPanel);
        mainFrame.setVisible(true);
    }
    private void showRadioButtonDemo() {
        headerLabel.setText("Control in action: RadioButton");
        final JRadioButton radApple = new JRadioButton();
        final JRadioButton radMango = new JRadioButton();
        final JRadioButton radPeer = new JRadioButton();
        radApple.setMnemonic(KeyEvent.VK_C);
        radMango.setMnemonic(KeyEvent.VK_M);
        radPeer.setMnemonic(KeyEvent.VK_P);
        radApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("First RadioButton: "
                        + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        radMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Second RadioButton: "
                        + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        radPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Third RadioButton: "
                        + (e.getStateChange() == 1 ? "checked" : "unchecked"));
            }
        });
        JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        checkBoxPanel.add(new JLabel("Label: ")); // Add label before checkbox

        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radApple);
        group.add(radMango);
        group.add(radPeer);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioPanel.add(new JLabel("Label: "));
        radioPanel.add(radApple);
        radioPanel.add(radMango);
        radioPanel.add(radPeer);
        controlPanel.add(radioPanel);
        mainFrame.setVisible(true);
    }
    private void showColorChooserDemo(){
        headerLabel.setText("Control in action: JColorChooser");
        JButton chooseButton = new JButton("Choose Background");
        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = JColorChooser.showDialog(mainFrame,
                        "Choose background color", Color.white);
                if(backgroundColor != null){
                    controlPanel.setBackground(backgroundColor);
                    mainFrame.getContentPane().setBackground(backgroundColor);
                }
            }
        });
        controlPanel.add(chooseButton);
        mainFrame.setVisible(true);
    }
    private void showSpinnerDemo(){
        headerLabel.setText("Control in action: JSpinner");
        SpinnerModel spinnerModel = new SpinnerNumberModel(10, //initial value
                0, //min
                100, //max
                1);//step
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                statusLabel.setText("Value : " + ((JSpinner)e.getSource()).getValue());
            }
        });
        controlPanel.add(spinner);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton okButton = new JButton("OK");
        JButton submitButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Save");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    private void showComboboxDemo(){
        headerLabel.setText("Control in action: JComboBox");
        final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();

        fruitsName.addElement("Mere");
        fruitsName.addElement("Pere");
        fruitsName.addElement("Mango");
        fruitsName.addElement("Struguri");

        final JComboBox fruitCombo = new JComboBox(fruitsName);
        fruitCombo.setSelectedIndex(0);

        JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);
        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (fruitCombo.getSelectedIndex() != -1) {
                    data = "Fruits Selected: "
                            + fruitCombo.getItemAt
                            (fruitCombo.getSelectedIndex());
                }
                statusLabel.setText(data);
            }
        });
        controlPanel.add(fruitListScrollPane);
        controlPanel.add(showButton);
        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Save")) {
                statusLabel.setText("Saved Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}