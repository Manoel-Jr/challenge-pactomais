package br.com.api.conta.bancaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.conta.bancaria.core.ConvertService;
import br.com.api.conta.bancaria.dto.CorrentistaDTO;
import br.com.api.conta.bancaria.entity.Correntista;
import br.com.api.conta.bancaria.repository.CorrentistaRepository;
import br.com.api.conta.bancaria.service.CorrentistaService;

@Service
public class CorrentistaServiceImpl implements CorrentistaService {

	@Autowired
	private CorrentistaRepository correntistaRepository;

	@Autowired
	private ConvertService convertService;

	@Override
	public CorrentistaDTO criar(Correntista correntista) {
		return convertService.converterParaDTOSalvarCorrentista(correntistaRepository.save(correntista));
	}

	@Override
	public CorrentistaDTO consultar(String cpf) {
		Correntista cliente = correntistaRepository.findByCpf(cpf);
		CorrentistaDTO contaCorrente = convertService.converterParaDTOSalvarCorrentista(cliente);
		return contaCorrente;
	}

}
