import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();
    private Long contadorId = 1L;

    public Cliente criarCliente(String nome, String cpf, String telefone, String endereco) {
        Cliente cliente = new Cliente(contadorId++, nome, cpf, telefone, endereco);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarPorId(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean atualizarCliente(Long id, String nome, String cpf, String telefone, String endereco) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            return true;
        }
        return false;
    }

    public boolean deletarCliente(Long id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }
}
