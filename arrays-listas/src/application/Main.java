package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Aluno;
import util.CalculadoraMedia;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//criação do vetor
		double[] notas = new double[3];
		
		
		for(int i = 0; i < notas.length; i++) {
			System.out.print("Nota " + (i + 1) + ": ");
			// percorre os indices do vetor e atribui o que o usuário digitar
			notas[i] = sc.nextDouble();
		}
		
		Aluno aluno = new Aluno("Gustavo", notas);
		
		System.out.println(aluno);
		
		// Laço for each
		for (double nota : notas) {
			System.out.println(nota);
		}
		System.out.printf("Média das notas: %.2f%n", CalculadoraMedia.media(aluno.getNotas()));
		
		System.out.println("---------------");
		
		// Criação de uma lista
		List<String> list = new ArrayList<>();
		
		list.add("Maria"); // adiciona um elemento na lista na última posição
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");
		list.add(2, "Marco"); // adiciona um elemento na lista no indice indicado - 1
		
		System.out.println(list.size()); // mostra o tamanho da lista
		
		list.remove("Anna"); // remove quem estiver no argumento. pode ser um indice também
		
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("---------------");
		
		list.removeIf(x -> x.charAt(0) == 'M'); // remover usando um predicado (lambda)
		
		for (String x : list) {
			System.out.println(x);
		}

		System.out.println("---------------");
		System.out.println("Index of Bob: " + list.indexOf("Bob")); // retorna o indice de quem está no argumento
		System.out.println("Index of Marco: " + list.indexOf("Marco")); // retorna valor -1 quando não encontrado
		
		System.out.println("---------------");
		
		// deixar apenas quem começa com a letra A
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
		// criar uma outra lista que recebe a lista original
		// stream é um tipo especial do java 8 para frente que permite expressões lambda
		// a partir da stream, chamamos o filter para passar a expressão lambda para que queremos filtrar
		// o list não é compatível com lista, então temos que chamar a função collect
		// nos parametros do collect, colocamos Collector.toList() para retornar uma lista para nós
		
		for (String x : result) {
			System.out.println(x);
		}
		
		System.out.println("---------------");
		// Pegar em uma string através de uma função lambda o primeiro nome com A da lista
		String nome = list.stream().filter(x -> x.charAt(0) == 'B').findFirst().orElse(null);
		// findFirst para encontrar o primeiro
		// orElse para retornar null se não existir
		
		System.out.println(nome);
		
		sc.close();
	}

}
