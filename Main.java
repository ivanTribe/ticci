import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastroClientes = new CadastroClientes();
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal");
            System.out.println("1. Funcionários");
            System.out.println("2. Clientes");
            System.out.println("3. Produtos");
            System.out.println("4. Busca");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                cadastroFuncionarios.menuFuncionarios(scanner);
            } else if (opcao == 2) {
                cadastroClientes.menuClientes(scanner);
            } else if (opcao == 3) {
                cadastroProdutos.menuProdutos(scanner);
            } else if (opcao == 4) {
                System.out.println("Menu de Busca");
                System.out.println("1. Buscar Funcionário");
                System.out.println("2. Buscar Cliente");
                System.out.println("3. Buscar Produto");
                System.out.println("4. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");
                int opcaoBusca = scanner.nextInt();
                scanner.nextLine();

                if (opcaoBusca == 1) {
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = scanner.nextLine();
                    List<Funcionario> resultados = cadastroFuncionarios.buscarFuncionariosPorNome(nome);
                    if (resultados.isEmpty()) {
                        System.out.println("Nenhum funcionário encontrado.");
                    } else {
                        System.out.println("Funcionários encontrados:");
                        for (Funcionario funcionario : resultados) {
                            funcionario.exibir();
                        }
                    }
                } else if (opcaoBusca == 2) {
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    List<Cliente> resultados = cadastroClientes.buscarClientesPorNome(nome);
                    if (resultados.isEmpty()) {
                        System.out.println("Nenhum cliente encontrado.");
                    } else {
                        System.out.println("Clientes encontrados:");
                        for (Cliente cliente : resultados) {
                            cliente.exibir();
                        }
                    }
                } else if (opcaoBusca == 3) {
                    System.out.println("Buscar Produto por:");
                    System.out.println("1. Titulo");
                    System.out.println("2. Descrição");
                    System.out.println("3. Preço");
                    System.out.print("Escolha uma opção: ");
                    int opcaoProduto = scanner.nextInt();
                    scanner.nextLine();

                    if (opcaoProduto == 1) {
                        System.out.print("Digite o titulo: ");
                        String nome = scanner.nextLine();
                        List<Produto> resultados = cadastroProdutos.buscarPorNome(nome);
                        if (resultados.isEmpty()) {
                            System.out.println("Nenhum livro encontrado.");
                        } else {
                            System.out.println("Livros encontrados:");
                            for (Produto produto : resultados) {
                                System.out.println(produto);
                            }
                        }
                    } else if (opcaoProduto == 2) {
                        System.out.print("Digite a descrição: ");
                        String descricao = scanner.nextLine();
                        List<Produto> resultados = cadastroProdutos.buscarPorDescricao(descricao);
                        if (resultados.isEmpty()) {
                            System.out.println("Nenhum livro encontrado.");
                        } else {
                            System.out.println("Livros encontrados:");
                            for (Produto produto : resultados) {
                                System.out.println(produto);
                            }
                        }
                    } else if (opcaoProduto == 3) {
                        System.out.print("Digite o preço: ");
                        double preco = scanner.nextDouble();
                        List<Produto> resultados = cadastroProdutos.buscarPorPreco(preco);
                        if (resultados.isEmpty()) {
                            System.out.println("Nenhum livro encontrado.");
                        } else {
                            System.out.println("Livros encontrados:");
                            for (Produto produto : resultados) {
                                System.out.println(produto);
                            }
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } else if (opcaoBusca == 4) {
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }
            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}