package model.rules;

import model.Player;

/**
 * Class that encapsulates when a player (the dealer) should take more cards.
 */
class BasicHitStrategy implements HitStrategy {
  private static final int hitLimit = 17;

  /**
   * Returns if dealer should take another card.
   *
   * @param dealer the dealer.
   * @return dealer take more card if less than hit limit.
   */
  public boolean doHit(Player dealer) {
    return dealer.calcScore() < hitLimit;
  }
}