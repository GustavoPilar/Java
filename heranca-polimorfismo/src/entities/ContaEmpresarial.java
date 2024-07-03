package entities;

public final class ContaEmpresarial extends Conta{

	private Double limiteEmprestimo;
	
	public ContaEmpresarial() {
		super();
	}

	public ContaEmpresarial(Integer numero, String titular, Double saldo, Double limiteEmprestimo) {
		super(numero, titular, saldo);
		this.limiteEmprestimo = limiteEmprestimo;
	}

	//Getters e Setters
	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	//Metodos
	public void emprestimo(double montante) {
		if(montante <= limiteEmprestimo) {
			saldo += montante - 10.0;
		}
	}
	
	@Override
	public final void saque(Double montante) {
		super.saque(montante);
		saldo -= 2.0;
	}
	
}
