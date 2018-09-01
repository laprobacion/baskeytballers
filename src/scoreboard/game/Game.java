 package scoreboard.game;
 
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.sound.sampled.AudioInputStream;
 import javax.sound.sampled.Clip;
 
  
 public class Game{
     
   public static Game gameInstance;
   private int gameMinutes;
   private int gameSeconds;
   private int shotClock;
   private int period;
   private AudioInputStream beep;
   private Clip clip;
   private Default defaultVal;
   private Timer timerThread;
   
   public static Game getInstance(){
     if (gameInstance == null) {
       gameInstance = new Game();
     }
     return gameInstance;
   }
   
   public int getGameMinutes() {
     return this.gameMinutes;
   }
   
   public void setGameMinutes(int gameMinutes) {
     this.gameMinutes = gameMinutes;
   }
   
   public int getGameSeconds() {
     return this.gameSeconds;
   }
   
   public void setGameSeconds(int gameSeconds) {
     if (gameSeconds < 0) {
       this.gameMinutes -= 1;
       this.gameSeconds = 59;
     } else {
       this.gameSeconds = gameSeconds;
     }
   }
   
   public int getShotClock() {
     return this.shotClock;
   }
   
   public void setShotClock(int shotClock) {
     this.shotClock = shotClock;
   }
   public int getPeriod() {
     return this.period;
   }
   
   public void setPeriod(int period) {
     this.period = period;
   }
   
   public boolean validateTime() {
     boolean flag = false;
     try {
       if (this.shotClock == 0) {
         GameMedia.playBuzzer();
         flag = true;
       }
       if ((this.gameMinutes == 0) && (this.gameSeconds == 0)) {
         GameMedia.playBuzzer();
         flag = true;
       }
     } catch (Exception ex) {
       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
     }
     return flag;
   }
   
   public Default getDefaultVal() {
     return this.defaultVal;
   }
   
   public void setDefaultVal(Default defaultVal) {
     this.defaultVal = defaultVal;
   }
   
   public Timer getTimerThread() {
     return this.timerThread;
   }
   
   public void setTimerThread(Timer timerThread) {
     this.timerThread = timerThread;
   }
 }
