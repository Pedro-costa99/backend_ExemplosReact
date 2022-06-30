package chamados.service;

import java.util.List;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Perfil;

public interface PerfilServiceInterface {
	public Perfil createPerfil(Perfil perfil);
	public Perfil updatePerfil(Long id, Perfil perfil) throws ResourceNotFoundException;
	public void deletePerfil(Long id);
	public List<Perfil> getPerfis();
	public Perfil getPerfil(Long id) throws ResourceNotFoundException;
}
