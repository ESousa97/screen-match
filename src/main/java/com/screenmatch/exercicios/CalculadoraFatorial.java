package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Calcula o fatorial de um número inteiro — exercício de loops.
 */
public class CalculadoraFatorial {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculadora de Fatorial ===");
        System.out.print("Digite um número inteiro não-negativo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("Fatorial não é definido para números negativos.");
            return;
        }

        long fatorial = 1;
        for (int i = 2; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.printf("O fatorial de %d é %d%n", numero, fatorial);
    }
}
