package entities;

public class Client {
    private String name;
    private int id;

    private ShoppingCart shoppingCart;

    public Client(String name, int id, ShoppingCart shoppingCart) {
        this.name = name;
        this.id = id;
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
