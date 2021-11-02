package com.unicesumar.adsis4s2021.dozero.meu.caneca;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.RegistroJáExistente;
import com.unicesumar.adsis4s2021.dozero.base.RegistroNãoExistente;

@Service
@Transactional
public class CanecaService {
	@Autowired
	private CanecaRepository repo;

	public List<Caneca> obterTodos() {
		return repo.findAll();
	}

	public Caneca criar(Caneca novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new RegistroJáExistente();
		}
		return repo.save(novo);
	}

	public void atualizar(Caneca caneca) {
		if (!repo.findById(caneca.getId()).isPresent()) {
			throw new RegistroNãoExistente();
		}
		repo.save(caneca);
	}

	public Caneca obterPeloId(String id) {
		try {
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();

		}
	}

	public void excluirPeloId(String id) {
		try {
			Caneca recuperado = repo.findById(id).get();
			repo.delete(recuperado);
		} catch (NoSuchElementException e) {
			throw new RegistroNãoExistente();
		}
	}

}
