package br.com.saldo.positivo.model;

import java.util.Arrays;

public enum EnumCategoriaTitulo implements EnumValor {
	RECEBIMENTO(1),
	PAGAMENTO(2),
	INVESTIMENTO(3);
	
	private int valor;

	EnumCategoriaTitulo(int valor) {
		this.valor = valor;
	}
	
	public static EnumCategoriaTitulo of(int valor) {
		return Arrays.stream(values()).filter( f -> f.valor == valor).findFirst().orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public int getValor() {
		return valor;
	}

}
