package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Exercício de tabuada — gera a tabuada de um número.
 */
public class Tabuada {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tabuada ===");
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        System.out.printf("%nTabuada do %d:%n", numero);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %d%n", numero, i, numero * i);
        }
    }
}
