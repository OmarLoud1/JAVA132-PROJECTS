//Omar Loudghiri oxl51 Project 3
// testing class for european chess.

import static org.junit.jupiter.api.Assertions.*;

class EuropeanChessTest extends EuropeanChess {
    //first we create a board for the piece to move in
    ChessBoard board = new SwingChessBoard(new EuropeanChessDisplay(), new EuropeanChess());
    // then we create a north and a south king piece
    KingPiece kingN = new KingPiece(board, ChessGame.Side.NORTH, 4, 4);
    KingPiece kingS = new KingPiece(board, ChessGame.Side.SOUTH, 0, 4);


    @org.junit.jupiter.api.Test
    void testlegalPieceToPlay() {
        // boolean playing side is automatically set to true, meaning the north piece starts
        assertTrue(legalPieceToPlay(kingN,4,4));
        // and a south piece cannot play
        assertFalse(legalPieceToPlay(kingS,0,4));
        // make a move to change the playing side
        makeMove(kingN,4,5);
        // now south pieces can move
        assertTrue(legalPieceToPlay(kingS,0,4));
        assertFalse(legalPieceToPlay(kingN,4,5));
    }

    @org.junit.jupiter.api.Test
    void testmakeMove() {
        board.addPiece(kingN,4,4);
        // moves the piece
        makeMove(kingN,4,5);
        // make sure the make move moved the piece
        assertEquals(kingN.getColumn(),5);
    }
}