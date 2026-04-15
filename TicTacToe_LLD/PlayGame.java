package TicTacToe_LLD;
import TicTacToe_LLD.models.*;

public class PlayGame {
    public void main(String[] args){
        System.out.println("Let's play TicTacToe Game");
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        GameStatus status = game.startGame();
        switch(status){
            case WIN:
                System.out.println(game.winner.name + "won game.");
                break;
            case DRAW:
                System.out.println("Game drawn");
                break;
            default:
                System.out.println("No result");
                break;
        }
    }
}
