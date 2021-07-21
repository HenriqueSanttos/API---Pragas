package com.api_pragas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_pragas.domain.Verificacoes;
import com.api_pragas.repository.ITalhaoRepository;
import com.api_pragas.repository.IVerificacoesRepository;

@RestController
@RequestMapping("/v2/verificacoes")
public class VerificacoesResources {

	@Autowired
	private IVerificacoesRepository repository;
	
	@Autowired
	private ITalhaoRepository repTalhao;
	

	
	
	@GetMapping
	public ResponseEntity<List<Verificacoes>>listarVerificacoesTalhoes(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@PostMapping()
	public ResponseEntity<Verificacoes> salvarVerificacoesTalhoes(@RequestBody Verificacoes v) {
	               this.repTalhao.getById( v.getTalhao().getId() ).getArea();
		
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(v));
	}
	
	
	
	
	
	
	
	
	
	
}
	
