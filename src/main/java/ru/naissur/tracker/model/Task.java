package ru.naissur.tracker.model;

import lombok.Builder;
import lombok.Data;

/**
 * Класс, представляющий задачу
 */
@Data
@Builder
public class Task {

  private int id;
  private String name;
  private String description;

}
