package com.api_pragas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.PragasEncontradas;
import com.api_pragas.repository.IPragasEncontradasRepository;


@Service
public class PragasEncontradasServices {
	
	@Autowired
	private IPragasEncontradasRepository repPragasEncontradas;
	

	public List<PragasEncontradas> listarPragasEncontradas(){
		return repPragasEncontradas.findAll();
	}
	
	public PragasEncontradas listarPragasEncontradasPorUuid(String uuid) {
		return repPragasEncontradas.findByUuid(uuid);
	}
	
	public PragasEncontradas salvarPragasEncontradas(PragasEncontradas e) {	
		e.setUuid( UUIDServices.genUUID() );
		return repPragasEncontradas.save(e);
	}
	

}
