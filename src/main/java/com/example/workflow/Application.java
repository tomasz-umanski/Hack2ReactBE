package com.example.workflow;

import com.example.workflow.event.EventController;
import com.example.workflow.organization.OrganizationController;
import com.example.workflow.project.ProjectController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
  private final OrganizationController organizationController;
  private final EventController eventController;
  private final ProjectController projectController;

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    organizationController.createMockData();
    eventController.createMockData();
    projectController.createMockData();
  }
}