package ru.naissur.tracker.data;

import ru.naissur.tracker.model.Task;
import ru.naissur.tracker.repository.TaskRepository;

public class InMemoryTestDataGenerator {

  public static void createSampleData(TaskRepository taskRepository) {
    taskRepository.addTask(Task.builder().name("Клетка").description("Прибраться в клетке у крыс").build());
    taskRepository.addTask(Task.builder().name("Вода").description("Сходить за водой").build());
    taskRepository.addTask(Task.builder().name("Задачи на JavaRush").description("Решить минимум 2 задачи на JavaRush").build());
  }

}
