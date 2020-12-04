// Omar Loudghiri oxl51, EECS 132, project 3
// the knight piece testing class
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightPieceTest {
    //first we create a board for the piece to move in
    SwingChessBoard board = new SwingChessBoard(new SwingEuropeanChessDisplay(), new EuropeanChess());
    // then we create a knight piece
    ChessPiece knight = new KnightPiece(board, ChessGame.Side.NORTH, 4, 4);

    @Test
    // check that the knight can move in the L shape in the 8 possible.
    public void isLegalNonCaptureMove() {
        // add the piece to the board
        board.addPiece(knight, 4,4);

        // we check each L shaped move, they all returns true
        assertTrue(knight.isLegalNonCaptureMove(3,2));
        assertTrue(knight.isLegalNonCaptureMove(5,2));
        assertTrue(knight.isLegalNonCaptureMove(2,3));
        assertTrue(knight.isLegalNonCaptureMove(2,5));
        assertTrue(knight.isLegalNonCaptureMove(3,6));
        assertTrue(knight.isLegalNonCaptureMove(5,6));
        assertTrue(knight.isLegalNonCaptureMove(6,5));
        assertTrue(knight.isLegalNonCaptureMove(6,3));
    }

    @Test
    public void isLegalCaptureMove() {
        board.addPiece(knight, 4,4);
        // we set two pieces, one of the other side, the other on the same side on the chessboard
        ChessPiece knightN = new KnightPiece(board, ChessGame.Side.NORTH, 5, 2);
        board.addPiece(knightN,5,2);
        ChessPiece knightS = new KnightPiece(board, ChessGame.Side.SOUTH, 6, 5);
        board.addPiece(knightN,6,5);

        //we then try to move the tester knight to both other pieces, it should only be able to move and capture the piece on the other side
        assertFalse(knight.isLegalCaptureMove(5, 2));
        assertTrue(knight.isLegalCaptureMove(6, 5));
    }

    @Test
    public void isLegalMove() {
        ChessPiece knightN = new KnightPiece(board, ChessGame.Side.NORTH, 5, 2);
        board.addPiece(knightN,5,2);
        //moving to piece with a pawn of the same side should false
        assertFalse(knight.isLegalMove(5, 2));
        assertTrue(knight.isLegalMove(3,6));
    }

}