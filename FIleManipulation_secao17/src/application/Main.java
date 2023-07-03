package application;

import model.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String strPath = "/home/mateusflores/Documents/in.csv";
        List<Product> products = new ArrayList<>();
        String[] info = new String[3];

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                info = line.split(",");
                products.add(new Product(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String outPath = "/home/mateusflores/Documents/out/";
        boolean b = new File(outPath).mkdir();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath + "out.csv"))) {
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}