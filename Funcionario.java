public class Funcionario extends Pessoa implements IPessoa {
    private String cargo;
    private double salario;

    public Funcionario(String nome, int idade, long cpf, String cargo, double salario) {
        super(nome, idade, cpf);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void exibir() {
        System.out.println("<--------------------------------->");
        System.out.println("Nome do funcionario: " + getNome());
        System.out.println("Idade do funcionario: " + getIdade());
        System.out.println("CPF do funcionario: " + getCpf());
        System.out.println("Cargo do funcionario: " + cargo);
        System.out.println("Salário do funcionario: " + salario);
        System.out.println("<--------------------------------->");
    }
}
