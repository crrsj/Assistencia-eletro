package br.com.assistencia;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Assistência Técnica Para Eletrodomésticos",
				version = "1.0",
				description = "API para gerenciamento de asssistência técnica",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class AssistenciaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistenciaTecnicaApplication.class, args);
	}

}
