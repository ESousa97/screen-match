import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu treino favorito: ");
        String treino1 = leitura.nextLine();

        System.out.println(treino1 + "? legal! Quantas séries você faz?: ");
        int serie = leitura.nextInt();

        System.out.println(serie + "? com essa quatidade de série você faz quantas repetições? ");
        double repeticao = leitura.nextDouble();

        System.out.println(repeticao);
        System.out.println(serie);
        System.out.println(treino1);
    }
}
