/*    */ package scoreboard.shotclock;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.animation.AnimationTimer;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.scene.control.Label;
/*    */ import scoreboard.game.Game;
/*    */ import scoreboard.game.Utility;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FXMLShotClockController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private Label shotClock;
/*    */   @FXML
/*    */   private Label gameTime;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb)
/*    */   {
/* 32 */     setFont();
/* 33 */     new AnimationTimer()
/*    */     {
/*    */       public void handle(long l)
/*    */       {
/* 37 */         FXMLShotClockController.this.shotClock.setText(Utility.appendZero(Game.getInstance().getShotClock()));
/* 38 */         FXMLShotClockController.this.gameTime.setText(Utility.formatTime(Game.getInstance().getGameMinutes(), Game.getInstance().getGameSeconds()));
/*    */       }
/*    */     }.start();
/*    */   }
/*    */   
/*    */   private void setFont() {
/* 44 */     this.gameTime.setFont(Utility.getFont(350));
/* 45 */     this.shotClock.setFont(Utility.getFont(800));
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\shotclock\FXMLShotClockController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */