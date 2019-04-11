package com.connectionwithmysql.connection.Controller;

import com.connectionwithmysql.connection.Repository.AssigneeRepository;
import com.connectionwithmysql.connection.Repository.TodoRepository;
import com.connectionwithmysql.connection.Security.JwtAuthenticationEntryPoint;
import com.connectionwithmysql.connection.Security.JwtAuthenticationProvider;
import com.connectionwithmysql.connection.Services.AssigneeService;
import com.connectionwithmysql.connection.Services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@ActiveProfiles("Test")
class MainControllerTest {
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  @Autowired
  MockMvc mockMvc;

  @MockBean
  AssigneeService assigneeService;

  @MockBean
  AssigneeRepository assigneeRepository;

  @MockBean
  TodoService todoService;

  @MockBean
  TodoRepository todoRepository;

  @MockBean
  ApplicationContext applicationContext;

  @MockBean
  EntityManager entityManager;

  @MockBean
  JwtAuthenticationProvider jwtAuthenticationProvider;

  @MockBean
  JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @InjectMocks
  MainController mainController;

  @Test
  void addTodo() throws Exception {
    mockMvc.perform(get("/add"))
        .andExpect(status().isOk());
  }
}