package br.com.saldo.positivo.model;

import java.util.Arrays;

public enum EnumClasseTitulo implements EnumValor {
	RECEBIMENTO(1),
	GASTOS_FIXO(2),
	GASTOS_PERIODICO(3),
	CARTAO_CREDITO(4),
	APORTE(5),
	RESGATE(6),
	DESEMBOLSO(7);

	private int valor;

	EnumClasseTitulo(int valor) {
		this.valor = valor;
	}
	
	public static EnumClasseTitulo of(int valor) {
		return Arrays.stream(values()).filter( f -> f.valor== valor).findFirst().orElseThrow(IllegalArgumentException::new);
	}

	public int getValor() {
		return valor;
	}

}
