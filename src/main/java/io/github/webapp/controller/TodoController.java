package io.github.webapp.controller;

import ch.qos.logback.core.joran.action.ImplicitModelDataForComplexProperty;
import io.github.webapp.entity.Todo;
import io.github.webapp.form.TodoForm;
import io.github.webapp.helper.TodoHelper;
import io.github.webapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", todoService.findAllTodo());
        return "todo/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model,
                         RedirectAttributes attributes) {
        Optional<Todo> todo = todoService.findByIdTodo(id);

        // 없으면 홈으로
        if(todo.isEmpty()) {
            attributes.addFlashAttribute("errorMessage", "해당 데이터 없음");
            return "redirect:/todos";
        }

        model.addAttribute("todo", todo.get());
        return "todo/detail";
    }

    @GetMapping("/form")
    public String newTodo(@ModelAttribute TodoForm todoForm) {
        todoForm.setNew(true);
        return "todo/form";
    }

    @PostMapping("/save")
    public String create(@Validated TodoForm todoForm, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            todoForm.setNew(true);
            return "todo/form";
        }

        Todo todo = TodoHelper.convertTodo(todoForm);
        todoService.insertTodo(todo);
        redirectAttributes.addFlashAttribute("message", "새로운 Todo");
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Todo> target = todoService.findByIdTodo(id);
        if(target.isEmpty()) {
           redirectAttributes.addAttribute("errorMessage", "대상 데이터 없음");
           return "redirect:/todos";
        }

        Todo todo = target.get();
        TodoForm form = TodoHelper.convertTodoForm(todo);
        model.addAttribute("todoForm", form);
        return "todo/form";
    }

    @PostMapping("/update")
    public String update(@Validated TodoForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            form.setNew(false);
            return "todo/form";
        }

        Todo todo = TodoHelper.convertTodo(form);
        todoService.updateTodo(todo);
        redirectAttributes.addAttribute("message", "업데이트 됨");
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id ,RedirectAttributes redirectAttributes) {
        todoService.deleteTodo(id);
        redirectAttributes.addAttribute("message", id + "번 Todo가 삭제됨");
        return "redirect:/todos";
    }
}











