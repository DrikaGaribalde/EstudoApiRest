package org.serratec.backend.controller;

import org.serratec.backend.dto.ClienteDTO;
import org.serratec.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
//	@GetMapping
//	public ResponseEntity<List<ClienteDTO>>getAll(@RequestParam(name="ordenar", required = false, defaultValue = "id") String nome){
//		return new ResponseEntity<List<ClienteDTO>>(clienteService.findAllCliente(nome),HttpStatus.OK);
//	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO>create(@RequestBody ClienteDTO dto){
		return new ResponseEntity<ClienteDTO>(clienteService.create(dto),HttpStatus.OK);
	}
}
