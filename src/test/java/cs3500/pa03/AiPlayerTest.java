package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.types.Coord;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
/**
 * Test for AiPlayer
 */

public class AiPlayerTest {
  /**
   * The testShots method tests the shot generation algorithm of the AiPlayerMock class.
   * It verifies that the generated shots fall within the valid range of the game grid and
   */

  @Test
  public void testShots() {
    AiPlayerMock computer = new AiPlayerMock(6, 6);
    computer.setShipSize();
    List<Coord> generatedShots = computer.takeShots();
    for (Coord computerShot : generatedShots) {
      //valid on board size
      assertTrue(computerShot.getX() < 6 && computerShot.getX() >= 0);
      assertTrue(computerShot.getY() < 6 && computerShot.getY() >= 0);
    }
    List<Coord> fakeSuccessfulShots = new ArrayList<>();
    fakeSuccessfulShots.add(new Coord(1, 1));
    computer.setPreviousSuccessfulShots(fakeSuccessfulShots);
    generatedShots = computer.takeShots();
    //at least one Coord follows the algorithm of guessing one point away from successful shot
    List<String> coordsToStrings = new ArrayList<>();
    for (Coord shots : generatedShots) {
      coordsToStrings.add(shots.toString());
    }
    //change to string to compare
    assertTrue(coordsToStrings.contains(new Coord(0, 0).toString())
        || coordsToStrings.contains(new Coord(1, 0).toString())
        || coordsToStrings.contains(new Coord(0, 1).toString())
        || coordsToStrings.contains(new Coord(2, 1).toString())
        || coordsToStrings.contains(new Coord(1, 2).toString())
        || coordsToStrings.contains(new Coord(2, 2).toString())
        || coordsToStrings.contains(new Coord(0, 2).toString())
        || coordsToStrings.contains(new Coord(2, 0).toString()));
  }


}
