import Cliente.java
import ClienteService.java
import java.until.list

public class VendaControle {

  private final VendaService service = new VendaService();

  public void registrarVenda(Venda venda) {
    service.registrar(venda);
  }

  public double exibirTotalDeVendas() {
    return service.totalVendas();
  }

  public List<Venda> listarVendas() {
    return service.listar();
  }
}
