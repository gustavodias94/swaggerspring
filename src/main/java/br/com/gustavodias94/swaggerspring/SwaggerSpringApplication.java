package br.com.gustavodias94.swaggerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.gustavodias94.swaggerspring"})
public class SwaggerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerSpringApplication.class, args);
	}


}
