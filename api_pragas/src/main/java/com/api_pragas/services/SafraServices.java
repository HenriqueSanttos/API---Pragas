package com.api_pragas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.Cultura;
import com.api_pragas.domain.Safra;
import com.api_pragas.repository.ICulturaRepository;
import com.api_pragas.repository.ISafraRepository;

@Service
public class SafraServices {
	
	@Autowired
	private ISafraRepository repSafra;
	
	@Autowired
	private ICulturaRepository repCultura;

	public List<Safra> listarSafra(){
		return repSafra.findAll();
	}
	
	public Safra listarSafraPorUuid(String uuid) {
		return repSafra.findByUuid(uuid);
	}
	
	public Safra salvarSafra(Safra s) {	
		s.setId( UUIDServices.genUUID() );
		return repSafra.save(s);
	}
	
	public boolean excluirSafra(String uuid) {
		Safra s = repSafra.findByUuid(uuid);

		if ( s != null ) {
			repSafra.deleteById(s.getId());
			return true;
		}
		return false;
	}
	
	public boolean excluirCultura(String uuid, Long idEnd) {
		Safra s = repSafra.findByUuid(uuid);
        final Cultura c;
		
		if ( s != null ) {
			c = repCultura.getById(idEnd);
			
			if (c != null && c.getSafra().getId() == s.getId()) {
				repCultura.deleteById(c.getId());
				return true;
			}			
		} 
		return false;
		
	}

}
