package com.connectionwithmysql.connection.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Assignee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  private String name;
  private String email;

  @OneToMany (fetch = FetchType.EAGER, mappedBy = "assignee")
  private List<Todo> todos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Assignee() {
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public String toString() {
    return name;
  }
}
