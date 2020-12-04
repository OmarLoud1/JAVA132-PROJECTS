//Omar Loudghiri oxl51, EECS 132 project 3
// this class implements the pawn moves, which is a piece that can only move one piece on the opposing side direction
import javax.swing.*;
public class PawnPiece extends ChessPiece implements StraightMove, DiagonalMove{
    // the constructor for a pawn piece.
    public PawnPiece(ChessBoard chessBoard, ChessGame.Side side, int row, int column) {
        super("P", chessBoard, side, row, column, new ImageIcon());
    }

    @Override
    public boolean isLegalCaptureMove(int toRow, int toColumn) {
        // the pawn only captures in diagonals
        if (DiagonalMove.isDiagonalMove(this, toRow, toColumn)) {
            //needs to determine the side of the pawn
            //north pawns can only move downwards
            if (this.getSide() == ChessGame.Side.NORTH) {
                // return true if it is moving downwards by one square
                if(this.getRow() == toRow - 1)
                    return isNotSameSide(toRow, toColumn);
            //south pawns can only move upwards
            } else if (this.getSide() == ChessGame.Side.SOUTH) {
                // return true if it is moving upwards by one square
                if(this.getRow() == toRow + 1)
                    return isNotSameSide(toRow, toColumn);
            // east pawns can only move towards the left
            } else if (this.getSide() == ChessGame.Side.EAST) {
                // return true if it is moving one towards the left
                if(this.getColumn() == toColumn + 1)
                    return isNotSameSide(toRow, toColumn);
            //west pawns can only move towards the right
            } else if (this.getSide() == ChessGame.Side.WEST) {
                if (StraightMove.isHorizontalMove(this, toRow, toColumn)) {
                    if(this.getColumn() == toColumn - 1)
                        return isNotSameSide(toRow, toColumn);
                }
            }
        }
       // if not diagonal then false.
       return false;
    }

    @Override
    public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
        if (StraightMove.isStraightMove(this, toRow, toColumn)) {
            //needs to check for the side
            //north pawns can only move downwards
            if (this.getSide() == ChessGame.Side.NORTH) {
                // north pawns can only move vertically
                if (StraightMove.isVerticalMove(this, toRow, toColumn)) {
                    // return true if it is moving downwards by one square
                    if (this.getRow() == toRow - 1) {
                        return true;
                    }
                    // or if it is moving two squares and it is its first row
                    else return (this.getRow() == toRow - 2) && this.getRow() == 1;
                }
                //south pawns can only move upwards
            } else if (this.getSide() == ChessGame.Side.SOUTH) {
                // south pawns can only move vertically
                if (StraightMove.isVerticalMove(this, toRow, toColumn)) {
                    // return true if it is moving upwards by one square
                    if (this.getRow() == toRow + 1) {
                        return true;
                    }
                    // or if it is moving two squares and it is its first row
                    else return (this.getRow() == toRow + 2) && this.getRow() == 6;
                }

            } else if (this.getSide() == ChessGame.Side.EAST) {
                // east pawns can only move horizontaly
                if (StraightMove.isHorizontalMove(this, toRow, toColumn)) {
                    // return true if it is moving one towards the left
                    if (this.getColumn() == toColumn + 1) {
                        return true;
                    }
                    // or if it is moving two squares and it is its first row
                    else return (this.getColumn() == toColumn + 2) && this.getColumn() == 6;
                }
            //west pawns can only move towards the right
            } else if (this.getSide() == ChessGame.Side.WEST) {
                if (StraightMove.isHorizontalMove(this, toRow, toColumn)) {
                    if (this.getColumn() == toColumn - 1) {
                        return true;
                    }
                    // or if it is moving two squares and it is its first row
                    else return (this.getColumn() == toColumn - 2) && this.getColumn() == 1;
                }

            }
        }
    //if not straight move return false
    return false;
    }

    @Override
    // the pawn reaches the other end, we launch the replacing piece method.
    public void moveDone() {
        if (this.atOtherEnd()){
            this.replacePiece();
        }
    }

    //this method will be used to replace this pawn when it reaches the other side of the board
    private void replacePiece(){
        // the possible values when prompting what piece to replace the pawn.
        Object[] possibleValues = { "Knight", "Queen", "Rook", "Bishop" };

        // temps to remember the pawn parameters
        int row = this.getRow();
        int column = this.getColumn();
        ChessBoard board = this.getChessBoard();
        ChessGame.Side side = this.getSide();

        // remove the pawn
        this.getChessBoard().removePiece(this.getRow(), this.getColumn());

        /* prompts the player which type of piece they want the pawn replaced with
        with 4 options: knight, queen , bishop, rook.
         */
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose a piece to replace your pawn", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        // evaluates the return value and adds the selected piece
        if ( selectedValue.equals("Knight")){
            getChessBoard().addPiece(new KnightPiece(board, side, row, column), row, column);
        }
        else if (selectedValue.equals("Queen")){
            getChessBoard().addPiece(new QueenPiece(board, side, row, column), row, column);
        }
        else if (selectedValue.equals("Bishop")){
            getChessBoard().addPiece(new BishopPiece(board, side, row, column), row, column);
        }
        else if (selectedValue.equals("Rook")){
            getChessBoard().addPiece(new RookPiece(board, side, row, column), row, column);
        }
    }

    // checks that the pawn is at the other of its side
    private boolean atOtherEnd(){
        // if a north pawn reaches row on the other side
        if(this.getSide() == ChessGame.Side.NORTH){
            return getRow() == 7;
        }
        //if a south pawn reaches the row on the other side
        else if (this.getSide() == ChessGame.Side.SOUTH){
            return getRow() == 0;
        }
        //if an east pawn reaches the column on the other side
        else if(this.getSide() == ChessGame.Side.EAST){
            return getColumn() == 0;
        }
        // if an east pawn reaches the column on the other side
        else if (this.getSide() == ChessGame.Side.WEST){
            return getColumn() == 7;
        }
    return false;
    }
}
