package hust.soict.dsai.aims.media;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartTungNM {
    public static final int MAX_NUMBERS_ORDERED = 20;
    //private List<MediaTungNM> itemsOrdered = new ArrayList<>();
    private ObservableList<MediaTungNM> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<MediaTungNM> getItemsOrdered() {
        return itemsOrdered;
    }

    //add item
	public boolean addMediaTungNM(MediaTungNM media) {
        if (media == null) {
            return false;
        }
        
        if(itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("Your cart is full");
            return false;
        } 
        
        if (itemsOrdered.contains(media)) {
            System.out.println("Item already exists in cart");
            return false;
        }
        
        itemsOrdered.add(media);
        System.out.println("Item has been added to your cart");
        return true;
    }

    //remove item 
    public boolean removeMediaTungNM(MediaTungNM media) {
        if(!itemsOrdered.contains(media)) {
            System.out.println("Item not found");
            return false;
        } else {
            itemsOrdered.remove(media);
            System.out.println("Item has been removed in your cart");
            return true;
        }
    }

    //caculate total price
    public float totalPrice() {
        float total = 0f;
        for(int i=0; i<itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    // print the list of ordered items of a cart
    public void printItemsInCartNMT() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i=0; i<itemsOrdered.size(); i++) {
            MediaTungNM media = itemsOrdered.get(i);
            System.out.printf("%d. Media %s - %s: %.2f$ \n",
                                    i+1, media.getTitle(), media.getCategory(), media.getCost() );
        }

        float totalCost = totalPrice();
        System.out.printf("Total price: %.2f $ \n", totalCost);
        System.out.println("***************************************************");
    }

    public MediaTungNM searchByIdNmt(int id) {
        for (MediaTungNM item : itemsOrdered) {
            if (item.getId() == id) {
                return item; // Trả về đối tượng nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
    
    public MediaTungNM searchByTitleNmt(String title) {
        for (MediaTungNM media : itemsOrdered) {
            if (media.isMatchNmt(title)) {
                return media; // Return the matching item
            }
        }
        System.out.println("No data is matching");
        return null; // Return null if no match is found
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, MediaTungNM.COMPARE_BY_COST_TITLE);
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, MediaTungNM.COMPARE_BY_TITLE_COST);
    }

    public void emptyCart() {
        itemsOrdered.clear();
    }

}
