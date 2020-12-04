import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class SoldierPieceTest {
    
    JavaFXChessBoard board = new JavaFXChessBoard();
    ChessPiece soldierN = new SoldierPiece(board, ChessGame.Side.NORTH, 1, 2);
    ChessPiece soldierS = new SoldierPiece(board, ChessGame.Side.NORTH, 2, 3);
    ChessPiece soldierS1 = new SoldierPiece(board, ChessGame.Side.NORTH, 4, 3);
    ChessPiece soldierN1 = new SoldierPiece(board, ChessGame.Side.NORTH, 5, 2);

    @Test
    void isLegalNonCaptureMove() {
        board.addPiece(soldierN,3,2);
        board.addPiece(soldierS,6,3);

        // test that they can only move vertically down and up respectively
        assertTrue(soldierN.isLegalNonCaptureMove(4,2));
        assertTrue(soldierS.isLegalNonCaptureMove(5,3));

        assertFalse(soldierN.isLegalNonCaptureMove(3,2));
        assertFalse(soldierS.isLegalNonCaptureMove(7,3));

        //test if when a  piece is on the other side of the board it can move horizontally too
        board.addPiece(soldierS1,4,3);
        board.addPiece(soldierN1,5,2);

        assertTrue(soldierN1.isLegalNonCaptureMove(5,3));
        assertTrue(soldierS1.isLegalNonCaptureMove(4,2));
        
    }

    @Test
    void isLegalCaptureMove() {
        // set the north piece on the board
        board.addPiece(soldierN,1,2 );
        // add the south piece on a position where both can capture the other
        board.addPiece(soldierS,1,3);
        assertTrue(soldierN.isLegalCaptureMove(1,3));
        // test a false move
        ChessPiece soldierN1 = new PawnPiece(board, ChessGame.Side.NORTH, 1, 1);
        board.addPiece(soldierN1,1,1);

        assertFalse(soldierN.isLegalCaptureMove(0,1));
    }
}