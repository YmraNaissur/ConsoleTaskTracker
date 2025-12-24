package ru.naissur.tracker.controller;

import ru.naissur.tracker.view.MainMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

  private static final int ADD_TASK = 1;
  private static final int SHOW_ALL_TASKS = 2;
  private static final int EDIT_TASK = 3;
  private static final int DELETE_TASK = 4;
  private static final int EXIT = 5;

  public void start() {
    MainMenu mainMenu = new MainMenu();
    Scanner sc = new Scanner(System.in);

    int choice;
    do {
      try {
        mainMenu.show();

        System.out.print("Выберите действие: ");
        choice = sc.nextInt();
        switch (choice) {
          case ADD_TASK -> System.out.println("Вы выбрали добавить задачу");
          case SHOW_ALL_TASKS -> System.out.println("Вы выбрали просмотреть список задач");
          case EDIT_TASK -> System.out.println("Вы выбрали редактировать задачу");
          case DELETE_TASK -> System.out.println("Вы выбрали удалить задачу");
          case EXIT -> System.out.println("Вы выбрали выйти из программы. До свидания!");
          default -> System.out.println("Вы ввели неверное значение. Попробуйте еще раз");
        }
      } catch (InputMismatchException e) {
        System.out.println("Необходимо ввести число!");
        sc.next();
        choice = -1;
      }
    } while (choice != EXIT);
  }

}
