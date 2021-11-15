package com.unicesumar.adsis4s2021.dozero.carro;

import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.unicesumar.adsis4s2021.dozero.marca.Marca;


@Entity
@NamedNativeQuery(
		   name = "qr_encontrar_nome_dto",
		   query = "SELECT modelo from carro",
		   resultSetMapping = "rs_mapping_nome_dto"
		)
@SqlResultSetMapping(
	    name = "rs_mapping_nome_dto",
	    classes = @ConstructorResult(
	        targetClass = NomeDTO.class,
	        columns = {
	            @ColumnResult(name = "modelo", type = String.class)
	        }
	    )
	)
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
	
	@ManyToOne
	private Marca marca;
	
	//@JsonFormat(pattern="HOURS")
	private Duration tempoDeMontagem;
	
	
	
	
	public Carro() {
		id = UUID.randomUUID().toString();
	}
	
		
	public Carro(String id, String modelo, Integer anoDeFabricacao, String placa, String codigoRenavam,
			Integer quilometragem, TipoDeCombustível tipoDeCombustivel, Marca marca, Duration tempoDeMontagem) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.codigoRenavam = codigoRenavam;
		this.quilometragem = quilometragem;
		this.tipoDeCombustivel = tipoDeCombustivel;
		this.marca = marca;
		this.tempoDeMontagem = tempoDeMontagem;
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
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public Marca getMarca() {
		return marca;
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

