public class Game {

    public Deck createMainDeck() {
        Deck main_deck = new Deck();
        main_deck.fillDeckWithCards();
        main_deck.shuffleDeck();
        return main_deck;
    }

    public void createPlayers(Deck main_deck) {
        Player user = new Player();
        user.getPlayerName();

        Player computer = new Player();
        computer.name = "Computer";

        drawPlayerStartingHands(user, computer, main_deck);
        String card_value = playCard(user);
        System.out.println(card_value);
    }

    public void drawPlayerStartingHands(Player user, Player computer, Deck main_deck) {
        user.drawStartingHand(main_deck);
        computer.drawStartingHand(main_deck);
    }

    public String playRound(Player user, Player computer) {
        Card player_card = user.removeCardFromHand();
        Card computer_card = computer.removeCardFromHand();

        if (player_card.value > computer_card.value) {
            Placeholder;
            // Declare player as winner
            // Add both cards to computers hand
            // Determine logic for size of current hand
            // Determine any other needed logic
        }
        else if (computer_card.value > player_card.value) {
            Placeholder;
        }

        else {
            Placeholder;
            // Determine tie logic
            // Create 'War' function
        }

        return player_card.full_card_info;
    }
}
