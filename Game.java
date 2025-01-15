import java.util.Scanner;

public class Game {

    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;
    
    public Game(Player player1, Player player2, int size){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        board = new Board(size, player1, player2);
    }

    public void play(){
        board.printBoard();
        while(!board.isBoardFull() && !board.hasWinner()){
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput(String.format("Enter row (0-%d): ",board.n-1));
            int col = getValidInput(String.format("Enter col (0-%d): ", board.n-1));

            try {
                board.move(currentPlayer, row, col);
                board.printBoard();
                switchPlayer();
            } catch (Exception e) {
                System.out.println(e.getMessage());            
            }
        }

        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public int getValidInput(String messageString){
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println(messageString);
            if (sc.hasNextInt()){
                input = sc.nextInt();
                if(input>0 || input<board.n){
                    return input;
                }else{
                    sc.next();
                }
            }
            System.out.println("Invalid input! Please enter a number between 0 and " + (board.n-1));
        }
    }
}
