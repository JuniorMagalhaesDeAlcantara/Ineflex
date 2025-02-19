# Projeto de Gerenciamento de Funcionários

Este projeto consiste em um sistema de gerenciamento de funcionários, onde realizamos diversas operações, como inserção, remoção, agrupamento e cálculo de salários, utilizando o Java. O objetivo principal é demonstrar o uso de listas, mapas e streams no Java, além de formatar as saídas conforme especificações.

## Funcionalidades

1. **Inserção de Funcionários**: Os funcionários são inseridos com dados como nome, data de nascimento, salário e função.
2. **Remoção de Funcionário**: O funcionário chamado "João" foi removido da lista.
3. **Impressão de Todos os Funcionários**: Exibe os dados de todos os funcionários, incluindo nome, data de nascimento formatada, salário formatado, função e idade.
4. **Aumento Salarial**: Um aumento de 10% foi aplicado a todos os salários dos funcionários.
5. **Agrupamento por Função**: Os funcionários foram agrupados por suas respectivas funções em um `Map` onde a chave é a função e o valor é a lista de funcionários.
6. **Exibição por Função**: Os funcionários foram impressos, agrupados por função.
7. **Funcionários com Aniversário em Outubro e Dezembro**: Foram impressos os funcionários com aniversário nos meses de outubro ou dezembro.
8. **Funcionário Mais Velho**: O funcionário com a maior idade foi identificado e impresso.
9. **Ordenação Alfabética**: A lista de funcionários foi ordenada alfabeticamente por nome.
10. **Total de Salários**: Foi calculado e impresso o total dos salários de todos os funcionários.
11. **Salários Mínimos**: Para cada funcionário, foi calculado quantos salários mínimos ele ganha (considerando o valor de R$ 1212,00).

## Tecnologias Utilizadas

- **Java 8+**: Usado para manipulação de listas, streams e cálculos.
- **BigDecimal**: Usado para cálculos precisos com valores monetários.
- **LocalDate**: Usado para armazenar e manipular as datas de nascimento dos funcionários.

## Como Executar o Projeto

### Pré-requisitos

- **Java 8 ou superior** instalado em seu computador.
  
### Passos para execução

1. Clone este repositório:
    ```bash
    git clone https://github.com/JuniorMagalhaesDeAlcantara/Ineflex
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd ProjetoFuncionario
    ```
3. Compile e execute o programa:
    ```bash
    javac Principal.java
    java Principal
    ```

O programa será executado e as saídas serão impressas no console.

## Exemplo de Saída

```plaintext
Nome: Maria
Data de Nascimento: 18/10/2000
Salário: R$ 2.209,44
Função: Operador
Idade: 24 anos

Função: Operador
  Nome: Maria
  Salário: R$ 2.209,44

...

Total dos salários: R$ 40.292,30

Alice ganha 1,83 salários mínimos
...
