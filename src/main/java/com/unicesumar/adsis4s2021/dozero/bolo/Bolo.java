package com.unicesumar.adsis4s2021.dozero.bolo;

import javax.persistence.Entity;

import com.unicesumar.adsis4s2021.dozero.base.BaseEntity;

@Entity
public class Bolo extends BaseEntity {
	private String nome;

	public Bolo() {
		super();
	}

	public String getNome() {
		return nome;
	}
	
}
