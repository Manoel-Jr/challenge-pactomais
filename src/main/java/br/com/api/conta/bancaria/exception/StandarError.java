package br.com.api.conta.bancaria.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandarError {

	private LocalDateTime timestemp;

	private Integer status;

	private String error;

	private String path;
}
