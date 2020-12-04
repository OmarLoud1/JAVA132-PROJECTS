import javax.swing.*;

/**The Elephant piece from Xiangqi
 * @author Omar Loudghiri
 */
public class ElephantPiece extends ChessPiece implements DiagonalMove {
    /**
     *Makes an elephant piece and place it on the board
     * @param chessBoard the board it will be on
     * @param side the side it plays for
     * @param row location
     * @param column location
     */
    public ElephantPiece( ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("E", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * it can move diagonally two squares
     * @param toRow destination
     * @param toColumn destination
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
            // if the move is a diagonal
            if(DiagonalMove.isDiagonalMove(this, toRow, toColumn)){
                // if there are no pieces between the destination and the piece then it can move there
                if(DiagonalMove.isAllowed(this, toRow, toColumn)){
                    if((toRow <= 4 && this.getSide() == ChessGame.Side.NORTH) || (toRow >= 5 && this.getSide() == ChessGame.Side.SOUTH) )
                    // return that it only moved to squares
                    return (((Math.abs(this.getRow() - toRow)) == 2) || ((Math.abs(this.getColumn() - toColumn)) == 2));
                }
            }
            return false;
    }

    /**
     * a move to capture another pawn
     * @param toRow the row of the other pawn
     * @param toColumn the column of the other pawn
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if(isLegalNonCaptureMove(toRow, toColumn)){
            return this.isNotSameSide(toRow, toColumn);
        }
        return false;
    }

    @Override
    public void moveDone() {

    }
}
