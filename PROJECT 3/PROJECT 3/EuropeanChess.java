/*Omar Loudghiri oxl51 Project 3
A class that implements the rules of european chess through determining which side is legal to play, and
moving pieces from when their move is legal. It also implements the main method that creates the chessboard with all
the playing pawns
 */
import javax.swing.JOptionPane;
public class EuropeanChess implements ChessGame{
    /* a field that initializes the first player allowed to move, true means that north or west can play, false means
    that the playing side is south or east*/
    private boolean playingSide = true ;

    //setter method for the playing side
    public void setPlayingSide(boolean side){
        this.playingSide = side;
    }

    //getter method for the playing side
    public boolean getPlayingSide(){
        return this.playingSide;
    }

    public static void main(String[] args){
        // make the chessboard
        ChessBoard board = new ChessBoard(8,8, new EuropeanChessDisplay(), new EuropeanChess());

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


    @Override
    /* a method that determines which side can play, the first sides to play are North if in a north south game
     or west if it's a west east game */
    public boolean legalPieceToPlay(ChessPiece piece, int row, int column) {
        //if the piece picked is either north or west and the playing side flag is true the piece is legal to play
        if((piece.getSide() == Side.NORTH && playingSide) || (piece.getSide() == Side.WEST && playingSide)) {
            return true;
        //else if it is a south or west and the flag is false then it is legal to play
        }else if((piece.getSide() == Side.SOUTH && !playingSide) || (piece.getSide() == Side.EAST && !playingSide)) {
            return true;
        }
        // returns false if a piece doesn't have a side.
        return false;

    }

    @Override
    // a method that moves the piece if that move is legal
    public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
        // checks it's an overall legal move
        if(!piece.isLegalMove(toRow, toColumn))
            return false;
        /* if it is a legal non capture move and the destination has no piece, the piece is moved and then it
           changes the playing side  */
        else if(piece.isLegalNonCaptureMove(toRow, toColumn) && !piece.getChessBoard().hasPiece(toRow, toColumn)) {
            piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
            piece.getChessBoard().addPiece(piece, toRow, toColumn);
            piece.moveDone();
            // when the move is done change playing side
            setPlayingSide(!this.getPlayingSide());
            return true;
        }
        /* if it is a legal capture move and there is a piece besides a king at the destination, the piece captured is removed,
          and the capturing pieces moves to that location, if the captured piece is a king, then the game is lost*/
        else if(piece.isLegalCaptureMove(toRow, toColumn) && piece.getChessBoard().hasPiece(toRow, toColumn)){
            if(!piece.getChessBoard().getPiece(toRow,toColumn).getLabel().equals("K")) {
                piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
                piece.getChessBoard().removePiece(toRow, toColumn);
                piece.getChessBoard().addPiece(piece, toRow, toColumn);
                piece.moveDone();
                // when the move is done change playing side
                setPlayingSide(!this.getPlayingSide());
                return true;
            }
            else{
                //removes the king and print an Message telling the player they lost
                piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
                piece.getChessBoard().removePiece(toRow, toColumn);
                piece.getChessBoard().addPiece(piece, toRow, toColumn);
                piece.moveDone();
                JOptionPane.showMessageDialog(null, "YOU LOST","Message", JOptionPane.ERROR_MESSAGE);
            }

        }
        return false;
    }

    @Override
    public boolean canChangeSelection(ChessPiece piece, int row, int column) {
        return true;
    }
}
