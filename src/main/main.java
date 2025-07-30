import java.util.*;
import java.time.LocalDateTime;

public class ScreenMatchInterativo {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Filme> filmes = new ArrayList<>();
    private static final Random random = new Random();

    /**
     * Classe interna que representa um filme com seus dados e avaliações.
     */
    static class Filme {
        String nome;
        int anoLancamento;
        double nota;
        String genero;
        boolean incluidoNoPlano;
        List<Double> avaliacoes;

        public Filme(String nome, int anoLancamento, String genero, boolean incluidoNoPlano) {
            this.nome = nome;
            this.anoLancamento = anoLancamento;
            this.genero = genero;
            this.incluidoNoPlano = incluidoNoPlano;
            this.avaliacoes = new ArrayList<>();
            this.nota = 0.0;
        }

        /**
         * Adiciona uma nova avaliação e recalcula a média.
         */
        public void adicionarAvaliacao(double avaliacao) {
            avaliacoes.add(avaliacao);
            calcularMediaAvaliacoes();
        }

        /**
         * Calcula a média das avaliações registradas.
         */
        private void calcularMediaAvaliacoes() {
            if (!avaliacoes.isEmpty()) {
                double soma = avaliacoes.stream().mapToDouble(Double::doubleValue).sum();
                this.nota = soma / avaliacoes.size();
            }
        }

        /**
         * Representação em texto do filme.
         */
        @Override
        public String toString() {
            return String.format("""
                    FILME: %s (%d)
                    NOTA: %.1f/10 (%d avaliações)
                    GÊNERO: %s
                    INCLUÍDO NO PLANO: %s
                    """, nome, anoLancamento, nota, avaliacoes.size(), genero,
                    incluidoNoPlano ? "Sim" : "Não");
        }
    }

    public static void main(String[] args) {
        inicializarFilmesExemplo();
        exibirBoasVindas();

        int opcao;
        do {
            opcao = exibirMenuPrincipal();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("\n=== Obrigado por usar o Screen Match! Até logo! ===");
        scanner.close();
    }

    /**
     * Inicializa filmes e avaliações iniciais para demonstração.
     */
    private static void inicializarFilmesExemplo() {
        filmes.add(new Filme("Top Gun: Maverick", 2022, "Ação", true));
        filmes.add(new Filme("Avatar: O Caminho da Água", 2022, "Ficção Científica", true));
        filmes.add(new Filme("John Wick 4", 2023, "Ação", false));
        filmes.add(new Filme("Oppenheimer", 2023, "Drama", true));
        filmes.add(new Filme("Barbie", 2023, "Comédia", false));

        filmes.get(0).adicionarAvaliacao(8.5);
        filmes.get(0).adicionarAvaliacao(9.0);
        filmes.get(1).adicionarAvaliacao(7.8);
        filmes.get(2).adicionarAvaliacao(8.9);
    }

    /**
     * Mostra mensagem inicial de boas-vindas.
     */
    private static void exibirBoasVindas() {
        System.out.println("===============================================");
        System.out.println("          SCREEN MATCH - SISTEMA INTERATIVO");
        System.out.println("===============================================");
        System.out.println("Bem-vindo ao melhor sistema de catálogo de filmes!");
        System.out.println("Aqui você pode gerenciar filmes, avaliações e muito mais.\n");
    }

    /**
     * Exibe o menu principal e lê opção do usuário com validação.
     *
     * @return opção numérica válida ou -1 se inválida
     */
    private static int exibirMenuPrincipal() {
        System.out.println("\n=================== MENU PRINCIPAL ===================");
        System.out.println("1. Gerenciar Filmes");
        System.out.println("2. Calculadora Interativa");
        System.out.println("3. Jogos");
        System.out.println("4. Utilitários");
        System.out.println("5. Relatórios");
        System.out.println("0. Sair");
        System.out.println("=====================================================");
        System.out.print("Escolha uma opção: ");

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Digite apenas números válidos!");
            return -1;
        }
    }

    /**
     * Direciona o fluxo de acordo com a opção escolhida.
     *
     * @param opcao opção selecionada
     */
    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> menuFilmes();
            case 2 -> menuCalculadora();
            case 3 -> menuJogos();
            case 4 -> menuUtilitarios();
            case 5 -> menuRelatorios();
            case 0 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("ERRO: Opção inválida! Tente novamente.");
        }
    }

    // =================== MENU FILMES ===================

    private static void menuFilmes() {
        int opcao;
        do {
            System.out.println("\n=============== GERENCIAMENTO DE FILMES ===============");
            System.out.println("1. Listar todos os filmes");
            System.out.println("2. Adicionar novo filme");
            System.out.println("3. Avaliar filme");
            System.out.println("4. Buscar filme por nome");
            System.out.println("5. Filtrar filmes por ano");
            System.out.println("6. Verificar disponibilidade no plano");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("==================================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> listarFilmes();
                    case 2 -> adicionarFilme();
                    case 3 -> avaliarFilme();
                    case 4 -> buscarFilme();
                    case 5 -> filtrarFilmesPorAno();
                    case 6 -> verificarDisponibilidade();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números válidos!");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado no sistema.");
            return;
        }

        System.out.println("\n========== CATÁLOGO DE FILMES ==========");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.printf("\n[%d] %s", i + 1, filmes.get(i));
        }
        System.out.println("=======================================");
    }

    private static void adicionarFilme() {
        System.out.println("\n========== ADICIONAR NOVO FILME ==========");

        System.out.print("Nome do filme: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.print("Nome não pode ser vazio. Digite o nome do filme: ");
            nome = scanner.nextLine().trim();
        }

        int ano = lerInteiroValido("Ano de lançamento: ", 1888, LocalDateTime.now().getYear());

        System.out.print("Gênero: ");
        String genero = scanner.nextLine().trim();
        while (genero.isEmpty()) {
            System.out.print("Gênero não pode ser vazio. Digite o gênero: ");
            genero = scanner.nextLine().trim();
        }

        System.out.print("Está incluído no plano? (s/n): ");
        boolean incluido = lerSimNao();

        filmes.add(new Filme(nome, ano, genero, incluido));
        System.out.println("\nFilme '" + nome + "' adicionado com sucesso!");
    }

    private static void avaliarFilme() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme disponível para avaliação.");
            return;
        }

        listarFilmes();
        int indice = lerInteiroValido("Escolha o número do filme para avaliar: ", 1, filmes.size()) - 1;

        double nota = lerDoubleValido("Digite sua nota (0.0 a 10.0): ", 0.0, 10.0);

        filmes.get(indice).adicionarAvaliacao(nota);
        System.out.println("Avaliação adicionada com sucesso!");
        System.out.printf("Nova média do filme: %.1f\n", filmes.get(indice).nota);
    }

    private static void buscarFilme() {
        System.out.print("Digite o nome do filme (ou parte dele): ");
        String termoBusca = scanner.nextLine().toLowerCase();

        System.out.println("\n========== RESULTADOS DA BUSCA ==========");
        boolean encontrou = false;

        for (Filme filme : filmes) {
            if (filme.nome.toLowerCase().contains(termoBusca)) {
                System.out.println(filme);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum filme encontrado com esse termo.");
        }
    }

    private static void filtrarFilmesPorAno() {
        int ano = lerInteiroValido("Digite o ano para filtrar: ", 1888, LocalDateTime.now().getYear());

        System.out.println("\n========== FILMES DE " + ano + " ==========");
        boolean encontrou = false;

        for (Filme filme : filmes) {
            if (filme.anoLancamento == ano) {
                System.out.println(filme);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum filme encontrado para o ano " + ano);
        }
    }

    private static void verificarDisponibilidade() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
            return;
        }

        listarFilmes();
        int indice = lerInteiroValido("Escolha o número do filme: ", 1, filmes.size()) - 1;

        Filme filme = filmes.get(indice);
        System.out.println("\n========== VERIFICAÇÃO DE DISPONIBILIDADE ==========");

        if (filme.anoLancamento >= 2022) {
            System.out.println("Categoria: Lançamento recente (" + filme.anoLancamento + ")");
        } else {
            System.out.println("Categoria: Filme retrô (" + filme.anoLancamento + ")");
        }

        if (filme.incluidoNoPlano) {
            System.out.println("Status: FILME LIBERADO!");
            System.out.println("Você pode assistir sem custo adicional.");
        } else {
            System.out.println("Status: DEVE PAGAR A LOCAÇÃO!");
            System.out.println("Este filme requer pagamento adicional.");
        }
    }

    // =================== MENU CALCULADORA ===================

    private static void menuCalculadora() {
        int opcao;
        do {
            System.out.println("\n============== CALCULADORA INTERATIVA ==============");
            System.out.println("1. Calculadora de áreas");
            System.out.println("2. Verificador de números (par/ímpar, positivo/negativo)");
            System.out.println("3. Comparador de números");
            System.out.println("4. Gerador de tabuada");
            System.out.println("5. Calculadora de fatorial");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("===============================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> calculadoraAreas();
                    case 2 -> verificadorNumeros();
                    case 3 -> comparadorNumeros();
                    case 4 -> geradorTabuada();
                    case 5 -> calculadoraFatorial();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números válidos!");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void calculadoraAreas() {
        String continuar;
        do {
            System.out.println("\n========== CALCULADORA DE ÁREAS ==========");
            System.out.println("1. Calcular área do quadrado");
            System.out.println("2. Calcular área do círculo");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiroValido("", 1, 2);

            switch (opcao) {
                case 1 -> {
                    double lado = lerDoubleValido("Digite o lado do quadrado: ", 0.00001, Double.MAX_VALUE);
                    double area = lado * lado;
                    System.out.printf("Área do quadrado: %.2f\n", area);
                }
                case 2 -> {
                    double raio = lerDoubleValido("Digite o raio do círculo: ", 0.00001, Double.MAX_VALUE);
                    double area = Math.PI * raio * raio;
                    System.out.printf("Área do círculo: %.2f\n", area);
                }
            }

            System.out.print("\nDeseja calcular outra área? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    private static void verificadorNumeros() {
        String continuar;
        do {
            System.out.println("\n========== VERIFICADOR DE NÚMEROS ==========");
            int numero = lerInteiroValido("Digite um número inteiro: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

            if (numero > 0) {
                System.out.println("Classificação: POSITIVO");
            } else if (numero < 0) {
                System.out.println("Classificação: NEGATIVO");
            } else {
                System.out.println("Classificação: ZERO");
            }

            if (numero % 2 == 0) {
                System.out.println("Paridade: PAR (divisível por 2)");
            } else {
                System.out.println("Paridade: ÍMPAR (não divisível por 2)");
            }

            System.out.printf("Resto da divisão por 2: %d\n", numero % 2);

            System.out.print("\nDeseja verificar outro número? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    private static void comparadorNumeros() {
        System.out.println("\n========== COMPARADOR DE NÚMEROS ==========");
        int num1 = lerInteiroValido("Digite o primeiro número: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int num2 = lerInteiroValido("Digite o segundo número: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("\n--- RESULTADO DA COMPARAÇÃO ---");

        if (num1 == num2) {
            System.out.println("Os números são IGUAIS.");
        } else {
            System.out.println("Os números são DIFERENTES.");
            if (num1 > num2) {
                System.out.printf("O primeiro número (%d) é MAIOR.\n", num1);
                System.out.printf("Diferença: %d\n", num1 - num2);
            } else {
                System.out.printf("O segundo número (%d) é MAIOR.\n", num2);
                System.out.printf("Diferença: %d\n", num2 - num1);
            }
        }
    }

    private static void geradorTabuada() {
        String continuar;
        do {
            System.out.println("\n========== GERADOR DE TABUADA ==========");
            int numero = lerInteiroValido("Digite um número para ver sua tabuada: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

            System.out.println("\n--- TABUADA DO " + numero + " ---");
            System.out.println("---------------------------");

            for (int i = 1; i <= 10; i++) {
                System.out.printf("%2d x %2d = %3d\n", numero, i, numero * i);
            }

            System.out.println("---------------------------");

            System.out.print("\nDeseja gerar outra tabuada? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    private static void calculadoraFatorial() {
        String continuar;
        do {
            System.out.println("\n========== CALCULADORA DE FATORIAL ==========");
            int numero = lerInteiroValido("Digite um número inteiro não negativo: ", 0, Integer.MAX_VALUE);

            long fatorial = 1L;

            System.out.println("\n--- CÁLCULO DO FATORIAL DE " + numero + " ---");

            if (numero == 0) {
                System.out.println("0! = 1 (por definição)");
            } else {
                System.out.print(numero + "! = ");
                for (int i = numero; i >= 1; i--) {
                    System.out.print(i);
                    if (i > 1) System.out.print(" x ");
                    fatorial *= i;
                }
                System.out.println();
            }

            System.out.println("Resultado: " + numero + "! = " + fatorial);

            if (numero > 20) {
                System.out.println("AVISO: Para números muito grandes, o resultado pode exceder o limite de armazenamento!");
            }

            System.out.print("\nDeseja calcular outro fatorial? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    // =================== MENU JOGOS ===================

    private static void menuJogos() {
        int opcao;
        do {
            System.out.println("\n================= ÁREA DE JOGOS =================");
            System.out.println("1. Jogo de Adivinhação");
            System.out.println("2. Quiz de Filmes");
            System.out.println("3. Contador Interativo");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("=============================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> jogoAdivinhacao();
                    case 2 -> quizFilmes();
                    case 3 -> contadorInterativo();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números válidos!");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void jogoAdivinhacao() {
        String jogarNovamente;
        do {
            int numeroSecreto = random.nextInt(100);
            int tentativas = 5;
            boolean acertou = false;

            System.out.println("\n========== JOGO DE ADIVINHAÇÃO ==========");
            System.out.println("Tente adivinhar o número de 0 a 99!");
            System.out.println("Você tem " + tentativas + " tentativas.\n");

            for (int i = 1; i <= tentativas; i++) {
                int numeroDigitado = lerInteiroValido(String.format("Tentativa %d/%d - Digite um número: ", i, tentativas),
                        0, 99);

                if (numeroDigitado == numeroSecreto) {
                    System.out.println("PARABÉNS! Você acertou o número " + numeroSecreto + " na " + i + "ª tentativa!");
                    acertou = true;
                    break;
                } else if (numeroDigitado < numeroSecreto) {
                    System.out.println("Errou! O número é MAIOR que " + numeroDigitado);
                } else {
                    System.out.println("Errou! O número é MENOR que " + numeroDigitado);
                }

                if (i < tentativas) {
                    System.out.println("Restam " + (tentativas - i) + " tentativas.\n");
                }
            }

            if (!acertou) {
                System.out.println("\nSuas tentativas acabaram! O número era: " + numeroSecreto);
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            jogarNovamente = scanner.nextLine().trim().toLowerCase();
        } while (jogarNovamente.equals("s") || jogarNovamente.equals("sim"));
    }

    private static void quizFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado para o quiz.");
            return;
        }

        System.out.println("\n========== QUIZ DE FILMES ==========");
        System.out.println("Vamos testar seus conhecimentos sobre os filmes cadastrados!");

        int pontuacao = 0;
        int totalPerguntas = Math.min(5, filmes.size());

        List<Filme> filmesDisponiveis = new ArrayList<>(filmes);
        Collections.shuffle(filmesDisponiveis);

        for (int i = 0; i < totalPerguntas; i++) {
            Filme filme = filmesDisponiveis.get(i);

            int resposta = lerInteiroValido(String.format("\nPergunta %d: Em que ano foi lançado '%s'?\nSua resposta: ", i + 1, filme.nome),
                    1800, LocalDateTime.now().getYear());

            if (resposta == filme.anoLancamento) {
                System.out.println("CORRETO! +1 ponto");
                pontuacao++;
            } else {
                System.out.println("ERRADO! O ano correto é: " + filme.anoLancamento);
            }
        }

        System.out.println("\n========== RESULTADO FINAL ==========");
        System.out.printf("Você acertou %d de %d perguntas!\n", pontuacao, totalPerguntas);

        double percentual = (double) pontuacao / totalPerguntas * 100;
        if (percentual >= 80) {
            System.out.println("EXCELENTE! Você é um expert em filmes!");
        } else if (percentual >= 60) {
            System.out.println("BOM TRABALHO! Você conhece bem os filmes!");
        } else if (percentual >= 40) {
            System.out.println("NÃO FOI MAL! Continue assistindo mais filmes!");
        } else {
            System.out.println("PRECISA MELHORAR! Que tal assistir mais filmes?");
        }
    }

    private static void contadorInterativo() {
        System.out.println("\n========== CONTADOR INTERATIVO ==========");
        int inicio = lerInteiroValido("Digite o número inicial: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int fim = lerInteiroValido("Digite o número final: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int incremento;

        while (true) {
            incremento = lerInteiroValido("Digite o incremento (diferente de zero): ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (incremento == 0) {
                System.out.println("ERRO: Incremento não pode ser zero!");
            } else {
                break;
            }
        }

        System.out.println("\n--- CONTAGEM ---");

        if (incremento > 0) {
            for (int i = inicio; i <= fim; i += incremento) {
                System.out.print(i + " ");
                pausarCurto();
            }
        } else {
            for (int i = inicio; i >= fim; i += incremento) {
                System.out.print(i + " ");
                pausarCurto();
            }
        }

        System.out.println("\n\nContagem finalizada!");
    }

    // =================== MENU UTILITÁRIOS ===================

    private static void menuUtilitarios() {
        int opcao;
        do {
            System.out.println("\n=============== UTILITÁRIOS ===============");
            System.out.println("1. Conversor de temperatura");
            System.out.println("2. Calculadora de idade");
            System.out.println("3. Gerador de senhas");
            System.out.println("4. Dia da semana por número");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("==========================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> conversorTemperatura();
                    case 2 -> calculadoraIdade();
                    case 3 -> geradorSenhas();
                    case 4 -> diaDaSemana();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números válidos!");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void conversorTemperatura() {
        String continuar;
        do {
            System.out.println("\n========== CONVERSOR DE TEMPERATURA ==========");
            System.out.println("1. Celsius para Fahrenheit");
            System.out.println("2. Fahrenheit para Celsius");
            System.out.println("3. Celsius para Kelvin");
            System.out.println("4. Kelvin para Celsius");
            System.out.print("Escolha o tipo de conversão: ");

            int opcao = lerInteiroValido("", 1, 4);

            switch (opcao) {
                case 1 -> {
                    double celsius = lerDoubleValido("Digite a temperatura em Celsius: ", -273.15, Double.MAX_VALUE);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.printf("%.2f °C = %.2f °F\n", celsius, fahrenheit);
                }
                case 2 -> {
                    double fahrenheit = lerDoubleValido("Digite a temperatura em Fahrenheit: ", -459.67, Double.MAX_VALUE);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.printf("%.2f °F = %.2f °C\n", fahrenheit, celsius);
                }
                case 3 -> {
                    double celsius = lerDoubleValido("Digite a temperatura em Celsius: ", -273.15, Double.MAX_VALUE);
                    double kelvin = celsius + 273.15;
                    System.out.printf("%.2f °C = %.2f K\n", celsius, kelvin);
                }
                case 4 -> {
                    double kelvin = lerDoubleValido("Digite a temperatura em Kelvin: ", 0, Double.MAX_VALUE);
                    double celsius = kelvin - 273.15;
                    System.out.printf("%.2f K = %.2f °C\n", kelvin, celsius);
                }
            }

            System.out.print("\nDeseja fazer outra conversão? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    private static void calculadoraIdade() {
        System.out.println("\n========== CALCULADORA DE IDADE ==========");
        int anoNascimento = lerInteiroValido("Digite o ano de nascimento: ", 1900, LocalDateTime.now().getYear());

        int anoAtual = LocalDateTime.now().getYear();
        int idade = anoAtual - anoNascimento;

        if (idade < 0) {
            System.out.println("ERRO: Ano de nascimento não pode ser no futuro!");
        } else if (idade == 0) {
            System.out.println("Você nasceu este ano!");
        } else {
            System.out.printf("Você tem %d anos (em %d).\n", idade, anoAtual);

            // Classificação por faixa etária
            if (idade < 13) {
                System.out.println("Classificação: Criança");
            } else if (idade < 18) {
                System.out.println("Classificação: Adolescente");
            } else if (idade < 60) {
                System.out.println("Classificação: Adulto");
            } else {
                System.out.println("Classificação: Idoso");
            }

            // Cálculo aproximado em dias
            int diasVividos = idade * 365;
            System.out.printf("Você já viveu aproximadamente %d dias!\n", diasVividos);
        }
    }

    private static void geradorSenhas() {
        String continuar;
        do {
            System.out.println("\n========== GERADOR DE SENHAS ==========");
            int tamanho = lerInteiroValido("Digite o tamanho da senha (mínimo 4): ", 4, Integer.MAX_VALUE);

            System.out.println("Opções de caracteres:");
            System.out.println("1. Apenas números");
            System.out.println("2. Apenas letras");
            System.out.println("3. Letras e números");
            System.out.println("4. Letras, números e símbolos");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiroValido("", 1, 4);
            String caracteres = switch (opcao) {
                case 1 -> "0123456789";
                case 2 -> "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                case 3 -> "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                case 4 -> "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
                default -> "";
            };

            StringBuilder senha = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                int indice = random.nextInt(caracteres.length());
                senha.append(caracteres.charAt(indice));
            }

            System.out.println("\nSenha gerada: " + senha);

            analisarForcaSenha(senha.toString());

            System.out.print("\nDeseja gerar outra senha? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    private static void analisarForcaSenha(String senha) {
        int pontuacao = 0;

        if (senha.length() >= 8) pontuacao++;
        if (senha.matches(".*[a-z].*")) pontuacao++;
        if (senha.matches(".*[A-Z].*")) pontuacao++;
        if (senha.matches(".*\\d.*")) pontuacao++;
        if (senha.matches(".*[!@#$%&*].*")) pontuacao++;

        System.out.print("Força da senha: ");
        switch (pontuacao) {
            case 0, 1 -> System.out.println("MUITO FRACA");
            case 2 -> System.out.println("FRACA");
            case 3 -> System.out.println("MÉDIA");
            case 4 -> System.out.println("FORTE");
            case 5 -> System.out.println("MUITO FORTE");
        }
    }

    private static void diaDaSemana() {
        String continuar;
        do {
            System.out.println("\n========== DIA DA SEMANA ==========");
            System.out.println("Digite um número de 1 a 7:");
            System.out.println("(1=Domingo, 2=Segunda, ..., 7=Sábado)");
            System.out.print("Número: ");

            int dia = lerInteiroValido("", 1, 7);
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

            System.out.println("O dia " + dia + " corresponde a: " + nomeDia);

            if (dia == 1 || dia == 7) {
                System.out.println("Categoria: Final de semana");
            } else {
                System.out.println("Categoria: Dia útil");
            }

            System.out.print("\nDeseja consultar outro dia? (s/n): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s") || continuar.equals("sim"));
    }

    // =================== MENU RELATÓRIOS ===================

    private static void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n=============== RELATÓRIOS ===============");
            System.out.println("1. Relatório completo de filmes");
            System.out.println("2. Estatísticas do catálogo");
            System.out.println("3. Top filmes mais bem avaliados");
            System.out.println("4. Filmes por década");
            System.out.println("5. Relatório de disponibilidade");
            System.out.println("0. Voltar ao menu principal");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1 -> relatorioCompleto();
                    case 2 -> estatisticasCatalogo();
                    case 3 -> topFilmes();
                    case 4 -> filmesPorDecada();
                    case 5 -> relatorioDisponibilidade();
                    case 0 -> System.out.println("Voltando ao menu principal...");
                    default -> System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números válidos!");
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private static void relatorioCompleto() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado para gerar relatório.");
            return;
        }

        System.out.println("\n=============== RELATÓRIO COMPLETO DE FILMES ===============");
        System.out.println("Total de filmes cadastrados: " + filmes.size());
        System.out.println("Data do relatório: " + java.time.LocalDate.now());
        System.out.println("============================================================");

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            System.out.printf("\n[%d] %s\n", i + 1, filme.toString());

            if (!filme.avaliacoes.isEmpty()) {
                System.out.println("    Avaliações individuais: " + filme.avaliacoes);
                double somaNotas = filme.avaliacoes.stream().mapToDouble(Double::doubleValue).sum();
                System.out.printf("    Soma total das notas: %.1f\n", somaNotas);
            }
            System.out.println("    ----------------------------------------");
        }
    }

    private static void estatisticasCatalogo() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado para gerar estatísticas.");
            return;
        }

        System.out.println("\n=============== ESTATÍSTICAS DO CATÁLOGO ===============");

        int totalFilmes = filmes.size();
        long filmesAvaliados = filmes.stream().filter(f -> !f.avaliacoes.isEmpty()).count();
        long filmesNoPlano = filmes.stream().filter(f -> f.incluidoNoPlano).count();

        double mediaGeral = filmes.stream()
                .filter(f -> !f.avaliacoes.isEmpty())
                .mapToDouble(f -> f.nota)
                .average()
                .orElse(0.0);

        int anoMaisAntigo = filmes.stream().mapToInt(f -> f.anoLancamento).min().orElse(0);
        int anoMaisRecente = filmes.stream().mapToInt(f -> f.anoLancamento).max().orElse(0);

        System.out.println("Total de filmes: " + totalFilmes);
        System.out.println("Filmes avaliados: " + filmesAvaliados);
        System.out.println("Filmes não avaliados: " + (totalFilmes - filmesAvaliados));
        System.out.println("Filmes incluídos no plano: " + filmesNoPlano);
        System.out.println("Filmes que requerem pagamento: " + (totalFilmes - filmesNoPlano));
        System.out.printf("Média geral das avaliações: %.1f/10\n", mediaGeral);
        System.out.println("Período do catálogo: " + anoMaisAntigo + " - " + anoMaisRecente);

        Map<String, Long> generos = filmes.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        f -> f.genero,
                        java.util.stream.Collectors.counting()));

        System.out.println("\nDistribuição por gênero:");
        generos.forEach((genero, count) ->
                System.out.printf("  %s: %d filme(s)\n", genero, count));

        System.out.println("=======================================================");
    }

    private static void topFilmes() {
        List<Filme> filmesAvaliados = filmes.stream()
                .filter(f -> !f.avaliacoes.isEmpty())
                .sorted((f1, f2) -> Double.compare(f2.nota, f1.nota))
                .toList();

        if (filmesAvaliados.isEmpty()) {
            System.out.println("\nNenhum filme foi avaliado ainda.");
            return;
        }

        System.out.println("\n========== TOP FILMES MAIS BEM AVALIADOS ==========");

        int limite = Math.min(5, filmesAvaliados.size());
        for (int i = 0; i < limite; i++) {
            Filme filme = filmesAvaliados.get(i);
            String medalha = switch (i) {
                case 0 -> "1º lugar";
                case 1 -> "2º lugar";
                case 2 -> "3º lugar";
                default -> (i + 1) + "º lugar";
            };

            System.out.printf("\n%s - %s (%.1f/10)\n", medalha, filme.nome, filme.nota);
            System.out.printf("    Ano: %d | Gênero: %s | Avaliações: %d\n",
                    filme.anoLancamento, filme.genero, filme.avaliacoes.size());
        }
        System.out.println("==================================================");
    }

    private static void filmesPorDecada() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
            return;
        }

        Map<String, List<Filme>> filmesPorDecada = new TreeMap<>();

        for (Filme filme : filmes) {
            int decada = (filme.anoLancamento / 10) * 10;
            String chaveDecada = decada + "s";
            filmesPorDecada.computeIfAbsent(chaveDecada, k -> new ArrayList<>()).add(filme);
        }

        System.out.println("\n============ FILMES ORGANIZADOS POR DÉCADA ============");

        for (Map.Entry<String, List<Filme>> entrada : filmesPorDecada.entrySet()) {
            System.out.println("\n--- DÉCADA DE " + entrada.getKey().toUpperCase() + " ---");
            System.out.println("Total: " + entrada.getValue().size() + " filme(s)");

            for (Filme filme : entrada.getValue()) {
                System.out.printf("  • %s (%d) - %.1f/10\n",
                        filme.nome, filme.anoLancamento, filme.nota);
            }
        }
        System.out.println("======================================================");
    }

    private static void relatorioDisponibilidade() {
        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
            return;
        }

        System.out.println("\n========== RELATÓRIO DE DISPONIBILIDADE ==========");

        List<Filme> filmesNoPlano = filmes.stream()
                .filter(f -> f.incluidoNoPlano)
                .toList();

        List<Filme> filmesParaAlugar = filmes.stream()
                .filter(f -> !f.incluidoNoPlano)
                .toList();

        List<Filme> lancamentosRecentes = filmes.stream()
                .filter(f -> f.anoLancamento >= 2022)
                .toList();

        List<Filme> filmesRetro = filmes.stream()
                .filter(f -> f.anoLancamento < 2022)
                .toList();

        System.out.println("\n--- FILMES INCLUÍDOS NO PLANO ---");
        System.out.println("Total: " + filmesNoPlano.size());
        filmesNoPlano.forEach(f -> System.out.println("  • " + f.nome + " (" + f.anoLancamento + ")"));

        System.out.println("\n--- FILMES PARA ALUGAR ---");
        System.out.println("Total: " + filmesParaAlugar.size());
        filmesParaAlugar.forEach(f -> System.out.println("  • " + f.nome + " (" + f.anoLancamento + ")"));

        System.out.println("\n--- LANÇAMENTOS RECENTES (2022+) ---");
        System.out.println("Total: " + lancamentosRecentes.size());
        lancamentosRecentes.forEach(f -> System.out.println("  • " + f.nome + " (" + f.anoLancamento + ")"));

        System.out.println("\n--- FILMES RETRÔ (antes de 2022) ---");
        System.out.println("Total: " + filmesRetro.size());
        filmesRetro.forEach(f -> System.out.println("  • " + f.nome + " (" + f.anoLancamento + ")"));

        System.out.println("==================================================");

        // Resumo financeiro simulado
        double custoAluguel = filmesParaAlugar.size() * 12.90; // R$ 12,90 por filme
        System.out.printf("\nCUSTO ESTIMADO para alugar todos os filmes pagos: R$ %.2f\n", custoAluguel);
    }

    // =================== MÉTODOS AUXILIARES ===================

    /**
     * Lê um inteiro dentro de um intervalo válido, solicitando até entrada correta.
     */
    private static int lerInteiroValido(String mensagem, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < min || valor > max) {
                    System.out.printf("ERRO: Valor deve estar entre %d e %d.%n", min, max);
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Entrada inválida! Digite um número inteiro válido.");
            }
        }
    }

    /**
     * Lê um double dentro de um intervalo válido, solicitando até entrada correta.
     */
    private static double lerDoubleValido(String mensagem, double min, double max) {
        double valor;
        while (true) {
            System.out.print(mensagem);
            try {
                valor = Double.parseDouble(scanner.nextLine().trim());
                if (valor < min || valor > max) {
                    System.out.printf("ERRO: Valor deve estar entre %.2f e %.2f.%n", min, max);
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Entrada inválida! Digite um número válido.");
            }
        }
    }

    /**
     * Lê uma resposta 'sim' ou 'não', aceitando variações.
     */
    private static boolean lerSimNao() {
        while (true) {
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("n") || resposta.equals("nao") || resposta.equals("não")) {
                return false;
            } else {
                System.out.print("Resposta inválida. Digite 's' para sim ou 'n' para não: ");
            }
        }
    }

    /**
     * Pausa curta para efeito visual em contadores e jogos.
     */
    private static void pausarCurto() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
