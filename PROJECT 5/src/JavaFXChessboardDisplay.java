import javafx.scene.control.Button;

/**The javaFX display for a chessboard
 * @author Omar Loudghiri
 */
public interface JavaFXChessboardDisplay {

    /**
     *Display a square that has no piece on it.
     * @param button the button that is used for the chessboard square
     * @param row    the row of this square on the board
     * @param column the column of this square on the board
     */
    void displayEmptySquare(Button button, int row, int column);

    /**
     * Display of a square with a piece on it
     * @param button the button to select that square
     * @param row the row of the square
     * @param column the column of the square
     * @param piece the piece that is selected with the button
     */
    void displayFilledSquare(Button button, int row, int column, ChessPiece piece);

    /**
     * higlights the selected squares
     * @param highlight is it highlighted or not
     * @param button the button clicked
     * @param row the row of the square selected
     * @param column the column of the square selected
     * @param piece the piece on the highlighted square
     */
    void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece);


}
