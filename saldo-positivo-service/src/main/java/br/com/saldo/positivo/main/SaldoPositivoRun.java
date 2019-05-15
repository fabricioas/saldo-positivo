package br.com.saldo.positivo.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"br.com.saldo.positivo.dao"})
@EnableSwagger2
@ComponentScan(basePackages = { "br.com.saldo.positivo.main", "br.com.saldo.positivo.api" , 
		"br.com.saldo.positivo.config","br.com.saldo.positivo.controller",
		"br.com.saldo.positivo.bo"})
public class SaldoPositivoRun implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(SaldoPositivoRun.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
