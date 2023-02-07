package br.com.api.conta.bancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.conta.bancaria.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	public Conta findByAgenciaAndNumeroConta(String agencia, String numeroConta);
	
	public boolean existsByAgenciaAndNumeroConta(String agencia, String numeroConta);
}
