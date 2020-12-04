import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardPieceTest {

    JavaFXChessBoard board = new JavaFXChessBoard();
    ChessPiece guard_N = new GuardPiece(board, ChessGame.Side.NORTH, 0, 5);


    @Test
    void isLegalNonCapture() {
        board.addPiece(guard_N,0,5);
        //it can move diagonaly inside the square
        assertTrue(guard_N.isLegalNonCaptureMove(1, 4));

        //cannot move outside the square
        assertFalse(guard_N.isLegalNonCaptureMove(1, 6));

    }

    @Test
    void isLegalCapture() {
        board.addPiece(guard_N,0,4);
        ChessPiece rook1_S = new RookPiece(board, ChessGame.Side.SOUTH, 1, 5);
        board.addPiece(rook1_S,1, 5);
        // it can capture a piece inside its legal noncaputure move perimeter
        assertTrue(guard_N.isLegalCaptureMove(1,5));
    }
}