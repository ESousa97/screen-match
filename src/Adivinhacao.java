// DESAFIO AULA 3
//Agora é com você! Pratique os conceitos que foram ensinados ao longo dessa aula com o seguinte desafio:
//
//Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que o usuário tente adivinhar o número, em até 5 tentativas. A cada tentativa, o programa deve informar se o número digitado pelo usuário é maior ou menor do que o número gerado.

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        int adivinha = new Random().nextInt(100);
        Scanner numeroAdivinhacao = new Scanner(System.in);
        int tentativas = 5;
        boolean acertou = false;

        System.out.println("=== JOGO DE ADIVINHAÇÃO ===");
        System.out.println("Tente adivinhar o número de 0 a 99!");
        System.out.println("Você tem " + tentativas + " tentativas.\n");

        for (int i = 1; i <= tentativas; i++) {
            System.out.print("Tentativa " + i + "/" + tentativas + " - Digite um número: ");
            int numeroDigitado = numeroAdivinhacao.nextInt();

            if (numeroDigitado == adivinha) {
                System.out.println(" PARABÉNS! Você acertou o número " + adivinha + " na " + i + "ª tentativa!");
                acertou = true;
                break; // Sai do loop se acertou
            } else if (numeroDigitado < adivinha) {
                System.out.println(" Errou! O número é MAIOR que " + numeroDigitado);
            } else {
                System.out.println(" Errou! O número é MENOR que " + numeroDigitado);
            }

            // Mostra quantas tentativas restam (se não for a última)
            if (i < tentativas) {
                System.out.println("Restam " + (tentativas - i) + " tentativas.\n");
            }
        }

        // Se não acertou em nenhuma tentativa
        if (!acertou) {
            System.out.println("\n Suas tentativas acabaram! O número era: " + adivinha);
        }

        numeroAdivinhacao.close();
    }
}