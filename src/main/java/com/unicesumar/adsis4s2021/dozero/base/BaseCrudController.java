package com.unicesumar.adsis4s2021.dozero.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.unicesumar.adsis4s2021.dozero.carro.Carro;


//public class CorController extends BaseCrudController<CorService> {
//}

public class BaseCrudController<
					ENTITY extends BaseEntity, 
					REPOSITORY extends JpaRepository<ENTITY, String>,
					SERVICE extends BaseCrudService<ENTITY, REPOSITORY>> {
	@Autowired
	private SERVICE service;


	public SERVICE getService() {
		return service;
	}
	
	@GetMapping
	public List<ENTITY> obterTodos() {
		return service.obterTodos();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String criar(@RequestBody ENTITY nova) {
		nova = service.criar(nova);
		return nova.getId();
	}
	
	@GetMapping("/{id}")
	public ENTITY obterPeloId(@PathVariable("id") String id) {
		return service.obterPeloId(id);
	}

	@DeleteMapping("/{id}")
	public void excluirPeloId(@PathVariable("id") String id) {
		service.excluirPeloId(id);
	}

	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id") String id, @RequestBody ENTITY entidade) {
		if (!id.equals(entidade.getId())) {
			throw new RequisiçãoPutInválida();
		}
		service.atualizar(entidade);
	}


}


