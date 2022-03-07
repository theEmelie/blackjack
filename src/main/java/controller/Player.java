package controller;

import java.util.concurrent.TimeUnit;
import model.Game;
import observer.DealtCardObserver;
import view.EnglishView;
import view.View;

/**
 * Scenario controller for playing the game.
 */
public class Player implements DealtCardObserver {

  private View view;
  private Game game;

  public Player() {
    game = new Game();
    view = new EnglishView(); // new SwedishView();
  }
  
  /**
   * Runs the play use case.

   * @return True as long as the game should continue.
   */
  public boolean play() {
    game.setObserver(this);
    view.displayWelcomeMessage();

    displayHands();

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    view.getInput();

    if (view.playSelected()) {
      game.newGame();
    } else if (view.hitSelected()) {
      game.hit();
    } else if (view.standSelected()) {
      game.stand();
    } 

    return !view.quitSelected();
  }

  @Override
  public void dealtCard() {
    view.clearScreen();
    displayHands();

    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      System.out.println("Interrupted Sleep");
    }
    
  }

  private void displayHands() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }
}