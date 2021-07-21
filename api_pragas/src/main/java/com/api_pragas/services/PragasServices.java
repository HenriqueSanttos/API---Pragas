package com.api_pragas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.Pragas;
import com.api_pragas.domain.Talhao;
import com.api_pragas.repository.IPragasRepository;
import com.api_pragas.repository.ITalhaoRepository;

@Service
public class PragasServices {
	
	@Autowired
	private IPragasRepository repPragas;
	
	@Autowired
	private ITalhaoRepository repTalhao;

	public List<Pragas> listarPragas(){
		return repPragas.findAll();
	}
	
	public Pragas listarPragasPorUuid(String uuid) {
		return repPragas.findByUuid(uuid);
	}
	
	public Pragas salvarPragas(Pragas p) {	
		p.setId( UUIDServices.genUUID() );
		return repPragas.save(p);
	}
	
	public boolean excluirPragas(String uuid) {
		Pragas p = repPragas.findByUuid(uuid);

		if ( p != null ) {
			repPragas.deleteById(p.getId());
			return true;
		}
		return false;
	}
	
	public boolean excluirTalhao(String uuid, Long idEnd) {
		Pragas p = repPragas.findByUuid(uuid);
        final Talhao t;
		
		if ( p != null ) {
			t = repTalhao.getById(idEnd);
			
			if (t != null && t.getPragas().getId() == p.getId()) {
				repTalhao.deleteById(t.getId());
				return true;
			}			
		} 
		return false;
		
	}
}
