package chamados.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Perfil;
import chamados.repository.PerfilRepository;
import chamados.service.PerfilServiceInterface;

@Service
public class PerfilServiceInterfaceImpl implements PerfilServiceInterface{

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	@Transactional
	public Perfil createPerfil(Perfil perfil) {
		Perfil perfilAtual = new Perfil(perfil.getNome(), 
				perfil.getEmail(), perfil.getFoto());
		perfilAtual = this.perfilRepository.save(perfilAtual);		
		return perfilAtual;	
	}

	@Override
	@Transactional
	public Perfil updatePerfil(Long id, Perfil perfil) throws ResourceNotFoundException {

		Perfil perfilAtual = this.perfilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ClienteDTO não encontrado para o ID :: " + id));		
		perfilAtual.setNome(perfil.getNome());
		perfilAtual.setEmail(perfil.getEmail());
		perfilAtual.setFoto(perfil.getFoto());
		perfilAtual = this.perfilRepository.save(perfilAtual);
		return perfilAtual;	
	}

	@Override
	@Transactional
	public void deletePerfil(Long id) {
		this.perfilRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public List<Perfil> getPerfis() {
		return this.perfilRepository.findAll();
	}

	@Override
	@Transactional
	public Perfil getPerfil(Long id) throws ResourceNotFoundException {

		Perfil perfil = this.perfilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ClienteDTO não encontrado para o ID :: " + id));
		return perfil;	
	}

}
