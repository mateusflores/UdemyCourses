package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;

import java.sql.Connection;
import java.util.Date;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
