 package scoreboard.control;
 
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.stage.Stage;
 import scoreboard.game.Default;
 import scoreboard.game.Game;
import scoreboard.game.GameMedia;
 import scoreboard.game.Team;
 import scoreboard.game.Timer;
 import scoreboard.game.Utility;
 import scoreboard.game.stages.MessageBoxStage;
 
 public class FXMLControlController implements javafx.fxml.Initializable
 {
   @FXML   private Label teamAScore;
   @FXML   private Label teamBScore;
   @FXML   private Label teamATOL;
   @FXML   private Label teamBTOL;
   @FXML   private Label teamAFoul;
   @FXML   private Label teamBFoul;
   @FXML   private Label gamePeriod;
   @FXML   private Label gameShotClock;
   @FXML   private Label gameTime;
   @FXML   private Label teamAName;
   @FXML   private Label teamBName;
   @FXML   private Label teamAPenalty;
   @FXML   private Label teamBPenalty;
   @FXML   private Label titleBarLabel;
   @FXML   private Label shotClockLabel;
   @FXML   private Label tolNameALabel;
   @FXML   private Label tolNameBLabel;
   @FXML   private Label foulALabel;
   @FXML   private Label foulBLabel;
   @FXML   private Label periodLabel;
   @FXML   private Label minLabel;
   @FXML   private Label secLabel;
   @FXML   private Button startStopButton;
   @FXML   private Button startStopShotClockButton;
   @FXML   private Button buzzerButton;
   @FXML   private Button shotClockResetButton;
   @FXML   private Button shotClockResetButton1;
   @FXML   private Button clockCancelButton;
   @FXML   private Button shotClockCancelButton;
   @FXML   private TextField shotClockText;
   @FXML   private TextField gameMinText;
   @FXML   private TextField gameSecText;
   @FXML   private javafx.scene.control.MenuItem scoreBoardMenu;
   @FXML   private TextField teamNameAText;
   @FXML   private TextField teamNameBText;
   @FXML   private Label teamANameEditLabel;
   @FXML   private Label teamBNameEditLabel;
   @FXML   private javafx.scene.control.MenuItem resetScoresButton;
   @FXML   private javafx.scene.control.MenuItem resetFoulsButton;
   @FXML   private javafx.scene.control.MenuItem resetTOLsButton;
   @FXML   private javafx.scene.control.MenuItem gameTimeResetButton;
   private Game game;
   private Team teamA;
   private Team teamB;
   private Default def;
   private Thread gameThread;
   private Timer gameTimer;
   private boolean isRunning;
   
   public void initialize(java.net.URL url, java.util.ResourceBundle rb) {
     setFont();
     this.isRunning = false;
     this.game = Game.getInstance();
     this.def = this.game.getDefaultVal();
     this.teamA = this.def.getTeamA();
     this.teamB = this.def.getTeamB();
     this.gameTimer = new Timer(this.game, this);
     this.gameThread = new Thread(this.gameTimer);
     this.gameTimer.setSuspend(true);
     this.startStopButton.setText("Start (F9)");
     this.gameThread.start();
     this.game.setTimerThread(this.gameTimer);
     this.game.setPeriod(1);
     this.clockCancelButton.setVisible(false);
     this.shotClockCancelButton.setVisible(false);
     this.buzzerButton.setGraphic(new javafx.scene.image.ImageView(new javafx.scene.image.Image(scoreboard.ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/siren.png"))));
     
     initValues();
     updateTime();
     Utility.limitToNumberAndMaxLimit(this.shotClockText, 2);
     Utility.limitToNumberAndMaxLimit(this.gameMinText, 2);
     Utility.limitToNumberAndMaxLimit(this.gameSecText, 2);
     this.teamNameAText.setVisible(false);
     this.teamNameBText.setVisible(false);
     this.teamNameAText.setText(this.teamA.getTeamName());
     this.teamNameBText.setText(this.teamB.getTeamName());
     Utility.addTextFieldMaxLimit(this.teamNameAText, 11);
     Utility.addTextFieldMaxLimit(this.teamNameBText, 11);
     
     this.shotClockText.focusedProperty().addListener(new ChangeListener(){
         @Override
         public void changed(ObservableValue observable, Object oldValue, Object newValue) {
             FXMLControlController.this.shotClockCancelButton.setVisible(true);
         }
         
     });
     this.gameMinText.focusedProperty().addListener(new javafx.beans.value.ChangeListener(){
         @Override
         public void changed(ObservableValue observable, Object oldValue, Object newValue) {
             FXMLControlController.this.clockCancelButton.setVisible(true);
         }
         
    });
     this.gameSecText.focusedProperty().addListener(new javafx.beans.value.ChangeListener(){
         @Override
         public void changed(ObservableValue observable, Object oldValue, Object newValue) {
             FXMLControlController.this.clockCancelButton.setVisible(true);
         }
       
     });
   }
   
   private void initValues() {
     this.teamAScore.setText(String.valueOf(this.teamA.getTeamScore()));
     this.teamATOL.setText(String.valueOf(this.teamA.getTimeOutLeft()));
     this.teamAFoul.setText(String.valueOf(this.teamA.getTeamFouls()));
     this.teamBScore.setText(String.valueOf(this.teamB.getTeamScore()));
     this.teamBTOL.setText(String.valueOf(this.teamB.getTimeOutLeft()));
     this.teamBFoul.setText(String.valueOf(this.teamB.getTeamFouls()));
     this.gameShotClock.setText(String.valueOf(this.def.getMaxShotClock()));
     this.gameTime.setText(this.def.getMinutesPerPeriod() + ":00");
     this.teamAName.setText(this.teamA.getTeamName());
     this.teamBName.setText(this.teamB.getTeamName());
     this.gamePeriod.setText(String.valueOf(this.game.getPeriod()));
   }
   
   @FXML
   private void aboutAction(ActionEvent event) {
     try {
       Stage stage = new Stage();
       javafx.scene.Parent main = (javafx.scene.Parent)javafx.fxml.FXMLLoader.load(getClass().getResource("/scoreboard/about/FXMLABout.fxml"));
       javafx.scene.Scene mainScene = new javafx.scene.Scene(main);
       stage.setResizable(false);
       stage.setTitle("About");
       stage.setScene(mainScene);
       stage.show();
       stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
     } catch (Exception e) { e.printStackTrace(); }
   }
   
   @FXML
   private void teamAPlusOneAction(ActionEvent event) { this.teamA.setTeamScore(this.teamA.getTeamScore() + 1); }
   
   @FXML
   private void teamAPlusTwoAction(ActionEvent event){
     this.teamA.setTeamScore(this.teamA.getTeamScore() + 2);
   }
   
   @FXML
   private void teamAPlusThreeAction(ActionEvent event) {
     this.teamA.setTeamScore(this.teamA.getTeamScore() + 3);
   }
   
   @FXML
   private void teamALessOneAction(ActionEvent event) {
     if (this.teamA.getTeamScore() > 0) {
       this.teamA.setTeamScore(this.teamA.getTeamScore() - 1);
     }
   }
   
   @FXML
   private void teamBPlusOneAction(ActionEvent event) {
     this.teamB.setTeamScore(this.teamB.getTeamScore() + 1);
   }
   
   @FXML
   private void teamBPlusTwoAction(ActionEvent event) {
     this.teamB.setTeamScore(this.teamB.getTeamScore() + 2);
   }
   
 
   @FXML
   private void teamBPlusThreeAction(ActionEvent event) { this.teamB.setTeamScore(this.teamB.getTeamScore() + 3); }
   
   @FXML
   private void teamBLessOneAction(ActionEvent event) {
     if (this.teamB.getTeamScore() > 0)
       this.teamB.setTeamScore(this.teamB.getTeamScore() - 1);
   }
   
   @FXML
   private void teamAFoulLessOneAction(ActionEvent event) {
     if (this.teamA.getTeamFouls() > 0)
       this.teamA.setTeamFouls(this.teamA.getTeamFouls() - 1);
   }
   
   @FXML
   private void teamAFoulPlusOneAction(ActionEvent event) {
     this.teamA.setTeamFouls(this.teamA.getTeamFouls() + 1);
   }
   
   @FXML
   private void teamBFoulLessOneAction(ActionEvent event) {
     if (this.teamB.getTeamFouls() > 0)
       this.teamB.setTeamFouls(this.teamB.getTeamFouls() - 1);
   }
   
   @FXML
   private void teamBFoulPlusOneAction(ActionEvent event) {
     this.teamB.setTeamFouls(this.teamB.getTeamFouls() + 1);
   }
   
   @FXML
   private void shotClockResetAction(ActionEvent event) {
     this.game.setShotClock(this.def.getMaxShotClock());
   }
   @FXML
   private void shotClockResetAction1(ActionEvent event) {
     this.game.setShotClock(this.def.getMaxShotClock1());
   }
   @FXML
   private void teamATOLLessOneAction(ActionEvent event) {
     if ((this.teamA.getTimeOutLeft() > 0) && (!scoreboard.game.stages.TimeOutStage.getInstance().isIsLoaded())) {
       this.teamA.setTimeOutLeft(this.teamA.getTimeOutLeft() - 1);
       callTimeOut();
     } else {
       MessageBoxStage.getInstance().setMessage(true, "Timeout is already running.", 0);
     }
   }
   
   @FXML
   private void teamATOLPlusOneAction(ActionEvent event) {
     this.teamA.setTimeOutLeft(this.teamA.getTimeOutLeft() + 1);
   }
   
   @FXML
   private void teamBTOLLessOneAction(ActionEvent event) throws java.io.IOException {
     if ((this.teamB.getTimeOutLeft() > 0) && (!scoreboard.game.stages.TimeOutStage.getInstance().isIsLoaded())) {
       this.teamB.setTimeOutLeft(this.teamB.getTimeOutLeft() - 1);
       callTimeOut();
     } else {
       MessageBoxStage.getInstance().setMessage(true, "Timeout is already running.", 0);
     }
   }
   
   @FXML
   private void teamBTOLPlusOneAction(ActionEvent event) {
     this.teamB.setTimeOutLeft(this.teamB.getTimeOutLeft() + 1);
   }
   
   @FXML
   private void gamePeriodLessOneAction(ActionEvent event) {
     if (this.game.getPeriod() > 1)
       this.game.setPeriod(this.game.getPeriod() - 1);
   }
   
   @FXML
   private void gamePeriodPlusOneAction(ActionEvent event) {
     this.game.setPeriod(this.game.getPeriod() + 1);
   }
   
 
   @FXML
   private void BuzzerAction(ActionEvent event) {
       GameMedia.playBuzzer();
   }
   
   @FXML
   private void startStopAction(ActionEvent event){
     if ((!this.isRunning) && (!scoreboard.game.stages.TimeOutStage.getInstance().isIsLoaded())) {
       if (this.game.getShotClock() == 0) {
         this.game.setShotClock(this.def.getMaxShotClock());
         if ((this.game.getGameMinutes() == 0) && (this.game.getGameSeconds() == 0)) {
           this.game.setGameMinutes(this.def.getMinutesPerPeriod());
           this.game.setGameSeconds(0);
         }
       }
      this.gameTimer.setSuspend(false);
       this.startStopButton.setText("Stop (F9)");
     } else {
       this.gameTimer.setSuspend(true);
       this.startStopButton.setText("Start (F9)");
     }
     this.isRunning = (!this.isRunning);
   }
   
   @FXML
    private void gameTimeResetAction(ActionEvent event) { if ((this.game.getGameMinutes() != this.def.getMinutesPerPeriod()) && (this.game.getGameSeconds() != 0)) {
       MessageBoxStage.getInstance().setMessage(false, "Are you sure you want to reset the time?", 1);
     }
   }
   
   @FXML
   private void resetGameAction(ActionEvent event) {
     MessageBoxStage.getInstance().setMessage(false, "Are you sure you want to reset EVERYTHING?", 5);
   }
   
   @FXML
   private void scoreboardAction(ActionEvent event) throws Exception {
     scoreboard.game.stages.ScoreBoardStage stage = scoreboard.game.stages.ScoreBoardStage.getInstance();
     Stage scoreBoardStage = stage.getStage();
     if (!scoreBoardStage.isShowing()) {
       this.scoreBoardMenu.setStyle(null);
       scoreBoardStage.show();
     } else {
       scoreBoardStage.hide();
     }
   }
   
   @FXML
   private void shotClockAction(ActionEvent event) throws Exception {
     scoreboard.game.stages.ShotClockStage stage = scoreboard.game.stages.ShotClockStage.getInstance();
     Stage shotClockStage = stage.getStage();
     if (!shotClockStage.isShowing()) {
       shotClockStage.show();
     } else {
       shotClockStage.hide();
     }
   }
   
   @FXML
   private void resetScoresAction(ActionEvent event) throws Exception {
     if ((this.teamA.getTeamScore() > 0) || (this.teamB.getTeamScore() > 0)) {
       MessageBoxStage.getInstance().setMessage(false, "Are you sure you want to reset the scores for both team?", 4);
     }
   }
   
   @FXML
   private void editTeamALabelAction(javafx.scene.input.MouseEvent event) throws Exception {
     if (this.teamANameEditLabel.getText().equals("edit")) {
       this.teamNameAText.setVisible(true);
       this.teamAName.setVisible(false);
       this.teamANameEditLabel.setText("ok");
     } else {
       this.teamNameAText.setVisible(false);
       this.teamAName.setVisible(true);
       this.teamANameEditLabel.setText("edit");
       this.teamAName.setText(this.teamNameAText.getText());
       this.teamA.setTeamName(this.teamNameAText.getText());
     }
   }
   
   @FXML
   private void editTeamBLabelAction(javafx.scene.input.MouseEvent event) throws Exception {
     if (this.teamBNameEditLabel.getText().equals("edit")) {
       this.teamNameBText.setVisible(true);
       this.teamBName.setVisible(false);
       this.teamBNameEditLabel.setText("ok");
     } else {
       this.teamNameBText.setVisible(false);
       this.teamBName.setVisible(true);
       this.teamBNameEditLabel.setText("edit");
       this.teamBName.setText(this.teamNameBText.getText());
       this.teamB.setTeamName(this.teamNameBText.getText());
     }
   }
   
   @FXML
   private void shotClockSetAction(ActionEvent event) throws Exception {
     int shotClock = 0;
     if (!this.gameTimer.isSuspend()) {
       return;
     }
     try {
       shotClock = Integer.valueOf(this.shotClockText.getText()).intValue();
       if ((shotClock >= 1) && (shotClock <= 99)) {
         this.game.setShotClock(shotClock);
       }
     } catch (NumberFormatException e) {}
   }
   
   @FXML
   private void startStopShotClockAction(ActionEvent event) throws Exception {
     if (this.gameTimer.isShotClockFlag()) {
       this.gameTimer.setShotClockFlag(false);
       this.startStopShotClockButton.setText("Start");
     } else {
       this.gameTimer.setShotClockFlag(true);
       this.startStopShotClockButton.setText("Stop");
     }
   }
   
   @FXML
   private void gameTimeUpdateAction(ActionEvent event) throws Exception {
     int min = 0;
     int sec = 0;
     if (!this.gameTimer.isSuspend()) {
       return;
     }
     try {
       min = Integer.valueOf(this.gameMinText.getText()).intValue();
        sec = Integer.valueOf(this.gameSecText.getText()).intValue();
       if ((min >= 0) && (min <= 99)) {
         this.game.setGameMinutes(min);
       }
       if ((sec >= 0) && (sec <= 59)) {
         this.game.setGameSeconds(sec);
       }
     } catch (NumberFormatException e) {}
   }
   
   @FXML
   private void closeAction(ActionEvent event) throws Exception {
     Game.getInstance().getTimerThread().setShutdown(true);
     javafx.application.Platform.exit();
   }
   
   @FXML
   private void resetFoulsAction(ActionEvent event) throws Exception {
     if ((this.teamA.getTeamFouls() > 0) || (this.teamB.getTeamFouls() > 0)) {
       MessageBoxStage.getInstance().setMessage(false, "Are you sure you want to reset the fouls for both team?", 3);
     }
   }
   
   @FXML
   private void resetTOLsAction(ActionEvent event) throws Exception {
     if ((this.teamA.getTimeOutLeft() != this.def.getTimeoutPerPeriod()) || (this.teamB.getTimeOutLeft() != this.def.getTimeoutPerPeriod())) {
       MessageBoxStage.getInstance().setMessage(false, "Are you sure you want to reset the timeouts for both team?", 2);
     }
   }
   
   private void callTimeOut()
   {
     try {
       this.isRunning = false;
       this.gameTimer.setSuspend(true);
       this.startStopButton.setText("Start (F9)");
       scoreboard.game.stages.TimeOutStage.getInstance().show();
     } catch (Exception ex) {
       java.util.logging.Logger.getLogger(FXMLControlController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
   }
   
   private void updateShotClockState() {
     if (this.gameTimer.isShotClockFlag()) {
       this.gameShotClock.setTextFill(javafx.scene.paint.Color.web("#41cc00"));
       this.startStopShotClockButton.setText("Stop");
     } else {
       this.gameShotClock.setTextFill(javafx.scene.paint.Color.web("RED"));
       this.startStopShotClockButton.setText("Start");
     }
   }
   
   private void updateScreen() {
     this.gameTime.setText(Utility.formatTime(this.game.getGameMinutes(), this.game.getGameSeconds()));
     this.gameShotClock.setText(Utility.appendZero(this.game.getShotClock()));
     this.teamAScore.setText(Utility.appendZero(this.teamA.getTeamScore()));
     this.teamBScore.setText(Utility.appendZero(this.teamB.getTeamScore()));
     this.teamAFoul.setText(String.valueOf(this.teamA.getTeamFouls()));
     this.teamBFoul.setText(String.valueOf(this.teamB.getTeamFouls()));
     this.teamATOL.setText(String.valueOf(this.teamA.getTimeOutLeft()));
     this.teamBTOL.setText(String.valueOf(this.teamB.getTimeOutLeft()));
     this.gamePeriod.setText(String.valueOf(this.game.getPeriod()));
     this.teamAPenalty.setVisible(this.teamA.getTeamFouls() >= this.def.getFoulPenalty());
     this.teamBPenalty.setVisible(this.teamB.getTeamFouls() >= this.def.getFoulPenalty());
     
     if (this.gameTimer.isSuspend()) {
       this.gameTime.setTextFill(javafx.scene.paint.Color.web("RED"));
       this.startStopShotClockButton.setDisable(true);
       this.gameShotClock.setTextFill(javafx.scene.paint.Color.web("RED"));
       this.shotClockText.setDisable(false);
       this.gameMinText.setDisable(false);
       this.gameSecText.setDisable(false);
     } else {
       this.gameTime.setTextFill(javafx.scene.paint.Color.web("#41cc00"));
       this.startStopShotClockButton.setDisable(false);
       updateShotClockState();
       this.shotClockText.setDisable(true);
       this.gameMinText.setDisable(true);
       this.gameSecText.setDisable(true);
       this.clockCancelButton.setVisible(false);
       this.shotClockCancelButton.setVisible(false);
     }
     
     if ((this.game.getGameMinutes() == 0) && (this.game.getGameSeconds() < this.game.getShotClock())) {
       this.game.setShotClock(this.game.getGameSeconds());
     }
   }
   
   public void updateTime() {
     new javafx.animation.AnimationTimer()
     {
       public void handle(long l) {
         FXMLControlController.this.updateScreen();
         if (FXMLControlController.this.gameTimer.isSuspend()) {
           FXMLControlController.this.isRunning = false;
           FXMLControlController.this.startStopButton.setText("Start (F9)");
         }
       }
     }.start();
   }
   
   public void gameTimeReset() {
     this.game.setGameMinutes(this.def.getMinutesPerPeriod());
     this.game.setGameSeconds(0);
     this.gameTimer.setSuspend(true);
     this.game.setShotClock(this.def.getMaxShotClock());
   }
   
   public void resetFouls() {
     this.teamA.setTeamFouls(0);
     this.teamB.setTeamFouls(0);
   }
   
   public void resetScores() {
     this.teamA.setTeamScore(0);
     this.teamB.setTeamScore(0);
   }
   
   public void resetTOLs() {
     this.teamA.setTimeOutLeft(this.def.getTimeoutPerPeriod());
     this.teamB.setTimeOutLeft(this.def.getTimeoutPerPeriod());
   }
   
   public void resetGame() {
     resetTOLs();
     resetScores();
     resetFouls();
     gameTimeReset();
   }
   
   public void resetShotClock() {
     this.shotClockResetButton.fire();
   }
   
   public void resetShotClock1() {
     this.shotClockResetButton1.fire();
   }
   
   public void startStopClock() {
     this.startStopButton.fire();
   }
   
   public void buzzer() {
     this.buzzerButton.fire();
   }
   
   private void setFont() {
     this.teamAScore.setFont(Utility.getFont(50));
     this.teamBScore.setFont(Utility.getFont(50));
     this.teamATOL.setFont(Utility.getFont(50));
     this.teamBTOL.setFont(Utility.getFont(50));
     this.teamAFoul.setFont(Utility.getFont(50));
     this.teamBFoul.setFont(Utility.getFont(50));
     this.gamePeriod.setFont(Utility.getFont(50));
     this.gameShotClock.setFont(Utility.getFont(70));
     this.gameTime.setFont(Utility.getFont(100));
     this.teamAName.setFont(Utility.getFont(20));
     this.teamBName.setFont(Utility.getFont(20));
     this.teamAPenalty.setFont(Utility.getFont(20));
     this.teamBPenalty.setFont(Utility.getFont(20));
     
     this.titleBarLabel.setFont(Utility.getFont(30));
     this.shotClockLabel.setFont(Utility.getFont(18));
     this.tolNameALabel.setFont(Utility.getFont(15));
     this.tolNameBLabel.setFont(Utility.getFont(15));
     this.foulALabel.setFont(Utility.getFont(15));
     this.foulBLabel.setFont(Utility.getFont(15));
     this.periodLabel.setFont(Utility.getFont(15));
     this.minLabel.setFont(Utility.getFont(15));
     this.secLabel.setFont(Utility.getFont(15));
   }
 }
