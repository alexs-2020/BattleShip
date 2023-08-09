package cs3500.pa03;

import cs3500.pa03.controllers.GameController;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    System.out.println("Hello from Battle Salvo - PA03 Template Repo");
    GameController game = new GameController();
    game.run();
  }

}