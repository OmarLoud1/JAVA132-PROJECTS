import javax.swing.*;

/**The Xiangqi Soldier piece
 * @author Omar Loudghiri
 */

public class SoldierPiece extends ChessPiece implements StraightMove {

    /**
     * The constructor for a soldier piece
     * @param chessBoard the chess board it will be on
     * @param side the side it plays for
     * @param row the position
     * @param column the position
     */
    public SoldierPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("S", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * A soldier can only move vertically towards the opposite side, when it reaches the middle, the soldier can then
     * move horizontaly
     * @param toRow the row it will move to
     * @param toColumn the column it will move to
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        if (StraightMove.isStraightMove(this, toRow, toColumn)) {
            //needs to check for the side
            if (this.getSide() == ChessGame.Side.NORTH) {
                // north soldiers can only move vertically downwards untill they reach the middle line
                if (this.getRow() <= 4) {
                    if (StraightMove.isVerticalMove(this, toRow, toColumn)) {
                        // return true if it is moving downwards by one square
                        return this.getRow() == toRow - 1;
                    } // then they can move horizontally as well
                } else if (getRow() > 4) {
                    if (StraightMove.isStraightMove(this, toRow, toColumn))
                        return ((this.getRow() == toRow - 1) || ((Math.abs(this.getColumn() - toColumn)) == 1));
                }
            } else if (this.getSide() == ChessGame.Side.SOUTH) {
                // south soldiers can only move vertically upwards untill they reach the middle line
                if (this.getRow() >= 4) {
                    if (StraightMove.isVerticalMove(this, toRow, toColumn)) {
                        // return true if it is moving dupwards by one square
                        return this.getRow() == toRow + 1;
                    } // then they can move horizontally as well
                } else if (getRow() < 4) {
                    if (StraightMove.isStraightMove(this, toRow, toColumn))
                        return ((this.getRow() == toRow + 1) || ((Math.abs(this.getColumn() - toColumn)) == 1));
                }
            }

        }
        return false;
    }

    /**
     * it can capture the same way it moves on an non capture move, it just checks if the destination piece is of different side
     * @param toRow destination
     * @param toColumn destination
     * @return if the capture is allowed
     */
    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        // the soldier can capture on its normal moves
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
