//Omar Loudghiri, oxl51, EECS 132 project 3
// this is the testing class for the bishop piece

import static org.junit.jupiter.api.Assertions.*;

class BishopPieceTest {
    //first we create a board for the piece to move in
    SwingChessBoard board = new SwingChessBoard(new SwingEuropeanChessDisplay(), new EuropeanChess());
    // then we create a bishop piece
    ChessPiece bishop = new BishopPiece(board, ChessGame.Side.NORTH, 4, 4);

    @org.junit.jupiter.api.Test
    void isLegalNonCaptureMove() {
        // we add the piece to the chess board
        board.addPiece(bishop,4,4);
        // we move the bishop diagonally to see if the move works
        assertTrue(bishop.isLegalNonCaptureMove(7,7));
        assertFalse(bishop.isLegalNonCaptureMove(3,1));

    }

    @org.junit.jupiter.api.Test
    void isLegalCaptureMove() {
        // we add the piece to the chess board
        board.addPiece(bishop,4,4);
        // we then set two pieces, one of the other side, the other on the same side on the chessboard
        ChessPiece bishopN = new BishopPiece(board, ChessGame.Side.NORTH, 1, 1);
        board.addPiece(bishopN,1,1);
        ChessPiece bishopS = new BishopPiece(board, ChessGame.Side.SOUTH, 7, 7);
        board.addPiece(bishopS,7,7);

        // we then try to move the tester bishop to both other pieces, it should only be able to move and capture the piece on the other side
        assertFalse(bishop.isLegalCaptureMove(1,1));
        assertTrue(bishop.isLegalCaptureMove(7,7));
    }

    @org.junit.jupiter.api.Test
    void isLegalMove() {
        // we add the piece to the chess board
        board.addPiece(bishop,4,4);
        // we add a piece on the board
        ChessPiece bishopN = new BishopPiece(board, ChessGame.Side.NORTH, 1, 1);
        board.addPiece(bishopN,1,1);

        // should return true if moving to an empty piece, and should return false if moving to the full piece
        assertFalse(bishop.isLegalMove(1,1));
        assertTrue(bishop.isLegalMove(7,7));


    }

    @org.junit.jupiter.api.Test
    void moveDone() {
    }

}