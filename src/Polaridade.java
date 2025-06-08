// 1. Crie um programa que solicite ao usuário digitar um número. Se o número for positivo, exiba "Número positivo", caso contrário, exiba "Número negativo".

import java.util.Scanner;

public class Polaridade {
    public static void main(String[] args) {
        Scanner numeroDigita = new Scanner(System.in);
        boolean positivo = true;
        boolean negativo = false;

        for (int i = 0; i < 1;) {
            System.out.println("Digite um numero: ");
            int numero = numeroDigita.nextInt();

            if (numero >= 1) {
                System.out.println("Número positivo!");
                positivo = true;
                break;
            } else if (numero <= -1) {
                System.out.println("Número negativo!");
                negativo = true;
                break;
            } else {
                System.out.println("Número zero!");
            }
        }

        numeroDigita.close();

    }
}
