package com.unicesumar.adsis4s2021.dozero.meu.caneca;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Caneca {
	@Id
	private String id;

	@Column(nullable = false)
	private String modelo; // cor simples = simples, colorida = personalizada

	@Column(nullable = false)
	private Integer anoDeFabricacao;

	@Column(unique = true, nullable = false)
	private String ean; // código de barras EAN/GTIN

	public Caneca() {
		id = UUID.randomUUID().toString();
		System.out.println("Criando uma caneca de ID: " + id);
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(Integer anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caneca other = (Caneca) obj;
		return Objects.equals(id, other.id);
	}

}
