package com.connectionwithmysql.connection.Controller;

import com.connectionwithmysql.connection.Models.Todo;
import com.connectionwithmysql.connection.Services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {

  private TodoService todoService;

  public MainRestController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/api")
  @ResponseBody
  public List<Todo> todos() {
    return todoService.listAll();
  }

  @PostMapping("/api")
  public void addTodo(@RequestBody Todo todo) {
    todoService.addTodo(todo);
  }
}
