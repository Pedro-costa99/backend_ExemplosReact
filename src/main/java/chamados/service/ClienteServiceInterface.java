package chamados.service;

import java.util.List;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Cliente;

public interface ClienteServiceInterface {
	public Cliente createCliente(Cliente cliente);
	public Cliente updateCliente(Long id, Cliente cliente) throws ResourceNotFoundException;
	public void deleteCliente(Long id);
	public List<Cliente> getClientes();
	public Cliente getCliente(Long id) throws ResourceNotFoundException;
}
