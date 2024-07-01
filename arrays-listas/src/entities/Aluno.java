package entities;

import java.util.Arrays;

public class Aluno {
	private String name;
	private double[] notas = new double[3];
	
	public Aluno(String name, double[] notas) {
		super();
		this.name = name;
		this.notas = notas;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Aluno: " + name + "; Notas: " + Arrays.toString(notas) + ";";
	}
	
	
	
}
