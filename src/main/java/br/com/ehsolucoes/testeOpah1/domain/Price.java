package br.com.ehsolucoes.testeOpah1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe para controle dos tipos de preços dos quartos.
 * [Type] Adulto/Criança
 * [value] Valor de hospedagem
 */
public class Price {
    private double adult;
    private double child;

    public Price(){}

    public Price(double adult, double child) {
        this.adult = adult;
        this.child = child;
    }
    @JsonProperty("adult")
    public double getAdult() {
        return adult;
    }
    @JsonProperty("adult")
    public void setAdult(double adult) {
        this.adult = adult;
    }
    @JsonProperty("child")
    public double getChild() {
        return child;
    }
    @JsonProperty("child")
    public void setChild(double child) {
        this.child = child;
    }
}
