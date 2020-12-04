import javax.swing.*;

/** The Xiangqi Guard piece also called advisor
 * @author Omar Loudghiri
 */

public class GuardPiece extends ChessPiece implements DiagonalMove {

    /**
     * A constructor for the guard piece
     * @param chessBoard the chessboard it is put on
     * @param side the side of the piece
     * @param row the position
     * @param column the position
     */
    public GuardPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("G", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * The guard can move one square diagonally in the inner 9 squares
     * @param toRow where the piece will move
     * @param toColumn where the piece will move
     * @return if the move was allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        // if in the allowed squares, and the allowed distance move and a straight move
        if(((toRow == 0 || toRow  == 1 || toRow  == 2 || toRow  == 8 || toRow  == 7 || toRow  == 9)
                && (toColumn == 3 || toColumn == 4 || toColumn == 5))) {
            if (DiagonalMove.isDiagonalMove(this, toRow, toColumn))
                return (((Math.abs(this.getRow() - toRow)) == 1) || ((Math.abs(this.getColumn() - toColumn)) == 1));
        }
        return false;
    }

    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        // the guard can capture on its normal moves
        if(isLegalNonCaptureMove(toRow, toColumn))
            //returns that piece to capture is not of the same side
            return this.isNotSameSide(toRow, toColumn);
        //if not not a legal non capture move, this is false
        return false;
    }

    @Override
    public void moveDone() {
        // nothing here
    }
}
