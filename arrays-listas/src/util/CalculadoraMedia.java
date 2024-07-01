package util;

public class CalculadoraMedia {
	
	public static double media(double[] vect) {
		double soma = 0;
		for (int i = 0; i < vect.length; i++) {
			soma += vect[i];
		}
		return soma / vect.length;
	}
	
}
