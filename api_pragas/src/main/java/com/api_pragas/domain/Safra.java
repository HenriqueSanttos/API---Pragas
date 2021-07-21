package com.api_pragas.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Safra {
	
	@JsonIgnore
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("uuid")
	@Column(name = "ext_uuid", updatable = false,
				columnDefinition = "varchar(36) not null")
	private String uuid;
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JoinColumn(name = "safra_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cultura> cultura = new ArrayList<>();
	
	public Safra() {
		UUID uuid_ = UUID.randomUUID();
		this.uuid = uuid_.toString(); 
	}

	public List<Cultura> getCultura() {
		return cultura;
	}

	public void setEnderecos(List<Cultura> Cultura) {
		this.cultura = Cultura;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
