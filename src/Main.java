
public class Main {
    public static void main(String[] args) {

        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento:" + anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;
        // Expressões matemáticas no Java seguem a precedência de operadores.
        // Média calculada pelas 3 notas.
        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println("Media: " + media);

        String sinopse;
        sinopse = "Filme de aventura dos anos 80";
        System.out.println("Sinopse: " + sinopse);
        /* comentando blocos */
        // Text Blocks
        String sinopseNoPlano = """
                Filme Top Gun
                Filme de aventura dos anos 80
                Muito bom!
                Ano de lançamento:
                """ + anoDeLancamento;
        System.out.println("Sinopse: " + sinopseNoPlano);

        // Metodo Formatted
        String nome = "Maria";
        int idade = 30;
        double valor = 55.9999;
        System.out.println(String.format("Meu nome é %s, eu tenho %d anos e hoje gastei %.2f reais", nome, idade, valor));

        // Metodo Formatted com Text Block
        String nome2 = "João";
        int aulas = 4;

        String mensagem = """
                  Olá, %s!
                  Boas vindas ao curso de Java.
                  Teremos %d aulas para te mostrar o que é preciso para você dar o seu primeiro mergulho na linguagem!
                  """.formatted(nome2, aulas);
        System.out.println(mensagem);

        // Java possui palavras reservadas que não podem ser utilizadas fora de suas atribuições.
        // Casting (Conversão de Tipos)
        int classificacao = (int) (media /2);
        System.out.println(classificacao);

        // Casting implícito
        int x1 = 10;
        double y1 = x1; // casting implícito

        // Casting explícito
        double x2 = 10.5;
        int y2 = (int) x2; // casting explícito

        // Concatenação de String e inteiros
        String saudacao = "Olá, meu nome é ";
        String nome3 = "Alice ";
        String continuacao = "e minha idade é ";
        int idade3 = 17;
        System.out.println(saudacao + nome3 + continuacao + idade3);
    }
}