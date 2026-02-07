package com.screenmatch.exercicios;

/**
 * Exercício de condicionais básicas — if/else.
 */
public class Condicional {

    public static void executar() {
        System.out.println("=== Exercício de Condicionais ===");

        int ano = 2024;
        String filme = "Screen Match";
        double nota = 8.5;
        boolean incluidoNoPlano = true;

        System.out.println("Filme: " + filme);
        System.out.println("Ano: " + ano);

        if (ano >= 2020) {
            System.out.println("Filme recente (2020+).");
        } else {
            System.out.println("Filme lançado antes de 2020.");
        }

        if (nota >= 8.0) {
            System.out.println("Nota alta: " + nota);
        } else if (nota >= 5.0) {
            System.out.println("Nota média: " + nota);
        } else {
            System.out.println("Nota baixa: " + nota);
        }

        if (incluidoNoPlano) {
            System.out.println("Disponível no plano.");
        } else {
            System.out.println("Não disponível no plano.");
        }
    }
}
