package model.rules;

import model.Player;

/**
 * Create class for Soft17 hit strategy. 
 */
class Soft17HitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  /**
   * Decides whether the dealer should hit or not.
   *
   * @param dealer the dealer.
   * @return true or false.
   */
  public boolean doHit(Player dealer) {
    if (dealer.calcScore() < hitLimit) {
      return true;
    } else if (dealer.calcScore() > hitLimit) {
      return false;
    } else {
      // Equals 17
      if (dealer.calcNonAceScore() > 6) {
        return false;
      } else {
        return true;
      }
    }
  }
}