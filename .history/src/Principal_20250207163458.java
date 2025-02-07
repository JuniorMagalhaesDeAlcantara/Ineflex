import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        // 3.1 Inserir os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João", LocalDate.of(1980, 5, 10), new BigDecimal("3000"), "Analista"));
        funcionarios.add(new Funcionario("Maria", LocalDate.of(1990, 3, 25), new BigDecimal("4000"), "Gerente"));
        funcionarios.add(new Funcionario("Carlos", LocalDate.of(1985, 7, 15), new BigDecimal("3500"), "Assistente"));

        // 3.2 Remover o funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimir todos os funcionários
        funcionarios.forEach(func -> {
            System.out.println("Nome: " + func.getNome());
            System.out.println("Data de Nascimento: " + func.formatarDataNascimento());
            System.out.println("Salário: " + func.formatarSalario());
            System.out.println("Função: " + func.getFuncao());
            System.out.println("Idade: " + func.calcularIdade() + " anos");
            System.out.println();
        });

        // 3.4 Aumento de 10% no salário
        funcionarios.forEach(func -> func.setSalario(func.getSalario().multiply(BigDecimal.valueOf(1.10))));

        // 3.5 Agrupar os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario func : funcionarios) {
            funcionariosPorFuncao.computeIfAbsent(func.getFuncao(), k -> new ArrayList<>()).add(func);
        }

        // 3.6 Imprimir os funcionários agrupados por função
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(func -> {
                System.out.println("  Nome: " + func.getNome());
                System.out.println("  Salário: " + func.formatarSalario());
            });
            System.out.println();
        });

        // 3.8 Imprimir os funcionários com aniversário em outubro ou dezembro
        funcionarios.stream()
                .filter(func -> func.getDataNascimento().getMonthValue() == 10
                        || func.getDataNascimento().getMonthValue() == 12)
                .forEach(func -> {
                    System.out.println("Nome: " + func.getNome());
                    System.out.println("Data de Nascimento: " + func.formatarDataNascimento());
                    System.out.println();
                });

        // 3.9 Imprimir o funcionário com a maior idade
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::calcularIdade))
                .orElse(null);
        if (maisVelho != null) {
            System.out.println(
                    "Funcionario mais velho: " + maisVelho.getNome() + " - Idade: " + maisVelho.calcularIdade());
        }

        // 3.10 Imprimir a lista de funcionários por ordem alfabética
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(func -> System.out.println(func.getNome()));

        // 3.11 Imprimir o total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + totalSalarios);

        // 3.12 Imprimir quantos salários mínimos cada funcionário ganha
        funcionarios.forEach(func -> System.out
                .println(func.getNome() + " ganha " + func.calcularSalariosMinimos() + " salários mínimos"));
    }
}
