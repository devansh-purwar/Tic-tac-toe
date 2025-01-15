public class BoardGKCS {

    private final int [][] board;
    private final int [] rowSum, colSum;
    private final int n;
    private int winner, diagSum, revDiagSum, totalMoves;

    public BoardGKCS(int size){
        this.n = size;
        this.rowSum = new int[size];
        this.colSum = new int[size];
        this.board = new int[size][size];
    }

    public int getWinner(){
        return winner;
    }

    public void move(int player, int row, int col) throws Exception {
        if (row<0||col<0||row>=n||col>=n){
            throw new Exception("Illegal move outside board");
        } else if (board[row][col]!=0){
            throw new Exception("Cell already filled");
        } else if (player!=1||player!=2){
            throw new Exception("Invalid Player");
        } else if (totalMoves==n*n){
            throw new Exception("All cells filled, Restart game");
        }
        int move = player==1?-1:1;
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

}