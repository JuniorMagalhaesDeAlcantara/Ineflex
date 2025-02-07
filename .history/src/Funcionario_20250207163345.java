import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public int calcularIdade() {
        return Period.between(getDataNascimento(), LocalDate.now()).getYears();
    }

    public String formatarDataNascimento() {
        return getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String formatarSalario() {
        return String.format(Locale.GERMANY, "%,.2f", salario);
    }

    public int calcularSalariosMinimos() {
        return salario.divide(BigDecimal.valueOf(1212), BigDecimal.ROUND_HALF_UP).intValue();
    }
}
