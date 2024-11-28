import java.util.ArrayList;
import java.util.*;

public class Deck {
    public int current_deck_size;
    public ArrayList<Card> deck = new ArrayList<Card>();

    public void fillDeckWithCards() {
        current_deck_size = 52;
        for (int value = 0; value < 13; value++) {
            for(int suite = 0; suite < 4; suite++) {
                Card card = new Card();
                card.createCard(value, suite);
                deck.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawFromTop() {
        return deck.removeFirst();
    }

    public void addToDeck(Card card) {
        deck.add(card);
    }
}
