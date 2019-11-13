package br.com.ehsolucoes.testeOpah1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonPropertyOrder("cityCode")
    public Integer getCityCode() {
        return cityCode;
    }
    @JsonPropertyOrder("cityCode")
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }
    @JsonPropertyOrder("cityName")
    public String getCityName() {
        return cityName;
    }
    @JsonPropertyOrder("cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    @JsonPropertyOrder("rooms")
    public List<Rooms> getRooms() {
        return rooms;
    }
    @JsonPropertyOrder("rooms")
    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }
}
