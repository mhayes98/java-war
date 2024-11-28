import java.util.ArrayList;

public class Deck {
    public int current_deck_size;
    public int starting_card_count;

    public void createDeckObject() {
        ArrayList<Card> deck = new ArrayList<Card>();
    }

    public void fillDeckWithCards() {
        for (int i = 0; i < 13; i++) {
            for( int y = 0; y < 4; y++) {
                Card card = new Card();
                system.out.println(i, y);
                card.createCard(i, y);
            }
        }
    }
}
