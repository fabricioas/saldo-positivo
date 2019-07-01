package br.com.saldo.positivo.util;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.StatusTituloEnum;
import br.com.saldo.positivo.swagger.model.LancamentoMes.StatusLancamentoEnum;

@Component
public class EnumUtil {
	public StatusTituloEnum statusTitulo(final StatusLancamentoEnum status) {
		if( status == null) {
			return StatusTituloEnum.PENDENTE;
		}
		return Arrays.stream(StatusTituloEnum.values()).filter(f -> f.name().equals(status.name())).findFirst().get();
	}
}

