import javax.swing.JOptionPane;

/**A class that implements the rules of european chess through determining which side is legal to play, and
 *moving pieces from when their move is legal. It also implements the main method that creates the chessboard with all
 *the playing pawns
 *
 * @author Omar Loudghiri
 */

public class EuropeanChess implements ChessGame{


    /* a field that initializes the first player allowed to move, true means that north or west can play, false means
      that the playing side is south or east*/
    boolean playingSide = true;

    //setter method for the playing side
    @Override
    public void setPlayingSide(boolean side){
        this.playingSide = side;
    }

    //getter method for the playing side
    @Override
    public boolean getPlayingSide(){
        return this.playingSide;
    }

    /** New method
     * @return returns the number of rows in a standard European ChessGame
     */
    @Override
    public int getNumRows() {
        return 8;
    }

    /**New Method
     * @return returns the number of Columns in a normal European Chess game
     */
    @Override
    public int getNumColumns() {
        return 8;
    }


    /**
     * This method creates a standard European chessGame with all the pieces needed to play a north south game
     * @param board this is the board all the pieces will be on, it can be either swing or java FX.
     */
    public static void startGame(ChessBoard board) {

        //make the north initial pieces
        ChessPiece rook1_N = new RookPiece(board, Side.NORTH, 0, 0);
        board.addPiece(rook1_N,0, 0);

        ChessPiece knight1_N = new KnightPiece(board, Side.NORTH, 0, 1);
        board.addPiece(knight1_N, 0, 1);

        ChessPiece bishop1_N = new BishopPiece(board, Side.NORTH, 0, 2);
        board.addPiece(bishop1_N, 0, 2);

        ChessPiece queen_N = new QueenPiece(board, Side.NORTH, 0, 3);
        board.addPiece(queen_N, 0, 3);

        ChessPiece king_N = new KingPiece(board, Side.NORTH, 0, 4);
        board.addPiece(king_N,0,4);

        ChessPiece bishop2_N = new BishopPiece(board, Side.NORTH, 0, 5);
        board.addPiece(bishop2_N, 0, 5);

        ChessPiece knight2_N = new KnightPiece(board, Side.NORTH, 0, 6);
        board.addPiece(knight2_N, 0, 6);

        ChessPiece rook2_N = new RookPiece(board, Side.NORTH, 0, 7);
        board.addPiece(rook2_N,0, 7);

        ChessPiece pawn1_N = new PawnPiece(board, Side.NORTH, 1,0);
        board.addPiece(pawn1_N, 1,0);

        ChessPiece pawn2_N = new PawnPiece(board, Side.NORTH, 1,1);
        board.addPiece(pawn2_N, 1,1);

        ChessPiece pawn3_N = new PawnPiece(board, Side.NORTH, 1,2);
        board.addPiece(pawn3_N, 1,2);

        ChessPiece pawn4_N = new PawnPiece(board, Side.NORTH, 1,3);
        board.addPiece(pawn4_N, 1,3);

        ChessPiece pawn5_N = new PawnPiece(board, Side.NORTH, 1,4);
        board.addPiece(pawn5_N, 1,4);

        ChessPiece pawn6_N = new PawnPiece(board, Side.NORTH, 1,5);
        board.addPiece(pawn6_N, 1,5);

        ChessPiece pawn7_N = new PawnPiece(board, Side.NORTH, 1,6);
        board.addPiece(pawn7_N, 1,6);

        ChessPiece pawn8_N = new PawnPiece(board, Side.NORTH, 1,7);
        board.addPiece(pawn8_N, 1,7);

        // make the initial pieces for the south side

        ChessPiece rook1_S = new RookPiece(board, Side.SOUTH, 7, 0);
        board.addPiece(rook1_S,7, 0);

        ChessPiece knight1_S = new KnightPiece(board, Side.SOUTH, 7, 1);
        board.addPiece(knight1_S, 7, 1);

        ChessPiece bishop1_S = new BishopPiece(board, Side.SOUTH, 7, 2);
        board.addPiece(bishop1_S, 7, 2);

        ChessPiece queen_S = new QueenPiece(board, Side.SOUTH, 7, 4);
        board.addPiece(queen_S, 7, 4);

        ChessPiece king_S = new KingPiece(board, Side.SOUTH, 7, 3);
        board.addPiece(king_S,7,3);

        ChessPiece bishop2_S = new BishopPiece(board, Side.SOUTH, 7, 5);
        board.addPiece(bishop2_S, 7, 5);

        ChessPiece knight2_S = new KnightPiece(board, Side.SOUTH, 7, 6);
        board.addPiece(knight2_S, 7, 6);

        ChessPiece rook2_S = new RookPiece(board, Side.SOUTH, 7, 7);
        board.addPiece(rook2_S,7, 7);

        ChessPiece pawn1_S = new PawnPiece(board, Side.SOUTH, 6,0);
        board.addPiece(pawn1_S, 6,0);

        ChessPiece pawn2_S = new PawnPiece(board, Side.SOUTH, 6,1);
        board.addPiece(pawn2_S, 6,1);

        ChessPiece pawn3_S = new PawnPiece(board, Side.SOUTH, 6,2);
        board.addPiece(pawn3_S, 6,2);

        ChessPiece pawn4_S = new PawnPiece(board, Side.SOUTH, 6,3);
        board.addPiece(pawn4_S, 6,3);

        ChessPiece pawn5_S = new PawnPiece(board, Side.SOUTH, 6,4);
        board.addPiece(pawn5_S, 6,4);

        ChessPiece pawn6_S = new PawnPiece(board, Side.SOUTH, 6,5);
        board.addPiece(pawn6_S, 6,5);

        ChessPiece pawn7_S = new PawnPiece(board, Side.SOUTH, 6,6);
        board.addPiece(pawn7_S, 6,6);

        ChessPiece pawn8_S = new PawnPiece(board, Side.SOUTH, 6,7);
        board.addPiece(pawn8_S, 6,7);
    }
}
