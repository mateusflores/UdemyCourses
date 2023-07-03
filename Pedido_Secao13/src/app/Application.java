package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enumEntities.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Application {
    public static void main(String args[]) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Client c1 = new Client("Mateus Flores", "mateusgf.42@gmail.com", sdf.parse("21/06/1999"));
        Product p1 = new Product("RTX4070", 5000.00);
        Product p2 = new Product("Ryzen 7", 3500.00);
        Product p3 = new Product("SSD 512 Gb", 400.00);

        Order order = new Order(new Date(), OrderStatus.SHIPPED, c1);
        order.addOrderItem(new OrderItem(1, p1));
        order.addOrderItem(new OrderItem(1, p2));
        order.addOrderItem(new OrderItem(2, p3));


        System.out.println(order.toString());
    }
}
