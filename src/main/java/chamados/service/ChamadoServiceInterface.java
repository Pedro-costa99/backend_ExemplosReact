package chamados.service;

import java.util.List;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Chamado;

public interface ChamadoServiceInterface {
	public Chamado updateChamado(Long id, Chamado chamado) throws ResourceNotFoundException;
	public void deleteChamado(Long id);
	public List<Chamado> getChamados();
	public Chamado getChamado(Long id) throws ResourceNotFoundException;
	public Chamado createChamado(Chamado chamado) throws ResourceNotFoundException;
}
