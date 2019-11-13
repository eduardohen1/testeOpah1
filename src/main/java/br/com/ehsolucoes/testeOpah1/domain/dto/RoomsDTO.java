package br.com.ehsolucoes.testeOpah1.domain.dto;

import br.com.ehsolucoes.testeOpah1.domain.Price;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("roomID")
    public Integer getRoomsId() {
        return roomsId;
    }
    @JsonProperty("roomID")
    public void setRoomsId(Integer roomsId) {
        this.roomsId = roomsId;
    }
    @JsonProperty("categoryName")
    public String getCategoryName() {
        return categoryName;
    }
    @JsonProperty("categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @JsonProperty("totalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }
    @JsonProperty("totalPrice")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    @JsonProperty("priceDetail")
    public PriceDetailsDTO getPriceDetailDTO() {
        return priceDetailDTO;
    }
    @JsonProperty("priceDetail")
    public void setPriceDetailDTO(PriceDetailsDTO priceDetailDTO) {
        this.priceDetailDTO = priceDetailDTO;
    }
}
