package cs3500.pa03.model.types;

/**
 * The Coord class represents a coordinate in a two-dimensional Board
 */
public class Coord {
  private int xcoord;
  private int ycoord;
  /**
   * Constructor with X and Y coordinates
   *
   * @param xcoord the x coordinate
   * @param ycoord the y coordinate
   */

  public Coord(int xcoord, int ycoord) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }
  /**
   * Returns a string representation of the Coord object.
   *
   * @return a string representation of the x and y coordinates
   */

  public String toString() {
    return "x: " + this.xcoord + " y: " + this.ycoord + "\n";
  }

  /**
   * Getter for x Coord
   *
   * @return the x coordinate
   */

  public int getX() {
    return this.xcoord;
  }

  /**
   * Getter for Y Coord
   *
   * @return the y coordinate
   */

  public int getY() {
    return this.ycoord;
  }

  /**
   * Setting the values as -1 representing a Coord that has been hit
   */

  public void setNull() {
    this.xcoord = -1;
    this.ycoord = -1;
  }

}

