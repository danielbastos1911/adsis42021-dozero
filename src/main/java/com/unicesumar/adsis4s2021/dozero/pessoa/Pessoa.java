package com.unicesumar.adsis4s2021.dozero.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.unicesumar.adsis4s2021.dozero.base.BaseEntity;

@Entity
public class Pessoa extends BaseEntity {
	private String nome;
	private String email;
	
	@OneToMany
	private List<Papel> papeis = new ArrayList<>();
		
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
