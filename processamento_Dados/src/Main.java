import java.util.Locale; // importar classe

public class Main {

	public static void main(String[] args) {
		
		int y = 19;
		double x = 10.35784;
		System.out.println(y);
		
		System.out.println(x);
		System.out.printf("%.2f%n", x); // Padrão de mascará de formatação de pontos flutuantes
		
		Locale.setDefault(Locale.US); // Trocar o local padrão
		System.out.printf("%.4f%n", x);
		
		System.out.printf("Resultado = %.2f metros%n", x); // Concatenar elementos no mesmo comando de linha
		
		System.out.println("Bom dia!");
		
		String nome = "Maria";
		int idade = 31;
		double renda = 4000.0;
		System.out.printf("%s tem %d anos e ganha R$%.2f reias%n", nome, idade, renda);
		/* 
		 *  %d -> int
		 *  %s -> String
		 *  %f -> float / double
		 *  %c -> char
		 *  %n -> quebra de linha
		 */

	}

}
