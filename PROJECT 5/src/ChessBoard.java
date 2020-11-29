/**This the Chessboard class that is independent of swing and JavaFx
 * @author Omar Loudghiri
 */
public abstract class ChessBoard {

    protected ChessGame gameRules;            //the rules of this game
    protected ChessPiece[][] pieces;          // the pieceson this board

    /**
     * returns the rules for this game
     * @return the ChessGame representing the rules
     */
    public ChessGame getGameRules(){
        return this.gameRules;
    }

    /**
     * Adds a piece to this board
     * @param piece the type of piece to add
     * @param row the row the piece will be added to
     * @param column the column this piece will be added to
     */
    public void addPiece(ChessPiece piece, int row, int column){
        pieces[row][column] = piece;
        //piece.setLocation(row, col);
    }

    /**
     * removes a piece in the input location
     * @param row the row where the piece is
     * @param column the column where the piece is
     * @return the piece that was removed
     */
    public ChessPiece removePiece(final int row, final int column){
        ChessPiece tmp = pieces[row][column];
        pieces[row][column]  = null;
        return tmp;
    }

    /**
     * checks if there is a piece on this location
     * @param row the row to examine
     * @param column the column to examine
     * @return true if there is a piece, false if there is no piece
     */
    public boolean hasPiece(int row, int column){
        return pieces[row][column] != null;
    }

    /**
     * retrieves the piece on a specific location
     * @param row the row to examine
     * @param column the column to examine
     * @return the piece that is on that location
     */
    public ChessPiece getPiece(int row, int column){
            return pieces[row][column];
    }

    /**
     * returns if a piece is threatened by another one frma different side
     * @param row     the row of the piece
     * @param column  the column of the piece
     * @param piece   a piece of the game
     * @return  true if the square can be attacked by a piece of an opposing side as the parameter piece
     */
    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalMove(row, column))
                    return true;
            }
        }
        return false;
    }

}
