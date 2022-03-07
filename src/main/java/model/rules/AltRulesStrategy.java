package model.rules;

import model.Player;

/**
 * Create alternative rule.
 */
public class AltRulesStrategy implements WinnerStrategy {
  
  /**
   * Create rule where dealer has to have higher score than player to win.
   *
   * @param dealer the dealer.
   * @param player the player.
   * @param maxScore the max score (21).
   * @return the winner (dealer or player).
   */
  @Override
  public boolean whichPlayerWins(Player dealer, Player player, int maxScore) {
    if (player.calcScore() > maxScore) {
      return true;
    } else if (dealer.calcScore() > maxScore) {
      return false;
    }
    return dealer.calcScore() > player.calcScore();
  }
}
