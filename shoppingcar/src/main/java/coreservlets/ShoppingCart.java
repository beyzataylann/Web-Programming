package coreservlets;
import java.util.*;

/** A shopping cart data structure used to track orders.
* The OrderPage servlet associates one of these carts
* with each user session.
*/
import javax.servlet.annotation.WebServlet;

@WebServlet("/ShoppingCart")
public class ShoppingCart {
    private List<ItemOrder> itemsOrdered;

    public ShoppingCart() {
        itemsOrdered = new ArrayList<>();
    }

    /** Returns List of ItemOrder entries giving
    * Item and number ordered. Declared as List instead
    * of ArrayList so that underlying implementation
    * can be changed later.
    */
    public List<ItemOrder> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addItem(String itemID) {
        for (ItemOrder order : itemsOrdered) {
            if (order.getItemID().equals(itemID)) {
                order.incrementNumItems();
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
        itemsOrdered.add(newOrder);
    }

    /** Looks through cart to find order entry corresponding
    * to item ID listed. If the designated number
    * is positive, sets it. If designated number is 0
    * (or, negative due to a user input error), deletes
    * item from cart.
    */
    public void setNumOrdered(String itemID, int numOrdered) {
        for (ItemOrder order : itemsOrdered) {
            if (order.getItemID().equals(itemID)) {
                if (numOrdered <= 0) {
                    itemsOrdered.remove(order);
                } else {
                    order.setNumItems(numOrdered);
                }
                return;
            }
        }
        if (numOrdered > 0) {
            ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
            newOrder.setNumItems(numOrdered);
            itemsOrdered.add(newOrder);
        }
    }
}
