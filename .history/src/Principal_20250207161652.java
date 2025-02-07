import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // Criando lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adicionando funcionários (exemplo fictício)
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios
                .add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios
                .add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Removendo o funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // Formatter para data
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatter para salário
        DecimalFormat salarioFormatter = new DecimalFormat("#,##0.00");

        // Aplicando aumento de 10% no salário de todos os funcionários
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(BigDecimal.valueOf(0.10));
            f.setSalario(f.getSalario().add(aumento));
        }
        System.out.println("\nAumento de 10% aplicado aos salários.");

        // Imprimindo funcionários formatados
        System.out.println("\nLista de Funcionários:");
        for (Funcionario f : funcionarios) {
            String dataFormatada = f.getDataNascimento().format(dateFormatter);
            String salarioFormatado = salarioFormatter.format(f.getSalario());
            System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: R$ %s, Função: %s\n",
                    f.getNome(), dataFormatada, salarioFormatado, f.getFuncao());
        }

        // Agrupando os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Imprimindo os funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(f -> System.out.printf("  - Nome: %s, Salário: R$ %s\n",
                    f.getNome(), salarioFormatter.format(f.getSalario())));
        });

        System.out.println("\nFuncionário 'João' removido com sucesso.");

        // Exibir funcionários cadastrados
        System.out.println("Funcionários cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getFuncao() + " - " + f.getSalario());

        }
    }
}
