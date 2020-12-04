import javax.swing.*;

/**the Horse piece from Xiangqi
 * @author Omar Loudghiri
 */
public class HorsePiece extends ChessPiece {

    /**
     * The constructor fo the Horse piece
     * @param chessBoard the chessboard it will be on
     * @param side the side it belongs to
     * @param row its position
     * @param column its position
     */
    public HorsePiece( ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("H", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * it moves in L shape how ever it cannot jump on its first move
     * @param toRow the destination
     * @param toColumn the destination
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        return ((toRow == getRow() + 2 &&  toColumn == getColumn() - 1) && (!getChessBoard().hasPiece(getRow()+1,getColumn())) ||

                (toRow == (this.getRow() + 2) && toColumn == (this.getColumn() + 1)) && (!getChessBoard().hasPiece(getRow()+1,getColumn())) ||
                //3
                (toRow == (this.getRow() - 2) && toColumn == (this.getColumn() - 1)) && (!getChessBoard().hasPiece(getRow()-1,getColumn())) ||
                //4
                (toRow == (this.getRow() - 2) && toColumn == (this.getColumn() + 1)) && (!getChessBoard().hasPiece(getRow()-1,getColumn())) ||
                //5
                (toRow == (this.getRow() + 1) && toColumn == (this.getColumn() - 2)) && (!getChessBoard().hasPiece(getRow(),getColumn()-1)) ||
                //6
                (toRow == (this.getRow() - 1) && toColumn == (this.getColumn() - 2)) && (!getChessBoard().hasPiece(getRow(),getColumn()-1)) ||
                //7
                (toRow == (this.getRow() + 1) && toColumn == (this.getColumn() + 2)) && (!getChessBoard().hasPiece(getRow(),getColumn()+1)) ||
                //8
                (toRow == (this.getRow() - 1) && toColumn == (this.getColumn() + 2)) && (!getChessBoard().hasPiece(getRow(),getColumn()-1)) );
    }


    /**
     * it can capture like  it moves
     * @param toRow the destination
     * @param toColumn the destination
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
