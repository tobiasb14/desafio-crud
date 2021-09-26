package br.com.bootcamp.desafiocrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bootcamp.desafiocrud.dto.ClientDTO;
import br.com.bootcamp.desafiocrud.entity.Client;
import br.com.bootcamp.desafiocrud.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageable) {
		return clientRepository.findAll(pageable).map(client -> new ClientDTO(client));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		return new ClientDTO(clientRepository.findById(id).get());
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDTO) {
		Client client = new Client();
		return new ClientDTO(clientRepository.save(resolveClient(client, clientDTO)));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDTO) {
		Client client = resolveClient(clientRepository.getOne(id), clientDTO);
		return new ClientDTO(clientRepository.save(client));
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
	private Client resolveClient(Client client, ClientDTO clientDTO) {
		client.setName(clientDTO.getName());
		client.setCpf(clientDTO.getCpf());
		client.setIncome(clientDTO.getIncome());
		client.setBirthdate(clientDTO.getBirthDate());
		client.setChildren(clientDTO.getChildren());
		return client;
	}

}
