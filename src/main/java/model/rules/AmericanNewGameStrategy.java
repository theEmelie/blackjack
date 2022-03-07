package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Create American game.
 */
class AmericanNewGameStrategy implements NewGameStrategy {

  /**
   * Create a new American game.
   *
   * @param deck the deck.
   * @param dealer the dealer.
   * @param player the player.
   * @return true.
   */
  public boolean newGame(Deck deck, Dealer dealer, Player player) {

    dealer.dealingCard(player, true);

    dealer.dealingCard(dealer, true);

    dealer.dealingCard(player, true);

    dealer.dealingCard(dealer, false);

    return true;
  }
}