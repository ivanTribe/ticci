import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CadastroFuncionarios {
    private List<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else
            for (Funcionario funcionario : funcionarios) {
                funcionario.exibir();
            }
    }

    public List<Funcionario> buscarFuncionariosPorNome(String prefixo) {
        List<Funcionario> resultados = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().toLowerCase().startsWith(prefixo.toLowerCase())) {
                resultados.add(funcionario);
            }
        }
        return resultados;
    }

    public void menuFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("1. Adicionar funcionario");
            System.out.println("2. Remover funcionario");
            System.out.println("3. Exibir funcionarios");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("<----------------------------------->");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.print("CPF: ");
                long cpf = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();
                System.out.print("Salario: ");
                double salario = scanner.nextDouble();
                System.out.println("Cliente cadastrado com sucesso!");
                System.out.println("<----------------------------------->\n");
                Funcionario funcionario = new Funcionario(nome, idade, cpf, cargo, salario);
                adicionarFuncionario(funcionario);

            } else if (opcao == 2) {
                System.out.print("Nome do funcioario a remover: ");
                String nome = scanner.nextLine();
                List<Funcionario> funcionariosCorrespondentes = buscarFuncionariosPorNome(nome);

                if (funcionariosCorrespondentes.isEmpty()) {
                    System.out.println("Nenhum funcionario encontrado com este nome.");
                } else {
                    System.out.println("Funcionarios encontrados:");
                    for (int i = 0; i < funcionariosCorrespondentes.size(); i++) {
                        System.out.println((i + 1) + ". " + funcionariosCorrespondentes.get(i).getNome());
                    }
                    System.out.print("Escolha o número do funcionario a remover: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha > 0 && escolha <= funcionariosCorrespondentes.size()) {
                        removerFuncionario(funcionariosCorrespondentes.get(escolha - 1).getNome());
                        System.out.println("<----------------------------------->");
                        System.out.println("Funcionario removido com sucesso!");
                        System.out.println("<----------------------------------->\n");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (opcao == 3) {
                exibirFuncionarios();
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
