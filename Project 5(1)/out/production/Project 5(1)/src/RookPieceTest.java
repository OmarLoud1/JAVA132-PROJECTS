// Omar Loudghiri oxl51 EECS 132 project 3
// testing class for the rook piece
import org.junit.Test;

import static org.junit.Assert.*;
public class RookPieceTest {
    //first we create a board for the piece to move in
    SwingChessBoard board = new SwingChessBoard(new SwingEuropeanChessDisplay(), new EuropeanChess());
    // then we create a rook piece
    ChessPiece rook = new RookPiece(board, ChessGame.Side.NORTH, 4, 4);

    @Test
    // the rook can only move horizontally or vertically
    public void isLegalNonCaptureMove() {
        // add the rook on an empty board
        board.addPiece(rook,4,4);
        assertTrue(rook.isLegalNonCaptureMove(4,7));
        assertTrue(rook.isLegalNonCaptureMove(7,4));
        assertFalse(rook.isLegalNonCaptureMove(3,7));
    }

    @Test
    public void isLegalCaptureMove() {
        // add the rook on an empty board
        board.addPiece(rook,4,4);
        //creates two rooks one of the same side and the other of another side
        ChessPiece rookN = new RookPiece(board, ChessGame.Side.NORTH, 4,7);
        board.addPiece(rookN,4,7);
        assertFalse(rook.isLegalCaptureMove(4,7));

        ChessPiece rookS = new RookPiece(board, ChessGame.Side.SOUTH, 4,0);
        board.addPiece(rookS, 4, 0);
        assertTrue(rook.isLegalCaptureMove(4,0));
    }

    @Test
    public void isLegalMove() {
        // capture move
        board.addPiece(rook,4,4);
        //creates two rooks one of the same side and the other of another side
        ChessPiece rookN = new RookPiece(board, ChessGame.Side.NORTH, 4,7);
        board.addPiece(rookN,4,7);
        assertFalse(rook.isLegalCaptureMove(4,7));

        // non capture move
        assertTrue(rook.isLegalNonCaptureMove(7,4));
    }
}