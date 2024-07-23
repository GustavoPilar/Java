package application;

import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Department dp = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDate.now(), 3000.0, dp);
        System.out.println(seller);
    }
}
