import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XiangqiTest {

    //create an instance
    Xiangqi game = new Xiangqi();

    @Test
    void playingSide() {
        // make sure the getter returns what the setter gets as an input
        game.setPlayingSide(false);
        assertFalse(game.getPlayingSide());

    }

    @Test
    void getNumRowsCol() {
        assertEquals(game.getNumColumns(), 9);
        assertEquals(game.getNumRows(), 10);
    }

    @Test
    void startgame1() {
        // creates a board for the game to start on
        JavaFXChessBoard board = new JavaFXChessBoard();
        Xiangqi.startGame(board);

        // asserts that the rook piece is where it supposed to be and same for the king, checks that there is no piece at an empty square
        assertEquals(board.getPiece(0,0).getLabel(), "R");
        assertEquals(board.getPiece(0,4).getLabel(), "X");
        assertFalse(board.hasPiece(2,2));
    }


}