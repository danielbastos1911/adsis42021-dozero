package com.unicesumar.adsis4s2021.dozero.carro;

import java.time.Duration;
import java.util.UUID;

public class PostCarroDTO {
	private String id;
	private String modelo;
	private Integer anoDeFabricacao;
	private String placa;
	private String codigoRenavam;
	private Integer quilometragem;
	private TipoDeCombustível tipoDeCombustivel = TipoDeCombustível.FLEX;
	private String idMarca;
	private Duration tempoDeMontagem;

	public PostCarroDTO(String id, String modelo, Integer anoDeFabricacao, String placa, String codigoRenavam,
			Integer quilometragem, TipoDeCombustível tipoDeCombustivel, String idMarca, Duration tempoDeMontagem) {
		super();		
		this.id = id;
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
		}
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.codigoRenavam = codigoRenavam;
		this.quilometragem = quilometragem;
		this.tipoDeCombustivel = tipoDeCombustivel;
		if (this.tipoDeCombustivel == null) {
			this.tipoDeCombustivel = TipoDeCombustível.FLEX;
		}
		this.idMarca = idMarca;
		this.tempoDeMontagem = tempoDeMontagem;
	}

	public Duration getTempoDeMontagem() {
		return tempoDeMontagem;
	}

	public String getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCodigoRenavam() {
		return codigoRenavam;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public TipoDeCombustível getTipoDeCombustivel() {
		return tipoDeCombustivel;
	}

	public String getIdMarca() {
		return idMarca;
	}

}
