package src.app;

import src.db.DB;
import src.db.DbException;

import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        insertSeller();
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

            st = conn.prepareStatement("USE coursejdbc");
            st.executeQuery();

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

}