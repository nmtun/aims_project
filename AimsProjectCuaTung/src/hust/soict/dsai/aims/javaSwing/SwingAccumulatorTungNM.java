package hust.soict.dsai.aims.javaSwing;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class SwingAccumulatorTungNM extends JFrame{
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;       // Accumulated sum, init to 0

    // Constructor to setup the GUI components and event handlers
    public SwingAccumulatorTungNM() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulatorTungNM();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
