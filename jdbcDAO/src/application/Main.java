package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment ===");
        List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 3: seller findByAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TEST 4: seller inster ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDate.now(), 4000.0, new Department(2, null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("=== TEST 5: seller seller update ===");
        seller = sellerDao.findById(14);
        seller.setName("Martha Mayane");
        seller.setEmail("martha@gmail.com");
        sellerDao.update(seller);
        System.out.println("Update complete");

        System.out.println("=== TEST 6: seller seller delete ===");
        System.out.print("Enter id: ");
        sellerDao.deleteById(sc.nextInt());
        sc.close();
        System.out.println("Delete complete");
    }
}
