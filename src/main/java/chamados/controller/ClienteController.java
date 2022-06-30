package chamados.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import chamados.exception.ResourceNotFoundException;
import chamados.model.Cliente;
import chamados.service.ClienteServiceInterface;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/costumers")
public class ClienteController {	
	
	@Autowired
	ClienteServiceInterface clienteServiceInterface;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> getAllClientes(){	
		return clienteServiceInterface.getClientes();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {		
		Cliente cliente = clienteServiceInterface.getCliente(id);
	    return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return this.clienteServiceInterface.createCliente(cliente);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Long id,
    	@Validated @RequestBody Cliente clienteDescricao) throws ResourceNotFoundException {
		Cliente cliente = clienteServiceInterface.updateCliente(id, clienteDescricao);
        return ResponseEntity.ok(cliente);     
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> deleteCliente(@PathVariable(value = "id") Long id)  {
		clienteServiceInterface.deleteCliente(id);       
	    Map<String, Boolean> resposta = new HashMap<>();
	    resposta.put("cliente removido", Boolean.TRUE);
	    return resposta;
	}
}
