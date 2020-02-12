package com.eu.favorite;

import java.util.stream.IntStream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import com.eu.favorite.user.User;
import com.eu.favorite.user.UserService;

@SpringBootApplication
public class FavoriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner run(UserService userService) {
		return (args) -> {
			IntStream.rangeClosed(1,15)
				.mapToObj(i -> {
					User user = new User();
					user.setUsername("user"+i);
					user.setDisplayName("display"+i);
					user.setPassword("P4ssword");
					return user;
				})
				.forEach(userService::save);
			
		};
	}
}
