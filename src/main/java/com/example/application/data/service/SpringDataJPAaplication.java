package com.example.application.data.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.application.data.Role;
import com.example.application.data.entity.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.application.data.Role;
import com.example.application.data.entity.Consulta;
import com.example.application.data.entity.CuentaBancaria;
import com.example.application.data.entity.User;

@SpringBootApplication
public class SpringDataJPAaplication {
	public static void main(String[] args) {
		/*//SpringApplication.run(SpringDataJPAaplication.class, args);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Crear BD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Consulta consulta = new Consulta();
		
		tx.begin();
		try {
			em.persist(consulta);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}
		em.close();
		emf.close();*/
	}
		
	@Bean
	public CommandLineRunner run(UserRepository repository) {
		return (args -> {
			insertUser(repository);
			System.out.println(repository.findAll());
		});
	}
	
	private void insertUser(UserRepository repository) {
		com.example.application.data.entity.User usuario = new User("Diaz", "Juanma", "juanmadiaz@gmail.com","1111111A",new Date(112,7,1,10,30,15), "asdfghjk", Role.USER, "https://i.stack.imgur.com/l60Hf.png");
		repository.save(usuario);
	}


}
