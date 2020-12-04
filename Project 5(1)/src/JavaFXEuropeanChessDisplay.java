import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;

import java.awt.*;

/**This is the way the european chess chessboard board is set to look
 * @author Omar Loudghiri
 */
public class JavaFXEuropeanChessDisplay implements JavaFXChessboardDisplay {

    /**
     * this is the way empty squares are displayed the colors alternate for each piece
     * @param button the button that is used for the chessboard square
     * @param row    the row of this square on the board
     * @param column the column of this square on the board
     */
    @Override
    public void displayEmptySquare(Button button, int row, int column) {
        button.setStyle((row + column) % 2 == 0 ? "-fx-background-color: #BF424C" : "-fx-background-color: #FADDAF" );
        button.setText("");
    }

    /**
     * The way filled squares are displayed, the north pieces have a green text and the south one have a red text
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
     * square are highlighted whenever they are selected
     * @param highlight is it highlighted or not
     * @param button the button clicked
     * @param row the row of the square selected
     * @param column the column of the square selected
     * @param piece the piece on the highlighted square
     */
    @Override
    public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece) {
        if (highlight) {
            button.setStyle("-fx-background-color: 8D4B42");
        }
        else if (piece == null)
            displayEmptySquare(button, row, column);
        else
            displayFilledSquare(button, row, column, piece);
    }
}

