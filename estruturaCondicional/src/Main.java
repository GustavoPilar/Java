
public class Main {

	public static void main(String[] args) {
		
		//Estrutura condicional simples
		
		int horario = 9;
		
		if (horario < 12) {
			System.out.println("Bom dia!");
		}
		
		System.out.println("Olá! Tudo bem?");
		
		// Estrutura Condicional
		
		int num = 5;
		
		System.out.println("Número: " + num);
		if (num % 2 == 0) {
			System.out.println("Par.");
		} else {
			System.out.println("Ímpar");
		}
		
		// encadeamente de estruras condicionais 
		
		char sexo = 'F';
		int idade = 17;
		
		System.out.println("Idade: " + idade);
		if (idade > 18) {
			System.out.println("Acesso permitido");
			if(sexo == 'F') {
				System.out.println("Bem vinda!");
			} else {
				System.out.println("Bem vindo!");
			}
		} else {
			System.out.println("Acesso negado! Menor de idade.");
		}

		// Estrutura switch case
		
		int dia = 3;
		
		switch(dia) {
			case 1:
				System.out.println("Domingo");
				break;
			case 2:
				System.out.println("Segunda-Feira");
				break;
			case 3:
				System.out.println("Terça-Feira");
				break;
			case 4:
				System.out.println("Quarta-Feira");
				break;
			case 5:
				System.out.println("Quinta-Feira");
				break;
			case 6:
				System.out.println("Sexta-Feira");
				break;
			case 7:
				System.out.println("Sabádo");
				break;
			default:
				System.out.println("Valor inválido para dia de semana.");
				break;
		}
		
		// Expressão ternária
		
		double valor = 34.5;
		double desconto = (valor < 20.0) ? valor * 0.1 : valor * 0.05;
		System.out.printf("Desconto de R$%.2f%n", desconto);
	}

}
