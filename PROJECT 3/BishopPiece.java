//Omar Loudghiri oxl51 eecs 132 project 3
//this class represents a bishop piece which moves diagonally in any direction as long as the path is empty
import javax.swing.*;
public class BishopPiece extends ChessPiece implements DiagonalMove {

    /* Constructor that assigns a label and a chessboard and a side and a location to this piece
     * @param chessBoard sets the chess board this piece is playing on
     */
    protected BishopPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("B", chessBoard, side, row, column, new ImageIcon());
    }

    @Override
    // a method that makes sure the bishop is moving diagonally and that there is nothing on its way
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        // if the move is a diagonal
        if(DiagonalMove.isDiagonalMove(this, toRow, toColumn)){
            // if there are no pieces between the destination and the piece then it can move there
            return DiagonalMove.isAllowed(this, toRow, toColumn);
        }
        return false;
    }

    @Override
    // a method that checks that move is diagonal and that the piece it captures is of the other side.
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        //if the move is a diagonal
        if(DiagonalMove.isDiagonalMove(this, toRow, toColumn)){
            // if there are no pieces between the destination and the piece
            if(DiagonalMove.isAllowed(this, toRow, toColumn))
                //it returns whether the last piece is not same side
                return isNotSameSide(toRow,toColumn);
        }
        return false;
    }

    @Override
    //there is nothing to do after the bishop moves
    public void moveDone(){};
}
