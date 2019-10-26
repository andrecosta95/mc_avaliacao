package com.fiap.avaliacoes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MyAvaliacaoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MyAvaliacaoApplication.class, args);
	}

}
