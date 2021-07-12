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

import com.api_pragas.domain.Safra;
import com.api_pragas.repository.ICulturaRepository;
import com.api_pragas.repository.ISafraRepository;


@RestController
@RequestMapping("/safras")
public class SafraResources {
	
	@Autowired
	private ISafraRepository repository;
	
	@Autowired
	private ICulturaRepository repCultura;
	
	@GetMapping
	public ResponseEntity<List<Safra>> listarSafra(){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@PostMapping()
	public ResponseEntity <Safra> salvarSafra(@RequestBody Safra s ) {

		s.setNome( s.getNome()+" "+ 
	               this.repCultura.getById( s.getCultura().getId() ).getNome() );
		
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(s));
			
	}
}
