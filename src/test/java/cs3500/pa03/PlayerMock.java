package cs3500.pa03;

import cs3500.pa03.model.player.PlayerImp;

/**
 * Mock for PlayerImp
 * Provides an additional method to retrieve the views appendable object for testing purposes.
 */
public class PlayerMock extends PlayerImp {

  /**
   * Getter for appendable object of the view.
   *
   * @return the appendable object used by the view for the current player
   */
  public Appendable getView() {
    return view.getAppendable();
  }
}
