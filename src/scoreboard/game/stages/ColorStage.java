package scoreboard.game.stages;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import scoreboard.ScoreBoard;

public class ColorStage extends GameStage {
    private static ColorStage _this;
    private Object label;
    public static ColorStage getInstance(Object o) {
        try {
            if (_this == null) {
                _this = new ColorStage();
            }
            _this.label = o;
        } catch (Exception e) {}
        return _this;
    }

    private static void garbage() {
        _this = null;
        System.gc();
    }
    public void setColor(String txt) {
        if (txt.equals("Green")) {
            ((Label)label).setTextFill(javafx.scene.paint.Color.web("#41cc00"));
        } else if (txt.equals("Red")) {
            ((Label)label).setTextFill(javafx.scene.paint.Color.web("RED"));
        }
        getStage().close();
        garbage();
    }

    public static ColorStage getInstance() {
        try {
            if (_this == null) {
                _this = new ColorStage();
            }
        } catch (Exception e) {}
        return _this;
    }

    public ColorStage() throws Exception {
        super(ScoreBoard.class.getResource("/scoreboard/color/FXMLColor.fxml"));
        getStage().setResizable(false);
        getStage().getIcons().add(new Image(ColorStage.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
        getStage().setTitle("Color Picker");
        Scene scoreBoardScene = new Scene(getPane());
        scoreBoardScene.setFill(Color.TRANSPARENT);
        getStage().setScene(scoreBoardScene);
    }



}
