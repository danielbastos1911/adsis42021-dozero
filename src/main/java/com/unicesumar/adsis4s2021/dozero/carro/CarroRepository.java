package com.unicesumar.adsis4s2021.dozero.carro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarroRepository extends JpaRepository<Carro, String> {
	
	
	
	@Query(name = "qr_encontrar_nome_dto", nativeQuery = true)
	List<NomeDTO> encontrarNomes();

}
