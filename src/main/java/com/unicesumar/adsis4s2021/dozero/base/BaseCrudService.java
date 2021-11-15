package com.unicesumar.adsis4s2021.dozero.base;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseCrudService<ENTITY extends BaseEntity, REPOSITORY extends JpaRepository<ENTITY, String>> {
	@Autowired
	private REPOSITORY repo;

	public List<ENTITY> obterTodos() {
		return repo.findAll();
	}

	public ENTITY criar(ENTITY nova) {
		if (repo.findById(nova.getId()).isPresent()) {
			throw new RegistroJáExistente();
		}
		return repo.save(nova);
	}
	
	public ENTITY obterPeloId(String id) {
		try {			
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}
	
	public void excluirPeloId(String id) {
		try {			
			ENTITY recuperada = repo.findById(id).get();
			
			repo.delete(recuperada);
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}
	
	public void atualizar(ENTITY entidade) {
		if (!repo.findById(entidade.getId()).isPresent()) {
			throw new RegistroNãoExistente();
		}
		repo.save(entidade);
	}

}
