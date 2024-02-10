package entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private Double totalPrice;

    public ShoppingCart() {
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void includeToCart(Item item) {
        boolean exists = false;
        for (Item i : items) {
            if (!items.isEmpty() && (i.getProduct().getId() == item.getProduct().getId())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                exists = true;
            }
        }

        if (!exists)
            items.add(item);
    }

    public void removeFromCart(Item item) {
        items.remove(item);
    }

    public void totalToPay() {
        this.setTotalPrice(0.0);
        for (Item i : items) {
            this.totalPrice += (i.getQuantity() * i.getProduct().getPrice());
        }
        System.out.println("Total: " + String.format("%.2f", this.totalPrice));
    }

    public void showItems() {
        System.out.println("List of products added to cart");
        System.out.println("NAME    |   QUANT   |   PRICE   |");
        for (Item i : items) {
            System.out.printf("%s   |   %d  |   %s  |\n", i.getProduct().getName(), i.getQuantity(), String.format("%.2f", i.getProduct().getPrice()));
        }
    }
}
