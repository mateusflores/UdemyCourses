package app;

import entities.Client;
import entities.Item;
import entities.Product;
import entities.ShoppingCart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(0, "Beans", 1.25, 0);
        Product p2 = new Product(1, "Potato", 2.50, 0);
        Product p3 = new Product(2, "Carrot", 3.25, 0);
        Product p4 = new Product(3, "Apple", 4.00, 0);

        ShoppingCart sc = new ShoppingCart();

        sc.includeToCart(new Item(p1, 2));
        sc.includeToCart(new Item(p1, 3));
        sc.includeToCart(new Item(p2, 5));
        sc.includeToCart(new Item(p3, 1));
        sc.includeToCart(new Item(p4, 3));

        Client c = new Client("Mateus", 1, sc);

        c.getShoppingCart().showItems();
        c.getShoppingCart().totalToPay();
    }
}