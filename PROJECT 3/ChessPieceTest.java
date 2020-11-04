//Omar Loudghiri oxl51 EECS 132 project 3
// testing doc for chesspiece

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ChessPieceTest {
    // an instance of a chessboard necessary for the chess piece constructor
    ChessBoard board = new ChessBoard(8,8, new EuropeanChessDisplay(), new EuropeanChess());

    // an instance of a king piece which extends a chess piece
    ChessPiece piece = new KingPiece(board, ChessGame.Side.NORTH, 0, 0);

    //set the piece side to south, and check with the getter
    @org.junit.jupiter.api.Test
    void Side() {
        piece.setSide(ChessGame.Side.SOUTH);
        assertEquals(piece.getSide(), ChessGame.Side.SOUTH);
    }

    @org.junit.jupiter.api.Test
    // set the label to O and check with the getter
    void Label() {
        piece.setLabel("O");
        assertEquals(piece.getLabel(), "O");
    }

    @org.junit.jupiter.api.Test
    //set the icon to a string a check with the getter
    void Icon() {
        piece.setIcon("Icon");
        assertEquals(piece.getIcon(), "Icon");
    }

    @org.junit.jupiter.api.Test
    // set the location and then
    void Location() {
        piece.setLocation(3,2);
        assertEquals(piece.getRow(), 3);
        assertEquals(piece.getColumn(), 2);
    }

    @org.junit.jupiter.api.Test
    // we check it was the one set with the constructor
    void getChessBoard() {
        assertEquals(piece.getChessBoard(), board);
    }

    @org.junit.jupiter.api.Test
    void isNotSameSide() {
        // make 3 three pieces, 2 of the same side and one different
        ChessPiece piece = new KingPiece(board, ChessGame.Side.NORTH, 0, 0);
        piece.setLocation(0,0);
        ChessPiece piece1 = new KingPiece(board, ChessGame.Side.NORTH, 2, 6);
        piece1.setLocation(2,6);
        ChessPiece piece2 = new KingPiece(board, ChessGame.Side.SOUTH, 1, 1);
        piece2.setLocation(1,1);

        // piece and piece1 are of the same side so false
        assertFalse(piece.isNotSameSide(2,6));
        //piece1 and piece 2 are of different sides
        assertTrue(piece1.isNotSameSide(1,1));

    }


}