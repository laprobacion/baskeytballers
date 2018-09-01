/*    */ package scoreboard.timeout;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.animation.AnimationTimer;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.control.Label;
/*    */ import javafx.stage.Stage;
/*    */ import scoreboard.game.GameMedia;
/*    */ import scoreboard.game.Utility;
/*    */ import scoreboard.game.stages.TimeOutStage;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FXMLTimeoutController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private Label timeOut;
/*    */   @FXML
/*    */   private Label timeoutLabel;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb)
/*    */   {
/* 33 */     setFont();
/*    */   }
/*    */   
/*    */   public void run() {
/* 37 */     int MIL_SEC = 70;
/* 38 */     new AnimationTimer()
/*    */     {
/* 40 */       int sec = 30;
/* 41 */       int milSec = 70;
/*    */       
/*    */       public void handle(long l) {
/* 44 */         if (this.milSec <= 0) {
/* 45 */           this.sec -= 1;
/* 46 */           this.milSec = 70;
/*    */         } else {
/* 48 */           this.milSec -= 1;
/*    */         }
/* 50 */         FXMLTimeoutController.this.timeOut.setText(Utility.appendZero(this.sec));
/* 51 */         if (this.sec == 0) {
/* 52 */           GameMedia.playBuzzer();
/* 53 */           ((Stage)FXMLTimeoutController.this.timeOut.getScene().getWindow()).close();
/* 54 */           stop();
/* 55 */           TimeOutStage.getInstance().setIsLoaded(false);
/* 56 */           this.sec = 30;
/*    */         }
/*    */       }
/*    */     }.start();
/*    */   }
/*    */   
/*    */   private void setFont()
/*    */   {
/* 64 */     this.timeoutLabel.setFont(Utility.getFont(100));
/* 65 */     this.timeOut.setFont(Utility.getFont(500));
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\timeout\FXMLTimeoutController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */