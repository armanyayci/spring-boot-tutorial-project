package com.backend2.tutorial2;

import Business.UserService;
import dtos.UserCreateDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tutorial2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tutorial2Application.class, args);
	}


	/*@Bean
	CommandLineRunner createInitialUsers(UserService userService)
	{
		return(args) ->
		{
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("User1");
			user.setName("Arman1");
			user.setSurname("Yayci1");
			user.setPassword("123456");

			userService.createUser(user);

			UserCreateDTO user2 = new UserCreateDTO();
			user.setUserName("User2");
			user.setName("Arman2");
			user.setSurname("Yayci2");
			user.setPassword("123456");

			userService.createUser(user2);

			UserCreateDTO user3 = new UserCreateDTO();
			user.setUserName("User3");
			user.setName("Arman3");
			user.setSurname("Yaycı3");
			user.setPassword("123456");

			userService.createUser(user3);
		};
		}*/
	}



