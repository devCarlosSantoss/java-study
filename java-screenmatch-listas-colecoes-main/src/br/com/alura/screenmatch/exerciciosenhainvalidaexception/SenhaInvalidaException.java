package br.com.alura.screenmatch.exerciciosenhainvalidaexception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(String message) {
        super(message);
    }
}
