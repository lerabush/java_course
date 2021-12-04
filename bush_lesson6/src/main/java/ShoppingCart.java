import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Класс, реализующий корзину покупателя
 */
public class ShoppingCart implements Serializable {
    private final String cartId;
    private ArrayList<Item> items;
    private int itemCount;
    transient private double cartTotal;

    public ShoppingCart() {
        this.cartId = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.itemCount = 0;
        this.cartTotal = 0;
    }

    public void printCard() {
        System.out.println("Shopping cart, id= " + this.cartId + ", total sum: " + this.cartTotal);
        for (Item i : this.getItems()) {
            System.out.println(i.toString());
        }
    }

    public String getCartId() {
        return cartId;
    }


    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    void putItem(Item someItem) {
        items.add(someItem);
        itemCount++;
        cartTotal += someItem.getCost();
    }
}