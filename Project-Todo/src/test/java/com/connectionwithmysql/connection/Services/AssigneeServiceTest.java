package com.connectionwithmysql.connection.Services;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Repository.AssigneeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class AssigneeServiceTest {

  @InjectMocks
  AssigneeService assigneeService;

  @Mock
  AssigneeRepository assigneeRepository;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void findAssignee() {
    Assignee assignee = new Assignee();
    assignee.setId(23L);
    assignee.setName("Green Fox");
    assignee.setEmail("green@fox.hu");

    when(assigneeRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(assignee));

    Assignee assignee1 = (Assignee) assigneeService.findAssignee(23L);

    assertNotNull(assignee1);
    assertEquals("Green Fox", assignee1.getName());
    assertNotEquals("email", assignee1.getEmail());
  }

}