package br.com.saldo.positivo.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GenerateUtil {

	public String uuid() {
		return UUID.randomUUID().toString();
	}
}
