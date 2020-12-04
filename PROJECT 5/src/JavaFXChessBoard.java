import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.concurrent.Task;

public class JavaFXChessBoard extends Application implements ChessBoard {

    private ChessGame gameRules;            //the rules of this game
    private ChessPiece[][] pieces;          // the pieceson this board

    @Override
    public void start(Stage stage) throws Exception {
        int numRows;
        int numColumns;

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
        }

        String game = getParameters().getRaw().get(0);
        if(game.equals("Chess")) {
            JavaFXEuropeanChessDisplay displayFX = new JavaFXEuropeanChessDisplay();
            EuropeanChess.startGame(new JavaFXChessBoard());
            numRows = gameRules.getNumRows();
            numColumns = gameRules.getNumColumns();
        }
        else if (game.equals("Xiangqi")){
            JavaFXXiangqiDisplay displayFX = new JavaFXXiangqiDisplay();
            Xiangqi.startGame(new JavaFXChessBoard());
            numRows = gameRules.getNumRows();
            numColumns = gameRules.getNumColumns();
        }
        else{
            System.out.println("Enter a valid game");
            numRows = 8;
            numColumns =10;
        }

        Button[][] buttons = new Button[numRows][numColumns];
        GridPane gridPane = new GridPane();

        for(int i = 0; i <= numRows; i++){
            for (int j = 0; j <= numColumns; j++){
                buttons[i][j] = new Button();
                buttons[i][j].setOnAction(new BasicClick());
                gridPane.add(buttons[i][j],j,i);
            }
            Scene scene = new Scene(gridPane);
            stage.setScene(scene);
            stage.setTitle(game);
            stage.show();
        }
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
        //piece.setLocation(row, col);
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

    @Override
    public boolean squareThreatened(int row, int column, ChessPiece piece) {
        return false;
    }

    private class BasicClick implements EventHandler<javafx.event.ActionEvent> {

        @Override
        public void handle(ActionEvent click) {
            Button b = (Button) click.getSource();

            System.out.println("here");
        }
    }


}
