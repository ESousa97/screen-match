package com.screenmatch.exercicios;

/**
 * Exercício de loop for — iterações e padrões.
 */
public class LoopFor {

    public static void executar() {
        System.out.println("=== Exercício de Loop For ===");

        // Loop simples
        System.out.println("Números de 1 a 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("  " + i);
        }

        // Loop com passo
        System.out.println("\nMúltiplos de 3 (até 30):");
        for (int i = 3; i <= 30; i += 3) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Loop com array
        String[] filmes = {"Oppenheimer", "Barbie", "Avatar", "Top Gun", "John Wick"};
        System.out.println("\nFilmes:");
        for (int i = 0; i < filmes.length; i++) {
            System.out.printf("  [%d] %s%n", i + 1, filmes[i]);
        }

        // Enhanced for
        System.out.println("\nUsando enhanced for:");
        for (String filme : filmes) {
            System.out.println("  ★ " + filme);
        }
    }
}
