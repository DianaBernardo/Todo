package com.connectionwithmysql.connection;

import com.connectionwithmysql.connection.Models.Assignee;
import com.connectionwithmysql.connection.Models.AssigneeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class DTOModelMapper {

  public static void modelMapping(){

    Assignee sourceAssignee = new Assignee("Diana", "diana@gmail.com");

    AssigneeDTO targetAssigneeDTO = new AssigneeDTO();

    ModelMapper modelMapper = new ModelMapper();

    modelMapper.addMappings(new PropertyMap<Assignee, AssigneeDTO>() {
      @Override
      protected void configure() {
        map().setWorkEmail(sourceAssignee.getEmail());
      }
    });

    modelMapper.map(sourceAssignee, targetAssigneeDTO);
  }
}
