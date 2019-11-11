package br.com.ehsolucoes.testeOpah1.services;

import br.com.ehsolucoes.testeOpah1.domain.Hotel;
import org.json.JSONArray;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Service;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

@Service
public class HotelService {

    public Hotel GetHotelCity(Integer cityCode) throws IOException {
        Hotel hotel = new Hotel();
        JSONObject json = readJsonFromUrl("https://cvcbackendhotel.herokuapp.com/hotels/avail/" + cityCode);
        //fazer o parse
        return hotel;
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        String jsonText = "";
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            jsonText = jsonText.replace("[", "").replace("]", "");
            JSONObject json = new JSONObject(jsonText);
            return json;
        }catch (JSONException ex) {
            System.out.println("Erro 1: " + jsonText + "\n" + ex.getMessage());
            return null;
        }catch (IOException ex){
            System.out.println("Erro 2: " + jsonText + "\n" + ex.getMessage());
            return  null;
        } finally {
            is.close();
        }
    }

    public String retornaTesteHotel(Integer cityCode) throws IOException {
        try {
            String url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/" + cityCode.toString();
            InputStream is = new URL(url).openStream();

            JSONObject json = readJsonFromUrl(url);
            String txtRooms = "";

            String id = (String) json.get("id");
            String name = (String) json.get("name");
            String cityCode2 = (String) json.get("cityCode");
            String cityName = (String) json.get("cityName");

            JSONArray jsonArray = (JSONArray) json.get("rooms");
            Iterator itens = jsonArray.iterator();
            Iterator<Map.Entry> quartos = null;
            while (itens.hasNext()) {
                quartos = ((Map) itens.next()).entrySet().iterator();
                while (quartos.hasNext()) {
                    Map.Entry camp = quartos.next();
                    if (!camp.getKey().toString().toUpperCase().equals("PRICE")) {
                        txtRooms += camp.getKey() + ": " + camp.getValue();
                    } else {

                    }
                }
            }
            return "";
        }catch (Exception ex){
            System.out.println("Erro 1: " + ex.getMessage());
            return "";
        }
    }

}
