package view;

/**
 * Implements an english console view.
 */
public class EnglishView implements View {

  private int input;
  
  /**
   * Shows a welcome message.
   */
  public void displayWelcomeMessage() {
    clearScreen();
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * If player press 'p' play game.
   */
  public boolean playSelected() {
    return input == 'p';
  }

  /**
   * If player press 'h' do hit.
   */
  public boolean hitSelected() {
    return input == 'h';
  }

  /**
   * If player press 's' do stand.
   */
  public boolean standSelected() {
    return input == 's';
  }

  /**
   * If player press 'q' quit game.
   */
  public boolean quitSelected() {
    return input == 'q';
  }

  /**
   * Clear screen with 50 empty lines.
   */
  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
  }

  /**
   * Returns pressed characters from the keyboard.

   * @return the pressed character.
   */
  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      input = c;
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      input = 0;
      return 0;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.

   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }
}
