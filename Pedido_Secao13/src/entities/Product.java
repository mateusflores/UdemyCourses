package entities;

public class Product {
    private String name;
    private double Price;

    public Product(String name, double price) {
        this.name = name;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
