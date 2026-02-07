# Política de Segurança

## Versões Suportadas

| Versão | Suportada |
| :----- | :-------- |
| 1.0.x  | ✅        |

## Reportar Vulnerabilidades

Se você descobrir uma vulnerabilidade de segurança, **não abra uma issue pública**.

Em vez disso, entre em contato diretamente com o mantenedor:

- **LinkedIn:** [Enoque Sousa](https://www.linkedin.com/in/enoque-sousa-bb89aa168/)

### O que incluir no relatório:

- Descrição da vulnerabilidade
- Passos para reproduzir
- Impacto potencial
- Sugestão de correção (se houver)

### Prazo de Resposta

- **Confirmação de recebimento:** até 48 horas
- **Avaliação inicial:** até 7 dias
- **Correção (se aplicável):** depende da severidade

## Considerações de Segurança do Projeto

Este projeto é uma aplicação de console educacional que:

- **Não** se conecta a redes ou APIs externas
- **Não** persiste dados em disco ou banco de dados
- **Não** processa credenciais ou dados sensíveis
- **Não** possui dependências de runtime (apenas JDK padrão)

O perfil de risco de segurança é **baixo**. As dependências de build/test (JUnit, Maven plugins) são monitoradas via Dependabot.
