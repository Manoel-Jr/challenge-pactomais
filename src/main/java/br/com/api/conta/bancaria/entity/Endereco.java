package br.com.api.conta.bancaria.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rua;

	private String cidade;

	private String estado;
}
