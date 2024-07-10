package application;

import model.entities.Aluguel;
import model.entities.Carro;
import model.services.ServicoAluguel;
import model.services.TaxaServicoBrasil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("-- Entre com os dados do aluguel --");
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ano (yyyy): ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.print("Retirada (dd/mm/yyyy HH:mm): ");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Retorno (dd/mm/yyyy HH:mm): ");
        LocalDateTime retorno = LocalDateTime.parse(sc.nextLine(), fmt);
        Aluguel aluguel = new Aluguel(retirada, retorno, new Carro(marca, modelo, ano));

        System.out.print("Valor por hora: R$");
        double precoHora = sc.nextDouble();
        sc.nextLine();
        System.out.print("Valor por dia: R$");
        double precoDia = sc.nextDouble();
        sc.nextLine();

        ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora, precoDia, new TaxaServicoBrasil());

        servicoAluguel.processoFatura(aluguel);

        System.out.println("Fatura:");
        System.out.printf("Pagamento basico: %.2f%n", aluguel.getFatura().getPagamentoBasico());
        System.out.printf("Imposto %.2f%n", aluguel.getFatura().getTaxa());
        System.out.printf("Pagamento total: %.2f%n", aluguel.getFatura().pagamentoTotal());

        sc.close();
    }
}
