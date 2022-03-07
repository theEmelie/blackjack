package model.rules;

import model.Player;

/**
 * Class with standard rules.
 */
public class StandardRulesStrategy implements WinnerStrategy {

  /**
   * Create rule where dealer wins if same or higher score as player.
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
    return dealer.calcScore() >= player.calcScore();
  }


}
