package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.Pragas;


@Repository
public interface IPragasRepository extends JpaRepository<Pragas, Long>{
	
	Pragas getByNome(String nome);
	
	Pragas getByUuid(String uuid);

	Pragas findByUuid(String uuid);
	
	void deleteByUuid(String uuit);
	
}
