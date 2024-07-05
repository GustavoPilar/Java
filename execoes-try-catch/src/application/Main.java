package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		
		DateTimeFormatter  fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);
			
			Reservation r = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(r);
			
			System.out.println("\nEnter date to update the resavation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = LocalDate.parse(sc.nextLine(), fmt);
			
			r.updateDates(checkIn, checkOut);
			System.out.println(r);
		}
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format: " + e.getMessage());
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			// InputMismatchException é uma RuntimeException
			System.out.println("Unexpected error: ");
		}
			
		
		sc.close();
	
	}
}
