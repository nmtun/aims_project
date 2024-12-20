package hust.soict.dsai.aims.store;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import hust.soict.dsai.aims.cart.CartScreenTungNM;
import hust.soict.dsai.aims.media.BookTungNM;
import hust.soict.dsai.aims.media.CartTungNM;
import hust.soict.dsai.aims.media.CompactDiscTungNM;
import hust.soict.dsai.aims.media.DVDTungNM;
import hust.soict.dsai.aims.media.MediaTungNM;
import hust.soict.dsai.aims.media.StoreTungNM;

public class StoreScreenTungNM extends JFrame {
    private StoreTungNM store;
    private CartTungNM cart;

    public StoreScreenTungNM(StoreTungNM store, CartTungNM cart) {
        this.store = store;
        this.cart = cart;

        // Cài đặt Container chính của JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Cài đặt các thuộc tính JFrame
        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Tạo phần phía trên (MenuBar + Header)
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Tạo thanh menu
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
    
        JMenu smUpdateStore = new JMenu("Update Store");
        
        // Add Book menu item
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> showAddBookDialog());
        
        // Add CD menu item
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> showAddCDDialog());
        
        // Add DVD menu item
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> showAddDVDDialog());
    
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
    
        menu.add(smUpdateStore);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
    
        return menuBar;
    }

    // Tạo tiêu đề và nút "View Cart" ở góc trên bên phải
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        // Tiêu đề của ứng dụng
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.BLUE);

        // Nút "View Cart"
        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(120, 50));
        cartButton.setMaximumSize(new Dimension(120, 50));

        // Xử lý sự kiện khi nhấn nút "View Cart"
        cartButton.addActionListener(e -> {
            new CartScreenTungNM(this.store.getCart());
        });

        // Thêm tiêu đề và nút "View Cart" vào header
        header.add(Box.createRigidArea(new Dimension(10, 0))); 
        header.add(title);
        header.add(Box.createHorizontalGlue()); 
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 0))); 

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
    
        ArrayList<MediaTungNM> mediaInStore = store.getItemsInStore();
        for (MediaTungNM media : mediaInStore) {
            MediaStoreTungNM cell = new MediaStoreTungNM(media, cart); // Truyền cả cart
            center.add(cell);
        }

        return center;
    }

    private void showAddBookDialog() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Book",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                
                // Create and add new Book
                BookTungNM newBook = new BookTungNM(id, title, category, cost);
                store.addMediaTungNM(newBook);
                
                // Refresh the store display
                refreshStoreDisplay();
                
                JOptionPane.showMessageDialog(this, "Book added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID and Cost",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddCDDialog() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField directorField = new JTextField();
        
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add CD",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                int length = Integer.parseInt(lengthField.getText());
                String director = directorField.getText();
                
                // Create and add new CD
                CompactDiscTungNM newCD = new CompactDiscTungNM(id, title, category, cost, length, director);
                store.addMediaTungNM(newCD);
                
                // Refresh the store display
                refreshStoreDisplay();
                
                JOptionPane.showMessageDialog(this, "CD added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID, Cost, and Length",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddDVDDialog() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField directorField = new JTextField();
        
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Add DVD",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                int length = Integer.parseInt(lengthField.getText());
                String director = directorField.getText();
                
                // Create and add new DVD
                DVDTungNM newDVD = new DVDTungNM(title, category, cost, length, director);
                store.addMediaTungNM(newDVD);
                
                // Refresh the store display
                refreshStoreDisplay();
                
                JOptionPane.showMessageDialog(this, "DVD added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Cost and Length",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void refreshStoreDisplay() {
        // Remove the current center panel
        Container cp = getContentPane();
        cp.remove((JPanel)cp.getComponent(1));
        
        // Add the new center panel with updated store items
        cp.add(createCenter(), BorderLayout.CENTER);
        
        // Revalidate and repaint the frame
        revalidate();
        repaint();
    }
}
