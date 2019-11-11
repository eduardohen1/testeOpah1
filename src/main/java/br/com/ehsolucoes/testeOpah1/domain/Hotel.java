package br.com.ehsolucoes.testeOpah1.domain;

import java.util.List;

/**
 * Classe de controle dos dados do Hotel
 */
public class Hotel {

    private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    private List<Rooms> rooms;

    public Hotel(){}

    public Hotel(Integer id, String name, Integer cityCode, String cityName, List<Rooms> rooms) {
        this.id = id;
        this.name = name;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.rooms = rooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }
}
