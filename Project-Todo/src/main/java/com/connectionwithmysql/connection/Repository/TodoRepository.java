package com.connectionwithmysql.connection.Repository;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Models.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

  List<Todo> findAllByTitleContains(String query);

  List<Todo> findAllByAssignee(Assignee assignee);

  List<Todo> findTodosByAssignee(Assignee assignee);
}
