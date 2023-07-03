package entities;

import enumEntities.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        this.items.remove(orderItem);
    }

    public double total() {
        double total = 0;
        for (OrderItem o : items)
            total += o.subTotal();
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:" + "\n");
        sb.append("Order moment: ").append(sdf.format(this.moment)).append("\n");
        sb.append("Order status: ").append(this.status).append("\n");
        sb.append("Client: ").append(getClient().getName() + " ");
        sb.append("(" + sdfBirthDate.format(getClient().getBirthDate()) + ") ");
        sb.append("- " + getClient().getEmail() + "\n");
        sb.append("Order items:" + "\n");

        for (OrderItem o : items)
            sb.append(o.getProduct().getName()).append(", ")
                    .append("$")
                    .append(o.getProduct().getPrice())
                    .append(", ")
                    .append("Quantity: ")
                    .append(o.getQuantity())
                    .append(", ")
                    .append("Subtotal: ")
                    .append(o.subTotal())
                    .append("\n");

        sb.append("Total Price: $").append(this.total()).append("\n");
        return sb.toString();
    }
}
