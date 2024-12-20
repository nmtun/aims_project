package hust.soict.dsai.aims.javaSwing;

import java.awt.*;  
import java.awt.event.*;  

public class AWTAccumulatorTungNM extends Frame{
    private TextField tfInput;   
    private TextField tfOutput;  
    private int sum = 0;         // Tổng tích lũy, khởi tạo bằng 0

    // Constructor để thiết lập GUI và các bộ xử lý sự kiện
    public AWTAccumulatorTungNM() {
        setLayout(new GridLayout(2, 2));  

        // Nhãn và ô nhập dữ liệu
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());  

        add(new Label("The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);  
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulatorTungNM();  
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
