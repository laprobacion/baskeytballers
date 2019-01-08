package scoreboard.color;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import scoreboard.game.stages.ColorStage;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLColorController implements Initializable {
    @FXML
    private ChoiceBox colorPicker;

    public void initialize(URL url, ResourceBundle rb) {
      FXMLColorController.this.colorPicker.getItems().add("Green");
      FXMLColorController.this.colorPicker.getItems().add("Red");

        colorPicker.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                ColorStage.getInstance().setColor( (String) colorPicker.getItems().get((Integer) number2));
            }
        });
    }

}
