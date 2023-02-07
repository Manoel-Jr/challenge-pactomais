package br.com.api.conta.bancaria.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.conta.bancaria.dto.CorrentistaDTO;
import br.com.api.conta.bancaria.entity.Correntista;
import br.com.api.conta.bancaria.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaRest {

	@Autowired
	private CorrentistaService correntistaService;
	
	@PostMapping("/cadastrar-correntista")
	public ResponseEntity<CorrentistaDTO> cadastrar(@RequestBody Correntista correntista){
		return new ResponseEntity<>(correntistaService.criar(correntista),HttpStatus.CREATED);
	}
	
	@GetMapping("/consultar-correntista-via-cpf/{cpf}")
	public ResponseEntity<CorrentistaDTO> consultar(@PathVariable String cpf){
		return new ResponseEntity<>(correntistaService.consultar(cpf),HttpStatus.CREATED);
	}
}
