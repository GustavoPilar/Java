package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
		
		// Membros estáticos não precisam da instânciação do objeto
		// Basta você chamar ele através da classe e usá-lo
		// Um exemplo bastante comum é a classe Math
		double c = Calculator.circumference(radius);
		double v = Calculator.volume(radius);
		
		System.out.printf("Circumference: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI value: %.2f%n", Calculator.PI);
		
		
		sc.close();
	}
		

}
