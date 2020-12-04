// Omar Loudghiri oxl51, EECS 132, project 3
// the class that implements the knight legal moving piece.

import javax.swing.ImageIcon;
public class KnightPiece extends ChessPiece{

    //constructor that creates a knight piece and assigns a side, a chessboard and a loaction to it.
    public KnightPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("N", chessBoard, side, row, column, new ImageIcon());
    }

    @Override
    // the knight can move in an L shape in any direction and can jump over other pieces
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        // these are all the allowed L-shaped moves for a knight
        return ((toRow == getRow() + 2 &&  toColumn == getColumn() - 1) ||

                (toRow == (this.getRow() + 2) && toColumn == (this.getColumn() + 1)) ||
                //3
                (toRow == (this.getRow() - 2) && toColumn == (this.getColumn() - 1)) ||
                //4
                (toRow == (this.getRow() - 2) && toColumn == (this.getColumn() + 1)) ||
                //5
                (toRow == (this.getRow() + 1) && toColumn == (this.getColumn() - 2)) ||
                //6
                (toRow == (this.getRow() - 1) && toColumn == (this.getColumn() - 2)) ||
                //7
                (toRow == (this.getRow() + 1) && toColumn == (this.getColumn() + 2)) ||
                //8
                (toRow == (this.getRow() - 1) && toColumn == (this.getColumn() + 2)));
    }

    @Override
    // the knight can capture the same way it moves
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if(isLegalNonCaptureMove(toRow, toColumn)){
            return this.isNotSameSide(toRow, toColumn);
        }
        return false;
    }

    @Override
    // nothing needs to be done here.
    public void moveDone() {}


}
