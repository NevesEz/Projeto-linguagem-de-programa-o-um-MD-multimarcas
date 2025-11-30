import java.util.List;

public class VendaControle {

    private final VendaService vendaService;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final NotaFiscalService notaService;


    public VendaControle(ProdutoService produtoService, ClienteService clienteService,
                         VendaService vendaService, NotaFiscalService notaService) {
        this.produtoService = produtoService;
        this.clienteService = clienteService;
        this.vendaService = vendaService;
        this.notaService = notaService;
    }


    public NotaFiscal realizarVenda(Venda venda) {
        vendaService.registrar(venda);
        produtoService.atualizarEstoque(venda.getProduto(), venda.getQuantidade());
        return notaService.emitirNota(venda);
    }


    public double exibirTotalDeVendas() {
        return vendaService.totalVendas();
    }


    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }
}
