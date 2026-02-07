package com.screenmatch.util;

import java.util.Scanner;

/**
 * Utilitários para leitura segura de dados via console.
 */
public final class InputUtils {

    private InputUtils() {
        // classe utilitária – impede instanciação
    }

    /**
     * Lê um inteiro do console, repetindo até receber um valor válido.
     */
    public static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    /**
     * Lê um double do console, repetindo até receber um valor válido.
     */
    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String linha = scanner.nextLine().trim();
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número.");
            }
        }
    }

    /**
     * Pergunta S/N e retorna {@code true} para S.
     */
    public static boolean lerSimNao(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem + " (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("S")) {
                return true;
            }
            if (resposta.equals("N")) {
                return false;
            }
            System.out.println("Responda com S ou N.");
        }
    }

    /**
     * Lê uma opção numérica de menu (entre min e max, inclusive).
     */
    public static int lerOpcaoMenu(Scanner scanner, int min, int max) {
        while (true) {
            int opcao = lerInteiro(scanner, "Opção: ");
            if (opcao >= min && opcao <= max) {
                return opcao;
            }
            System.out.printf("Opção inválida. Escolha entre %d e %d.%n", min, max);
        }
    }

    /**
     * Lê uma opção numérica de menu (sem validação de faixa).
     */
    public static int lerOpcaoMenu(Scanner scanner) {
        return lerInteiro(scanner, "");
    }

    /**
     * Pergunta se o usuário deseja repetir a operação.
     */
    public static boolean desejaRepetir(Scanner scanner) {
        return lerSimNao(scanner, "Deseja realizar outra operação?");
    }
}
