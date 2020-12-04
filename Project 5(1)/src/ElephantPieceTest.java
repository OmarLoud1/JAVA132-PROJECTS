import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElephantPieceTest {

    JavaFXChessBoard board = new JavaFXChessBoard();
    ChessPiece elephantPiece = new ElephantPiece(board, ChessGame.Side.NORTH, 4, 4);


    @Test
    void isLegalNonCapture() {
        board.addPiece(elephantPiece,4,4);
        //it can move diagonnaly two square on its own half
        assertTrue(elephantPiece.isLegalNonCaptureMove(2, 2));
        assertTrue(elephantPiece.isLegalNonCaptureMove(2,6));

        //cannot cross the middle
        assertFalse(elephantPiece.isLegalNonCaptureMove(6, 6));

        //cannot jump other pieces
        ChessPiece rook1_S = new RookPiece(board, ChessGame.Side.SOUTH, 1, 5);
        board.addPiece(rook1_S,3, 3);

        assertFalse(elephantPiece.isLegalNonCaptureMove(2,2));



    }

    @Test
    void isLegalCapture() {
        board.addPiece(elephantPiece,4,4);
        ChessPiece rook1_S = new RookPiece(board, ChessGame.Side.SOUTH,2 , 2);
        board.addPiece(rook1_S,2, 2);
        // it can capture a piece inside its legal noncaputure move perimeter
        assertTrue(elephantPiece.isLegalCaptureMove(2,2));
    }
}