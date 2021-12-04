import java.io.Serializable;

/**
 * Элемент в корзине ShoppingCart
 */
public class Item implements Serializable {
    private Long id;
    private String description;
    private double cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Item(Long id, String description, double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item[id: " + id + ", cost: " + cost + ", desc: " + description + " ]";
    }
}