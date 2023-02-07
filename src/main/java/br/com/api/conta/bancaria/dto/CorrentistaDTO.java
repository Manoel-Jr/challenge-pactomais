package br.com.api.conta.bancaria.dto;

import br.com.api.conta.bancaria.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrentistaDTO {

	private String nome;

	private String cpf;

	private String profissao;

	private Endereco endereco;
}
