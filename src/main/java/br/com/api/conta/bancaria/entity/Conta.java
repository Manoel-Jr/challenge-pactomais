package br.com.api.conta.bancaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.api.conta.bancaria.enums.TipoContaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " tb_contas")
@EntityScan
@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "agencia")
	private String agencia;

	private String numeroConta;

	@Enumerated(EnumType.STRING)
	private TipoContaEnum tipoConta;

	private  double saldo;
	
	private double limite;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Correntista correntista;
}