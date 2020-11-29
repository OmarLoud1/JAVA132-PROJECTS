//Omar Loudghiti oxl51, EECS 132 project 3.
// this class implements the straight move rules and also implements an iterator to run throught the intermediate pieces
// to determine that the path is empty.
public interface StraightMove {
    // a method that checks the move is going straight in either directions
    public static boolean isStraightMove(ChessPiece piece, int toRow, int toColumn){
        // if the column changes value
        if (piece.getColumn() != toColumn )
            //then the row must remain the same for the move to be horizontal
            return ( piece.getRow() == toRow);
        //if the row changes
        else if(piece.getRow() != toRow)
            //then the column must remain the same so the move is vertical
            return (piece.getColumn() == toColumn);
        else
            //if none of the above is true, it is not a straight move
            return false;
    }

    // a method to check that the piece is only moving up or down
    public static boolean isVerticalMove(ChessPiece piece, int toRow, int toColumn){
        if(piece.getRow() != toRow)
            return (piece.getColumn() == toColumn);
        else
            return false;
    }

    // a method that checks if a piece is only moving left or right.
    public static boolean isHorizontalMove(ChessPiece piece, int toRow, int toColumn){
        if(piece.getColumn() != toColumn)
            return (piece.getRow() == toRow);
        else
            return false;
    }

    // a method that must be run after one of the previous methods to check there is no piece on the path
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
            return counter - 1 == (Math.abs(piece.getColumn() - toColumn));
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
            return counter - 1 == (Math.abs(piece.getRow() - toRow)  ) ;
        }
       return false;
    }


}
