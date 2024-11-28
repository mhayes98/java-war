import java.util.*;

public class Player {
    public String name;
    public Deck hand = new Deck();

    public void getPlayerName() {
        Scanner user_input = new Scanner(System.in);
        System.out.print("Enter username: ");
        name = user_input.nextLine();
        System.out.println();
    }

    public void drawStartingHand(Deck main_deck) {
        for (int i = 0; i < 7; i ++){
            Card card = main_deck.drawFromTop();
            hand.addToDeck(card);
        }
    }

    public void drawSingleCard(Deck main_deck, Deck hand) {
        Card card = main_deck.drawFromTop();
        hand.addToDeck(card);
    }

    public Card removeCardFromHand() {
        // Needs tested
        return hand.drawFromTop();
    }
}
