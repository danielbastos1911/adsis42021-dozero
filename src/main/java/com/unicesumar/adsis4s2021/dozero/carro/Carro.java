package com.unicesumar.adsis4s2021.dozero.carro;

import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Entity
public class Carro {
	@Id
	private String id;
		
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private Integer anoDeFabricacao;
	
	@Column(unique = true, nullable = false)
	private String placa;
	
	@Column(unique = true, nullable = false)
	private String codigoRenavam;
	
	@Column(nullable = false)
	private Integer quilometragem;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDeCombustível tipoDeCombustivel = TipoDeCombustível.FLEX;
	
	private Duration tempoDeMontagem;
	
	public Carro() {
		id = UUID.randomUUID().toString();
		System.out.println("Olha, criando um carro com id: " + id);
	}
	
	public Duration getTempoDeMontagem() {
		return tempoDeMontagem;
	}
	public void setTempoDeMontagem(Duration tempoDeMontagem) {
		this.tempoDeMontagem = tempoDeMontagem;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCodigoRenavam() {
		return codigoRenavam;
	}

	public void setCodigoRenavam(String codigoRenavam) {
		this.codigoRenavam = codigoRenavam;
	}

	public int getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getId() {
		return id;
	}
	
	public TipoDeCombustível getTipoDeCombustivel() {
		return tipoDeCombustivel;
	}
	
	public void setTipoDeCombustivel(TipoDeCombustível tipoDeCombustivel) {
		this.tipoDeCombustivel = tipoDeCombustivel;
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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}
		
}

