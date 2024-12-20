package hust.soict.dsai.aims.numGrid;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGridTungNM extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGridTungNM() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(false); 
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(5, 5)); 
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid - Nguyen Manh Tung 20225682");
        setSize(300, 400); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGridTungNM();
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            btnNumbers[i].setFont(new Font("Arial", Font.BOLD, 20));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].setFont(new Font("Arial", Font.BOLD, 20));
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        btnReset.setFont(new Font("Arial", Font.BOLD, 20));
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                String displayStr = tfDisplay.getText();
                if (displayStr.length() > 0) {
                    tfDisplay.setText(displayStr.substring(0, displayStr.length() - 1));
                }
            } else if (button.equals("C")) {
                tfDisplay.setText("");
            }
        }
    }
}
