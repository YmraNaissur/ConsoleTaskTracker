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

  private long idSequence = 1;
  private final List<Task> tasks = new ArrayList<>(16);

  public void addTask(Task task) {
    task.setId(idSequence++);
    tasks.add(task);
    log.info("Задача добавлена: {}", task);
  }

  public List<Task> getAllTasks() {
    return tasks;
  }

  public boolean deleteTaskById(long id) {
    return tasks.removeIf(task -> task.getId() == id);
  }

  public void loadTasks() {
    System.out.println("Загрузка задач из файла...");
  }

  public void saveTasks() {
    System.out.println("Сохранение задач в файл...");
  }

}
