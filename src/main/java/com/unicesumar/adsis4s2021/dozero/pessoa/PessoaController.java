package com.unicesumar.adsis4s2021.dozero.pessoa;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s2021.dozero.base.BaseCrudController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController extends BaseCrudController<Pessoa, PessoaRepository, PessoaService> {

	@PostMapping("/{id}/aluno")
	public String postAluno(@PathVariable("id") String idDaPessoa, @RequestBody Aluno aluno) {
		getService().criarPapel(idDaPessoa, aluno);
		return aluno.getId();
	}

	@PostMapping("/{id}/professor")
	public String postProfessor(@PathVariable("id") String idDaPessoa, @RequestBody Professor professor) {
		getService().criarPapel(idDaPessoa, professor);
		return professor.getId();
	}

	@GetMapping("/{id}/papeis")
	public List<Papel> getPapeis(@PathVariable("id") String idDaPessoa) {
		return getService().obterPapéis(idDaPessoa);
	}

}
