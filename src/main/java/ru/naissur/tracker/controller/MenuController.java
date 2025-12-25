package ru.naissur.tracker.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import ru.naissur.tracker.model.Task;
import ru.naissur.tracker.repository.TaskRepository;
import ru.naissur.tracker.view.MainMenu;

import java.util.Scanner;

@RequiredArgsConstructor
public class MenuController {

  private final Scanner scanner;
  private final TaskRepository taskRepository;

  private static final int ADD_TASK = 1;
  private static final int SHOW_ALL_TASKS = 2;
  private static final int EDIT_TASK = 3;
  private static final int DELETE_TASK = 4;
  private static final int EXIT = 5;

  public void start() {
    MainMenu mainMenu = new MainMenu();

    int choice;
    do {
      try {
        mainMenu.show();
        System.out.print("Выберите действие: ");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
          case ADD_TASK -> addTask();
          case SHOW_ALL_TASKS -> showAllTasks();
          case EDIT_TASK -> editTask();
          case DELETE_TASK -> deleteTask();
          case EXIT -> exit();
          default -> System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
        }
      } catch (NumberFormatException e) {
        System.out.println("Необходимо ввести число!");
        choice = -1;
      }
    } while (choice != EXIT);
  }

  private void addTask() {
    System.out.println();
    System.out.println("Добавление задачи.");
    String taskName = askForAction("Введите название задачи: ", "Название задачи не может быть пустым");
    String taskDescription = askForAction("Введите описание задачи: ", "Описание задачи не может быть пустым");
    Task newTask = Task.builder()
        .name(taskName)
        .description(taskDescription)
        .build();
    taskRepository.addTask(newTask);
  }

  private void showAllTasks() {
    var tasks = taskRepository.getAllTasks();
    System.out.println("Просмотр списка задач.");
    if (CollectionUtils.isEmpty(tasks)) {
      System.out.println("Список задач пуст");
    } else {
      tasks.forEach(this::displayTask);
    }
  }

  private void editTask() {
    System.out.println("Редактирование задачи");
  }

  private void deleteTask() {
    System.out.println("Удаление задачи");
  }

  private void exit() {
    System.out.println("Сохранение задач в файл и выход из программы");
  }

  private String askForAction(String action, String errorMessage) {
    String value;
    do {
      System.out.print(action);
      value = scanner.nextLine();
      if (value.isEmpty()) {
        System.out.println(errorMessage);
      }
    } while (value.isEmpty());
    return value;
  }

  private void displayTask(Task task) {
    System.out.println("ID: " + task.getId());
    System.out.println("\t" + "Название: " + task.getName());
    System.out.println("\t" + "Описание: " + task.getDescription());
  }

}
