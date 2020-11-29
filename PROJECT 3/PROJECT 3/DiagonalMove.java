// Omar Loudghiri oxl51 EECS 132, Project 3
// An interface that sets the rules for a correct diagonal move, and a rule that checks that there is no
// piece on the way to the intended square.
public interface DiagonalMove {

    /*a method to determine that a move is a diagonal move in either directions
    @param piece, the piece this operating on
    @param toRow, the destination Row
    @param toColumn the destination Column
     */
    static boolean isDiagonalMove(ChessPiece piece, int toRow, int toColumn){
        /*if the difference between the intended row and the actual row, and the difference between current column
          and the intended row is the same then the move is diagonal  */
        return (Math.abs(piece.getRow() - toRow)) == Math.abs(piece.getColumn() - toColumn);
    }

    /* a method that runs through all the intermediate squares and checks they are empty
    @param piece, the piece this operating on since this is a static method
    @param toRow, the destination Row
    @param toColumn the destination Column
     */
     static boolean isAllowed(ChessPiece piece, int toRow, int toColumn){
        int counter = 1;
            //if going south and east
        if(piece.getRow() < toRow && piece.getColumn() < toColumn) {
            while (counter <= Math.abs(piece.getColumn() - toColumn)){
                if (!piece.getChessBoard().hasPiece(piece.getRow() + counter, piece.getColumn() + counter))
                    counter++;
                else if (piece.getChessBoard().hasPiece(piece.getRow() + counter, piece.getColumn() + counter))
                    return false;
                }
        }
        //if going south and west
        if(piece.getRow() < toRow && piece.getColumn() > toColumn) {
            while (counter <= Math.abs (piece.getColumn() - toColumn)){
                if (!piece.getChessBoard().hasPiece(piece.getRow() + counter, piece.getColumn() - counter))
                    counter++;
                else if(piece.getChessBoard().hasPiece(piece.getRow() + counter, piece.getColumn() - counter))
                    return false;
            }
        }
        // northwest
        if(piece.getRow() > toRow && piece.getColumn() > toColumn) {
            while (counter <= Math.abs(piece.getColumn() - toColumn) ) {
                if (!piece.getChessBoard().hasPiece(piece.getRow() - counter, piece.getColumn() - counter))
                    counter++;
                 else if(piece.getChessBoard().hasPiece(piece.getRow() - counter, piece.getColumn() - counter))
                    return false;
            }
        }
        //northeast
        if(piece.getRow() > toRow && piece.getColumn() < toColumn ) {
            while (counter <= Math.abs(piece.getColumn() - toColumn)) {
                if (!piece.getChessBoard().hasPiece(piece.getRow() - counter, piece.getColumn() - counter))
                    counter++;
                else if(piece.getChessBoard().hasPiece(piece.getRow() - counter, piece.getColumn() - counter))
                    return false;
            }
        }
        // if there were no piece in the way between the two pieces it returns true, if not it returns false
        return counter - 1 == (Math.abs(piece.getColumn() - toColumn) );
    }


}
