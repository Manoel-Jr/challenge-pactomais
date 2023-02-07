package br.com.api.conta.bancaria.service;

import br.com.api.conta.bancaria.dto.CorrentistaDTO;
import br.com.api.conta.bancaria.entity.Correntista;

public interface CorrentistaService {

	public CorrentistaDTO criar(Correntista correntista);
	
	public CorrentistaDTO consultar(String cpf);
}
