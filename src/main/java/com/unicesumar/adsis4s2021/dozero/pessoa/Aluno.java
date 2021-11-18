package com.unicesumar.adsis4s2021.dozero.pessoa;

import javax.persistence.Entity;

@Entity
public class Aluno extends Papel {
	private String ra;
	
	public String getRa() {
		return ra;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}

}
