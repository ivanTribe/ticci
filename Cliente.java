import java.util.ArrayList;
import java.util.List;
public class Cliente extends Pessoa implements IPessoa{
    private String email;
    private int saldo;

    public Cliente(String nome, int idade, long cpf, String email, int saldo){
        super(nome, idade, cpf);
        this.email = email;
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public void exibir(){
        System.out.println("<--------------------------------->");
        System.out.println("Nome do cliente: "+ getNome());
        System.out.println("Idade do cliente: "+ getIdade());
        System.out.println("CPF do cliente: "+ getCpf());
        System.out.println("Email do cliente: "+ email);
        System.out.println("Saldo do cliente: "+ saldo);
        System.out.println("<--------------------------------->");
    }
}
