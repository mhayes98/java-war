void main() {
    Game game = new Game();
    Deck main_deck = game.createMainDeck();

    Player user = game.createPlayerUser();
    Player computer = game.createNPC();

    game.distributeCardsToPlayers(user, computer, main_deck);

    game.startGame(user, computer);
}
