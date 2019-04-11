package com.connectionwithmysql.connection.Services;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Models.Todo;
import com.connectionwithmysql.connection.Repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> listAll() {
    return (List<Todo>) todoRepository.findAll();
  }

  public List<Todo> search(String query) {
    return todoRepository.findAllByTitleContains(query);
  }

  public void addTodo(Todo todo) {
    todoRepository.save(todo);
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }

  public List<Todo> findByAssignee(Assignee assignee) {
    return todoRepository.findAllByAssignee(assignee);
  }

  public Todo findTodo(Long id) {
      return todoRepository.findById(id).get();
  }
}
