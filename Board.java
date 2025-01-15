public class Board {
    private final int [][] board;
    private final int [] rowSum, colSum;
    public final int n;
    private int diagSum, revDiagSum, totalMoves;
    private Player player1, player2, winner;

    public Board(int size, Player player1, Player player2){
        this.n = size;
        this.rowSum = new int[size];
        this.colSum = new int[size];
        this.board = new int[size][size];
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getWinner(){
        return winner;
    }

    public void move(Player player, int row, int col) throws Exception {
        if (row<0||col<0||row>=n||col>=n){
            throw new Exception("Illegal move outside board");
        } else if (board[row][col]!=0){
            throw new Exception("Cell already filled");
        } else if (totalMoves==n*n){
            throw new Exception("All cells filled, Restart game");
        }
        ;
        int move = player.equals(player1)?-1:1;
        board[row][col] = move;
        rowSum[row]+=move;
        colSum[col]+=move;
        if (row==col){
            diagSum+=move;
        } else if (row==n-col-1){
            revDiagSum+=move;
        }
        if (rowSum[row]==n || colSum[row]==n || diagSum==n || revDiagSum==n){
            winner = player;
        }
    }

    public boolean isBoardFull(){
        return totalMoves==n*n;
    }

    public boolean hasWinner(){
        return winner!=null;
    }

    public void printBoard(){
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                String symbol = player2.getSymbol();
                if(board[i][j]==-1){
                    symbol = player1.getSymbol();
                } else if(board[i][j]==0){
                    symbol = "-";
                }
                System.out.print(symbol+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
