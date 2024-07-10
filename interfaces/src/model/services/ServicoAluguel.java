package model.services;

import model.entities.Aluguel;
import model.entities.Fatura;

import java.time.Duration;

public class ServicoAluguel {
    private Double precoHora;
    private Double precoDia;

    private TaxaServico taxaServico;

    public ServicoAluguel(Double precoHora, Double precoDia, TaxaServico taxaServico) {
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.taxaServico = taxaServico;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public Double getPrecoDia() {
        return precoDia;
    }

    public void processoFatura(Aluguel aluguel) {

        double minutos = Duration.between(aluguel.getSaida(), aluguel.getRetorno()).toMinutes();
        double horas = minutos / 60.0;

        double pagamentoBasico;
        if(horas <= 12) {
            pagamentoBasico = precoHora * Math.ceil(horas);
        }
        else {
            pagamentoBasico = precoDia * Math.ceil(horas / 24);
        }

        double taxa = taxaServico.taxa(pagamentoBasico);

        aluguel.setFatura(new Fatura(pagamentoBasico, taxa));
    }
}
