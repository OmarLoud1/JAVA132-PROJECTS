import javafx.scene.control.Button;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;

/** This class represents the way a Xiangqi board is supposed to look like
 * @author Omar Loudghiri
 */

public class JavaFXXiangqiDisplay implements JavaFXChessboardDisplay {

    /**
     * The way the empty squares look like, there are two sqaure on each end of the sides withdarker color and everything
     * else is the same color
     * @param button the button that is used for the chessboard square
     * @param row    the row of this square on the board
     * @param column the column of this square on the board
     */
    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        if((row == 0 || row == 1 || row == 2 || row == 8 || row == 7 || row == 9) &&
                (column == 3 || column == 4 || column == 5))
            button.setStyle("-fx-background-color: cc5200");
        else
            button.setStyle("-fx-background-color: ffd1b3");
        button.setText("");
    }

    /**
     * the way filled square should look like, red text for south and green text for north
     * @param button the button to select that square
     * @param row the row of the square
     * @param column the column of the square
     * @param piece the piece that is selected with the button
     */
    @Override
    public void displayFilledSquare(Button button, int row, int column, ChessPiece piece) {
        if(piece.getSide() == ChessGame.Side.NORTH)
            button.setStyle("-fx-text-fill: green");
        else
            button.setStyle("-fx-text-fill: red");

        button.setText(piece.getLabel());

    }

    /**
     * highlighted selected squares
     * @param highlight is it highlighted or not
     * @param button the button clicked
     * @param row the row of the square selected
     * @param column the column of the square selected
     * @param piece the piece on the highlighted square
     */
    @Override
    public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece) {
        if (highlight) {
            button.setStyle("-fx-background-color: 8D4B8C");
        }
        else if (piece == null)
            displayEmptySquare(button, row, column);
        else
            displayFilledSquare(button, row, column, piece);
    }
}
