package com.connectionwithmysql.connection;

import com.connectionwithmysql.connection.Repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ConnectionApplication.class, args);

  }

  @Override
  public void run(String... args) throws Exception {
  }



}

