package ru.naissur.tracker.model;

import lombok.Builder;
import lombok.Data;

/**
 * Класс, представляющий задачу
 */
@Data
@Builder
public class Task {

  private long id;
  private String name;
  private String description;

}
