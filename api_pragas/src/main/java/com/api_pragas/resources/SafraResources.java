package com.api_pragas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_pragas.domain.Cultura;
import com.api_pragas.domain.Safra;
import com.api_pragas.repository.ICulturaRepository;
import com.api_pragas.repository.ISafraRepository;


@RestController
@RequestMapping("/v2/safras")
public class SafraResources {
	
	@Autowired
	private ISafraRepository repository;
	
	@Autowired
	private ICulturaRepository repCultura;
	
	@GetMapping
	public ResponseEntity<List<Safra>> listarSafra(){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Safra> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( repository.getByUuid(uuid) );
	}
	
//	@PostMapping()
//	public ResponseEntity <Safra> salvarSafra(@RequestBody Safra s ) {
//		s.setNome( s.getNome()+" "+ 
//	               this.repCultura.getById (s.getCultura().getId()).getNome());
//		return ResponseEntity.
//				status(HttpStatus.OK).body(this.repository.save(s));
//			
//	}

//	public ResponseEntity <Safra> salvarSafra(@PathVariable String uuid, 
//											  @RequestBody Cultura cultura){
//		Safra s = repositorySafra.getByUuid(uuid);
//		
//		if (s != null) {
//			cultura.setSafra();
//			
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(this.repository.save(s));
//	}
	
	@PostMapping()
	public ResponseEntity <Safra> salvarSafra(@RequestBody Safra s ) {
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(s));
			
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirSafras(@PathVariable String uuid){
		Safra s = repository.findByUuid(uuid);
		
		if (s != null) {
			repository.deleteById(s.getId());
		}
		
		return ResponseEntity.noContent().build();
	}

}

