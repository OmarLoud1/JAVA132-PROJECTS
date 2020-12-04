import javax.swing.*;

public class XiangqiKingPiece extends ChessPiece implements StraightMove {


    /**
     * The constructuor for a Xiangqi King
     * @param chessBoard the chessboard it will be put into
     * @param side its side
     * @param row the position
     * @param column the position
     */
    public XiangqiKingPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("X", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * a move to an empty square
     * @param toRow the square moving to
     * @param toColumn the column moving to
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        // if in the allowed squares, and the allowed distance move and a straight move
       if(((toRow == 0 || toRow  == 1 || toRow  == 2 || toRow  == 8 || toRow  == 7 || toRow  == 9)
                && (toColumn == 3 || toColumn == 4 || toColumn == 5))) {
           if (StraightMove.isStraightMove(this, toRow, toColumn))
               return (((Math.abs(this.getRow() - toRow)) == 1) || ((Math.abs(this.getColumn() - toColumn)) == 1));
       }
        return false;
    }

    /**
     * a move to capture another piece
     * @param toRow the row of the other pawn
     * @param toColumn the column of the other pawn
     * @return if the move is allowed
     */
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
    public void moveDone() {

    }
}
