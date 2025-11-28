import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private Long contadorId = 1L;

    public Produto criarProduto(String nome, String descricao, double preco, int quantidade) {
        Produto produto = new Produto(contadorId++, nome, descricao, preco, quantidade);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarPorId(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean atualizarProduto(Long id, String nome, String descricao, double preco, int quantidade) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            return true;
        }
        return false;
    }

    public boolean deletarProduto(Long id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }
}
