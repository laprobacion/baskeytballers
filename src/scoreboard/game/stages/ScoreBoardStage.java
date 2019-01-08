package scoreboard.game.stages;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import scoreboard.ScoreBoard;

public class ScoreBoardStage extends GameStage {
    private static ScoreBoardStage _this;

    public static ScoreBoardStage getInstance() {
        try {
            if (_this == null) {
                _this = new ScoreBoardStage();
            }
        } catch (Exception e) {}
        return _this;
    }

    public ScoreBoardStage() throws Exception {
        super(ScoreBoard.class.getResource("/scoreboard/main/FXMLDocument.fxml"));
        getStage().setResizable(false);
        getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
        getStage().setTitle("Score Board");
        Scene scoreBoardScene = new Scene(getPane());
        scoreBoardScene.setFill(Color.TRANSPARENT);
        getStage().setScene(scoreBoardScene);
    }
}