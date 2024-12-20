package hust.soict.dsai.aims.test;

import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

public class TestStoreScreen {
    public static void main(String[] args) {
        StoreTungNM store = new StoreTungNM();
        CartTungNM cart = new CartTungNM();

        MediaTungNM m1 = new DVDTungNM("Doraemon", "DVD", 20.99f, 15, "Fijio");
        MediaTungNM m2 = new BookTungNM(0, "Why we sleep", "Book", 9f);
        MediaTungNM m3 = new CompactDiscTungNM(1, "Gao ranger", "CD", 20f, 2, "TungNM");
        MediaTungNM m4 = new CompactDiscTungNM(1, "Conan", "CD", 15.99f, 10, "Khanh");

        store.addMediaTungNM(m1);
        store.addMediaTungNM(m2);
        store.addMediaTungNM(m3);
        store.addMediaTungNM(m4);

        StoreScreenTungNM storeScreen = new StoreScreenTungNM(store, cart);
        //CartScreenTungNM cartScreen = new CartScreenTungNM(cart);
        store.setCart(cart);

        storeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
