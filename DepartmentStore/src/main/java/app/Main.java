package app;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DepartmentDao dao = DaoFactory.createDepartmentDao();
        Department dep = new Department(null, "Pets");
        dao.insert(dep);
    }
}