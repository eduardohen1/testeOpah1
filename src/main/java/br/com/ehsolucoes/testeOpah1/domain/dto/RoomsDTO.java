package br.com.ehsolucoes.testeOpah1.domain.dto;

import br.com.ehsolucoes.testeOpah1.domain.Price;

public class RoomsDTO {
    private Integer roomsId;
    private String categoryName;
    private Double totalPrice;
    private PriceDetailsDTO priceDetailDTO;

    public RoomsDTO(){}

    public RoomsDTO(Integer roomsId, String categoryName, Double totalPrice, PriceDetailsDTO priceDetailDTO) {
        this.roomsId = roomsId;
        this.categoryName = categoryName;
        this.totalPrice = totalPrice;
        this.priceDetailDTO = priceDetailDTO;
    }

    public Integer getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(Integer roomsId) {
        this.roomsId = roomsId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PriceDetailsDTO getPriceDetailDTO() {
        return priceDetailDTO;
    }

    public void setPriceDetailDTO(PriceDetailsDTO priceDetailDTO) {
        this.priceDetailDTO = priceDetailDTO;
    }
}
