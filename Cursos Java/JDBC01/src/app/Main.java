package src.app;

import src.db.DB;
import src.db.DbException;
import src.db.DbIntegrityException;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        trasaction();
    }

    private static void selectDepartments() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();
            st.executeQuery("use coursejdbc");

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException sqle) {
            throw new DbException(sqle.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void insertSeller() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            useDatabase(conn);

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4);

            // Returns an Integer representing the number of rows affected
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();

        }
    }

    private static void updataSalary() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            useDatabase(conn);

            ps = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ?"
                    + "WHERE "
                    + "(DepartmentId = ?)"
            );
            ps.setDouble(1, 200.00);
            ps.setInt(2, 2);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }

    private static void deleteSeller() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DB.getConnection();
            useDatabase(conn);

            ps = conn.prepareStatement("DELETE FROM department "
                    + "WHERE "
                    + "Id = ?"
            );

            ps.setInt(1, 5);

            int rowsAffected = ps.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }

    }

    private static void trasaction() {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            useDatabase(conn);

            // Alterações no banco de dados não são realizadas automaticamente quando == false
            conn.setAutoCommit(false);

            st = conn.createStatement();
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void useDatabase(Connection conn) {
        try {
            PreparedStatement st = conn.prepareStatement("USE coursejdbc");
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}