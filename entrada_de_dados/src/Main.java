import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int x;
		String s1, s2, s3;
		
		x = sc.nextInt();
		//Quando usamos um comando de leitura diferente do nextLine(), fica um dependência
		// e é necessário colocar um nextLine() extra sozinho para consumir essa dependencia
		sc.nextLine();
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		
		System.out.println("Dados digitados: ");
		System.out.println(x);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		sc.close();

	}

}
