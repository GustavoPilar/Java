package entities;

public final class Poupanca extends Conta{
	//final signigica que não pode ser herdada
	
	private Double taxaJuros;
	
	public Poupanca() {
		super();
	}

	public Poupanca(Integer numero, String titular, Double saldo, Double taxaJuros) {
		super(numero, titular, saldo);
		this.taxaJuros = taxaJuros;
	}

	public Double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public void atualizarSaldo() {
		saldo += saldo * taxaJuros;
	}

	//Sobreescrita de metodos
	@Override
	public final void saque(Double montante) {
		// final signinifica que não pode ser sobrescrita
		saldo -= montante;
	}
}
