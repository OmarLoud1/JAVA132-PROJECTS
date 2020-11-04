// Omar Loudghiri oxl51 EECS 132 project 3
// this class implements the legal move for a rook, it can move any number of squares either horizontally or vertically
import javax.swing.*;
public class RookPiece extends ChessPiece implements StraightMove {
    // the constructor for a rook piece, sets its board, its side, and the location
    protected RookPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("R", chessBoard, side, row, column, new ImageIcon());
    }

    @Override
    // the rook can move horizontally or vertically so long as there is no piece on its way
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        if (StraightMove.isStraightMove(this, toRow, toColumn)){
            return StraightMove.isAllowed(this, toRow, toColumn);
        }
        return false;
    }

    @Override
    //it captures like it moves and it returns whether the piece at the destination is of not the same side
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if(isLegalNonCaptureMove(toRow, toColumn)){
            return this.isNotSameSide(toRow, toColumn);
        }
        return false;
    }

    @Override
    // this should implement how many moves the rook has done for the castle move
    public void moveDone() {}
}
