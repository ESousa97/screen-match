import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;
        int totalDenotas = 0;

        while (nota != -1) {
            System.out.println("Digite sua avaliação para o filme ou -1 para encerrar o programa. ");
            nota = leitura.nextDouble();
            if (nota != -1) {
            mediaAvaliacao += nota;
            totalDenotas++;
            }
        }
        System.out.println("Média de avaliações: " + mediaAvaliacao / totalDenotas);
    }
}
