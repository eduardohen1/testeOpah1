package br.com.ehsolucoes.testeOpah1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Classe de controle de quartos
 */
public class Rooms {
    private Integer roomID;
    private String categoryName;
    private Price price;
    public Rooms(){}

    public Rooms(Integer roomID, String categoryName, Price price) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.price = price;
    }

    @JsonProperty("roomID")
    public Integer getRoomID() {
        return roomID;
    }
    @JsonProperty("roomID")
    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }
    @JsonProperty("categoryName")
    public String getCategoryName() {
        return categoryName;
    }
    @JsonProperty("categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }
    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }
}
