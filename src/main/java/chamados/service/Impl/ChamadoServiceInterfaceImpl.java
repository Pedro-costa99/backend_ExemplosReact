package chamados.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Chamado;
import chamados.model.Cliente;
import chamados.repository.ChamadoRepository;
import chamados.repository.ClienteRepository;
import chamados.service.ChamadoServiceInterface;

@Service

public class ChamadoServiceInterfaceImpl implements ChamadoServiceInterface{

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public Chamado createChamado(Chamado chamado) throws ResourceNotFoundException{
		Cliente cliente = this.clienteRepository.findById(chamado.getClienteId())
				.orElseThrow(() -> new ResourceNotFoundException("ClienteDTO não encontrado para o ID :: " + chamado.getClienteId()));
		Chamado chamadoAtual = new Chamado(cliente.getId(), chamado.getNomeCliente(), chamado.getAssunto(), chamado.getComplemento(), chamado.getStatus());
		chamadoAtual = this.chamadoRepository.save(chamadoAtual);
		return chamadoAtual;	
	}

	@Override
	@Transactional
	public Chamado updateChamado(Long id, Chamado chamado) throws ResourceNotFoundException {
		Chamado chamadoAtual = this.chamadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ChamadoDTO não encontrado para o ID :: " + id));
		chamadoAtual.setAssunto(chamado.getAssunto());
		chamadoAtual.setCadastradoEm();
		chamadoAtual.setClienteId(chamado.getClienteId());
		chamadoAtual.setComplemento(chamado.getComplemento());
		chamadoAtual.setNomeCliente(chamado.getNomeCliente());
		chamadoAtual.setStatus(chamado.getStatus());
		chamadoAtual = this.chamadoRepository.save(chamadoAtual);
		return chamadoAtual;	
	}

	@Override
	@Transactional
	public void deleteChamado(Long id) {
		this.chamadoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public List<Chamado> getChamados() {		
		return this.chamadoRepository.findAll();
	}

	@Override
	@Transactional
	public Chamado getChamado(Long id) throws ResourceNotFoundException {
		Chamado chamado = chamadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ChamadoDTO não encontrado para o ID :: " + id));
		return chamado;	
	}

}
