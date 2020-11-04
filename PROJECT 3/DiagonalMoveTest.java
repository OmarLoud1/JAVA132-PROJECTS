//  Omar Loudghiri oxl51, EECS 132 Project 3
// testing class for diagonal move
import static org.junit.jupiter.api.Assertions.*;
class DiagonalMoveTest {
    // create a chessboard to create pieces on
    ChessBoard board = new ChessBoard(8,8, new EuropeanChessDisplay(), new EuropeanChess());
    // create a piece that move diagonally
    ChessPiece bishop = new BishopPiece(board, ChessGame.Side.NORTH, 4, 4);

    @org.junit.jupiter.api.Test
    void isDiagonalMove() {
        //a series of diagonal moves that return true
        assertTrue(DiagonalMove.isDiagonalMove(bishop, 2, 2));
        assertTrue(DiagonalMove.isDiagonalMove(bishop, 6, 6));
        assertTrue(DiagonalMove.isDiagonalMove(bishop, 2, 6));
        assertTrue(DiagonalMove.isDiagonalMove(bishop, 6, 2));

        // false diagonal move
        assertFalse(DiagonalMove.isDiagonalMove(bishop, 3, 6));
        assertFalse(DiagonalMove.isDiagonalMove(bishop, 6, 7));

    }

    @org.junit.jupiter.api.Test
    // this method contains a loop and needs a 0,1,many / first mid last test
    void isAllowed() {
        // 0. first, since the board we are on is empty but for the bishop piece, we test that all directions return true.
        assertTrue(DiagonalMove.isAllowed(bishop, 2, 2));
        assertTrue(DiagonalMove.isAllowed(bishop, 6, 6));
        assertTrue(DiagonalMove.isAllowed(bishop, 2, 6));
        assertTrue(DiagonalMove.isAllowed(bishop, 6, 2));

        //1. we then add one piece in each direction and the is allowed should return false
        // first. the loop will find the object in its first iteration
        ChessPiece bishop = new BishopPiece(board, ChessGame.Side.NORTH, 4, 4);
        //first. square after the bishop
        ChessPiece bishop1 = new BishopPiece(board, ChessGame.Side.NORTH, 3, 3);
        //first.square after the bishop
        ChessPiece bishop2 = new BishopPiece(board, ChessGame.Side.NORTH, 5, 5);
        //first square next to the bishop
        ChessPiece bishop3 = new BishopPiece(board, ChessGame.Side.NORTH, 3,5 );
        // first square next to the bishop
        ChessPiece bishop4 = new BishopPiece(board, ChessGame.Side.NORTH, 5, 3);

        assertFalse(DiagonalMove.isAllowed(bishop, 1, 1));
        assertFalse(DiagonalMove.isAllowed(bishop, 7,7 ));
        assertFalse(DiagonalMove.isAllowed(bishop, 1, 7));
        assertFalse(DiagonalMove.isAllowed(bishop, 7, 1));

        //many, we add more pieces in between and we test the move is not allowed
        //middle and last, the piece will be found in the middle of the math or at the end of it
        // middle
        ChessPiece bishop5 = new BishopPiece(board, ChessGame.Side.NORTH, 2, 2);
        //middle
        ChessPiece bishop6 = new BishopPiece(board, ChessGame.Side.NORTH, 6, 6);
        //last
        ChessPiece bishop7 = new BishopPiece(board, ChessGame.Side.NORTH, 2,6 );
        // last
        ChessPiece bishop8 = new BishopPiece(board, ChessGame.Side.NORTH, 6, 2);
        //last
        ChessPiece bishop9 = new BishopPiece(board, ChessGame.Side.NORTH, 1, 1);

        assertFalse(DiagonalMove.isAllowed(bishop, 0, 0));
        assertFalse(DiagonalMove.isAllowed(bishop, 7,7 ));
        assertFalse(DiagonalMove.isAllowed(bishop, 1, 7));
        assertFalse(DiagonalMove.isAllowed(bishop, 7, 1));
    }
}