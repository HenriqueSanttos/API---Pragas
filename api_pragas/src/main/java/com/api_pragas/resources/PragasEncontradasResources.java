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

import com.api_pragas.domain.PragasEncontradas;
import com.api_pragas.services.PragasEncontradasServices;

@RestController
@RequestMapping("/v2/pragasencontradas")
public class PragasEncontradasResources {
	

	
	@Autowired
	private PragasEncontradasServices svc;
	
	@GetMapping
	public ResponseEntity<List<PragasEncontradas>> listarPragasEncontradas(){
		return ResponseEntity.
				status(HttpStatus.OK).
				body(svc.listarPragasEncontradas());
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<PragasEncontradas> buscarPorUuid(@PathVariable String uuid) {	
       	return ResponseEntity.
			   status(HttpStatus.OK).
			   body( svc.listarPragasEncontradasPorUuid(uuid) );
	}
	
	@PostMapping()
	public ResponseEntity<PragasEncontradas> salvarPragasEncontradas(@RequestBody PragasEncontradas e) {

		return ResponseEntity.
				status(HttpStatus.OK).
				body( this.svc.salvarPragasEncontradas(e) );
		
	}
	
	
}
