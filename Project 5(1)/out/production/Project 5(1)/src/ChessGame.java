import javax.swing.*;

/**
 * An interface that encodes specific rules for a version of chess.  ( The added methods were tested in Project 3 under another class)
 * @author Omar Loudghiri
 * @author Harold Connamacher
 */
public interface ChessGame {
  /** The "side" or "team" or "player" the piece belongs to.  
    * The "players" are named by the compass positions around the board
    */
  public enum Side {NORTH, SOUTH, EAST, WEST};

  // a method that sets which side is up to play
  void setPlayingSide(boolean side);

  // a method to get the value of the playing side
  boolean getPlayingSide();
  
  /** Determines if it is legal to play a given piece.
    * @param piece   the piece to be played
    * @param row     the row of the square the piece is on
    * @param column  the column of the square the piece is on
    * @return true if the piece is allowed to move on this turn
    */

  /* a method that determines which side can play, the first sides to play are North if in a north south game
     or west if it's a west east game */
  default boolean legalPieceToPlay(ChessPiece piece, int row, int column) {
    //if the piece picked is either north or west and the playing side flag is true the piece is legal to play
    if((piece.getSide() == Side.NORTH && getPlayingSide()) || (piece.getSide() == Side.WEST && getPlayingSide())) {
      return true;
      //else if it is a south or west and the flag is false then it is legal to play
    }else if((piece.getSide() == Side.SOUTH && !getPlayingSide()) || (piece.getSide() == Side.EAST && !getPlayingSide())) {
      return true;
    }
    // returns false if a piece doesn't have a side.
    return false;

  }
  
  /** Moves a piece to a new position.
    * @param piece     the piece to move
    * @param toRow     the row of the square the piece is moving to
    * @param toColumn  the column of the square the piece is moving to
    * @return true if the move was made, false if the move was not made
    */
  // a method that moves the piece if that move is legal
  default boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
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
  
  /**
   * Returns whether a user can choose a different piece from the one selected or if they have to move the selected piece.
   * If this method returns false, then the <tt>legalPieceToPlay</tt> method must not return true if that piece has no
   * legal moves.  Otherwise the game could freeze with a player not permitted to change selection of a piece with no legal moves.
   * @param piece   the piece the user selected
   * @param row     the row of the square the piece is on
   * @param column  the column of the square the piece is on
   * @return true if the player can change the piece they selected and false if they cannot and must move that piece
   */
  public default boolean canChangeSelection(ChessPiece piece, int row, int column) {
    return true;
  }

  /**
   * returns the number of rows in this particular game
   * @return the number of rows
   */
  public int getNumRows();

  /**
   * returns the number of rows in this particular game
   * @return the number of rows
   */
  public int getNumColumns();

}
