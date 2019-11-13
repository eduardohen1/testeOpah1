package br.com.ehsolucoes.testeOpah1.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceDetailsDTO {

    private Double pricePerDayAdult;
    private Double pricePerDayChild;

    public PriceDetailsDTO(){}

    public PriceDetailsDTO(Double pricePerDayAdult, Double pricePerDayChild) {
        this.pricePerDayAdult = pricePerDayAdult;
        this.pricePerDayChild = pricePerDayChild;
    }
    @JsonProperty("pricePerDayAdult")
    public Double getPricePerDayAdult() {
        return pricePerDayAdult;
    }
    @JsonProperty("pricePerDayAdult")
    public void setPricePerDayAdult(Double pricePerDayAdult) {
        this.pricePerDayAdult = pricePerDayAdult;
    }
    @JsonProperty("pricePerDayChild")
    public Double getPricePerDayChild() {
        return pricePerDayChild;
    }
    @JsonProperty("pricePerDayChild")
    public void setPricePerDayChild(Double pricePerDayChild) {
        this.pricePerDayChild = pricePerDayChild;
    }
}
