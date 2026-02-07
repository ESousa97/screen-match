package com.screenmatch.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Filme")
class FilmeTest {

    private Filme filme;

    @BeforeEach
    void setUp() {
        filme = new Filme("Test Movie", 2023, "Ação", true);
    }

    @Nested
    @DisplayName("Construção")
    class Construcao {

        @Test
        @DisplayName("deve inicializar com nota zero e sem avaliações")
        void deveInicializarCorreto() {
            assertEquals("Test Movie", filme.getNome());
            assertEquals(2023, filme.getAnoLancamento());
            assertEquals("Ação", filme.getGenero());
            assertTrue(filme.isIncluidoNoPlano());
            assertEquals(0.0, filme.getNota());
            assertEquals(0, filme.getTotalAvaliacoes());
            assertTrue(filme.getAvaliacoes().isEmpty());
        }

        @Test
        @DisplayName("deve criar filme fora do plano")
        void deveCriarForaDoPlano() {
            Filme foraPlan = new Filme("Fora", 2020, "Drama", false);
            assertFalse(foraPlan.isIncluidoNoPlano());
        }
    }

    @Nested
    @DisplayName("Avaliações")
    class Avaliacoes {

        @Test
        @DisplayName("deve calcular média com uma avaliação")
        void deveCalcularMediaUmaAvaliacao() {
            filme.adicionarAvaliacao(8.0);

            assertEquals(8.0, filme.getNota(), 0.001);
            assertEquals(1, filme.getTotalAvaliacoes());
        }

        @Test
        @DisplayName("deve calcular média com múltiplas avaliações")
        void deveCalcularMediaMultiplasAvaliacoes() {
            filme.adicionarAvaliacao(8.0);
            filme.adicionarAvaliacao(6.0);
            filme.adicionarAvaliacao(10.0);

            assertEquals(8.0, filme.getNota(), 0.001);
            assertEquals(3, filme.getTotalAvaliacoes());
        }

        @Test
        @DisplayName("deve retornar cópia imutável das avaliações")
        void deveRetornarCopiaImutavel() {
            filme.adicionarAvaliacao(7.5);
            var avaliacoes = filme.getAvaliacoes();

            assertEquals(1, avaliacoes.size());
            // A lista retornada deve ser imutável
            try {
                avaliacoes.add(9.0);
                // Se chegou aqui, não é imutável — falha
                assertFalse(true, "Lista deveria ser imutável");
            } catch (UnsupportedOperationException e) {
                // Comportamento esperado
                assertTrue(true);
            }
        }

        @Test
        @DisplayName("deve recalcular média a cada nova avaliação")
        void deveRecalcularMedia() {
            filme.adicionarAvaliacao(10.0);
            assertEquals(10.0, filme.getNota(), 0.001);

            filme.adicionarAvaliacao(6.0);
            assertEquals(8.0, filme.getNota(), 0.001);

            filme.adicionarAvaliacao(5.0);
            assertEquals(7.0, filme.getNota(), 0.001);
        }
    }

    @Nested
    @DisplayName("toString")
    class ToStringTest {

        @Test
        @DisplayName("deve incluir informações do filme na representação textual")
        void deveIncluirInformacoes() {
            filme.adicionarAvaliacao(9.0);
            String resultado = filme.toString();

            assertTrue(resultado.contains("Test Movie"));
            assertTrue(resultado.contains("2023"));
            assertTrue(resultado.contains("9.0"));
            assertTrue(resultado.contains("Ação"));
            assertTrue(resultado.contains("Sim"));
        }
    }
}
