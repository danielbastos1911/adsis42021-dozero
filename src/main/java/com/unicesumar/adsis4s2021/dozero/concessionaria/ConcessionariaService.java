package com.unicesumar.adsis4s2021.dozero.concessionaria;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.RegistroJáExistente;
import com.unicesumar.adsis4s2021.dozero.base.RegistroNãoExistente;

@Service
@Transactional
public class ConcessionariaService {
	@Autowired
	private ConcessionariaRepository repo;
	
	
	public List<Concessionaria> obterTodos() {
		return repo.findAll();
	}


	public Concessionaria criar(Concessionaria novo) {
//		if (repo.findById(novo.getId()).isPresent()) {
//			throw new RegistroJáExistente();
//		}
		return repo.save(novo);
	}


	public void atualizar(Concessionaria carro) {
		if (!repo.findById(carro.getId()).isPresent()) {
			throw new RegistroNãoExistente();
		}
		repo.save(carro);
	}


	public Concessionaria obterPeloId(Long id) {
		try {			
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}


	public void excluirPeloId(Long id) {
		try {			
			Concessionaria recuperado = repo.findById(id).get();
			
			repo.delete(recuperado);
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}
	
}
