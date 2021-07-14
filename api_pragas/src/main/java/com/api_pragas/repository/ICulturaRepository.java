package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.Cultura;


@Repository
public interface ICulturaRepository extends JpaRepository<Cultura, Long>{
	
	Cultura getByNome(String nome);
	
	Cultura getByUuid(String uuid);

	Cultura findByUuid(String uuid);
	
	void deleteByUuid(String uuit);
	
}
