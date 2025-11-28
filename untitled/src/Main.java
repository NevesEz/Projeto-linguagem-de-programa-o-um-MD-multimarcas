import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();

        while (true) {
            System.out.println("\n=== SISTEMA DE LOJA ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("5 - Cadastrar produto");
            System.out.println("6 - Listar produtos");
            System.out.println("7 - Atualizar produto");
            System.out.println("8 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir o enter

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    clienteService.criarCliente(nome, cpf, telefone, endereco);
                    System.out.println("Cliente cadastrado!");
                }
                case 2 -> {
                    System.out.println("\n=== CLIENTES ===");
                    for (Cliente c : clienteService.listarClientes()) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }
                }
                case 3 -> {
                    System.out.print("ID do cliente: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    if (clienteService.atualizarCliente(id, nome, cpf, telefone, endereco)) {
                        System.out.println("Cliente atualizado!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case 4 -> {
                    System.out.print("ID do cliente: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    if (clienteService.deletarCliente(id)) {
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                }
                case 5 -> {
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    produtoService.criarProduto(nome, descricao, preco, qtd);
                    System.out.println("Produto cadastrado!");
                }
                case 6 -> {
                    System.out.println("\n=== PRODUTOS ===");
                    for (Produto p : produtoService.listarProdutos()) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - R$" + p.getPreco() + " (Estoque: " + p.getQuantidade() + ")");
                    }
                }
                case 7 -> {
                    System.out.print("ID do produto: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    if (produtoService.atualizarProduto(id, nome, descricao, preco, qtd)) {
                        System.out.println("Produto atualizado!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                }
                case 8 -> {
                    System.out.print("ID do produto: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    if (produtoService.deletarProduto(id)) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                }
                case 0 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
