public class TicTacToe {
    public static void main(String[] args) {
        Player player1 = new Player("devansh", "X");
        Player player2 = new Player("adarsh", "O" );
        int gridSize = 3;
        Game newGame = new Game(player1, player2, gridSize);
        newGame.play();
    }
}
