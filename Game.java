import java.util.*;

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

    public void playGame(Player user, Player computer) {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Enter any key to play a round, or 'e' to exit.\n");
            String option = user_input.nextLine().toLowerCase();

            while (!option.equals("e")) {
                playRound(user, computer);
                System.out.println("Enter any key to keep playing, or 'e' to exit.\n");
                option = user_input.nextLine().toLowerCase();
                System.out.println("\n");
            }

            endGameEarly(user, computer);
    }

    public void playRound(Player user, Player computer) {
        Card user_card = user.removeCardFromHand();
        Card computer_card = computer.removeCardFromHand();

        if (user_card.num_value == computer_card.num_value) {
            System.out.println("User: " + user_card.named_value);
            System.out.println("Computer: " + computer_card.named_value);
            System.out.println("War!");
            warDeclared(user, computer);
        }
        else {
            Player winner = (user_card.num_value > computer_card.num_value) ? user : computer;
            System.out.println(user.name + ": " + user_card.named_value );
            System.out.println(computer.name + ": " + computer_card.named_value + "");
            System.out.println(winner.name + " wins!\n");
            winner.addToPlayerDeck(user_card);
            winner.addToPlayerDeck(computer_card);
            checkForEmptyDecks(user, computer);
        }
    }

    public Player warDeclared(Player user, Player computer) {
        Player winner = null;

        checkDeckCapacityForWar(user, computer);

        Card user_facedown_card = user.removeCardFromHand();
        Card user_faceup_card = user.removeCardFromHand();

        Card computer_facedown_card = computer.removeCardFromHand();
        Card computer_faceup_card = computer.removeCardFromHand();

        System.out.println("\nEach player has drawn a card and laid it face down.\n");

        if (user_faceup_card.num_value != computer_faceup_card.num_value) {
            winner = (user_faceup_card.num_value > computer_faceup_card.num_value) ? user : computer;
            System.out.println(user.name + ": " + user_faceup_card.named_value );
            System.out.println(computer.name + ": " + computer_faceup_card.named_value);
            System.out.println(winner.name + " wins this round of War!\n");
        }
        else {
            System.out.println(user.name + ": " + user_faceup_card.named_value );
            System.out.println(computer.name + ": " + computer_faceup_card.named_value);
            System.out.println("War-ception!!!");
            winner = warDeclared(user, computer);
        }

        winner.addToPlayerDeck(user_facedown_card);
        winner.addToPlayerDeck(computer_facedown_card);
        winner.addToPlayerDeck(user_faceup_card);
        winner.addToPlayerDeck(computer_faceup_card);

        checkForEmptyDecks(user, computer);

        return winner;
    }

    public void checkForEmptyDecks(Player user, Player computer) {
        if (user.hand.deck.size() <= 0 || computer.hand.deck.size() <= 0) {
            Player loser = (user.hand.deck.size() <= 0 ? user : computer);
            declareWinner(loser == user ? computer : user, loser);
        }
    }

    public void checkDeckCapacityForWar(Player user, Player computer) {
        if (user.hand.deck.size() < 2 || computer.hand.deck.size() < 2) {
            Player loser = (user.hand.deck.size() < 2 ? user : computer);
            declareWinner(loser == user ? computer : user, loser);
        }
    }

    public void declareWinner(Player winning_user, Player losing_user) {
        System.out.println("\n\n");
        System.out.println(losing_user.name + " is out of cards!");
        System.out.println(winning_user.name + " has won the game!");
        System.exit(0);
    }

    public void endGameEarly(Player user, Player computer) {
        if (user.hand.deck.size() == computer.hand.deck.size()) {
            System.out.println("Ending game. Both decks are of equal size. Nobody wins.");
        }
        else {
            Player winner = (user.hand.deck.size() > computer.hand.deck.size()) ? user : computer;
            System.out.printf("Ending game. %s has more cards and is our *winner.\n", winner.name);
        }
        System.exit(0);
    }

    public void displayRules() {
        System.out.println("\n\nWelcome to 'War'!\n");
        System.out.println("Rules:");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("'War' is played with a standard 52-card deck.");
        System.out.println("\tThis deck will be shuffled and evenly distributed amongst the players.");
        System.out.println("\t\t(The players being you & an NPC)\n");
        System.out.println("Each round you will both draw a card and lay it face down. Higher card wins!");
        System.out.println("\tThe loser will then take both cards and add them to their deck.\n");
        System.out.println("If there's a tie then War is declared!");
        System.out.println("\tEach player will one card and lay it face down.");
        System.out.println("\tThen, each player will draw an additional card and play a standard head-to-head round.");
        System.out.println("\tThe winner of War will receive all 4 cards (or more, if there's War within a War)\n");
        System.out.println("First player to obtain all 52 cards will be crowned the winner!");
        System.out.println("\t* Note - It's, uh, pretty unrealistic to ACTUALLY complete a game of two-player 52-card game of 'War'...");
        System.out.println("\t\t\t A two-player game of 'War' can take hundreds upon hundreds of rounds to complete.");
        System.out.println("\t\t\t And that's if a winner is even possible. Sometimes the stars align & decks end up in a stalemate.");
        System.out.println("\t\t\t\t (And you won't know if thats the case)\n");
        System.out.println("Have fun!");
        System.out.println("______________________________________________________________________________________________________________\n");
    }

}
