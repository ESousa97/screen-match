package com.screenmatch.exercicios;

import java.util.Scanner;

/**
 * Exercício de leitura de dados do console com Scanner.
 */
public class Leitura {

    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Leitura de Dados ===");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite sua altura (m): ");
        double altura = scanner.nextDouble();

        System.out.printf("%nDados informados:%n");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.printf("Altura: %.2f m%n", altura);

        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade.");
        }
    }
}
