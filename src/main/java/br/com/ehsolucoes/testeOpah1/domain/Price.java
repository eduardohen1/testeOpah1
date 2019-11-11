package br.com.ehsolucoes.testeOpah1.domain;

/**
 * Classe para controle dos tipos de preços dos quartos.
 * [Type] Adulto/Criança
 * [value] Valor de hospedagem
 */
public class Price {
    private String type;
    private Double value;
    public Price(){}

    public Price(String type, Double value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
