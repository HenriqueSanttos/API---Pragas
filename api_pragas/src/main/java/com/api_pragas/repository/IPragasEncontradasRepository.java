package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.PragasEncontradas;

@Repository
public interface IPragasEncontradasRepository extends JpaRepository<PragasEncontradas, Long> {
	
	PragasEncontradas findByUuid(String uuid);
}

