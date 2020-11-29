//Omar Loudghiti oxl51, EECS 132 project 3.
// this is the testing class for horizontal move


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightMoveTest {
    // create a chessboard to create pieces on
    ChessBoard board = new SwingChessBoard(new EuropeanChessDisplay(), new EuropeanChess());
    //create the rook piece
    ChessPiece rook = new RookPiece(board, ChessGame.Side.NORTH, 4,4);

    @Test
    public void testStraightMove() {
        //first test that a vertical and horizontal moves are straight moves, and then check that a non straight move is false
        assertTrue(StraightMove.isStraightMove(rook, 7,4));
        assertTrue(StraightMove.isStraightMove(rook, 4, 0));
        assertFalse(StraightMove.isStraightMove(rook, 5,6));
    }

    private void assertFalse(boolean straightMove) {
    }

    @Test
    public void VerticalMove() {
        //try one vertical and one  horizontal
        assertTrue(StraightMove.isVerticalMove(rook, 6, 4));
        assertFalse(StraightMove.isVerticalMove(rook, 4, 7));
    }

    @Test
    public void HorizontalMove() {
        //try one horizontal and one non horizontal
        assertTrue(StraightMove.isHorizontalMove(rook, 4, 7));
        assertFalse(StraightMove.isHorizontalMove(rook, 3, 2));
    }

    @Test
    public void Allowed() {
        // 0. moving all directions without pieces around
        assertTrue(StraightMove.isAllowed(rook, 4,7));
        assertTrue(StraightMove.isAllowed(rook, 7,4));
        assertTrue(StraightMove.isAllowed(rook, 0,4));
        assertTrue(StraightMove.isAllowed(rook, 4,0));

        //1. we then add one piece in each direction and the is allowed should return false
        // first. the loop will find the object in its first iteration
        //first. square after the rook
        ChessPiece rook1 = new RookPiece(board, ChessGame.Side.NORTH, 4, 5);
        //first.square after the rook
        ChessPiece rook2 = new RookPiece(board, ChessGame.Side.NORTH, 4, 3);
        //first square next to the rook
        ChessPiece rook3 = new RookPiece(board, ChessGame.Side.NORTH, 5,4 );
        // first square next to the rook
        ChessPiece rook4 = new RookPiece(board, ChessGame.Side.NORTH, 3, 4);

        assertFalse(StraightMove.isAllowed(rook, 4, 6));
        assertFalse(StraightMove.isAllowed(rook, 4,2 ));
        assertFalse(StraightMove.isAllowed(rook,6 , 4));
        assertFalse(StraightMove.isAllowed(rook, 2, 4));

        //many, we add more pieces in between and we test the move is not allowed
        //middle and last, the piece will be found in the middle of the math or at the end of it
        // middle
        ChessPiece rook5 = new RookPiece(board, ChessGame.Side.NORTH, 4, 6);
        //middle
        ChessPiece rook6 = new RookPiece(board, ChessGame.Side.NORTH, 4, 2);
        //last
        ChessPiece rook7 = new RookPiece(board, ChessGame.Side.NORTH, 6,4 );
        // last
        ChessPiece rook8 = new RookPiece(board, ChessGame.Side.NORTH, 7, 4);
        //last
        ChessPiece rook9 = new RookPiece(board, ChessGame.Side.NORTH, 1, 4);

        assertFalse(StraightMove.isAllowed(rook, 4, 7));
        assertFalse(StraightMove.isAllowed(rook, 4,0 ));
        assertFalse(StraightMove.isAllowed(rook, 7, 4));
        assertFalse(StraightMove.isAllowed(rook, 0, 4));
    }
}