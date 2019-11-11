package br.com.ehsolucoes.testeOpah1.domain.dto;

public class PriceDetailsDTO {

    private Double pricePerDayAdult;
    private Double pricePerDayChild;

    public PriceDetailsDTO(){}

    public PriceDetailsDTO(Double pricePerDayAdult, Double pricePerDayChild) {
        this.pricePerDayAdult = pricePerDayAdult;
        this.pricePerDayChild = pricePerDayChild;
    }

    public Double getPricePerDayAdult() {
        return pricePerDayAdult;
    }

    public void setPricePerDayAdult(Double pricePerDayAdult) {
        this.pricePerDayAdult = pricePerDayAdult;
    }

    public Double getPricePerDayChild() {
        return pricePerDayChild;
    }

    public void setPricePerDayChild(Double pricePerDayChild) {
        this.pricePerDayChild = pricePerDayChild;
    }
}
