package br.com.ehsolucoes.testeOpah1.domain;

import java.util.List;

/**
 * Classe de controle de quartos
 */
public class Rooms {
    private Integer roomID;
    private String categoryName;
    private List<Price> price;
    public Rooms(){}

    public Rooms(Integer roomID, String categoryName, List<Price> price) {
        this.roomID = roomID;
        this.categoryName = categoryName;
        this.price = price;
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }
}
