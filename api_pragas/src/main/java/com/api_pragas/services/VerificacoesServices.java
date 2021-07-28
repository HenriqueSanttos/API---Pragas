package com.api_pragas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_pragas.domain.Verificacoes;
import com.api_pragas.repository.IVerificacoesRepository;

@Service
public class VerificacoesServices {
	
	@Autowired
	private IVerificacoesRepository repVerificacoes;
	

	public List<Verificacoes> listarVerificacoes(){
		return repVerificacoes.findAll();
	}
	
	public Verificacoes listarVerificacoesPorUuid(String uuid) {
		return repVerificacoes.findByUuid(uuid);
	}
	
	public Verificacoes salvarVerificacoes(Verificacoes v) {	
		v.setUuid( UUIDServices.genUUID() );
		return repVerificacoes.save(v);
	}
	


}


