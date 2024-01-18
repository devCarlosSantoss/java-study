package br.com.alura.screenmatch.cep;


import br.com.alura.screenmatch.cep.entities.CepRequest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Locale;
import java.util.Scanner;

public class CepConsumer {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o cep: ");
        String cep = sc.nextLine();
        CepRequest cepRequest = new CepRequest();
        String jsonResponse = cepRequest.cepRequest(cep);

        String localidade = extrairLocalidadeDoJson(jsonResponse);
        System.out.println("Localidade: " + localidade);
    }

    private static String extrairLocalidadeDoJson(String jsonResponse) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonResponse).getAsJsonObject();

        // Supondo que a localidade esteja em um campo chamado "localidade"
        if (jsonObject.has("localidade")) {
            return jsonObject.get("localidade").getAsString();
        } else {
            return "Localidade não encontrada no JSON.";
        }
    }
}
