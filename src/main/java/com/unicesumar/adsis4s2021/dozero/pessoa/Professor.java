package com.unicesumar.adsis4s2021.dozero.pessoa;

import javax.persistence.Entity;

@Entity
public class Professor extends Papel {
	private String ctps;
	
	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	
}

