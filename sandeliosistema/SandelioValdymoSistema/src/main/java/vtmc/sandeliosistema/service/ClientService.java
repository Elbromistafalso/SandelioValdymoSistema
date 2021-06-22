package vtmc.sandeliosistema.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vtmc.sandeliosistema.dao.ClientDao;
import vtmc.sandeliosistema.dao.InventoryDao;
import vtmc.sandeliosistema.domain.Client;
import vtmc.sandeliosistema.domain.ClientType;
import vtmc.sandeliosistema.domain.Inventory;
import vtmc.sandeliosistema.dto.ClientDto;
import vtmc.sandeliosistema.dto.InventoryDto;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private InventoryDao inventoryDao;
	
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
	
	public ResponseEntity<?> addInventury(InventoryDto inventuryDto, Long clientId){
		
		Client client = clientDao.getOne(clientId);
		
		Inventory inventory = new Inventory();
		inventory.setName(inventuryDto.getName());
		inventory.setWeight(inventory.getWeight());
		inventory.setSector(inventory.getSector());
		Date date = java.util.Date.from(LocalDateTime.now()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
		inventory.setDate(date);
		inventoryDao.save(inventory);
		inventory.addClient(client);
		
		return new ResponseEntity<>("New Inventory named " + inventory.getName() + " successfully saved"
				+ " and added to client with id " + client.getId(), HttpStatus.OK);
		
		
		
		
	}
	
	
	
	public List<ClientDto> getClients(){
		
		List<Client> clients = clientDao.findAll();
		List<ClientDto> clientDtos = clients.stream().map(client ->
			
			new ClientDto(client.getId(), client.getName(), client.getSurname(), client.getDate(), client.getPhone(),
					client.getType().name(), client.getInventoryList().size()))
				.collect(Collectors.toList());
		
		return clientDtos;
	}
	
	public ClientDto getClient(Long clientId) {
		
		Client client = clientDao.getOne(clientId);
		ClientDto clientDto = new ClientDto();
		clientDto.setName(client.getName());
		clientDto.setSurname(client.getSurname());
		clientDto.setDate(client.getDate());
		clientDto.setPhone(clientDto.getPhone());
		clientDto.setType(clientDto.getType());
		
		return clientDto;
		
	}

}
