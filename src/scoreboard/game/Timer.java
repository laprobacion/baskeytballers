 package scoreboard.game;
 
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javafx.fxml.Initializable;
 import scoreboard.control.FXMLControlController;
 

 public class Timer implements Runnable {
   private Game game;
   private boolean suspend;
   private Initializable controller;
   private boolean shutdown;
   private boolean shotClockFlag;
   
   public Timer(Game game, Initializable controller){
     this.game = game;
     this.suspend = false;
     this.controller = controller;
     this.shutdown = false;
     this.shotClockFlag = true;
   }
   
   private void startTime() {
     if (!this.suspend) {
       int gameSec = this.game.getGameSeconds();
       int shotClock = this.game.getShotClock();
       this.game.setGameSeconds(gameSec - 1);
       if (this.shotClockFlag) {
         this.game.setShotClock(shotClock - 1);
       }
       ((FXMLControlController)this.controller).updateTime();
       if (this.game.validateTime()) {
         this.suspend = true;
       }
     }
   }
   
   public void setSuspend(boolean suspend) {
     this.suspend = suspend;
   }
   
   public boolean isSuspend() {
     return this.suspend;
   }
   
   public void run()  {
     for (;;) {
       try {
         Thread.sleep(1000L);
         startTime();
       } catch (InterruptedException ex) {
         Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
       }
       if (this.shutdown) {
         break;
       }
     }
   }
   
   public void setShutdown(boolean shutdown) {
     this.shutdown = shutdown;
   }
   
   public void setShotClockFlag(boolean shotClockFlag) {
     this.shotClockFlag = shotClockFlag;
   }
   
   public boolean isShotClockFlag() {
     return this.shotClockFlag;
   }
 }
