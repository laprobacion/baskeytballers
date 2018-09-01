/*    */ package scoreboard.game.stages;
/*    */ 
/*    */ import javafx.collections.ObservableList;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.paint.Color;
/*    */ import javafx.stage.Stage;
/*    */ import javafx.stage.StageStyle;
/*    */ import scoreboard.ScoreBoard;
/*    */ import scoreboard.timeout.FXMLTimeoutController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeOutStage
/*    */   extends GameStage
/*    */ {
/*    */   private static TimeOutStage _this;
/*    */   
/*    */   public static TimeOutStage getInstance()
/*    */   {
/*    */     try
/*    */     {
/* 28 */       if (_this == null) {
/* 29 */         _this = new TimeOutStage();
/*    */       }
/*    */     } catch (Exception e) {}
/* 32 */     return _this;
/*    */   }
/*    */   
/*    */   private TimeOutStage() throws Exception {
/* 36 */     super(ScoreBoard.class.getResource("/scoreboard/timeout/FXMLTimeout.fxml"));
/* 37 */     getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
/* 38 */     Scene timeoutScene = new Scene(getPane());
/* 39 */     getStage().setScene(timeoutScene);
/* 40 */     timeoutScene.setFill(Color.TRANSPARENT);
/* 41 */     getStage().setResizable(false);
/* 42 */     getStage().initStyle(StageStyle.UNDECORATED);
/* 43 */     getStage().setTitle("Timeout");
/*    */   }
/*    */   
/*    */   public void show() {
/*    */     try {
/* 48 */       if (!_this.isIsLoaded()) {
/* 49 */         _this.setIsLoaded(true);
/* 50 */         ((FXMLTimeoutController)getController()).run();
/* 51 */         getStage().show();
/*    */         
/* 53 */         finalize();
/*    */       }
/*    */     }
/*    */     catch (Throwable e) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\game\stages\TimeOutStage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */