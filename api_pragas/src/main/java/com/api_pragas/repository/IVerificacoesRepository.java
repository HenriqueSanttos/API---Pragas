package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_pragas.domain.Verificacoes;

public interface IVerificacoesRepository extends JpaRepository<Verificacoes, Long> {
	
}
