package ar.unrn.observer.ejercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONObject;

public class WeatherChannelService implements ClimaOnline {
    public String temperatura() {
        ConfigConfiguracion config = new ConfigConfiguracion();
        String temp = config.obtenerUrlClima();
        try {
            URL url = new URL(temp);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                con.disconnect();

                JSONObject jsonCompleto = new JSONObject(response.toString());

                JSONObject mainNode = jsonCompleto.getJSONObject("main");
                double temperatura = mainNode.getDouble("temp");

                return "La temperatura actual en Viedma es: " + temperatura + "°C";
            } else {
                String mensajeServidor = con.getResponseMessage();
                return "Error de la API. Código HTTP: " + responseCode + " (" + mensajeServidor + ")";
            }
        } catch (Exception e) {
            return "Error al conectar con el servicio de clima: " + e.getMessage();
        }
    }


}