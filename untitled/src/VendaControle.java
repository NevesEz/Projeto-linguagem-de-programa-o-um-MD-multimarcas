import Cliente.java
import ClienteService.java
import java.until.list

public class VendaControle {

  private final VendaService service = new VendaService();
  private final ProdutoService produtoService = new ProdutoService();
  private final NotaFiscalService notaService = new NotaFiscalService();

 public NotaFiscal realizarVenda(Venda venda) {
    vendaService.registrar(venda);
    produtoService.atualizarEstoque(venda.getProduto(), venda.getQuantidade());
    return notaService.emitirNota(venda);
  }

  public double exibirTotalDeVendas() { return vendaService.totalVendas(); }
}
