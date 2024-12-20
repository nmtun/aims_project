package hust.soict.dsai.aims.test;

import javax.swing.*;

import hust.soict.dsai.aims.cart.CartScreenTungNM;
import hust.soict.dsai.aims.media.*;

public class TestCartScreen {
    public static void main(String[] args) {
        CartTungNM cart = new CartTungNM();

        //MediaTungNM m1 = new DVDTungNM("Doraemon", "Anime", "Fujio",15,  15f);
        MediaTungNM m1 = new DVDTungNM("Doraemon", "Anime", 15f);
        MediaTungNM m2 = new BookTungNM(0, "Why we sleep", "Scientific", 9f);
        MediaTungNM m3 = new CompactDiscTungNM(1, "Gao ranger", "Super sentai", 20f, 2, "TungNM");
        MediaTungNM m4 = new DiscTungNM(1, "Conan", "Anime", 50f, 10, "Khanh");

        cart.addMediaTungNM(m1);
        cart.addMediaTungNM(m2);
        cart.addMediaTungNM(m3);
        cart.addMediaTungNM(m4);

        CartScreenTungNM cartScreen = new CartScreenTungNM(cart);

        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
