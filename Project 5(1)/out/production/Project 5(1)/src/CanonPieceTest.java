import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class CanonPieceTest {
    JavaFXChessBoard board = new JavaFXChessBoard();
    ChessPiece canon = new CanonPiece(board, ChessGame.Side.NORTH, 4, 4);

    @Test
    void isLegalNonCaptureMove() {
        // we add the piece to the chess board
        board.addPiece(canon,4,4);
        // we move the canon diagonally to see if the move works
        assertTrue(canon.isLegalNonCaptureMove(4,7));
        assertTrue(canon.isLegalNonCaptureMove(7,4));
        assertFalse(canon.isLegalNonCaptureMove(3,7));

        // cannot jump pieces
        ChessPiece canon1 = new CanonPiece(board, ChessGame.Side.NORTH, 4, 6);
        board.addPiece(canon1, 4,6);
        assertFalse(canon.isLegalNonCaptureMove(4,7));

    }

    @Test
    void isLegalCaptureMove() {
        board.addPiece(canon,4,4);
        ChessPiece canon1 = new CanonPiece(board, ChessGame.Side.NORTH, 4, 6);
        board.addPiece(canon1, 4,6);
        ChessPiece canonS = new CanonPiece(board, ChessGame.Side.SOUTH, 4,7);
        board.addPiece(canonS, 4,7);
        // can capture because it jumps  canon1
        assertTrue(canon.isLegalNonCaptureMove(4,7));
        ChessPiece canonS1 = new CanonPiece(board, ChessGame.Side.SOUTH, 4,7);
        board.addPiece(canonS1, 4,8);
        // it cannot jump two pieces, only one
        assertFalse(canon.isLegalCaptureMove(4,8));

        // if canon1 is removed then this move is not possible
        board.removePiece(4,6);
        assertFalse(canon.isLegalCaptureMove(4,7));


        
    }

}