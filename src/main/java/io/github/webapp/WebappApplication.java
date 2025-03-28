package io.github.webapp;

import io.github.webapp.entity.Todo;
import io.github.webapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class WebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args)
				.getBean(WebappApplication.class).exe();
	}


	void exe() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String digest = encoder.encode("adminpass");
		System.out.println(digest);
		digest = encoder.encode("userpass");
		System.out.println(digest);
	}
}
