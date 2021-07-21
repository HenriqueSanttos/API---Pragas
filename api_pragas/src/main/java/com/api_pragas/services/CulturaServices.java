package com.api_pragas.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.Cultura;
import com.api_pragas.repository.ICulturaRepository;

@Service
public class CulturaServices {

	@Autowired
	private ICulturaRepository repository;
	
	public boolean salvarCultura(Cultura c) {
		if( this.repository.save(c) != null) {
			return true;
		}
		return false;
	}
}
