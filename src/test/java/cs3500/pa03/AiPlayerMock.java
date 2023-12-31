package cs3500.pa03;

import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.types.Coord;
import cs3500.pa03.model.types.Ship;
import cs3500.pa03.model.types.ShipType;
import java.util.ArrayList;
import java.util.List;
/**
 *  AiPlayerMock represents a mock for the AI player
 *  Provides additional methods for setting previous successful
 *  shots and ship sizes for testing purposes.
 */

public class AiPlayerMock extends AiPlayer {
  /**
   * Constructor
   *
   * @param h The height of the game grid.
   * @param w The width of the game grid.
   */
  public AiPlayerMock(int h, int w) {
    super(h, w);
  }
  /**
   * Manual setter for previous successfull shots
   *
   * @param shots The list of coordinates representing the previous successful shots.
   */

  public void setPreviousSuccessfulShots(List<Coord> shots) {
    previousSuccessfulShots = shots;
  }
  /**
   * Sets the ship sizes for the AI player.
   * This method creates a list of ships with the same size and adds them to the players fleet.
   * This is intended for testing purposes.
   */

  public void setShipSize() {
    playerShips = new ArrayList<>();
    List<Coord> x = new ArrayList<>();
    x.add(new Coord(5, 5));
    playerShips.add(new Ship(new ShipType("fake"), x));
    playerShips.add(new Ship(new ShipType("fake"), x));
    playerShips.add(new Ship(new ShipType("fake"), x));
    playerShips.add(new Ship(new ShipType("fake"), x));
  }
}
