package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.Safra;

@Repository
public interface ISafraRepository extends JpaRepository<Safra, Long> {
	Safra getByNome(String nome);
	
	Safra getByUuid(String uuid);

	Safra findByUuid(String uuid);
	
	void deleteByUuid(String uuit);

}
