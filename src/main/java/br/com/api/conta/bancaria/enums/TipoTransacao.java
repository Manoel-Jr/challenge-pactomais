package br.com.api.conta.bancaria.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoTransacao {

	DEPOSITO(1),
	SAQUE(2);
	
	private int codigo;
	
	public TipoTransacao valueOf(Integer IdTipoTransacao) {
		for ( TipoTransacao value : TipoTransacao.values()) {
			 if(IdTipoTransacao.equals(value.codigo)) {
				 return value;
			 }
		}
		return null;
	}
}
