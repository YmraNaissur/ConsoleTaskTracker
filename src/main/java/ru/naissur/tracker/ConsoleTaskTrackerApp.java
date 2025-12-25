package ru.naissur.tracker;

import ru.naissur.tracker.controller.MenuController;
import ru.naissur.tracker.repository.TaskRepository;

import java.util.Scanner;

public class ConsoleTaskTrackerApp {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      var menuController = new MenuController(scanner, new TaskRepository());
      menuController.start();
    }
  }
}