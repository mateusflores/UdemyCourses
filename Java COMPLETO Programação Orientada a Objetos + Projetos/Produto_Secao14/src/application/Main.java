package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scn = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int quantityProducts = scn.nextInt();

        for (int i = 0; i < quantityProducts; i++) {
            System.out.printf("Product #%d data:\n", i+1);
            System.out.print("Common, used or imported? (c/u/i): ");
            char ch = scn.next().charAt(0);
            scn.nextLine();
            System.out.print("Name: ");
            String name = scn.nextLine();
            System.out.print("Price: ");
            Double price = scn.nextDouble();

            if (ch == 'u') {
                scn.nextLine();
                System.out.print("Manufacture date (dd/MM/yyyy): ");
                String date = scn.nextLine();
                products.add(new UsedProduct(name, price, sdf.parse(date)));
            } else if (ch == 'i') {
                System.out.print("Custom fee: ");
                Double fee = scn.nextDouble();
                products.add(new ImportedProduct(name, price, fee));
            } else {
                products.add(new Product(name, price));
            }
        }
        scn.close();

        System.out.println("\nPRICE TAGS: ");
        for (Product p : products) {
            System.out.print(p.priceTag());
        }
    }
}