package br.com.alura.screenmatch.cep.entities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepRequest {
    public String cepRequest(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        String json = null;
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();


        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return json;
    }

}
