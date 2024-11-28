public class Card {
    public String[] card_values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public String[] card_suites = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public int value;
    public String suite;
    public String full_card_info;


    public void createCard(int value_index, int suite_index) {
        value = value_index+=1;
        suite = card_suites[suite_index];
        full_card_info = String.format("%s of %s", card_values[value_index], suite);
    }

}