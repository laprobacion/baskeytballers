 package scoreboard.game;
 
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javafx.scene.media.Media;
 import javafx.scene.media.MediaPlayer;
 import javafx.util.Duration;
 import scoreboard.ScoreBoard;
 import scoreboard.control.FXMLControlController;
 
 public class GameMedia {
   private Media someSound;
   private MediaPlayer mediaPlayer;
   private static GameMedia _this;
   private GameMedia(){}
   private static GameMedia get(){
       if(_this == null){
           _this = new GameMedia();
           _this.someSound = new Media(ScoreBoard.class.getResource("/scoreboard/game/resources/buzzer.mp3").toString());
           _this.mediaPlayer = new MediaPlayer(_this.someSound);
           _this.mediaPlayer.setStartTime(Duration.ZERO);
           _this.mediaPlayer.seek(Duration.ZERO);
       }
       return _this;
   }
           
   public static void playBuzzer() {
     try {
       get().mediaPlayer.stop();
       get().mediaPlayer.play();
     } catch (Exception ex) {
       Logger.getLogger(FXMLControlController.class.getName()).log(Level.SEVERE, null, ex);
       ex.printStackTrace();
     }
   }
 }