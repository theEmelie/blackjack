package model.rules;

import model.Player;

/**
 * Rule interface that encapsulates when a player (the dealer) should take more cards.
 */
public interface WinnerStrategy {

  boolean whichPlayerWins(Player dealer, Player player, int maxScore);
}