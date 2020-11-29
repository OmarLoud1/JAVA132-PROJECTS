import org.junit.Test;

import static org.junit.Assert.*;

public class QueenPieceTest {
    //first we create a board for the piece to move in
    ChessBoard board = new ChessBoard(8,8, new EuropeanChessDisplay(), new EuropeanChess());
    // then we create a queen piece
    ChessPiece queen = new QueenPiece(board, ChessGame.Side.NORTH, 4, 4);

    @Test
    public void isLegalNonCaptureMove() {
        // set the queen on the board
        board.addPiece(queen, 4,4);
        // then make sure that diagonal moves are allowed
        assertTrue(queen.isLegalMove(4, 7));
        assertTrue(queen.isLegalMove(7,4));
        assertTrue(queen.isLegalMove(0,4));
        assertTrue(queen.isLegalMove(4,0));
        assertTrue(queen.isLegalMove(7,7));
        assertTrue(queen.isLegalMove(1,1));
        assertTrue(queen.isLegalMove(1,7));
        assertTrue(queen.isLegalMove(7,1));
    }

    @Test
    public void isLegalCaptureMove() {
        // set the queen on the board
        board.addPiece(queen, 4,4);
        // set a piece to capture
        KingPiece king = new KingPiece(board, ChessGame.Side.NORTH, 4, 6);
        board.addPiece(king,4,6);

        assertTrue(queen.isLegalCaptureMove(4,6));
    }

    @Test
    public void isLegalMove() {
        //test a legal capture move
        board.addPiece(queen, 4, 4);
        // set a piece to capture
        KingPiece king = new KingPiece(board, ChessGame.Side.NORTH, 4, 6);
        board.addPiece(king, 4, 6);
        assertTrue(queen.isLegalMove(4, 6));
        // and test a non capture move
        assertTrue(queen.isLegalMove(4, 7));
    }

}