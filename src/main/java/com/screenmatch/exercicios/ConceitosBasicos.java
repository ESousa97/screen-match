package com.screenmatch.exercicios;

/**
 * Conceitos básicos de Java — variáveis, tipos, casting e operadores.
 */
public class ConceitosBasicos {

    public static void executar() {
        System.out.println("=== Conceitos Básicos de Java ===");

        // Variáveis e tipos
        String nomeFilme = "Screen Match";
        int anoLancamento = 2024;
        double nota = 8.7;
        boolean disponivel = true;

        System.out.println("Filme: " + nomeFilme);
        System.out.println("Ano: " + anoLancamento);
        System.out.println("Nota: " + nota);
        System.out.println("Disponível: " + disponivel);

        // Casting
        int notaInteira = (int) nota;
        System.out.println("Nota (int): " + notaInteira);

        double divisao = (double) anoLancamento / 100;
        System.out.printf("Divisão (double): %.2f%n", divisao);

        // Operadores aritméticos
        int soma = anoLancamento + 10;
        int subtracao = anoLancamento - 2000;
        double multiplicacao = nota * 2;

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.printf("Multiplicação: %.1f%n", multiplicacao);

        // Concatenação
        String descricao = nomeFilme + " (" + anoLancamento + ") - Nota: " + nota;
        System.out.println("Descrição: " + descricao);
    }
}
