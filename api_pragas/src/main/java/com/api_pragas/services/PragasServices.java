package com.api_pragas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.Pragas;
import com.api_pragas.repository.IPragasRepository;

@Service
public class PragasServices {
	@Autowired
	private IPragasRepository repository;
	
	public boolean salvarPragas(Pragas p) {
		if( this.repository.save(p) != null) {
			return true;
		}
		return false;
	}

}
