package com.unicesumar.adsis4s2021.dozero.meu.caneca;

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
@RequestMapping("api/canecas")
public class CanecaController {
	@Autowired
	private CanecaService service;

	@GetMapping("/{id}")
	public Caneca obterPeloId(@PathVariable("id") String id) {
		return service.obterPeloId(id);
	}

	@GetMapping
	public List<Caneca> obterTodos() {
		return service.obterTodos();
	}

	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable("id") String id) {
		service.excluirPeloId(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String criar(@RequestBody Caneca novo) {
		novo = service.criar(novo);
		return novo.getId();
	}

	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id") String id, @RequestBody Caneca caneca) {
		if (!id.equals(caneca.getId())) {
			throw new RequisiçãoPutInválida();
		}
		service.atualizar(caneca);
	}

}
