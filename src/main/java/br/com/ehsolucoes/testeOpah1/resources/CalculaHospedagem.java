package br.com.ehsolucoes.testeOpah1.resources;

import br.com.ehsolucoes.testeOpah1.domain.dto.CotacaoDTO;
import br.com.ehsolucoes.testeOpah1.services.CalculaHospedagemService;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/calc_hospedagem")
public class CalculaHospedagem {

    private List<CotacaoDTO> cotacaoDTO;

    @Autowired
    private CalculaHospedagemService calculaHospedagemService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CotacaoDTO>> calculaHospedagem(
            @RequestParam(value = "citycode", defaultValue = "0") String cityCode,
            @RequestParam(value = "checkin", defaultValue = "") String checkin,
            @RequestParam(value = "checkout", defaultValue = "") String checkout,
            @RequestParam(value = "qteadulto", defaultValue = "0") String qteAdulto,
            @RequestParam(value = "qtecrianca", defaultValue = "0") String qteCrianca
    ) {
        Boolean dataValida;
        String msmErro = "";
        try {
            dataValida = true;
            if(!validarData(checkin)){
                dataValida = false;
                msmErro = "Data de checkIn inválida!";
            }

            if(!validarData(checkout)){
                dataValida = false;
                if(msmErro.trim().length() > 0) msmErro += "\n";
                msmErro += "Data de checkOut inválida";
            }
            if(dataValida) {
                //rotina de comparação de datas do framework JodaTime
                Days d = Days.daysBetween(new DateTime(new SimpleDateFormat("dd/MM/yyyy").parse(checkin)), new DateTime(new SimpleDateFormat("dd/MM/yyyy").parse(checkout)));
                Integer qteDias = d.getDays();
                if (qteDias < 0){
                    dataValida = false;
                    if(msmErro.trim().length() > 0) msmErro += "\n";
                    msmErro += "Data de checkIn menor que a data de checkOut";
                }
            }

            if(dataValida) {
                Date dtCheckin = null;
                Date dtCheckout = null;
                if (checkin.toString().trim().length() > 0)
                    dtCheckin = new SimpleDateFormat("dd/MM/yyyy").parse(checkin);
                if(checkout.toString().trim().length()>0)
                    dtCheckout = new SimpleDateFormat("dd/MM/yyyy").parse(checkout);

                cotacaoDTO = calculaHospedagemService.cotacao(
                        Integer.parseInt(cityCode),
                        dtCheckin,
                        dtCheckout,
                        Integer.parseInt(qteAdulto),
                        Integer.parseInt(qteCrianca)
                );
                //String response = jSon.toJson(cotacaoDTO);
                return ResponseEntity.ok()
                        .body(cotacaoDTO);
            }else{
                System.out.println("Erro(01) em calculaHospedagem em [CalculaHospedagem]: " + msmErro);
                return null;
            }
        }catch (Exception ex){
            System.out.println("Erro(02) em calculaHospedagem em [CalculaHospedagem]: " + ex.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/teste/{cityID}", method = RequestMethod.GET)
    public ResponseEntity<String> findHotel(@PathVariable Integer cityID) throws IOException {
        String teste = calculaHospedagemService.testeBuscaCidade(cityID);
        return ResponseEntity.ok().body(teste);
    }

    /**
     * Rotina para verificar se a data é valida
     * @param data data para verificação
     * @return retorna verdadeiro ou falso
     */
    private Boolean validarData(String data){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try{
            format.parse(data);
            return true;
        }catch (ParseException e){
            return false;
        }
    }

}
