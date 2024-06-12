import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CadastroProdutos {
    private ArrayList<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Livro adicionado com sucesso: " + produto);
    }

    public void removerProduto(String nome) {
        produtos.removeIf(produto -> produto.getNome().equals(nome));
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Produto produto : produtos) {
                produto.exibir2();
            }
        }
    }

    public List<Produto> buscarPorDescricao(String descricao) {
        List<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getDescricao().toLowerCase().startsWith(descricao.toLowerCase())) {
                resultados.add(produto);
            }
        }
        return resultados;
    }

    public List<Produto> buscarPorNome(String codigo){
        List<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().startsWith(produto.getNome().toLowerCase())){
                resultados.add(produto);
            }
        }
        return resultados;
    }

    public List<Produto> buscarPorPreco(double preco) {
        List<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getPreco() == preco) {
                resultados.add(produto);
            }
        }
        return resultados;
    }

    private Produto produtoMaisCaro() {
        Produto maisCaro = null;
        for (Produto produto : produtos) {
            if (maisCaro == null || produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }
        return maisCaro;
    }

    private Produto produtoMaisBarato() {
        Produto maisBarato = null;
        for (Produto produto : produtos) {
            if (maisBarato == null || produto.getPreco() < maisBarato.getPreco()) {
                maisBarato = produto;
            }
        }
        return maisBarato;
    }

    private double mediaProdutos() {
        if (produtos.isEmpty()) {
            return 0;
        }
        double somaPrecos = 0;
        for (Produto produto : produtos) {
            somaPrecos += produto.getPreco();
        }
        return somaPrecos / produtos.size();
    }
    private void relatorioProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há nenhum livro cadastrado.");
            return;
        }
        System.out.println("Relatório Produtos:");
        System.out.println("1. Produto mais caro: " + produtoMaisCaro().getDescricao() + ", R$" + produtoMaisCaro().getPreco());
        System.out.println("2. Produto mais barato: " + produtoMaisBarato().getDescricao() + ", R$" + produtoMaisBarato().getPreco());
        System.out.println("3. Preço médio dos produtos: R$" + mediaProdutos());
    }

    public void menuProdutos(Scanner scanner) {
        while (true) {
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Exibir livros");
            System.out.println("4. Relatório livros");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("<----------------------------------->");
                System.out.print("Titulo: ");
                String nome = scanner.nextLine();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Codigo: ");
                String codigo = scanner.nextLine();
                System.out.println("Produto cadastrado com sucesso!");
                System.out.println("<----------------------------------->\n");
                Produto produto = new Produto(nome, descricao, preco, quantidade, codigo);
                adicionarProduto(produto);

            } else if (opcao == 2) {
                System.out.print("Titulo do livro a remover: ");
                String nome = scanner.nextLine();
                List<Produto> produtosCorrespondentes = buscarPorDescricao(nome);

                if (produtosCorrespondentes.isEmpty()) {
                    System.out.println("Nenhum livro encontrado com este nome.");
                } else {
                    System.out.println("Livros encontrados:");
                    for (int i = 0; i < produtosCorrespondentes.size(); i++) {
                        System.out.println((i + 1) + ". " + produtosCorrespondentes.get(i).getNome());
                    }
                    System.out.print("Escolha o número do livro a remover: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    if (escolha > 0 && escolha <= produtosCorrespondentes.size()) {
                        removerProduto(produtosCorrespondentes.get(escolha - 1).getNome());
                        System.out.println("<----------------------------------->");
                        System.out.println("Produto removido com sucesso!");
                        System.out.println("<----------------------------------->\n");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (opcao == 3) {
                exibirProdutos();
            }else if (opcao == 4){
                relatorioProdutos();
            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}


