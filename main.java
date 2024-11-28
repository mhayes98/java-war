void main() {
    Game game = new Game();
    Deck main_deck = game.createMainDeck();
    game.createPlayers(main_deck);
}
