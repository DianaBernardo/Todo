package com.connectionwithmysql.connection.Models;

public class AssigneeDTO {

  private Long id;
  private String name;
  private String workEmail;

  public AssigneeDTO() {
  }

  public AssigneeDTO(Long id, String name, String workEmail) {
    this.id = id;
    this.name = name;
    this.workEmail = workEmail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWorkEmail() {
    return workEmail;
  }

  public void setWorkEmail(String workEmail) {
    this.workEmail = workEmail;
  }
}
