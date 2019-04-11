package com.connectionwithmysql.connection.Services;

import com.connectionwithmysql.connection.Models.Todo;
import com.connectionwithmysql.connection.Models.TodoDTO;
import com.connectionwithmysql.connection.Repository.TodoRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class TodoServiceTest {

  @InjectMocks
  TodoService todoService;

  @Mock
  TodoRepository todoRepository;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void findTodo() {

    Todo todo = new Todo();
    todo.setId(1L);
    todo.setTitle("Learn this stuff");
    todo.setDone(false);

    when(todoRepository.findById(anyLong())).thenReturn(Optional.ofNullable(todo));

    Todo todo2 = todoService.findTodo(1L);

    assertNotNull(todo2);
    assertEquals("Learn this stuff", todo2.getTitle());
    assertFalse(todo2 .isDone());
  }
}