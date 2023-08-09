package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.types.Ship;
import cs3500.pa03.model.types.ShipType;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class ControllerTest {
  ControllerMock testGame = new ControllerMock();
  String testInput;
  ByteArrayInputStream testIn;

  @Test
  public void testDims() {

    //test set Dims
    String testInput = "10 10";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    testGame.setBoardSize();
    assertEquals(10, testGame.getBoardDims()[0]);
    assertEquals(10, testGame.getBoardDims()[1]);

    //test dims
    testInput = "5 2";
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    assertThrows(NoSuchElementException.class, testGame::setBoardSize);

    //test setFleet
    testInput =  "1 1 1 1";
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    testGame.setFleet();
    Map<ShipType, Integer> test = new HashMap<>();
    test.put(new ShipType("Carrier"), 1);
    test.put(new ShipType("Battleship"), 1);
    test.put(new ShipType("Destroyer"), 1);
    test.put(new ShipType("Submarine"), 1);

    assertEquals(test.values().toString(), testGame.getuBoats().values().toString());

    //testAIFleet
    testGame.setAiFleet();
    int sum = 0;
    for (int value : testGame.getAiBoats().values()) {
      sum += value;
    }
    assertTrue(sum <= 8);

    //testSetup
    testGame.setDims();
    testGame.setBoats();
    testInput = "Alex";
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    testGame.setupUser();
    List<Ship> something = testGame.getUserBoats();
    assertEquals(4, something.size());

    testGame.setupAi();
    List<Ship> somethingElse = testGame.getUserBoats();
    assertEquals(4, somethingElse.size());
  }
}
