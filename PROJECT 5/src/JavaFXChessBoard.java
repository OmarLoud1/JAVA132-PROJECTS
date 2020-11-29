import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXChessBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String game = getParameters().getRaw().get(0);
        if(game.equals("Chess")) {
            Ja
            EuropeanChess.startGame();

        }


    }
}
