import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/** This is an implementation of a Java FX display for a chess board on which we can play European Chess or Xiangqi
 * @author Omar Loudghiri
 */

public class JavaFXChessBoard extends Application implements ChessBoard {

    private ChessGame gameRules;                      //the rules of this game
    private ChessPiece[][] pieces;                   // the pieces this board
    private Button[][] buttons;                     // the buttons that will be represent the pieces
    private JavaFXChessboardDisplay displayFX;     // the way this game is displayed
    private JavaFXChessBoard board;

    private boolean firstPick = true;   // indiacted if this button click is the first one in a series of two
    private int pieceRow;              // remember row of selected piece
    private int pieceCol;             // remember column of selected piece
    private ChessPiece pieceSelected; // recalls the last piece that was selected

    public JavaFXChessBoard(){
        // creates more pieces than needed.
            pieces = new ChessPiece[10][10];
            buttons = new Button[10][10];
    }

    @Override
    public void start(Stage stage) throws Exception {
        int numRows;        // the number of rows in this game
        int numColumns;     // the number of columns in this game


        // retrieves what game the user want to play and initializes the component of that game
        String game = getParameters().getRaw().get(0);
        if (game.equals("Chess")) {
                board = new JavaFXChessBoard();
                EuropeanChess chess = new EuropeanChess();
                board.setGameRules(chess);
                numRows = board.getGameRules().getNumRows();
                numColumns = board.getGameRules().getNumColumns();
                displayFX = new JavaFXEuropeanChessDisplay();

                EuropeanChess.startGame(board);

            } else if (game.equals("Xiangqi")) {
                 board = new JavaFXChessBoard();
                 Xiangqi xiangqi =new Xiangqi();
                 board.setGameRules(xiangqi);
                 numRows = board.getGameRules().getNumRows() ;
                 numColumns = board.getGameRules().getNumColumns();
                 displayFX = new JavaFXXiangqiDisplay();

                 Xiangqi.startGame(board);
            } else {
                 System.out.println("Enter a valid game: Either Chess or Xiangqi");
                 throw new Exception();
              }

        //creates a gridPane to put the pieces and buttons in
        pieces = new ChessPiece[numRows][numColumns];
        GridPane gridBoard = new GridPane();
        int width = 70 * numColumns;
        int height = 70 * numRows;
        buttons = new Button[numRows][numColumns];

        //creates a button for each square going through rows and columns and adds them to the GridPane
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].setOnAction(new BasicClick());
                buttons[i][j].setPrefSize(70,70);

                displayFX.displayEmptySquare(buttons[i][j],i,j);
                gridBoard.add(buttons[i][j],j,i);

                if(board.hasPiece(i,j))
                    displayFX.displayFilledSquare(buttons[i][j],i,j,board.getPiece(i,j));
            }
        }
        stage.setScene(new Scene(gridBoard, width, height));
        stage.setResizable(false);
        stage.setTitle(game);
        stage.show();
    }

    /**
     * this method retrieves whether it was the first pick
     * @return true if it is the first pick
     */
    public boolean getFirstPick(){
        return this.firstPick;
    }

    /**
     * changes the boolean value first pick
     * @param pick the value of the pick
     */
    public void setFirstPick(boolean pick){
        this.firstPick = pick;
    }

    /**
     * retrieves the last piece selected
     * @return the value of the piece
     */
    public ChessPiece getPieceSelected(){
        return this.pieceSelected;
    }

    /**
     * sets the recalled piece
     * @param piece the value of the piece
     */
    public void setPieceSelected(ChessPiece piece){
        this.pieceSelected = piece;
    }

    /**
     *changes the rules of the game played
     * @param rules the games we want to play
     */
    private void setGameRules(ChessGame rules){
        this.gameRules = rules;
    }

    /**
     * get the rules of the game played on this board
     * @return the name of the game
     */
    @Override
    public ChessGame getGameRules() {
        return this.gameRules;
    }

    /**
     * Adds a piece to this board
     * @param piece the type of piece to add
     * @param row the row the piece will be added to
     * @param column the column this piece will be added to
     */
    public void addPiece(ChessPiece piece, int row, int column){
        pieces[row][column] = piece;
        piece.setLocation(row, column);
    }

    /**
     * removes a piece in the input location
     * @param row the row where the piece is
     * @param column the column where the piece is
     * @return the piece that was removed
     */
    public ChessPiece removePiece(final int row, final int column){
        ChessPiece tmp = pieces[row][column];
        pieces[row][column]  = null;
        return tmp;
    }

    /**
     * checks if there is a piece on this location
     * @param row the row to examine
     * @param column the column to examine
     * @return true if there is a piece, false if there is no piece
     */
    public boolean hasPiece(int row, int column){
        return this.pieces[row][column] != null;
    }

    /**
     * retrieves the piece on a specific location
     * @param row the row to examine
     * @param column the column to examine
     * @return the piece that is on that location
     */
    public ChessPiece getPiece(int row, int column){
        return pieces[row][column];
    }

    /**
     * Returns true if a particular square is threatened by an opposing piece.
     * @param row     the row of the square
     * @param column  the column of the square
     * @param piece   a piece of the game
     */
    @Override
    public boolean squareThreatened(int row, int column, ChessPiece piece) {

       return true;
    }

    /** A Nested Class that implements the actionEvent and defines the way buttons are handled
     *
     */
    private class BasicClick implements EventHandler<javafx.event.ActionEvent> {
        /**
         * handles the click performed on the pieces.
         * @param click the input click that this method detects
         */
        @Override
        public void handle(ActionEvent click) {
            Button b = (Button) click.getSource();
            //values which are not on the board
            int col = -1;
            int row = -1;

            // first find which button (board square) was clicked.
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttons[i][j] == b) {
                        row = i;
                        col = j;
                    }
                }
            }
            //if it is the first pic, it highlights the piece selected if it is allowed to play and stores it
            if(board.getFirstPick()) {
                pieceRow = row;
                pieceCol = col;
                if(board.hasPiece(pieceRow,pieceCol) && board.getGameRules().legalPieceToPlay(board.getPiece(row, col), row, col)) {
                    displayFX.highlightSquare(true, buttons[row][col], row, col, pieces[row][col]);
                    board.setPieceSelected(board.getPiece(row,col));

                    board.setFirstPick(false);
                }

            } // when it is the second click
            else { // if the second click is on the same spot it returns empty
                if (row == pieceRow && col == pieceCol)
                    return;

                boolean movePossible = board.getPiece(pieceRow,pieceCol).isLegalMove(row,col);
                // if the piece can be moved it removes it from the first display and displays it on the destination pic
                if (movePossible && board.getGameRules().legalPieceToPlay(board.getPieceSelected(), board.pieceRow, board.pieceCol)) {
                    board.setPieceSelected(board.getPiece(pieceRow,pieceCol));

                    if(board.getPieceSelected() != null) {
                        board.getGameRules().makeMove(board.getPieceSelected(), row, col);

                        displayFX.highlightSquare(false, buttons[pieceRow][pieceCol], pieceRow, pieceCol, getPieceSelected());
                        displayFX.displayEmptySquare(buttons[pieceRow][pieceCol], pieceRow, pieceCol);
                        displayFX.displayFilledSquare(buttons[row][col], row, col, board.getPieceSelected());

                        board.setFirstPick(true);
                    }
                }

            }

        }
    }


}
