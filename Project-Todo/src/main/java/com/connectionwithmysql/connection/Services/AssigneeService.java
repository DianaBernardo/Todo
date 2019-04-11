package com.connectionwithmysql.connection.Services;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Repository.AssigneeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssigneeService {

  private AssigneeRepository assigneeRepository;

  public AssigneeService(AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  public List<Assignee> allAssignees() {
   return (List<Assignee>) assigneeRepository.findAll();
  }

  public void deleteAssignee(Long id) {
    assigneeRepository.deleteById(id);
  }

  public void addAssignee(Assignee assignee) {
    assigneeRepository.save(assignee);
  }

  public Assignee findAssignee(Long id) {
    return assigneeRepository.findById(id).get();
  }
}
