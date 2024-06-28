import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		// Estrutura while
		
		byte x = 0;
		while(x < 5) {
			System.out.print(x + " ");
			x++;
		}
		
		System.out.println();
		
		
		// estrutura for
		for(int i = 0; i < 5; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// Estrutura do-while
		
		Random aleatorio = new Random();
		int n = aleatorio.nextInt(25);
		
		do {
			System.out.println(n);
			n = aleatorio.nextInt(50);
		} while(n <= 40);

	}

}
