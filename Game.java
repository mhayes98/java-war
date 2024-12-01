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
        while (!checkForEmptyDecks(user, computer)) {
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
            System.out.println("War!");
            System.out.println("Computer: " + computer_card.named_value);
            System.out.println("User: " + player_card.named_value);
            System.out.println("\n");
            System.out.println("Each player will now draw 1 card and lay it face down." +
                                "\n Each player will then draw 1 more card and play a traditional round." +
                                "\n If either player runs out of cards during War they will lose.\n");
            warDeclared(user, computer);
        }
    }

    public void warDeclared(Player user, Player computer) {
        if(!checkForEmptyDecks(user, computer)) {
            user.removeCardFromHand();
            computer.removeCardFromHand();
            System.out.println("\n\n");
        }
        playRound(user, computer);
    }

    public boolean checkForEmptyDecks(Player user, Player computer) {
        if (user.hand.deck.size() <= 0 || computer.hand.deck.size() <= 0) {
            if (user.hand.deck.size() <= 0) {
                declareWinner(computer, user);
                return true;
            }
            else {
                declareWinner(user, computer);
                return true;
            }
        }
        return false;
    }

    public void declareWinner(Player winning_user, Player losing_user) {
        System.out.println("\n\n");
        System.out.println(losing_user.name + " is out of cards!");
        System.out.println(winning_user.name + " has won the game!");
        System.out.println(winning_user.hand.deck.size());
    }

}
