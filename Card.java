public class Card {
    public String[] card_values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public int num_value;
    public String named_value;

    public void assignCardValue(int value_index) {
        num_value = value_index+2;
        named_value = card_values[value_index];
    }
}