package br.com.gestao.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class GestaoTarefasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoTarefasApiApplication.class, args);
	}

}
