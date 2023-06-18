package com.example.workflow;

import com.example.workflow.event.EventController;
import com.example.workflow.organization.OrganizationController;
import com.example.workflow.project.ProjectController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

@Component
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
  private final EventController eventController;
  private final ProjectController projectController;
  private final DataSource dataSource;
  private final ResourceLoader resourceLoader;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    try (Connection connection = dataSource.getConnection()) {
      Statement statement = connection.createStatement();
      String sql = StreamUtils.copyToString(resourceLoader.getResource("classpath:/sqls/data.sql").getInputStream(), StandardCharsets.UTF_8);
      statement.executeUpdate(sql);
    }

    eventController.createMockData();
    projectController.createMockData();
  }
}