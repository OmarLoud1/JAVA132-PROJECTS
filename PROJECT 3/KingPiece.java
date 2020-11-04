//Omar Loudghiri oxl51 eecs 132, project 3
// this class defines the moves of a king piece, it can only move one square in all directions
import javax.swing.*;
// a class that sets the behavior needed for the king
public class KingPiece extends ChessPiece implements StraightMove,DiagonalMove{

    // a field that stores how many move that king has done
    private int counter = 0;

    //constructor that creates a king piece and gives a side a chessboard and a location
    protected KingPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("K", chessBoard, side, row, column, new ImageIcon());
    }

    public int getKingCounter(){
        return this.counter;
    }

    public void addCounter(){
        this.counter += 1;
    }

    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        //when the move is diagonal the difference between either the row or column to the destination should be absolute value of 1
        if (DiagonalMove.isDiagonalMove(this, toRow, toColumn)) {
            return Math.abs(this.getRow() - toRow) == 1;
        }
        // when the move is horizontal it can only move one column at a time
        else if (StraightMove.isHorizontalMove(this, toRow, toColumn)) {
            return Math.abs(this.getColumn() - toColumn) == 1;
        }
        // when it is moving vertically it can only move one row at a time
        else if (StraightMove.isVerticalMove(this, toRow, toColumn)) {
            return Math.abs(this.getRow() - toRow) == 1;
        }

        // if none of the above then not legal move
        return false;
    }

    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        // the king can capture on its normal moves
        if(isLegalNonCaptureMove(toRow, toColumn))
            //returns that piece to capture is not of the same side
            return this.isNotSameSide(toRow, toColumn);
        //if not not a legal non capture move, this is false
        return false;
    }

    @Override
    // counts how many times a king has moved for the castle method
    public void moveDone() {
        addCounter();
    }

}
