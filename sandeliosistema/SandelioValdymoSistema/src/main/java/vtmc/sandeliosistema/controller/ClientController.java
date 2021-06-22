package vtmc.sandeliosistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vtmc.sandeliosistema.dto.ClientDto;
import vtmc.sandeliosistema.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(path = "/clients/new", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }
	
	@RequestMapping(path = "/clients", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }


}
