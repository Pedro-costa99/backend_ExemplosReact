package chamados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import chamados.model.Perfil;
import chamados.service.Impl.PerfilServiceInterfaceImpl;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/profile")
public class PerfilController {	
	
	@Autowired
	PerfilServiceInterfaceImpl perfilServiceInterface;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil createPerfil(@RequestBody Perfil perfil) {
		return this.perfilServiceInterface.createPerfil(perfil);
	}
	

}
