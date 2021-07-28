package com.api_pragas.domain;


import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PragasEncontradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int qntd;
	
	@ManyToOne
	private Pragas pragas;
	
	@ManyToOne
	private Verificacoes verificacoes;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false,
			columnDefinition = "varchar(36) not null")
	private String uuid;
	
	public PragasEncontradas() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQntd() {
		return qntd;
	}

	public void setQntd(int qntd) {
		this.qntd = qntd;
	}
	
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	

	public Pragas getPragas() {
		return pragas;
	}

	public void setPragas(Pragas pragas) {
		this.pragas = pragas;
	}

	public Verificacoes getVerificacoes() {
		return verificacoes;
	}

	public void setVerificacoes(Verificacoes verificacoes) {
		this.verificacoes = verificacoes;
	}
	
	
	
	
}
