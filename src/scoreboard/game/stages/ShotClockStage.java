/*    */ package scoreboard.game.stages;
/*    */ 
/*    */ import javafx.collections.ObservableList;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.paint.Color;
/*    */ import javafx.stage.Stage;
/*    */ import scoreboard.ScoreBoard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShotClockStage
/*    */   extends GameStage
/*    */ {
/*    */   private static ShotClockStage _this;
/*    */   
/*    */   public static ShotClockStage getInstance()
/*    */   {
/*    */     try
/*    */     {
/* 25 */       if (_this == null) {
/* 26 */         _this = new ShotClockStage();
/*    */       }
/*    */     } catch (Exception e) {}
/* 29 */     return _this;
/*    */   }
/*    */   
/*    */   public ShotClockStage() throws Exception {
/* 33 */     super(ScoreBoard.class.getResource("/scoreboard/shotclock/FXMLShotClock.fxml"));
/* 34 */     getStage().setResizable(false);
/* 35 */     getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
/* 36 */     getStage().setTitle("Shot Clock");
/* 37 */     Scene scoreBoardScene = new Scene(getPane());
/* 38 */     scoreBoardScene.setFill(Color.TRANSPARENT);
/* 39 */     getStage().setScene(scoreBoardScene);
/*    */   }
/*    */ }
