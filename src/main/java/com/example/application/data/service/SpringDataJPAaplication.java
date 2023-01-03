package com.example.application.data.service;

import java.util.Date;
import com.example.application.data.Role;
import com.example.application.data.entity.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.application.data.Role;
import com.example.application.data.entity.CuentaBancaria;
import com.example.application.data.entity.User;

@SpringBootApplication
public class SpringDataJPAaplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPAaplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(UserRepository repository) {
		return (args -> {
			insertUser(repository);
			System.out.println(repository.findAll());
		});
	}
	
	private void insertUser(UserRepository repository) {
		com.example.application.data.entity.User usuario = new User("Diaz", "Juanma", "1111111A",new Date(112,7,1,10,30,15), "asdfghjk", Role.USER, "https://i.stack.imgur.com/l60Hf.png");
		repository.save(usuario);
	}
	
}
