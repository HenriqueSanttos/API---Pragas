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

import com.api_pragas.domain.PragasEncontradas;
import com.api_pragas.repository.IPragasEncontradasRepository;
import com.api_pragas.repository.IPragasRepository;

@RestController
@RequestMapping("/v2/pragasencontradas")
public class PragasEncontradasResources {
	
	@Autowired
	private IPragasEncontradasRepository repository;
	
	@Autowired
	private IPragasRepository repPragas;
	
	@GetMapping
	public ResponseEntity<List<PragasEncontradas>>ListarPragasEncontradas(){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	

	
	@PostMapping()
	public ResponseEntity<PragasEncontradas> salvarPragasEncontradasPragas(@RequestBody PragasEncontradas P) {
	               this.repPragas.getById( P.getPragas().getId() ).getNome();
		
		return ResponseEntity.
				status(HttpStatus.OK).body(this.repository.save(P));
	}
	
	
}
