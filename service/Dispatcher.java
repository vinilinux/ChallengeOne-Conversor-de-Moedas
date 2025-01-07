package service;

import com.google.gson.Gson;
import dto.Moeda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static constantes.DispatcherParams.*;

public class Dispatcher {

    public Moeda sendRequest(String moeda){

        String uri = URL + KEY + VERSION + moeda.toUpperCase();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return converterFromJson(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Moeda converterFromJson(String response) {
        Gson gson = new Gson();

        return gson.fromJson(response, Moeda.class);
    }

}
