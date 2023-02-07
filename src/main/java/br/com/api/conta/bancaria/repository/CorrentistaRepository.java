package br.com.api.conta.bancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.conta.bancaria.entity.Correntista;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{

	public Correntista findByCpf(String cpf);
}
