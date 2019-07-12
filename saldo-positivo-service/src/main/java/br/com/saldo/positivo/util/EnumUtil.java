package br.com.saldo.positivo.util;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.EnumValor;
import br.com.saldo.positivo.model.EnumStatusTitulo;
import br.com.saldo.positivo.swagger.model.LancamentoMes.StatusLancamentoEnum;

@Component
public class EnumUtil {
	public EnumStatusTitulo statusTitulo(final StatusLancamentoEnum status) {
		if( status == null) {
			return EnumStatusTitulo.PENDENTE;
		}
		return Arrays.stream(EnumStatusTitulo.values()).filter(f -> f.name().equals(status.name())).findFirst().get();
	}
	
	public Integer getEnumValor(EnumValor enumValor) {
		if( enumValor == null ) {
			return null;
		}
		return enumValor.getValor();
	}
}

