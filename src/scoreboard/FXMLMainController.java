 package scoreboard;
 
 import java.net.URL;
 import java.util.ResourceBundle;
 import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.fxml.Initializable;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.stage.Stage;
 import scoreboard.game.Default;
 import scoreboard.game.Game;
 import scoreboard.game.Team;
 import scoreboard.game.Utility;
 import scoreboard.game.stages.MainControllerStage;
 
 
 public class FXMLMainController
   implements Initializable
 {
   @FXML   private Label errorMessage;
   @FXML   private Label teamNameALabel;
   @FXML   private Label teamNameBLabel;
   @FXML   private Label timePerPeriodLabel;
   @FXML   private Label timeoutPerPeriodLabel;
   @FXML   private Label shotClockLabel;
   @FXML   private Label shotClockLabel1;
   @FXML   private Label foulPenaltyLabel;
   @FXML   private Label titleBarLabel;
   @FXML   private TextField teamAName;
   @FXML   private TextField teamBName;
   @FXML   private TextField timePerPeriod;
   @FXML   private TextField shotClockMax;
   @FXML   private TextField shotClockMax1;
   @FXML   private TextField foulPenalty;
   @FXML   private TextField timeoutPerPeriod;
   @FXML   private Button setAction;
   
   public void initialize(URL url, ResourceBundle rb) {
     setFont();
     this.teamAName.setText("Farters");
     this.teamBName.setText("Poopers");
     this.timePerPeriod.setText("10");
     this.shotClockMax.setText("24");
     this.shotClockMax1.setText("14");
     this.foulPenalty.setText("5");
     this.timeoutPerPeriod.setText("2");
     this.errorMessage.setText("");
   }
   
   @FXML
   private void setActionEvent(ActionEvent event) throws Exception {
     if (validate()) {
      return;
     }
     Game game = Game.getInstance();
     Team teamA = new Team();
     teamA.setTimeOutLeft(Utility.stringToInt(this.timeoutPerPeriod.getText()));
     teamA.setTeamName(this.teamAName.getText());
     teamA.setTeamFouls(0);
     teamA.setTeamScore(0);
     Team teamB = new Team();
     teamB.setTimeOutLeft(Utility.stringToInt(this.timeoutPerPeriod.getText()));
     teamB.setTeamName(this.teamBName.getText());
     teamB.setTeamFouls(0);
     teamB.setTeamScore(0);
     Default def = new Default();
     def.setTeamA(teamA);
     def.setTeamB(teamB);
     def.setFoulPenalty(Utility.stringToInt(this.foulPenalty.getText()));
     def.setMinutesPerPeriod(Utility.stringToInt(this.timePerPeriod.getText()));
     def.setMaxShotClock(Utility.stringToInt(this.shotClockMax.getText()));
     def.setMaxShotClock1(Utility.stringToInt(this.shotClockMax1.getText()));
     def.setTimeoutPerPeriod(Utility.stringToInt(this.timeoutPerPeriod.getText()));
     game.setDefaultVal(def);
     game.setPeriod(0);
     game.setShotClock(def.getMaxShotClock());
     game.setGameMinutes(def.getMinutesPerPeriod());
     game.setGameSeconds(0);
     loadScoreBoard();
   }
   
   private boolean validate()   {
     String teamAName = this.teamAName.getText();
     String teamBName = this.teamBName.getText();
     String timePerPeriod = this.timePerPeriod.getText();
     String shotClockMax = this.shotClockMax.getText();
     String shotClockMax1 = this.shotClockMax1.getText();
     String foulPenalty = this.foulPenalty.getText();
     String timeoutPerPeriod = this.timeoutPerPeriod.getText();
     int temp = 0;
     if (Utility.checkNullOrEmpty(new String[] { teamAName, teamBName, timePerPeriod, shotClockMax, foulPenalty, timeoutPerPeriod })) {
       this.errorMessage.setText("All fields are required!");
       return true;
     }
     try {
       temp = Integer.valueOf(timePerPeriod).intValue();
       temp = Integer.valueOf(shotClockMax).intValue();
       temp = Integer.valueOf(shotClockMax1).intValue();
       temp = Integer.valueOf(foulPenalty).intValue();
       temp = Integer.valueOf(timeoutPerPeriod).intValue();
     } catch (NumberFormatException ex) {
       this.errorMessage.setText("Some fields should be in number format.");
       return true;
     }
     temp = Integer.valueOf(timePerPeriod).intValue();
     if ((temp < 1) || (temp > 99)) {
       this.errorMessage.setText("Time per period must be 1 to 99 only.");
       return true;
     }
     temp = Integer.valueOf(shotClockMax).intValue();
     if ((temp < 1) || (temp > 99)) {
       this.errorMessage.setText("Shot clock must be 1 to 99 only.");
       return true;
     }
     temp = Integer.valueOf(shotClockMax1).intValue();
     if ((temp < 1) || (temp > 99)) {
       this.errorMessage.setText("Shot clock 2 must be 1 to 99 only.");
       return true;
     }
     temp = Integer.valueOf(foulPenalty).intValue();
     if ((temp < 1) || (temp > 10)) {
       this.errorMessage.setText("Foul penalty must be 1 to 10 only.");
       return true;
     }
     temp = Integer.valueOf(timeoutPerPeriod).intValue();
     if ((temp < 1) || (temp > 10)) {
       this.errorMessage.setText("Timeout per period must be 1 to 10 only.");
       return true;
     }
     return false;
   }
   
   private void loadScoreBoard() throws Exception {
     Stage mainStage = (Stage)this.setAction.getScene().getWindow();
     mainStage.close();
     MainControllerStage.getInstance().getStage().show();
   }
   
   private void setFont() {
     this.teamNameALabel.setFont(Utility.getFont(15));
     this.teamNameBLabel.setFont(Utility.getFont(15));
     this.timePerPeriodLabel.setFont(Utility.getFont(15));
     this.timeoutPerPeriodLabel.setFont(Utility.getFont(15));
     this.shotClockLabel.setFont(Utility.getFont(15));
     this.shotClockLabel1.setFont(Utility.getFont(15));
     this.foulPenaltyLabel.setFont(Utility.getFont(15));
     this.titleBarLabel.setFont(Utility.getFont(30));
   }
 }