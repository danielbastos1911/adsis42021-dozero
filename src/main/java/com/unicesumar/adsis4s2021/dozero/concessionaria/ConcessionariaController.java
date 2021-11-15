package com.unicesumar.adsis4s2021.dozero.concessionaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s2021.dozero.base.RequisiçãoPutInválida;

@RestController
@RequestMapping("/api/concessionarias")
public class ConcessionariaController { 
	@Autowired
	private ConcessionariaService service;

	@GetMapping("/{id}")
	public Concessionaria obterPeloId(@PathVariable("id") Long id) {
		return service.obterPeloId(id);
	}

	@GetMapping
	public List<Concessionaria> obterTodos() {
		return service.obterTodos();
	}

	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable("id") Long id) {
		service.excluirPeloId(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Long criarNovo(@RequestBody Concessionaria novo) {
		novo = service.criar(novo);
		return novo.getId();
	}

	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id") Long id, @RequestBody Concessionaria carro) {
		if (!id.equals(carro.getId())) {
			throw new RequisiçãoPutInválida();
		}
		service.atualizar(carro);
	}

}
