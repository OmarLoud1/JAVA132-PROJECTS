// Omar Loudghiri oxl51 EECS 132 project 3
// this class implements the moves for a queen piece, the piece can move in every single direction and it captures the
// same way it moves
import javax.swing.*;

public class QueenPiece extends ChessPiece implements StraightMove, DiagonalMove {

    // a constructor for the queen piece, that sets the chesboard, the side and the location
    public QueenPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("Q", chessBoard, side, row, column, new ImageIcon());
    }

    @Override
    // a method that lets the queen move as many pieces both as a straight move and a diagonal move
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        if(StraightMove.isStraightMove(this, toRow, toColumn)){
            return StraightMove.isAllowed(this, toRow, toColumn);
        }
        else if(DiagonalMove.isDiagonalMove(this, toRow, toColumn)){
            return DiagonalMove.isAllowed(this, toRow, toColumn);
        }
        return false;

    }

    @Override
    // can capture like it moves but it returns whether the piece is of the same side
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if(isLegalNonCaptureMove(toRow, toColumn)){
            return isNotSameSide(toRow, toColumn);
        }
        return false;
    }

    @Override
    // nothing here
    public void moveDone() {}

}
