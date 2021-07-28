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


import com.api_pragas.domain.Safra;
import com.api_pragas.services.SafraServices;


@RestController
@RequestMapping("/v2/safras")
public class SafraResources {
	
	@Autowired
	private SafraServices svc;
	
	
	@GetMapping
	public ResponseEntity<List<Safra>> listarSafra(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body(svc.listarSafra());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Safra> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( svc.listarSafraPorUuid(uuid) );
	}
	
	
	
	@PostMapping()
	public ResponseEntity<Safra> salvarSafra(@RequestBody Safra s) {

		return ResponseEntity.
				status(HttpStatus.OK).
				body( this.svc.salvarSafra(s) );
		
	}
	
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<Void> excluirSafra(@PathVariable String uuid){
		if (svc.excluirSafra(uuid)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	public void atualizarNome() {}
	
	


}

