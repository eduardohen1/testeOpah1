package br.com.ehsolucoes.testeOpah1.domain.dto;

public class CotacaoDTO {

    private Integer id;
    private String name;
    private RoomsDTO rooms;

    public CotacaoDTO(){}

    public CotacaoDTO(Integer id, String name, RoomsDTO rooms) {
        this.id = id;
        this.name = name;
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

    public RoomsDTO getRooms() {
        return rooms;
    }

    public void setRooms(RoomsDTO rooms) {
        this.rooms = rooms;
    }
}
