import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class HorsePieceTest {

    JavaFXChessBoard board = new JavaFXChessBoard();
    HorsePiece horse = new HorsePiece(board, ChessGame.Side.NORTH, 4,4);
    @Test
    void isLegalNonCaptureMove() {
        // we check each L shaped move, they all returns true
        assertTrue(horse.isLegalNonCaptureMove(3,2));
        assertTrue(horse.isLegalNonCaptureMove(5,2));
        assertTrue(horse.isLegalNonCaptureMove(2,3));
        assertTrue(horse.isLegalNonCaptureMove(2,5));
        assertTrue(horse.isLegalNonCaptureMove(3,6));
        assertTrue(horse.isLegalNonCaptureMove(5,6));
        assertTrue(horse.isLegalNonCaptureMove(6,5));
        assertTrue(horse.isLegalNonCaptureMove(6,3));

        //cannot move if there is a piece
        HorsePiece horse1 = new HorsePiece(board, ChessGame.Side.NORTH, 5,4);
        board.addPiece(horse1, 5,4);
        assertFalse(horse.isLegalNonCaptureMove(6,5));
    }

    @Test
    void isLegalCaptureMove() {
        HorsePiece horse1 = new HorsePiece(board, ChessGame.Side.SOUTH, 6,5);
        board.addPiece(horse1, 6,5);
        assertTrue(horse.isLegalCaptureMove(6,5));
    }
}