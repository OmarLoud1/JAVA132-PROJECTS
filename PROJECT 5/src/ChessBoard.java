/**This the Chessboard class that is independent of swing and JavaFx
 * @author Omar Loudghiri
 */
public interface ChessBoard {


    /**
     * returns the rules for this game
     * @return the ChessGame representing the rules
     */
    public ChessGame getGameRules();

    /**
     * Adds a piece to this board
     * @param piece the type of piece to add
     * @param row the row the piece will be added to
     * @param column the column this piece will be added to
     */
    public void addPiece(ChessPiece piece, int row, int column);

    /**
     * removes a piece in the input location
     * @param row the row where the piece is
     * @param column the column where the piece is
     * @return the piece that was removed
     */
    public ChessPiece removePiece(final int row, final int column);

    /**
     * checks if there is a piece on this location
     * @param row the row to examine
     * @param column the column to examine
     * @return true if there is a piece, false if there is no piece
     */
    public boolean hasPiece(int row, int column);

    /**
     * retrieves the piece on a specific location
     * @param row the row to examine
     * @param column the column to examine
     * @return the piece that is on that location
     */
    public ChessPiece getPiece(int row, int column);

    /**
     * returns if a piece is threatened by another one frma different side
     * @param row     the row of the piece
     * @param column  the column of the piece
     * @param piece   a piece of the game
     * @return  true if the square can be attacked by a piece of an opposing side as the parameter piece
     */
    public boolean squareThreatened(int row, int column, ChessPiece piece);

}
