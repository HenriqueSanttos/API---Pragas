package com.api_pragas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_pragas.domain.Talhao;

@Repository
public interface ITalhaoRepository extends JpaRepository<Talhao, Long>{
	
	
}
