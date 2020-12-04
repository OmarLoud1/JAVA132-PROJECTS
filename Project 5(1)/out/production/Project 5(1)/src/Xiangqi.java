/** This is the class that sets the rules for a xiangqi game, it also creates all the playing pieces to be set on
 *  a board
 * @author Omar Loudghiri
 */
public class Xiangqi implements ChessGame{

    /* a field that initializes the first player allowed to move, true means that north or west can play, false means
      that the playing side is south or east*/
    boolean playingSide = true;

    /**
     * /setter method for the playing side
     * @param side the side that is supposed to be playing
     */
    @Override
    public void setPlayingSide(boolean side){
        this.playingSide = side;
    }

    /**
     * getter method for the playing side
     * @return the side playing
     */
    @Override
    public boolean getPlayingSide(){
        return this.playingSide;
    }

    /**
     * the number of rows Xiangqi has
     * @return the number 10
     */
    @Override
    public int getNumRows() {
        return 10;
    }

    /**
     * the number of columns xianqgi has
     * @return the number 9
     */
    @Override
    public int getNumColumns() {
        return 9;
    }

    /**
     * This method creates a standard European chessGame with all the pieces needed to play a north south game
     * @param board this is the board all the pieces will be on, it can be either swing or java FX.
     */
    public static void startGame(ChessBoard board) {

        //make the north initial pieces
        ChessPiece rook1_N = new RookPiece(board, Side.NORTH, 0, 0);
        board.addPiece(rook1_N,0, 0);

        ChessPiece horse1_N = new HorsePiece(board, Side.NORTH, 0, 1);
        board.addPiece(horse1_N, 0, 1);

        ChessPiece elephant1_N = new ElephantPiece(board, Side.NORTH, 0, 2);
        board.addPiece(elephant1_N, 0, 2);

        ChessPiece guard_N = new GuardPiece(board, Side.NORTH, 0, 3);
        board.addPiece(guard_N, 0, 3);

        ChessPiece king_N = new XiangqiKingPiece(board, Side.NORTH, 0, 4);
        board.addPiece(king_N,0,4);

        ChessPiece guard1_N = new GuardPiece(board, Side.NORTH, 0, 5);
        board.addPiece(guard1_N,0,5);

        ChessPiece elephant2_N = new ElephantPiece(board, Side.NORTH, 0, 6);
        board.addPiece(elephant2_N, 0, 6);

        ChessPiece horse2_N = new HorsePiece(board, Side.NORTH, 0, 7);
        board.addPiece(horse2_N, 0, 7);

        ChessPiece rook2_N = new RookPiece(board, Side.NORTH, 0, 8);
        board.addPiece(rook2_N,0, 8);

        ChessPiece soldier1_N = new SoldierPiece(board, Side.NORTH, 3,0);
        board.addPiece(soldier1_N, 3,0);

        ChessPiece canon1_N = new CanonPiece(board, Side.NORTH, 2,1);
        board.addPiece(canon1_N, 2,1);

        ChessPiece soldier2_N = new SoldierPiece(board, Side.NORTH, 3,2);
        board.addPiece(soldier2_N, 3,2);

        ChessPiece soldier3_N = new SoldierPiece(board, Side.NORTH, 3,4);
        board.addPiece(soldier3_N, 3,4);

        ChessPiece soldier4_N = new SoldierPiece(board, Side.NORTH, 3,6);
        board.addPiece(soldier4_N, 3,6);

        ChessPiece canon2_N = new CanonPiece(board, Side.NORTH, 2,7);
        board.addPiece(canon2_N, 2,7);

        ChessPiece soldier5_N = new SoldierPiece(board, Side.NORTH, 3,8);
        board.addPiece(soldier5_N, 3,8);

        // make the initial pieces for the south side
        
        ChessPiece rook1_S = new RookPiece(board, Side.SOUTH, 9, 0);
        board.addPiece(rook1_S,9, 0);

        ChessPiece horse1_S = new HorsePiece(board, Side.SOUTH, 9, 1);
        board.addPiece(horse1_S, 9, 1);

        ChessPiece elephant1_S = new ElephantPiece(board, Side.SOUTH, 9, 2);
        board.addPiece(elephant1_S, 9, 2);

        ChessPiece guard_S = new GuardPiece(board, Side.SOUTH, 9, 3);
        board.addPiece(guard_S, 9, 3);

        ChessPiece king_S = new XiangqiKingPiece(board, Side.SOUTH, 9, 4);
        board.addPiece(king_S,9,4);

        ChessPiece guard1_S = new GuardPiece(board, Side.SOUTH, 9, 5);
        board.addPiece(guard1_S, 9, 5);

        ChessPiece elephant2_S = new ElephantPiece(board, Side.SOUTH, 9, 6);
        board.addPiece(elephant2_S, 9, 6);

        ChessPiece horse2_S = new HorsePiece(board, Side.SOUTH, 9, 7);
        board.addPiece(horse2_S, 9, 7);

        ChessPiece rook2_S = new RookPiece(board, Side.SOUTH, 9, 8);
        board.addPiece(rook2_S,9, 8);

        ChessPiece soldier1_S = new SoldierPiece(board, Side.SOUTH, 6,0);
        board.addPiece(soldier1_S, 6,0);

        ChessPiece canon2_S = new CanonPiece(board, Side.SOUTH, 7,1);
        board.addPiece(canon2_S, 7,1);

        ChessPiece soldier2_S = new SoldierPiece(board, Side.SOUTH, 6,2);
        board.addPiece(soldier2_S, 6,2);

        ChessPiece soldier3_S = new SoldierPiece(board, Side.SOUTH, 6,4);
        board.addPiece(soldier3_S, 6,4);

        ChessPiece soldier4_S = new SoldierPiece(board, Side.SOUTH, 6,6);
        board.addPiece(soldier4_S, 6,6);

        ChessPiece canon1_S = new CanonPiece(board, Side.SOUTH, 7,7);
        board.addPiece(canon1_S, 7,7);

        ChessPiece soldier5_S = new SoldierPiece(board, Side.SOUTH, 6,8);
        board.addPiece(soldier5_S, 6,8);
    }
}
