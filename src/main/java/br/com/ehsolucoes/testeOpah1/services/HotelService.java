package br.com.ehsolucoes.testeOpah1.services;

import br.com.ehsolucoes.testeOpah1.domain.Hotel;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class HotelService {

    public List<Hotel> GetHotelCity(Integer cityCode) {
        try {
            Gson gson = new Gson();
            //montagem da URL de pesquisa
            String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/" + cityCode.toString();
            //rotina para ler o json do host e devolve-lo em string para parse
            String jSon = readUrl(url);
            //Rotina de parse do json recuperado e abastecido list de objeto para trabalho
            List<Hotel> hotels = Arrays.asList(gson.fromJson(jSon, (Type) Hotel[].class));
            return hotels;
        }catch (Exception ex){
            System.out.println("Erro em GetHotelCity em [HotelService]: " + ex.getMessage());
            return  null;
        }
    }

    /**
     * Rotina para leitura de url com result de Json
     * @param urlString url para leitura
     * @return retorna json capturado
     * @throws Exception
     */
    private static String readUrl(String urlString) throws Exception{
        BufferedReader reader = null;
        try{
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1)
                buffer.append(chars,0,read);
            return  buffer.toString();
        }finally {
            if(reader != null)
                reader.close();
        }
    }

    public String retornaTesteHotel(Integer cityCode) throws IOException {
        try {
            String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/" + cityCode.toString();
            String jSon = readUrl(url);
            Gson gson = new Gson();

            List<Hotel> hotels = Arrays.asList(gson.fromJson(jSon, (Type) Hotel[].class));

            String texte = hotels.get(0).getCityName();

            return "";
        }catch (Exception ex){
            System.out.println("Erro 1: " + ex.getMessage());
            return "";
        }
    }

}
