package vtmc.sandeliosistema.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vtmc.sandeliosistema.dao.ClientDao;
import vtmc.sandeliosistema.domain.Client;
import vtmc.sandeliosistema.domain.ClientType;
import vtmc.sandeliosistema.dto.ClientDto;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	public ResponseEntity<?> createClient(ClientDto clientDto) {
		
		Client existingClient = clientDao.findByNameAndSurnameAndDate(clientDto.getName(), clientDto.getSurname(),
				clientDto.getDate());
		
		if(existingClient != null) {
			
			return new ResponseEntity<>("A client with such name, surname and birthday already exists",
					HttpStatus.UNAUTHORIZED);
			
		} else {
		
		Client client = new Client();
		client.setName(clientDto.getName());
		client.setSurname(clientDto.getSurname());
		client.setDate(clientDto.getDate());
		client.setPhone(clientDto.getPhone());
		client.setType(ClientType.valueOf(clientDto.getType()));
		
		clientDao.save(client);
		
		return new ResponseEntity<>("New client with id " + client.getId() + " successfully saved", HttpStatus.OK);
		
		}
	}
	
	public List<ClientDto> getClients(){
		
		List<Client> clients = clientDao.findAll();
		List<ClientDto> clientDtos = clients.stream().map(client ->
			
			new ClientDto(client.getId(), client.getName(), client.getSurname(), client.getDate(), client.getPhone(),
					client.getType().name()))
				.collect(Collectors.toList());
		
		return clientDtos;
	}

}
