import javax.swing.*;

/**The Xiangqi Canon Piece
 * @author Omar Loudghiri
 */
public class CanonPiece extends ChessPiece implements StraightMove {

    /**
     * The constructor that makes a canon piece
     * @param chessBoard the chess board it will place in
     * @param side the side it plays on
     * @param row the position
     * @param column the position
     */
    public CanonPiece( ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("C", chessBoard, side, row, column, new ImageIcon());
    }

    /**
     * The canon can move any number of pieces vertically or horizontally so long as there is no piece in the way
     * @param toRow destination
     * @param toColumn destination
     * @return if the move was allowed
     */
    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        if (StraightMove.isStraightMove(this, toRow, toColumn)){
            // this makes sure there is 0 piece between the piece and the destination
            return StraightMove.isAllowed(this, toRow, toColumn);
        }
        return false;
    }

    /**
     * if a canon is capturing, it needs to jump exactly one piece before capturing another piece
     * @param toRow the destination
     * @param toColumn the destination
     * @return if the move is allowed
     */
    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        if (StraightMove.isStraightMove(this, toRow, toColumn)){
            if(CanonPiece.isAllowed(this, toRow, toColumn)){
                return this.isNotSameSide(toRow, toColumn);
            }
        }
        return false;
    }

    @Override
    public void moveDone() {
        // nothing here
    }

    /**
     * This the same method as the allowed method, however, instead of it counting for no piece on the way to the
     * destination, it will make sure there is exactly one piece, and therefore the piece jumps on one piece
     * @param piece the piece that will perform this move
     * @param toRow the destination
     * @param toColumn the destination
     * @return true if there is exactly one piece between the piece and the destination
     */
    public static boolean isAllowed(ChessPiece piece, int toRow, int toColumn){
        // set a counter for the loops below
        int counter = 1;
        if(StraightMove.isHorizontalMove(piece, toRow, toColumn)){
            //while the piece is going towards the left and the counter is smaller than the distance moved
            while (piece.getColumn() > toColumn && counter <= Math.abs(piece.getColumn() - toColumn)){
                //if the next square is empty then we increment the counter
                if(!piece.getChessBoard().hasPiece(toRow, piece.getColumn() - counter))
                    counter ++;
                    //if it is full, then it returns false because it cannot move beyond it.
                else if(piece.getChessBoard().hasPiece(toRow, piece.getColumn() - counter))
                    return false;
            }
            //if the piece going towards the right
            while(piece.getColumn() < toColumn && counter <= Math.abs(piece.getColumn() - toColumn)){
                //if the next square is empty then we increment the counter
                if(!piece.getChessBoard().hasPiece(toRow, piece.getColumn() + counter))
                    counter ++;
                    //if it is full, then it returns false because it cannot move beyond it.
                else if(piece.getChessBoard().hasPiece(toRow, piece.getColumn() + counter))
                    return false;
            }
            // if the counter reached the distance that the pieces needed to move then there is no piece in its path
            return counter == (Math.abs(piece.getColumn() - toColumn));
        }
        if(StraightMove.isVerticalMove(piece, toRow, toColumn)){
            //if going up
            while (piece.getRow() > toRow && counter <= Math.abs(piece.getRow() - toRow)){
                //if the next square is empty then we increment the counter
                if(!piece.getChessBoard().hasPiece(piece.getRow() - counter, toColumn))
                    counter ++;
                    //if it is full, then it returns false because it cannot move beyond it.
                else if(piece.getChessBoard().hasPiece(piece.getRow() - counter, toColumn))
                    return false;
            }
            //if going down
            while(piece.getRow() < toRow && counter <= Math.abs(piece.getRow() - toRow)){
                //if the next square is empty then we increment the counter
                if(!piece.getChessBoard().hasPiece(piece.getRow() + counter, toColumn))
                    counter ++;
                    //if it is full, then it returns false because it cannot move beyond it.
                else if(piece.getChessBoard().hasPiece(piece.getRow() + counter, toColumn))
                    return false;
            }
            // if the counter reached the distance that the pieces needed to move then there is no piece in its path
            return counter == (Math.abs(piece.getRow() - toRow)  ) ;
        }
        return false;
    }
}
