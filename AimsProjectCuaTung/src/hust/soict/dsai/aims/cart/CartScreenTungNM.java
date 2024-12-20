package hust.soict.dsai.aims.cart;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.CartTungNM;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreenTungNM extends JFrame{
    private CartTungNM cart;
    public CartScreenTungNM(CartTungNM cart) {
        super();
        this.cart = cart;
        setSize(1050, 768);

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/cart/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }            
        });
    }
}
