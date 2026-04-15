package TicTacToe_LLD.models;
import java.util.List;
import java.util.ArrayList;


public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
    }

    public boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] != null){
            return false;
        }
        else {
            board[row][col] = piece;
            return true;
        }
    }

    public List<Pair<Integer,Integer>> getEmptyCells(){

         List<Pair<Integer,Integer>> emptyCells = new ArrayList<>();

         for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                if(board[row][col] == null){
                    emptyCells.add(new Pair<>(row,col));
                }
            }
         }
         return emptyCells;
    }

    
    public void printBoard(){
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                if(board[row][col] != null){
                    System.out.println(board[row][col].pieceType.name() + " ");
                }
                else{
                    System.out.println(" ");
                }
                System.out.println(" | ");
            }
            System.out.println();
        }
    }
}
