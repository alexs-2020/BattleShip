package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa03.model.board.GridImp;
import cs3500.pa03.model.types.Coord;
import cs3500.pa03.view.DisplayImp;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Test for Display class
 */


public class DisplayTest {
  DisplayImp testView = new DisplayImp();
  /**
   * Test case to verify the displayString method
   */

  @Test
  public void testSuccess() {
    testView.displayString("success");
    assertEquals("success", testView.getAppendable().toString());
  }
  /**
   * Test case to verify the getUserShots method
   */

  @Test
  public void testUserShots() {
    List<Coord> test = new ArrayList<>();
    test.add(new Coord(0, 1));

    String testInput =  "1 2";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);

    List<Coord> result = testView.getUserShots("test", 1);
    assertEquals(1, result.size());
    assertEquals(new Coord(1, 2).toString(), result.get(0).toString());
  }
  /**
   * Test case to verify the displayBoard method
   */

  @Test
  public void testDisplayBoard() {
    GridImp userBoard = new GridImp(6, 6);
    testView.displayBoard(userBoard.getGrid(), "test");
    assertEquals("O O O O O O \nO O O O O O \nO O O O O O \nO O O O O O"
        + " \nO O O O O O \nO O O O O O \n", testView.getAppendable().toString());
  }
  /**
   * Test case to verify the getFleet method
   */

  @Test
  public void testGetFleet() {
    String testInput =  "1 1 1 1";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    int[] testReturn = {1, 1, 1, 1};
    int[] fleet = testView.getFleet(8);
    assertEquals(testReturn[0], fleet[0]);
    assertEquals(testReturn[1], fleet[1]);
    assertEquals(testReturn[2], fleet[2]);
    assertEquals(testReturn[3], fleet[3]);
  }
  /**
   * Test case to verify the getBoardSize method
   */

  @Test
  public void testBoardSize() {
    String testInput =  "6 6";
    ByteArrayInputStream testIn;
    testIn = new ByteArrayInputStream(testInput.getBytes());
    System.setIn(testIn);
    int[] test = testView.getBoardSize();
    assertEquals(6, test[0]);
    assertEquals(6, test[1]);
  }
}
