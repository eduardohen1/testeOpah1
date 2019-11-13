package br.com.ehsolucoes.testeOpah1.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CotacaoDTO {

    private Integer id;
    private String name;
    private List<RoomsDTO> rooms;

    public CotacaoDTO(){}

    public CotacaoDTO(Integer id, String name, List<RoomsDTO> rooms) {
        this.id = id;
        this.name = name;
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
    @JsonProperty("cityName")
    public String getName() {
        return name;
    }
    @JsonProperty("cityName")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("rooms")
    public List<RoomsDTO> getRooms() {
        return rooms;
    }
    @JsonProperty("rooms")
    public void setRooms(List<RoomsDTO> rooms) {
        this.rooms = rooms;
    }
}
