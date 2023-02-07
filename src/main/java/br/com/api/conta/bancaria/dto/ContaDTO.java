package br.com.api.conta.bancaria.dto;

import br.com.api.conta.bancaria.entity.Correntista;
import br.com.api.conta.bancaria.enums.TipoContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {

	private String agencia;

	private String numeroConta;

	private TipoContaEnum tipoConta;

	private double saldo;

	private Correntista correntista;

	private double limite;
}
