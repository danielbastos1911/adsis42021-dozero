package com.unicesumar.adsis4s2021.dozero.pessoa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.BaseCrudService;

@Service
@Transactional
public class PessoaService extends BaseCrudService<Pessoa, PessoaRepository>{

	public void criarPapel(String idDaPessoa, Papel papel) {
		Pessoa recuperada = getRepo().findById(idDaPessoa).get();
		recuperada.adicionarPapel(papel);
		getRepo().save(recuperada);
	}

	public List<Papel> obterPapéis(String idDaPessoa) {
		return getRepo().obterPapéis(idDaPessoa);
	}

}
