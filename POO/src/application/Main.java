package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;


public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
		System.out.print("Quantity: ");
		int quantity = sc.nextInt();
		
		// Instanciando um objeto do tipo da classe criada
		Product product = new Product(name, price, quantity);
		
		// Chamando o toString da classe
		System.out.println(product);
		
		System.out.print("Enter the number of products to be added in stock: ");
		int updatedData = sc.nextInt();
		// Método de adicionar no estoque
		product.addQuantity(updatedData);		
		System.out.println(product);
		
		System.out.print("Enter the number of products to be removed from stock: ");
		updatedData = sc.nextInt();
		// Método de remover do estoque
		product.removeQuantity(updatedData);		
		System.out.println(product);
		
		sc.close();
		

	}

}
