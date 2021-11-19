package com.unicesumar.adsis4s2021.dozero.pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

	
	@Query(value = "select p.papeis from Pessoa p where p.id = :idDaPessoa")
	List<Papel> obterPapéis(String idDaPessoa);

}
