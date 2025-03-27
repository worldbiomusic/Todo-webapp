package io.github.webapp.helper;

import io.github.webapp.entity.Todo;
import io.github.webapp.form.TodoForm;

public class TodoHelper {
    public static Todo convertTodo(TodoForm form) {
        Todo Todo = new Todo();
        Todo.setId(form.getId());
        Todo.setTodo(form.getTodo());
        Todo.setDetail(form.getDetail());
        return Todo;
    }

    public static TodoForm convertTodoForm(Todo Todo) {
        TodoForm form = new TodoForm();
        form.setId(Todo.getId());
        form.setTodo(Todo.getTodo());
        form.setDetail(Todo.getDetail());
        // 업데이트 화면 설정
        form.setNew(false);
        return form;
    }
}