package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBuscas {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o filme: ");
        String busca = sc.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=cf6b8df4";
        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
//        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
            TituloOmdb meuTituloOmbd = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmbd);
//        try {
            Titulo meuTitulo = new Titulo(meuTituloOmbd);
            System.out.println(meuTitulo);
        }catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro do argumento de busca!");
        } catch (ErroDeConversaoDeAnoException e) {
            throw new RuntimeException(e);
        }
    }


}
