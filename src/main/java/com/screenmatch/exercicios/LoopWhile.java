package com.screenmatch.exercicios;

/**
 * Exercício de loop while e do-while.
 */
public class LoopWhile {

    public static void executar() {
        System.out.println("=== Exercício de Loop While ===");

        // While simples
        int contador = 1;
        System.out.println("While (1 a 5):");
        while (contador <= 5) {
            System.out.println("  Iteração: " + contador);
            contador++;
        }

        // Do-while
        int numero = 10;
        System.out.println("\nDo-while (contagem regressiva):");
        do {
            System.out.println("  " + numero);
            numero--;
        } while (numero > 0);

        System.out.println("  FIM!");

        // While com condição de saída
        System.out.println("\nPotências de 2 (até 1024):");
        int potencia = 1;
        while (potencia <= 1024) {
            System.out.print(potencia + " ");
            potencia *= 2;
        }
        System.out.println();
    }
}
