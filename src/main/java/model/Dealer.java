package model;

import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.RulesFactory;
import model.rules.WinnerStrategy;
import observer.DealtCardObserver;

/**
 * Represents a dealer player that handles the deck of cards and runs the game using rules.
 */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinnerStrategy winnerStrategy;
  private DealtCardObserver cardObserver; // if more than 1 observer, make this a list

  /**
   * Initializing constructor.

   * @param rulesFactory A factory that creates the rules to use.
   */
  public Dealer(RulesFactory rulesFactory) {

    newGameRule = rulesFactory.getNewGameRule();
    hitRule = rulesFactory.getHitRule();
    winnerStrategy = rulesFactory.getWinnerRule();
  }

  /**
   * Starts a new game if the game is not currently under way.

   * @param player The player to play agains.
   * @return True if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(deck, this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.

   * @param player The player to give a card to.
   * @return true if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      dealingCard(player, true);

      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.

   * @param player The player to check agains.
   * @return True if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winnerStrategy.whichPlayerWins(this, player, maxScore);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.

   * @return True if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /**
   * The player has choosen to take no more cards, it is the dealers turn.
   */
  public boolean stand() {
    if (deck != null) {
      showHand();

      while (hitRule.doHit(this)) {
        dealingCard(this, true);
      }
      return true;
    }
    
    return false;
  }

  /**
   * Deal card to player or dealer.
   */
  public void dealingCard(Player player, boolean visible) {
    Card.Mutable c;

    c = deck.getCard();
    c.show(visible);
    player.dealCard(c);
    // if more than 1 observer, this has to be a loop
    cardObserver.dealtCard();
  }

  /**
   * Set the observer.
   */
  public void setObserver(DealtCardObserver observer) {
    // if more than 1 observer, cardObserver will be some kind of list.
    cardObserver = observer;
  }

}