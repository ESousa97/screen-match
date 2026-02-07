package com.screenmatch.exercicios;

/**
 * Exercício de switch — modernizado com switch expressions (Java 14+).
 */
public class DiaDaSemana {

    public static void executar() {
        System.out.println("=== Dia da Semana ===");

        int dia = 4;
        String nomeDia = switch (dia) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> "Dia inválido";
        };

        System.out.printf("Dia %d = %s%n", dia, nomeDia);

        // Demonstração com múltiplos valores
        String tipoDia = switch (dia) {
            case 1, 7 -> "Final de semana";
            case 2, 3, 4, 5, 6 -> "Dia útil";
            default -> "Inválido";
        };

        System.out.println("Tipo: " + tipoDia);
    }
}
