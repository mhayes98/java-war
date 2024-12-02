void main() {
    Game game = new Game();
    game.displayRules();

    Deck main_deck = game.createMainDeck();

    Player user = game.createPlayerUser();
    Player computer = game.createNPC();

    game.distributeCardsToPlayers(user, computer, main_deck);

    game.playGame(user, computer);
}
