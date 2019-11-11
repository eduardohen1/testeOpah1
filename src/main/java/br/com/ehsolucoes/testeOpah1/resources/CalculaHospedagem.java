package br.com.ehsolucoes.testeOpah1.resources;

import br.com.ehsolucoes.testeOpah1.domain.dto.CotacaoDTO;
import br.com.ehsolucoes.testeOpah1.domain.dto.HospedagemDTO;
import br.com.ehsolucoes.testeOpah1.services.CalculaHospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.Date;

@RestController
@RequestMapping(value = "/calc_hospedagem")
public class CalculaHospedagem {

    private CotacaoDTO cotacaoDTO;

    @Autowired
    private CalculaHospedagemService calculaHospedagemService;

    public ResponseEntity<HospedagemDTO> calculaHospedagem(
            @RequestParam(value = "citycode", defaultValue = "0") String cityCode,
            @RequestParam(value = "checkin", defaultValue = "") String checkin,
            @RequestParam(value = "checkout", defaultValue = "") String checkout,
            @RequestParam(value = "qteadulto", defaultValue = "0") String qteAdulto,
            @RequestParam(value = "qtecrianca", defaultValue = "0") String qteCrianca
    ) throws IOException {
        Date dtCheckin = null;
        Date dtCheckout = null;

        cotacaoDTO = calculaHospedagemService.cotacao(
                Integer.parseInt(cityCode),
                dtCheckin,
                dtCheckout,
                Integer.parseInt(qteAdulto),
                Integer.parseInt(qteCrianca)
        );
        return null;/*
        return ResponseEntity.ok()
                .body(cotacaoDTO);*/
    }

    @RequestMapping(value = "/teste/{cityID}", method = RequestMethod.GET)
    public ResponseEntity<String> findHotel(@PathVariable Integer cityID) throws IOException {
        String teste = calculaHospedagemService.testeBuscaCidade(cityID);
        return ResponseEntity.ok().body(teste);
    }

}
