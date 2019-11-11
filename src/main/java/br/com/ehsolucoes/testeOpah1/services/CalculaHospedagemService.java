package br.com.ehsolucoes.testeOpah1.services;

import br.com.ehsolucoes.testeOpah1.domain.Hotel;
import br.com.ehsolucoes.testeOpah1.domain.Price;
import br.com.ehsolucoes.testeOpah1.domain.Rooms;
import br.com.ehsolucoes.testeOpah1.domain.dto.CotacaoDTO;
import br.com.ehsolucoes.testeOpah1.domain.dto.PriceDetailsDTO;
import br.com.ehsolucoes.testeOpah1.domain.dto.RoomsDTO;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class CalculaHospedagemService {

    @Autowired
    private HotelService hotelService;

    private Double totalPriceAdult;
    private Double totalPriceChild;
    private Double totalPrice;
    private CotacaoDTO cotacaoDTO;
    private RoomsDTO roomsDTO;
    private PriceDetailsDTO priceDetailsDTO;
    private Integer qteDias;

    /**
     * Rotina para calcular a cotação de hospedagem pela qte de dias e qte de hospedes
     * @param cityCode código da cidade
     * @param checkin data de entrada
     * @param checkout data de saída
     * @param qteAdult qte de hóspedes adultos
     * @param qteChild qte de hóspedes crianças
     * @return retorna objeto CotacaoDTO preenchido para result
     */
    public CotacaoDTO cotacao(
            Integer cityCode,
            Date checkin,
            Date checkout,
            Integer qteAdult,
            Integer qteChild
    ){
        totalPrice = 0.0;
        totalPriceAdult = 0.0;
        totalPriceChild = 0.0;
        cotacaoDTO = new CotacaoDTO();
        roomsDTO = new RoomsDTO();
        priceDetailsDTO = new PriceDetailsDTO();

        //rotina de comparação de datas do framework JodaTime
        Days d = Days.daysBetween(new DateTime(checkin), new DateTime(checkout));
        qteDias = d.getDays();
        /*
        Hotel hotel  = hotelService.GetHotelCity(cityCode);
        if (hotel != null) {
            cotacaoDTO.setId(hotel.getId());
            cotacaoDTO.setName(hotel.getName());

            for(Rooms rooms : hotel.getRooms()){
                roomsDTO.setRoomsId(rooms.getRoomID());
                roomsDTO.setCategoryName(rooms.getCategoryName());
                for(Price price : rooms.getPrice()){
                    if(price.getType().toUpperCase().equals("ADULT")){
                        totalPriceAdult = (price.getValue() * qteDias);
                    }
                    if(price.getType().toUpperCase().equals("CHILD")){
                        totalPriceChild = (price.getValue() * qteDias);
                    }
                }
                if(totalPriceAdult > 0) totalPrice = calculaComissao (totalPriceAdult * qteAdult);
                if(totalPriceChild > 0) totalPrice = totalPrice + calculaComissao (totalPriceChild * qteChild);

                priceDetailsDTO.setPricePerDayAdult(totalPriceAdult);
                priceDetailsDTO.setPricePerDayChild(totalPriceChild);
                roomsDTO.setPriceDetailDTO(priceDetailsDTO);
                roomsDTO.setTotalPrice(totalPrice);
            }
            cotacaoDTO.setRooms(roomsDTO);
            return cotacaoDTO;
        } else return null;
         */
        return null;
    }

    public String testeBuscaCidade(Integer cityCode) throws IOException {
        return hotelService.retornaTesteHotel(cityCode);
    }

    private Double calculaComissao(Double totalPrice) {
        return (totalPrice / .7);
    }

}
