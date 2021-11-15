package com.unicesumar.adsis4s2021.dozero.marca;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.RegistroJáExistente;
import com.unicesumar.adsis4s2021.dozero.base.RegistroNãoExistente;

@Service
@Transactional
public class MarcaService {
	@Autowired
	private MarcaRepository repo;
	
	
	public List<Marca> obterTodos() {
		return repo.findAll();
	}


	public Marca criar(Marca novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RegistroJáExistente();
		}
		return repo.save(novo);
	}


	public void atualizar(Marca carro) {
		if (!repo.findById(carro.getId()).isPresent()) {
			throw new RegistroNãoExistente();
		}
		repo.save(carro);
	}


	public Marca obterPeloId(String id) {
		try {			
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}


	public void excluirPeloId(String id) {
		try {			
			Marca recuperado = repo.findById(id).get();
			
			repo.delete(recuperado);
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}
	
}
