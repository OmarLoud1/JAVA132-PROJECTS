/* Omar Loudghiri oxl51 EECS 132 project 3
An abstract class that is the mold for all the chess pieces we will be using in the game
it has a side that piece will be playing from, a label to characterize the piece, an image icon
it also has the piece's location (row and column), it also determines which chessboard this piece is supposed to
be on.
 */
public abstract class ChessPiece {

    // stores the side this chess piece is on;
    private ChessGame.Side side;
    // a string that stores the name of this piece
    private String label;
    // an object that stores the graphics of this piece
    private Object icon;
    // a field to store the row the object is on
    private int row;
    // a field to store the column the object is on
    private int column;
    // a field that stores which chess board the piece is on
    private final ChessBoard chessBoard;

    /* Constructor of a chess piece, it sets the side the label of the piece, and the location it starts on
    @param label is the letter that is shown on the display to differentiate between pieces on the board
    @param chessboard is the board this piece belongs to
    @param side is the side or player this piece belongs to
    @param row, the row this starts is created on
    @param column the column this piece is created on
    @param icon is the image that is set for this piece
     */
    protected ChessPiece( String label, ChessBoard chessBoard, ChessGame.Side side, int row, int column, Object icon ) {
        this.label = label;
        this.chessBoard = chessBoard;
        this.side = side;
        this.row = row;
        this.column = column;
        this.icon = icon;
    }

    // a method to set the side the piece is playing on, takes one of the enum sides
    public void setSide(ChessGame.Side side){
        this.side = side;
    }

    // a method to retrieve what side this piece is playing on, returns one of the enum sides
    public ChessGame.Side getSide(){
        return this.side;
    }

    // a method to retrieve the piece's name
    public String getLabel() {
        return label;
    }

    // a method to set the piece's name
    public void setLabel(String label) {
        this.label = label;
    }

    // a method to retrieve the picture of this piece
    public Object getIcon() {
        return icon;
    }

    // a method to change the picture assigned to this piece
    public void setIcon(Object icon) {
        this.icon = icon;
    }

    // a method to return the row the piece is on
    public int getRow() {
        return row;
    }

    // a method to return the column this piece is on
    public int getColumn() {
        return column;
    }

    // a private method to change the row the object is on
    private void setRow(int row) {
        this.row = row;
    }

    // a private method to change the column this piece is on
    private void setColumn(int column) {
        this.column = column;
    }

    // a method to change both the row and the column of a piece in order to change the location
    public void setLocation(int row, int column){
        this.setRow(row);
        this.setColumn(column);
    }

    // a method to return which chessboard this piece belongs to.
    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    /* a method that behaves differently on each chess piece, determines if a move is allowed
    @param toRow is the row this piece  is moving to
    @param toColumn is the column this piece is moving to
    returns a boolean that determines whether the move is allowed or not*/
    public boolean isLegalMove(int toRow, int toColumn){
        //if the there is a piece at the destination, it checks if it's legal to capture it.
        if(getChessBoard().hasPiece(toRow, toColumn))
            return this.isLegalCaptureMove(toRow, toColumn);
            //if it is empty then it checks that the piece can move there
        else if(!getChessBoard().hasPiece(toRow, toColumn))
            return this.isLegalNonCaptureMove(toRow, toColumn);
        return false;
    }

    /* a method that checks that the square a piece is trying to move to is not of the same side,
    and therefore can be captured.
     @param toRow is the row this piece  is moving to
     @param toColumn is the column this piece is moving to
     */
    public boolean isNotSameSide(int toRow, int toColumn){
        //checks that there is a piece
        if(this.getChessBoard().hasPiece(toRow, toColumn))
            // returns true if side of the piece that calls the method is not the same as the piece in the square intended
            return (this.getSide() != this.getChessBoard().getPiece(toRow, toColumn).getSide());
        // if there is no piece then this method returns false
        else return false;
    }

    // a method to determine whether a piece is allowed to move to that location if no other piece is on it
    public abstract boolean isLegalNonCaptureMove(int toRow, int toColumn);

    // a method to determine whether a piece is allowed to capture the piece in the specified location
    public abstract boolean isLegalCaptureMove(int toRow, int toColumn);

    public abstract void moveDone();
}