import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criando lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adicionando funcionários (exemplo fictício)
        funcionarios.add(new Funcionario("Maria", LocalDate.of(1990, 10, 15), new BigDecimal("2000.00"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1985, 12, 20), new BigDecimal("3000.00"), "Gerente"));
        funcionarios.add(new Funcionario("Ana", LocalDate.of(1995, 6, 5), new BigDecimal("1500.00"), "Auxiliar"));

        // Exibir funcionários cadastrados
        System.out.println("Funcionários cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getFuncao() + " - " + f.getSalario());
        }
    }
}
