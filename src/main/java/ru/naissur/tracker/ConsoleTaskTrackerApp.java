package ru.naissur.tracker;

import ru.naissur.tracker.controller.MenuController;
import ru.naissur.tracker.data.InMemoryTestDataGenerator;
import ru.naissur.tracker.repository.TaskRepository;

import java.util.Scanner;

public class ConsoleTaskTrackerApp {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      var taskRepository = new TaskRepository();
      InMemoryTestDataGenerator.createSampleData(taskRepository);
      var menuController = new MenuController(scanner, taskRepository);
      menuController.start();
    }
  }
}