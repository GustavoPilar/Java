package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Connection (session) with a specific database. SQL statements are executed and results are returned within the context of a connection.
        Connection conn = null;

        //The object used for executing a static SQL statement and returning the results it produces.
        //https://docs.oracle.com/javase/8/docs/api/java/sql/Statement.html
        Statement st = null;

        //A table of data representing a database result set, which is usually generated by executing a statement that queries the database.
        //https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html
        ResultSet rs = null;

        //https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html
        //An object that represents a precompiled SQL statement.
        //A SQL statement is precompiled and stored in a PreparedStatement object. This object can then be used to efficiently execute this statement multiple times.
        PreparedStatement pst = null;

        try {
           conn = DB.getConnection();

           //RECUPERAR DADOS
           st = conn.createStatement(); // Creates a Statement object for sending SQL statements to the database.

           rs = st.executeQuery("select * from department"); // Executes the given SQL statement, which returns a single ResultSet object.

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

            //==========================================================================================================
            //INSERIR DADOS
            //Creates a PreparedStatement object for sending parameterized SQL statements to the database.
            pst = conn.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                            "VALUE " +
                            "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            System.out.print("Name: ");
            String name = sc.nextLine();
            pst.setString(1, name);
            System.out.print("Email: ");
            String email = sc.next();
            pst.setString(2, email);

            //Transforming date to long number
            System.out.print("BirthDate (dd/mm/yyyy): ");
            LocalDate date = LocalDate.parse(sc.next(), fmt);
            ZoneId zoneId = ZoneId.systemDefault();
            long longNumberDate = date.atStartOfDay(zoneId).toEpochSecond();
            //Sets the designated parameter to the given java.sql.Date value using the default time zone of the virtual machine that is running the application.
            //setDate(int parameterIndex, Date x)
            pst.setDate(3, new java.sql.Date(longNumberDate));

            System.out.print("Base Salary: ");
            sc.nextLine();
            double baseSalary = sc.nextDouble();
            pst.setDouble(4, baseSalary);
            System.out.print("Department (1 - 4): ");
            int department = sc.nextInt();
            pst.setInt(5, department);

            // Executes the SQL statement in this PreparedStatement object,
            // which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE;
            // or an SQL statement that returns nothing, such as a DDL statement.
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0) {
                rs = pst.getGeneratedKeys();
                while(rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }
            else {
                System.out.println("No row affected");
            }

            //ATUALIZAR DADOS
            pst = conn.prepareStatement("UPDATE seller " +
                                            "SET BaseSalary = BaseSalary + ? " +
                                            "WHERE " +
                                            "(DepartmentId = ?)");
            pst.setDouble(1, 300.0);
            pst.setInt(2, 2);

            rowAffected = pst.executeUpdate();
            System.out.println("Done! Rows affected: " + rowAffected);

            //EXCLUIR DADOS
            pst = conn.prepareStatement(
                    "DELETE FROM seller " +
                            "WHERE " +
                            "Name = ?");

            pst.setString(1, "Gustavo");

            rowAffected = pst.executeUpdate();
            System.out.println("Done! Rows affected: " + rowAffected);

            //TRANSAÇÃO DE DADOS
            st = conn.createStatement();

            conn.setAutoCommit(false);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090.0 WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090.0 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Rows 1: " + rows1);
            System.out.println("Rows 2: " + rows2);

        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Cause by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! " + e.getMessage());
            }
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeStatement(pst);
            DB.closeConnection();
        }

    }
}
