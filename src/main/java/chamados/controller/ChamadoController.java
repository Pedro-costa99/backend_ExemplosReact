package chamados.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import chamados.exception.ResourceNotFoundException;
import chamados.model.Chamado;
import chamados.service.ChamadoServiceInterface;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping
public class ChamadoController {	
	
	@Autowired
	ChamadoServiceInterface chamadoServiceInterface;
	
	@GetMapping("/dashboard")
	@ResponseStatus(HttpStatus.OK)
	public List<Chamado> getAllChamados(){	
		return chamadoServiceInterface.getChamados();
	}
	
	@GetMapping("dashboard/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Chamado> getChamadoById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {		
		Chamado chamado = chamadoServiceInterface.getChamado(id);
	    return ResponseEntity.ok().body(chamado);
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Chamado createChamado(@RequestBody Chamado chamado) throws ResourceNotFoundException {
		return this.chamadoServiceInterface.createChamado(chamado);
	}
	
	@PutMapping("/dashboard")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Chamado> updateChamado(@PathVariable(value = "id") Long id,
    	@Validated @RequestBody Chamado chamadoCaracteristicas) throws ResourceNotFoundException {
		Chamado chamado  = chamadoServiceInterface.updateChamado(id, chamadoCaracteristicas);        
        return ResponseEntity.ok(chamado);     
    }
	
	@DeleteMapping("/dashboard")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deleteChamado(@PathVariable(value = "id") Long id)  {
		chamadoServiceInterface.deleteChamado(id);       
	    Map<String, Boolean> resposta = new HashMap<>();
	    resposta.put("chamado deletado", Boolean.TRUE);
	    return resposta;
	}

}
