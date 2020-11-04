//Omar Loudghiri oxl51, EECS 132 project 3
//pawn testing document
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnPieceTest {
    //first we create a board for the piece to move in
    ChessBoard board = new ChessBoard(8,8, new EuropeanChessDisplay(), new EuropeanChess());
    // then we create a north and a south pawn piece
    ChessPiece pawnN = new PawnPiece(board, ChessGame.Side.NORTH, 1, 2);
    ChessPiece pawnS = new PawnPiece(board, ChessGame.Side.NORTH, 2, 3);

    @Test
    public void isLegalCaptureMove() {
        // set the north piece on the board
        board.addPiece(pawnN,1,2 );
        // add the south piece on a position where both can capture the other
        board.addPiece(pawnS,2,3);
        assertTrue(pawnN.isLegalCaptureMove(2,3));
        // test a false move
        ChessPiece pawnN1 = new PawnPiece(board, ChessGame.Side.NORTH, 0, 1);
        board.addPiece(pawnN1,0,1);
        assertFalse(pawnN.isLegalCaptureMove(0,1));
    }

    @Test
    public void isLegalNonCaptureMove() {
        // add both a north and a south piece.
        board.addPiece(pawnN,1,2);
        board.addPiece(pawnS,2,3);

        // test that they can only move vertically down and up respectively
        assertTrue(pawnN.isLegalNonCaptureMove(2,2));
        assertTrue(pawnS.isLegalNonCaptureMove(1,3));
        assertFalse(pawnN.isLegalNonCaptureMove(0,2));
        assertFalse(pawnS.isLegalNonCaptureMove(3,3));
    }


    @Test
    public void isLegalMove() {
        board.addPiece(pawnN,1,2);
        board.addPiece(pawnS,2,3);

        // make sure that north pawn can capture the piece and also move forward
        assertTrue(pawnN.isLegalMove(2,2));
        assertTrue(pawnN.isLegalMove(2,3));

    }

}