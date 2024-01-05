package app;

import model.entities.Department;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "Tech");
        System.out.println(obj.toString());
    }
}