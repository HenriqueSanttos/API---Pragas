package com.api_pragas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api_pragas.domain.Verificacoes;
import com.api_pragas.services.VerificacoesServices;

@RestController
@RequestMapping("/v2/verificacoes")
public class VerificacoesResources {

	@Autowired
	private VerificacoesServices svc;
	
	@GetMapping
	public ResponseEntity<List<Verificacoes>> listarVerificacoes(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body(svc.listarVerificacoes());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Verificacoes> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( svc.listarVerificacoesPorUuid(uuid) );
	}
	
	@PostMapping()
	public ResponseEntity<Verificacoes> salvarVerificacoes(@RequestBody Verificacoes v) {

		return ResponseEntity.
				status(HttpStatus.OK).
				body( this.svc.salvarVerificacoes(v) );
		
	}
	

	
	

	
	
	
	
	
}
	
