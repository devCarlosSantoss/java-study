package br.com.alura.screenmatch.exerciciodivisaoexception;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioDivisao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o numerador: ");
        int numerador = sc.nextInt();

        System.out.print("Informe o denominador: ");
        int denominador = sc.nextInt();

        try {
            int result = numerador / denominador;
            System.out.println("Resultado da divisão: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erro divisão por zero não permitida: " + e.getMessage());
        }
    }
}
