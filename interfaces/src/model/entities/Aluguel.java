package model.entities;

import java.time.LocalDateTime;

public class Aluguel {
    private LocalDateTime saida;
    private LocalDateTime retorno;

    private Carro carro;
    private Fatura fatura;

    private Aluguel() {

    }

    public Aluguel(LocalDateTime saida, LocalDateTime retorno, Carro carro) {
        this.saida = saida;
        this.retorno = retorno;
        this.carro = carro;
    }

    public Carro getCarro() {
        return carro;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public LocalDateTime getRetorno() {
        return retorno;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
