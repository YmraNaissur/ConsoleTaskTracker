package ru.naissur.tracker.repository;

import lombok.extern.slf4j.Slf4j;
import ru.naissur.tracker.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения задач
 */
@Slf4j
public class TaskRepository {

  private List<Task> tasks;

  public void addTask(Task task) {
    if (tasks == null) {
      log.info("Список задач не инициализирован. Создание нового списка.");
      tasks = new ArrayList<>(16);
    }

    task.setId(tasks.size() + 1);
    tasks.add(task);
    log.info("Задача добавлена: {}", task);
  }

  public List<Task> getAllTasks() {
    return tasks;
  }

  public void loadTasks() {
    System.out.println("Загрузка задач из файла...");
  }

  public void saveTasks() {
    System.out.println("Сохранение задач в файл...");
  }

}
