package br.com.saldo.positivo.model;

import java.util.Arrays;

public enum EnumTipoTitulo {
	RECEBIMENTO(1);
	
	private int tipo;

	EnumTipoTitulo(int tipo) {
		this.tipo = tipo;
	}
	
	public static EnumTipoTitulo of(int tipo) {
		return Arrays.stream(values()).filter( f -> f.tipo == tipo).findFirst().orElseThrow(IllegalArgumentException::new);
	}

}
