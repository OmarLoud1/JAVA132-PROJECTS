//Omar Loudghiri oxl51 EECS 132, project 3
//this is the testing class for KingPiece
import org.junit.Test;

import static org.junit.Assert.*;

public class KingPieceTest {
    //first we create a board for the piece to move in
    SwingChessBoard board = new SwingChessBoard(new SwingEuropeanChessDisplay(), new EuropeanChess());
    // then we create a king piece
    KingPiece king = new KingPiece(board, ChessGame.Side.NORTH, 4, 4);

    @Test
    public void isLegalNonCaptureMove() {
        // set the location
        king.setLocation(4,4);
        // we then make the king move vertically and diagonally, and then input an incorrect move
        assertTrue(king.isLegalNonCaptureMove(5, 4));
        assertTrue(king.isLegalNonCaptureMove(5,5));
        assertFalse(king.isLegalNonCaptureMove(2,1));
    }

    @Test
    public void isLegalCaptureMove() {
        // set the location
        king.setLocation(4,4);
        // we then set two pieces, one of a different side and the other of the same side as the king
        ChessPiece bishopN = new BishopPiece(board, ChessGame.Side.NORTH, 5, 5);
        board.addPiece(bishopN,5,5);
        ChessPiece bishopS = new BishopPiece(board, ChessGame.Side.SOUTH, 5, 3);
        board.addPiece(bishopS,5,3);

        assertTrue(king.isLegalCaptureMove(5,3));
        assertFalse(king.isLegalCaptureMove(5,5));
    }

    @Test
    public void moveDone() {
        king.moveDone();
        assertEquals(king.getKingCounter(), 1);
    }

    @Test
    public void isLegalMove() {
        // one capture move:
        ChessPiece bishopS = new BishopPiece(board, ChessGame.Side.SOUTH, 5, 3);
        board.addPiece(bishopS,5,3);
        assertTrue(king.isLegalCaptureMove(5,3));

        // and one non capture move
        assertTrue(king.isLegalNonCaptureMove(5, 4));
    }
}