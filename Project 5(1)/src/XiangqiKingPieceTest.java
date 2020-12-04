import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XiangqiKingPieceTest {

    JavaFXChessBoard board = new JavaFXChessBoard();
    ChessPiece king_N = new XiangqiKingPiece(board, ChessGame.Side.NORTH, 0, 5);


    @Test
    void isLegalNonCapture() {
        board.addPiece(king_N,0,5);
        //it can move horizontaly and vertically inside the square
        assertTrue(king_N.isLegalNonCaptureMove(0, 4));
        assertTrue(king_N.isLegalNonCaptureMove(1,5));

        //cannot move outside the square
        assertFalse(king_N.isLegalNonCaptureMove(0, 6));

    }

    @Test
    void isLegalCapture() {
        board.addPiece(king_N,0,5);
        ChessPiece rook1_S = new RookPiece(board, ChessGame.Side.SOUTH, 1, 5);
        board.addPiece(rook1_S,1, 5);
        // it can capture a piece inside its legal noncaputure move perimeter
       assertTrue(king_N.isLegalCaptureMove(1,5));
    }
}