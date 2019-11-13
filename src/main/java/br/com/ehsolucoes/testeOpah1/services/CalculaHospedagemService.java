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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalculaHospedagemService {

    @Autowired
    private HotelService hotelService;

    /**
     * Rotina para calcular a cotação de hospedagem pela qte de dias e qte de hospedes
     * @param cityCode código da cidade
     * @param checkin data de entrada
     * @param checkout data de saída
     * @param qteAdult qte de hóspedes adultos
     * @param qteChild qte de hóspedes crianças
     * @return retorna objeto CotacaoDTO preenchido para result
     */
    public List<CotacaoDTO> cotacao(
            Integer cityCode,
            Date checkin,
            Date checkout,
            Integer qteAdult,
            Integer qteChild
    ){
        Double totalPrice = 0.0;
        Double totalPriceAdult = 0.0;
        Double totalPriceChild = 0.0;
        Integer id = 0;
        Integer qteDias = 0;

        //rotina de comparação de datas do framework JodaTime
        Days d = Days.daysBetween(new DateTime(checkin), new DateTime(checkout));
        qteDias = d.getDays();
        List<CotacaoDTO> cotacaoDTOs = new ArrayList<>();
        try {
            List<Hotel> hotels = hotelService.GetHotelCity(cityCode);
            List<RoomsDTO> roomsDTOs;
            CotacaoDTO cotacao;
            RoomsDTO roomsDTO;
            PriceDetailsDTO priceDetailsDTO;
            for (Hotel hotel : hotels) {
                roomsDTOs = new ArrayList<>();
                cotacao = new CotacaoDTO();
                cotacao.setId(id);
                cotacao.setName(hotel.getCityName());

                for (Rooms room1 : hotel.getRooms()) {
                    roomsDTO = new RoomsDTO();
                    priceDetailsDTO = new PriceDetailsDTO();
                    roomsDTO.setRoomsId(room1.getRoomID());
                    roomsDTO.setCategoryName(room1.getCategoryName());
                    //Cálculo da hospedagem:
                    totalPriceAdult = room1.getPrice().getAdult() * qteDias * qteAdult;
                    totalPriceChild = room1.getPrice().getChild() * qteDias * qteChild;
                    totalPrice = calculaComissao(totalPriceAdult) + calculaComissao(totalPriceChild);
                    roomsDTO.setTotalPrice(totalPrice);
                    priceDetailsDTO.setPricePerDayAdult(room1.getPrice().getAdult());
                    priceDetailsDTO.setPricePerDayChild(room1.getPrice().getChild());
                    roomsDTO.setPriceDetailDTO(priceDetailsDTO);
                    roomsDTOs.add(roomsDTO);
                }
                cotacao.setRooms(roomsDTOs);
                cotacaoDTOs.add(cotacao);
                id++;
            }
            return cotacaoDTOs;
        }catch (Exception ex){
            System.out.println("Erro em cotacao em [CalculaHospedagemService]: " + ex.getMessage());
            return null;
        }
    }

    public String testeBuscaCidade(Integer cityCode) throws IOException {
        return hotelService.retornaTesteHotel(cityCode);
    }

    private Double calculaComissao(Double totalPrice) {
        return (totalPrice / .7);
    }

}
