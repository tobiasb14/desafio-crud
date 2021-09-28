package br.com.bootcamp.desafiocrud.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bootcamp.desafiocrud.dto.ClientDTO;
import br.com.bootcamp.desafiocrud.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAllPaged(Pageable pageable) {
		
		return ResponseEntity.ok(clientService.findAllPaged(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO clientDTO) {
		ClientDTO dto = clientService.insert(clientDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
		return ResponseEntity.ok(clientService.update(id, clientDTO));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
