// Gerencia a lista de clientes, permitindo adicionar, remover e exibir clientes.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(String nome) {
        clientes.removeIf(cliente -> cliente.getNome().equals(nome));
    }

    public void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else
        for (Cliente cliente : clientes) {
            cliente.exibir();
        }
    }

    //Cria uma lista resultados e adiciona nela todos os clientes cujo nome começa com o prefixo fornecido.
    //Retorna a lista resultados.
    public List<Cliente> buscarClientesPorNome(String prefixo) {
        List<Cliente> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().startsWith(prefixo.toLowerCase())) {
                resultados.add(cliente);
            }
        }
        return resultados;
    }

    private Cliente clienteMaisVelho() {
        if (clientes.isEmpty()) {
            return null;
        }
        Cliente maisVelho = clientes.getFirst(); //Inicializa com o primeiro cliente
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > maisVelho.getIdade()) {
                maisVelho = cliente;
            }
        }
        return maisVelho;
    }

    private Cliente clienteMaisNovo() {
        Cliente maisNovo = null;
        for (Cliente cliente : clientes) {
            if (maisNovo == null || cliente.getIdade() < maisNovo.getIdade()) {
                maisNovo = cliente;
            }
        }
        return maisNovo;
    }

    private int ClientesMaiores60() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() > 60) {
                quantidade++;
            }
        }
        return quantidade;
    }

    private int ClientesMenores18() {
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() < 18) {
                quantidade++;
            }
        }
        return quantidade;
    }

    private double idadeMediaClientes() {
        if (clientes.isEmpty()) {
            return 0;
        }
        int somaIdades = 0;
        for (Cliente cliente : clientes) {
            somaIdades += cliente.getIdade();
        }
        return (double) somaIdades / clientes.size();
    }

    private void relatorioClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Não há nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Relatório Clientes:");
        System.out.println("1. Cliente mais velho: " + clienteMaisVelho().getNome() + ", " + clienteMaisVelho().getIdade() + " anos");
        System.out.println("2. Cliente mais novo: " + clienteMaisNovo().getNome() + ", " + clienteMaisNovo().getIdade() + " anos");
        System.out.println("3. Quantidade de clientes com mais de 60 anos: " + ClientesMaiores60());
        System.out.println("4. Quantidade de clientes com menos de 18 anos: " + ClientesMenores18());
        System.out.println("5. Idade média dos clientes: " + idadeMediaClientes() + " anos");
    }

    public void menuClientes(Scanner scanner) {
        while (true) {
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Exibir Clientes");
            System.out.println("4. Relatório Clientes");
            System.out.println("5. Voltar ao Menu Principal");
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
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Saldo: ");
                int saldo = scanner.nextInt();
                System.out.println("Cliente cadastrado com sucesso!");
                System.out.println("<----------------------------------->\n");
                Cliente cliente = new Cliente(nome, idade, cpf, email, saldo);
                adicionarCliente(cliente);

            } else if (opcao == 2) {
                System.out.print("Nome do cliente a remover: ");
                String nome = scanner.nextLine();
                //Esta linha chama o método buscarClientesPorNome passando o nome digitado pelo usuário como argumento.
                // O método buscarClientesPorNome retorna uma lista de clientes (List<Cliente>) cujos nomes começam com o prefixo fornecido.
                List<Cliente> clientesCorrespondentes = buscarClientesPorNome(nome);

                if (clientesCorrespondentes.isEmpty()) {
                    System.out.println("Nenhum cliente encontrado com este nome.");
                } else {
                    System.out.println("Clientes encontrados:");
                    //O loop começa com i igual a 0 e continua enquanto i for menor que o tamanho da lista (clientesCorrespondentes.size()).
                    // A variável i é incrementada em 1 a cada iteração.
                    for (int i = 0; i < clientesCorrespondentes.size(); i++) {
                        //(i + 1): Converte o índice i (que começa em 0) para uma contagem que começa em 1.
                        // Isso é feito para que a lista mostrada ao usuário seja mais intuitiva (ou seja, comece com 1 em vez de 0).
                        System.out.println((i + 1) + ". " + clientesCorrespondentes.get(i).getNome()); // Obtém o nome do cliente na posição i da lista clientesCorrespondentes.
                    }
                    System.out.print("Escolha o número do cliente a remover: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha > 0 && escolha <= clientesCorrespondentes.size()) {
                        removerCliente(clientesCorrespondentes.get(escolha - 1).getNome());
                        System.out.println("<----------------------------------->");
                        System.out.println("Cliente removido com sucesso!");
                        System.out.println("<----------------------------------->\n");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (opcao == 3) {
                exibirClientes();
            }else if (opcao == 4){
                relatorioClientes();
            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
