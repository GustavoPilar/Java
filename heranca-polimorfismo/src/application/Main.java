package application;

import entities.Conta;
import entities.ContaEmpresarial;
import entities.Poupanca;
import entities.Poupanca;

public class Main {

	public static void main(String[] args) {
		
		Conta c = new Conta(1001, "Gustavo", 0.00);
		ContaEmpresarial ce = new ContaEmpresarial(1002, "Patricia", 0.00, 500.0);
		
		// Na herança tratamos como "é um"
		// Uma Conta Empresárial ou uma Poupanca também é uma Conta
		
		// UPCASTING --> subclasse para superclasse
		Conta c1 = ce;
		Conta c2 = new ContaEmpresarial(1003, "Bob", 0.00, 200.0);
		Conta c3 = new Poupanca(1004, "Maria", 0.00, 0.01);
		
		// DOWNCASTING --> superclasse para subclasse
		Poupanca p1 = (Poupanca)c3;
		ContaEmpresarial ce1 = (ContaEmpresarial)c2;
		
		// Instanceof --> uma forma de vefiricar se o downcast foi feito correto
		// Por exemplo, uma Poupanca é uma Conta, mas não é uma ContaEmpresarial
		if(c3 instanceof ContaEmpresarial) {
			// se a variavel c3 for uma instance de ContaEmpresarial
			ContaEmpresarial ce2 = (ContaEmpresarial)c3;
			ce2.emprestimo(200.0);
			System.out.println("Emprestimo!");
		}
		
		if(c3 instanceof Poupanca) {
			// se a variavel c3 for uma instancia de Poupanca
			Poupanca p2 = (Poupanca)c3;
			p2.atualizarSaldo();
			System.out.println("Atualizado.");
		}
		
		
		// POLIMORFISMO --> Poli (muitos) Morfismo(forma)
		
		Conta c4 = new Conta(1010, "Celso", 1000.0);
		Conta c5 = new Poupanca(1015, "Douglas", 1000.0, 0.5);
		
		c4.saque(50.0);
		c5.saque(50.0);
		
		// Chamei a mesma operação  em variaveis do mesmo tipo
		// Mas tiveram comportamentos diferentes, conforme os objetos para os quais elas apontam
		
		System.out.println(c4.getSaldo()); // out: 945.00
		System.out.println(c5.getSaldo()); // out: 950.00
		

	}

}
