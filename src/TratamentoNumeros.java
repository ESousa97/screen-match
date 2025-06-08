// 2. Peça ao usuário para inserir dois números inteiros. Compare os números e imprima uma mensagem indicando se são iguais, diferentes, o primeiro é maior ou o segundo é maior.

import java.util.Scanner;

public class TratamentoNumeros {
    public static void main(String[] args) {
        Scanner numerosDigitados = new Scanner(System.in);

        int numero1;
        int numero2;

        System.out.print("Digite o primeiro numero: ");
        numero1 = numerosDigitados.nextInt();
        System.out.print("Digite o segundo numero: ");
        numero2 = numerosDigitados.nextInt();

        // Comparação conforme pedido na questão
        if (numero1 == numero2) {
            System.out.println("Os números são iguais.");
        } else {
            System.out.println("Os números são diferentes.");

            if (numero1 > numero2) {
                System.out.println("O primeiro número (" + numero1 + ") é maior.");
            } else {
                System.out.println("O segundo número (" + numero2 + ") é maior.");
            }
        }

        numerosDigitados.close();
    }
}