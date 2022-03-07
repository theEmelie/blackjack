package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Create European game.
 */
class InternationalNewGameStrategy implements NewGameStrategy {

  /**
   * Create a new European game.
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

    return true;
  }
}