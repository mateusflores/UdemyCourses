package app;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "Tech");
        System.out.println(obj.toString());

        Seller seller = new Seller(21, "Bob", "Bob@gmail.com", new Date(), 3000.00, obj);
        System.out.println(seller.toString());
    }
}