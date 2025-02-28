import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * <p>Creates a chessboard in a window on the desktop.  The ChessBoard has a ChessBoardDisplay object that determines
 * how the individual squares of the chessboard should be drawn.</p>
 *
 * <p>The chessboard uses a ChessGame object to determine how the game should be played.  The way the chessboard works
 * is as follows.  The player selects a piece by clicking on the board, and
 * and the chessboard calls the <tt>legalPieceToPlay</tt> method of the ChessGame object.
 * If the player is allowed to select the piece, the board highlights it, and the player can select another square on
 * the board.  The chessboard then calls the <tt>makeMove</tt> method of the ChessGame object.  The ChessGame is
 * responsible for determining if the move is valid, and if it is to update the game and the chessboard
 * with the results of making that move.</p>
 *
 * @author Harold Connamacher
 * @author (additions) Omar Loudghiri
 */

public class SwingChessBoard implements ChessBoard{

    private ChessGame gameRules;            //the rules of this game
    private ChessPiece[][] pieces;          // the pieceson this board
    private JFrame board;                          // the game board
    private final JButton[][] squares;                   // the squares of the board
    private final SwingChessBoardDisplay boardDisplay;        // rules for how to draw the chess board

    /**
     * Builds a board of the desired size, the display parameters, and the rules for the chess game.
     * @param gameRules  the number of rows for the chessboard
     * @param boardDisplay  an object that determines how the squares on the chessboard should be drawn
     */
    public SwingChessBoard(SwingChessBoardDisplay boardDisplay, ChessGame gameRules) {

        final int numRows = gameRules.getNumRows();
        final int numColumns = gameRules.getNumColumns();

        // for Mac computers: this allows us to change a button background
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
        }
        // initialize the board
        this.boardDisplay = boardDisplay;
        squares = new JButton[numRows][numColumns];

        // create the board visuals on the event dispatch thread
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    board = new JFrame();

                    // create a grid for the squares and the listener for the user clicks
                    JPanel panel = new JPanel(new GridLayout(numRows, numColumns));
                    ActionListener responder = new SwingChessBoard.ChessAction();

                    // create the squares
                    for (int i = 0; i < numRows; i++) {
                        for (int j = 0; j < numColumns; j++) {
                            squares[i][j] = new JButton();
                            squares[i][j].addActionListener(responder);
                            boardDisplay.displayEmptySquare(squares[i][j], i, j);
                            panel.add(squares[i][j]);
                            pieces[i][j] = null;
                        }
                    }
                    board.add(panel);
                    board.setSize(boardDisplay.getSquareSize() * numColumns, boardDisplay.getSquareSize() * numRows);
                    board.setVisible(true);
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the number of rows in the board.
     * @return the number of rows
     */
    public final int numRows() {
        return squares.length;
    }

    /**
     * Returns the number of columns in the board.
     * @return the number of columns
     */
    public final int numColumns() {
        return squares[0].length;
    }

    /**
     * get the game played on this board
     * @return the type of game played
     */
    @Override
    public ChessGame getGameRules() {
        return this.gameRules;
    }

    /**
     *  Adds a piece to the board at the desired location.  Any piece currently
     *  at that location is lost.
     *  @param piece   the piece to add
     *  @param row     the row for the piece
     *  @param col     the column for the piece
     */
    @Override
    public void addPiece(final ChessPiece piece, final int row, final int col) {
        // set the piece on the board, tell the piece where it is, and then use the display rules to display the square
        // run the display code on the event dispatch thread

        pieces[row][col] = piece;
        piece.setLocation(row, col);

        Runnable addPiece = new Runnable() {
            public void run() {
                boardDisplay.displayFilledSquare(squares[row][col], row, col, piece);
            }
        };

        // run the code to change the display on the event dispatch to avoid drawing errors
        if (SwingUtilities.isEventDispatchThread())
            addPiece.run();
        else {
            try {
                SwingUtilities.invokeAndWait(addPiece);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Removes a piece from the board
     *  @param row  the row of the piece
     *  @param col  the column of the piece
     *  @return  the piece removed of null if there was no piece at that square
     */
    @Override
    public ChessPiece removePiece(final int row, final int col) {
        // remove the piece from the board, use the display rules to show an empty square,
        // and run the display code on the event dispatch thread

        ChessPiece save = getPiece(row, col);

        Runnable removePiece = new Runnable() {
            public void run() {
                boardDisplay.displayEmptySquare(squares[row][col], row, col);
            }
        };
        if (SwingUtilities.isEventDispatchThread())
            removePiece.run();
        else {
            try {
                SwingUtilities.invokeAndWait(removePiece);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return save;
    }

    /** The code the responds when the user clicks on the game board */
    private class ChessAction implements ActionListener {
        private boolean firstPick = true;  // if true, we a selecting a piece
        private int pieceRow;              // remember row of selected piece
        private int pieceCol;              // remember column of selected piece

        /**
         * What we do when the user chooses the piece to move.
         * @param row the row of the chosen piece
         * @param col the column of the chosen piece
         */
        private void processFirstSelection(int row, int col) {
            if ((pieces[row][col] != null) &&
                    (getGameRules() == null || getGameRules().legalPieceToPlay(pieces[row][col], row, col))) {
                /*
                 * if this is the first pick and a square with a piece was picked,
                 * remember the piece's location and highlight the square.
                 */
                pieceRow = row;
                pieceCol = col;
                boardDisplay.highlightSquare(true, squares[row][col], row, col, pieces[row][col]);
                firstPick = false;
            }
        }

        /**
         * What we do when the user chooses the square to move the piece to.
         * @param row the row the piece will move to
         * @param col the column the piece will move to
         */
        private void processSecondSelection(int row, int col) {
            if (row == pieceRow && col == pieceCol)
                return;

            boolean moveMade = getGameRules().makeMove(pieces[pieceRow][pieceCol], row, col);

            // if the move was made or if it was not made and the user select a new piece, then reset to choose a new move
            if (moveMade || getGameRules().canChangeSelection(pieces[pieceRow][pieceCol], pieceRow, pieceCol)) {
                boardDisplay.highlightSquare(false, squares[pieceRow][pieceCol], pieceRow, pieceCol, pieces[pieceRow][pieceCol]);
                firstPick = true;
            }
        }

        /**
         *  Handle a button click.  The method alternates between selecting a piece
         *  and selecting any square.  After both are selected, the piece's
         *  legalMove is called, and if the move is legal, the piece is moved.
         *  @param e   the event that triggered the method
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            int col = -1;
            int row = -1;

            // first find which button (board square) was clicked.
            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {
                    if (squares[i][j] == b) {
                        row = i;
                        col = j;
                    }
                }
            }

            if (firstPick) {
                processFirstSelection(row, col);
            }
            else {
                processSecondSelection(row, col);
            }
        }

    }

    /**
     * Returns true if a particular square is threatened by an opposing piece.
     * @param row     the row of the square
     * @param column  the column of the square
     * @param piece   a piece of the game
     * @return  true if the square can be attacked by a piece of an opposing side as the parameter piece
     */
    @Override
    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (hasPiece(i,j) && getPiece(i, j).getSide() != piece.getSide() &&
                        getPiece(i, j).isLegalMove(row, column))
                    return true;
            }
        }
        return false;
    }


    /**
     * checks if there is a piece on this location
     * @param row the row to examine
     * @param column the column to examine
     * @return true if there is a piece, false if there is no piece
     */
    public boolean hasPiece(int row, int column){
        return pieces[row][column] != null;
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



}
