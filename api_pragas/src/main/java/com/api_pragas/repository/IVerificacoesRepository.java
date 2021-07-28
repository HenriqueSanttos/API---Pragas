package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.Verificacoes;

@Repository
public interface IVerificacoesRepository extends JpaRepository<Verificacoes, Long> {

	Verificacoes findByUuid(String uuid);
	

}
