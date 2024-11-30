public class Game {

    public Deck createMainDeck() {
        Deck main_deck = new Deck();
        main_deck.fillDeckWithCards();
        main_deck.shuffleDeck();
        return main_deck;
    }

    public Player createPlayerUser() {
        Player user = new Player();
        user.getPlayerName();
        return user;
    }

    public Player createNPC() {
        Player computer = new Player();
        computer.name = "Computer";
        return computer;
    }

    public void distributeCardsToPlayers(Player user, Player computer, Deck main_deck) {
        user.drawStartingHand(main_deck);
        computer.drawStartingHand(main_deck);
    }

    public void startGame(Player user, Player computer) {
        for (int i = 0; i < 26; i ++) {
            playRound(user, computer);
        }
    }

    public void playRound(Player user, Player computer) {
        Card player_card = user.removeCardFromHand();
        Card computer_card = computer.removeCardFromHand();

        if (player_card.num_value > computer_card.num_value) {
            System.out.println("Player wins!");
            System.out.println("Computer: " + computer_card.named_value);
            System.out.println("User: " + player_card.named_value);
            System.out.println("\n\n");

            user.addToPlayerDeck(player_card);
            user.addToPlayerDeck(computer_card);

            // Declare player as winner
            // Add both cards to computers hand
            // Determine logic for size of current hand
            // Determine any other needed logic
        }
        else if (computer_card.num_value > player_card.num_value) {
            System.out.println("Computer wins!");
            System.out.println("Computer: " + computer_card.named_value);
            System.out.println("User: " + player_card.named_value);
            System.out.println("\n\n");

            computer.addToPlayerDeck(player_card);
            computer.addToPlayerDeck(computer_card);
        }

        else {
            System.out.println("WAR");
            System.out.println("Computer: " + computer_card.named_value);
            System.out.println("User: " + player_card.named_value);
            System.out.println("\n\n");
            // Determine tie logic
            // Create 'War' function
        }
    }

    public void checkForEmptyDecks(Player user, Player computer) {
        if (user.hand.size() = 0) {
            Placeholder;
        }
    }
}
