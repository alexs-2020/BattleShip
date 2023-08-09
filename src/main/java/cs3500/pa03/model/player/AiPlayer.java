package cs3500.pa03.model.player;

import cs3500.pa03.model.types.Coord;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The AiPlayer class extends the PlayerImp class representing and AI player
 * Implements AI-controlled strategies for taking shots,
 * reporting damage, and tracking successful hits.
 */

public class AiPlayer extends PlayerImp {

  protected List<Coord> previousSuccessfulShots = new ArrayList<>();
  protected List<Coord> missedShots = new ArrayList<>();
  private final int height;
  private final int width;
  /**
   * Constructore for Aiplayer
   *
   * @param h The height of the game grid.
   * @param w The width of the game grid.
   */

  public AiPlayer(int h, int w) {
    width = w;
    height = h;
  }
  /**
   * Generates a list of coordinates representing the shots to be taken by the AI player.
   * Uses a previous list of successful shots and makes most of its guesses 1 block away
   *
   * @return A list of coordinates representing the shots to be taken by AIPlayer.
   */

  @Override
  public List<Coord> takeShots() {
    List<Coord> shots = new ArrayList<>();
    Random random = new Random();
    if (previousSuccessfulShots.size() == 0) {
      for (int i = 0; i < playerShips.size(); i++) {
        shots.add(new Coord(random.nextInt(width), random.nextInt(height)));
      }
    } else {
      //iterate of succ hits
      while (shots.size() != playerShips.size() - 1) {
        for (Coord succShots : previousSuccessfulShots) {
          random = new Random();
          int randomGuess;
          Coord newGuess;
          do {
            randomGuess = random.nextInt(3) - 1;
            newGuess = new Coord(succShots.getX() + randomGuess, succShots.getY() + randomGuess);
          } while (previousSuccessfulShots.contains(newGuess) || missedShots.contains(newGuess));
          shots.add(newGuess);
        }
      }
      //loop can get stuck guessing in the same area - adding a random shot anywhere
      shots.add(new Coord(random.nextInt(width), random.nextInt(height)));
    }
    return shots;
  }
  /**
   * Processes the opponent's shots on the AI player's ships and reports the damaged coordinates.
   * It also updates the state of the AI players ships if a ship is hit or destroyed.
   *
   * @param opponentShotsOnBoard The list of coordinates representing the opponents shots
   * @return list of coordinates representing successfull hits on Ai player ships.
   */

  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    List<Coord> hits = new ArrayList<>();
    for (int j = 0; j < playerShips.size(); j++) {
      for (Coord shots : opponentShotsOnBoard) {
        for (int i = 0; i < playerShips.get(j).getCoords().size(); i++) {
          if (playerShips.get(j).getCoords().get(i).toString().equals(shots.toString())) {
            hits.add(shots);
            playerShips.get(j).deleteCoord(playerShips.get(j).getCoords().get(i));
          }
        }
      }
      if (playerShips.get(j).getCoords().size() == 0) {
        System.out.println("You have destroyed a " + playerShips.get(j).name());
        playerShips.remove(playerShips.get(j));
      }
    }
    return hits;
  }
  /**
   * Updates the list of previous successful shots
   *
   * @param shotsThatHitOpponentShips The list of coordinates representing  successful hits
   */

  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    previousSuccessfulShots.addAll(shotsThatHitOpponentShips);
  }
}
