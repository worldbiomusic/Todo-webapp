package io.github.webapp;

import io.github.webapp.entity.Todo;
import io.github.webapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class WebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args)
				.getBean(WebappApplication.class).exe();
	}

	private final TodoService todoService;

	void exe() {
		System.out.println("GO");
		Todo todo1 = new Todo();
		todo1.setTodo("A");
		todo1.setDetail("a");
		todoService.insertTodo(todo1);
	}
}
