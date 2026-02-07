# Contribuindo para o Screen Match

Obrigado pelo interesse em contribuir! Este guia explica como participar do projeto.

## Como Contribuir

### 1. Reportar Bugs

Abra uma [Issue](https://github.com/ESousa97/screen-match/issues) usando o template de bug report.

### 2. Sugerir Funcionalidades

Abra uma [Issue](https://github.com/ESousa97/screen-match/issues) usando o template de feature request.

### 3. Enviar Código

1. **Fork** o repositório
2. **Clone** seu fork:
   ```bash
   git clone https://github.com/SEU_USUARIO/screen-match.git
   ```
3. Crie uma **branch** descritiva:
   ```bash
   git checkout -b feature/nome-da-feature
   ```
4. Faça suas alterações
5. Verifique se tudo passa:
   ```bash
   mvn compile
   mvn test
   mvn checkstyle:check
   ```
6. Faça **commit** seguindo [Conventional Commits](https://www.conventionalcommits.org/):
   ```bash
   git commit -m "feat: adicionar novo exercício de arrays"
   git commit -m "fix: corrigir cálculo de média"
   git commit -m "docs: atualizar README com novo comando"
   ```
7. **Push** e abra um **Pull Request**

## Padrões de Código

- **Java 17+** — use recursos modernos da linguagem
- **Checkstyle** — o código deve passar no linter (`mvn checkstyle:check`)
- **Testes** — novas funcionalidades devem incluir testes JUnit 5
- **Javadoc** — documente classes e métodos públicos

## Conventional Commits

Use prefixos padronizados:

| Prefixo      | Uso                                     |
| :----------- | :-------------------------------------- |
| `feat:`      | Nova funcionalidade                     |
| `fix:`       | Correção de bug                         |
| `docs:`      | Alteração em documentação               |
| `refactor:`  | Refatoração sem mudança de comportamento|
| `test:`      | Adição/alteração de testes              |
| `chore:`     | Manutenção, configs, CI                 |

## Ambiente de Desenvolvimento

- **JDK 17+**
- **Maven 3.9+**
- IDE recomendada: IntelliJ IDEA, VS Code com extensões Java, ou Eclipse
