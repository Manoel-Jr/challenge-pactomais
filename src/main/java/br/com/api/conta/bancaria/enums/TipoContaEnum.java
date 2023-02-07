package br.com.api.conta.bancaria.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoContaEnum {

	CORRENTE(1),
	POUPANCA(2);
	
	private int codigo;
	
	public TipoContaEnum valueOf(Integer IdTipoConta) {
		for ( TipoContaEnum value : TipoContaEnum.values()) {
			 if(IdTipoConta.equals(value.codigo)) {
				 return value;
			 }
		}
		return null;
	}
	
}
