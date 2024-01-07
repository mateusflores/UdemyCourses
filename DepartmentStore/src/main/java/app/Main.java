package app;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---- TEST 1: Seller findById ----");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n---- TEST 1: Seller findByDepartment ----");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj:list) {
            System.out.println(obj);
        }

        System.out.println("\n---- TEST 3: Seller findAll ----");
        List<Seller> listAll = sellerDao.findAll();

        for (Seller s : listAll) {
            System.out.println(s);
        }

        /*
        System.out.println("\n---- TEST 4: Insert Seller ----");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(1999,06,21), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted seller! New ID: " + newSeller.getId());
         */

        System.out.println("\n---- TEST 4: Seller Update");
        seller = sellerDao.findById(9);
        seller.setName("Mateus");
        sellerDao.update(seller);
    }
}