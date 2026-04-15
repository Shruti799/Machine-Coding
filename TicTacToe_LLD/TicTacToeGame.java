package TicTacToe_LLD;
import TicTacToe_LLD.models.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;
    Player winner;

    public void initializeGame(){
        players = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("player1",crossPiece);

        PlayingPieceO roundPiece = new PlayingPieceO();
        Player player2 = new Player("player2", roundPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public boolean checkWinner(int row, int col, PieceType pieceType){
        boolean colCheck = true;
        boolean rowCheck = true;
        boolean diagonalCheck = true;
        boolean antiDiagonalCheck = true;

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                colCheck = false;
                break;
            }
        }

        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][row] == null || gameBoard.board[i][row].pieceType != pieceType){
                rowCheck = false;
                break;
            }
        }

        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                diagonalCheck = false;
                break;
            }
        }

        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;  i++,j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                antiDiagonalCheck = false;
                break;
            }
        }

        return (colCheck || rowCheck || diagonalCheck || antiDiagonalCheck);
    }

    public GameStatus startGame(){
        boolean isWinner = false;
        while(!isWinner){
            List<Pair<Integer, Integer>> emptyCells = gameBoard.getEmptyCells();

            Player currentPlayer = players.removeFirst();

            if(emptyCells.isEmpty()){
                isWinner = true;
                continue;
            }

            Scanner sc = new Scanner(System.in);

            System.out.println("currentPlayer.name" + "," + "Enter row");
            int row = sc.nextInt();

            System.out.println("currentPlayer.name" + "," + "Enter col");
            int col = sc.nextInt();

            boolean validMove = gameBoard.addPiece(row, col, currentPlayer.playingPiece.pieceType);

            if(!validMove){
                System.out.println("Not a valid move. Enter the row and column again.");
                players.addFirst(currentPlayer);
                continue;
            }

            isWinner = checkWinner(row, col, currentPlayer.playingPiece.pieceType);

            if(isWinner){
                gameBoard.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }

            players.addLast(currentPlayer);
        }
        return GameStatus.DRAW;
    }
}
