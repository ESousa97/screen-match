# Changelog

Todas as mudanças relevantes deste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/),
e este projeto adere ao [Versionamento Semântico](https://semver.org/lang/pt-BR/).

## [1.0.0] - 2026-02-06

### Adicionado
- Build system Maven com compilação, testes e linting automatizados
- Estrutura de pacotes Java padrão (`com.screenmatch`)
- Classe `Filme` como model separado com encapsulamento adequado
- Classe `InputUtils` centralizando toda lógica de input/validação
- Decomposição do menu em classes especializadas: `MenuPrincipal`, `MenuFilmes`, `MenuCalculadora`, `MenuJogos`, `MenuUtilitarios`, `MenuRelatorios`
- Testes unitários com JUnit 5 (`FilmeTest`, `MenuCalculadoraTest`)
- Checkstyle para linting de código
- GitHub Actions CI (build, test, lint)
- Dependabot para atualização automática de dependências
- Templates de Issue (bug report, feature request) e Pull Request
- Documentação: README, CONTRIBUTING, CODE_OF_CONDUCT, SECURITY, CHANGELOG
- `.editorconfig` e `.gitattributes` para consistência de formatação

### Corrigido
- Bug em `CalculoArea`: format string incorreto (`"%.2f\n" + area` → `printf`)
- Bug em `Contador`: duplo incremento no loop (pulava números)
- Bug em `Polaridade`: variáveis booleanas declaradas mas nunca usadas
- Typo no nome do arquivo `Taubada.java` → `Tabuada.java`
- Nome de arquivo `main.java` não correspondia à classe `ScreenMatchInterativo`

### Alterado
- Migração de compilação manual para Maven
- Reorganização de arquivos em estrutura de pacotes `com.screenmatch.*`
- README reescrito (de 674 linhas verbosas para ~120 linhas objetivas)
- `.gitignore` expandido para cobrir Maven, `.idea/`, `.iml`
- Exercícios renomeados para nomes descritivos: `Case.java` → `DiaDaSemana.java`, `Loop.java` → `LoopFor.java`, `OutroLoop.java` → `LoopWhile.java`, `Main.java` → `ConceitosBasicos.java`, `TratamentoNumeros.java` → `ComparadorNumeros.java`

### Removido
- Arquivo `screen-match.iml` (config de IDE, não deve ser versionado)
- Duplicação de código entre exercícios standalone e menus integrados
- Código morto (variáveis não utilizadas)
