package chamados.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Cliente;
import chamados.repository.ClienteRepository;
import chamados.service.ClienteServiceInterface;

@Service
public class ClienteServiceInterfaceImpl implements ClienteServiceInterface{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public Cliente createCliente(Cliente cliente) {
		Cliente clienteAtual = new Cliente(cliente.getNome(), 
				cliente.getCnpj(), cliente.getEndereco());
		clienteAtual = this.clienteRepository.save(clienteAtual);
		return clienteAtual;	
	}

	@Override
	@Transactional
	public Cliente updateCliente(Long id, Cliente cliente) throws ResourceNotFoundException {

		Cliente clienteAtual = this.clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ClienteDTO não encontrado para o ID :: " + id));
		clienteAtual.setEndereco(cliente.getEndereco());
		clienteAtual.setNome(cliente.getNome());
		clienteAtual.setCnpj(cliente.getCnpj());
		clienteAtual.setChamados(cliente.getChamados());
		clienteAtual = this.clienteRepository.save(clienteAtual);
		return clienteAtual;	
	}

	@Override
	@Transactional
	public void deleteCliente(Long id) {
		this.clienteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente getCliente(Long id) throws ResourceNotFoundException {	
			Cliente cliente = this.clienteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("ClienteDTO não encontrado para o ID :: " + id));
		return cliente;	
	}

}
