package br.com.saldo.positivo.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	public Integer getYear(LocalDate data) {
		if( data == null ) {
			return null;
		}
		return data.getYear();
	}

	public Integer getMonth(LocalDate data) {
		if( data == null ) {
			return null;
		}
		return data.getMonthValue();
	}

	public Integer getDay(LocalDate data) {
		if( data == null ) {
			return null;
		}
		return data.getDayOfMonth();
	}
}
