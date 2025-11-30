public class NotaFiscal {
  private Long id;
  private Venda venda;
  private String detalhes;


  public NotaFiscal(Long id, Venda venda) {
    this.id = id;
    this.venda = venda;
    this.detalhes = gerarDetalhes();
  }


  private String gerarDetalhes() {
    return "Nota Fiscal - Venda " + venda.getId() +
              "
Cliente: " + venda.getCliente().getNome() +
              "
Produto: " + venda.getProduto().getNome() +
              "
Quantidade: " + venda.getQuantidade() +
              "
Valor Total: R$ " + (venda.getProduto().getPreco() * venda.getQuantidade());
}


  public String getDetalhes() { return detalhes; }
}
