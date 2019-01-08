 package scoreboard.main;
 
 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.animation.AnimationTimer;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Label;
 import javafx.scene.input.MouseEvent;
 import javafx.stage.Modality;
 import javafx.stage.Stage;
 import javafx.stage.StageStyle;
 import scoreboard.game.Game;
 import scoreboard.game.Team;
 import scoreboard.game.Utility;
 import scoreboard.game.stages.ColorStage;
 import scoreboard.game.stages.ScoreBoardStage;


 public class FXMLDocumentController
   implements Initializable
 {
   @FXML   private Label teamAScore;
   @FXML   private Label teamBScore;
   @FXML   private Label teamAFoul;
   @FXML   private Label teamBFoul;
   @FXML   private Label teamAName;
   @FXML   private Label teamBName;
   @FXML   private Label period;
   @FXML   private Label gameTime;
   private Game game;
   private Team teamA;
   private Team teamB;
   
   @FXML
   private void handleButtonAction(ActionEvent event) {}
   
   public void initialize(URL url, ResourceBundle rb) {
     this.game = Game.getInstance();
     this.teamA = this.game.getDefaultVal().getTeamA();
     this.teamB = this.game.getDefaultVal().getTeamB();
     setFont();
     new AnimationTimer(){
       public void handle(long l){
         FXMLDocumentController.this.updateScreen();
       }
     }.start();
   }
   
    private void updateScreen() {
     this.teamAScore.setText(Utility.appendZero(this.teamA.getTeamScore()));
     this.teamBScore.setText(Utility.appendZero(this.teamB.getTeamScore()));
     this.teamAFoul.setText(String.valueOf(this.teamA.getTeamFouls()));
     this.teamBFoul.setText(String.valueOf(this.teamB.getTeamFouls()));
     this.teamAName.setText(this.teamA.getTeamName());
     this.teamBName.setText(this.teamB.getTeamName());
     this.period.setText(String.valueOf(this.game.getPeriod()));
     this.gameTime.setText(Utility.formatTime(this.game.getGameMinutes(), this.game.getGameSeconds()));
   }

   private void setFont() {
     this.teamAScore.setFont(Utility.getFont(550));
     this.teamBScore.setFont(Utility.getFont(550));
     this.teamAFoul.setFont(Utility.getFont(200));
     this.teamBFoul.setFont(Utility.getFont(200));
     this.teamAName.setFont(Utility.getFont(90));
     this.teamBName.setFont(Utility.getFont(90));
     this.period.setFont(Utility.getFont(400));
     this.gameTime.setFont(Utility.getFont(400));
   }

     public void goToColorPicker(MouseEvent mouseEvent) {
        Stage stage = ColorStage.getInstance(mouseEvent.getSource()).getStage();
        stage.initOwner(ScoreBoardStage.getInstance().getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();
     }
 }
