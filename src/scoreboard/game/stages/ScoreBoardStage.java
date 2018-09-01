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
/*    */ public class ScoreBoardStage
/*    */   extends GameStage
/*    */ {
/*    */   private static ScoreBoardStage _this;
/*    */   
/*    */   public static ScoreBoardStage getInstance()
/*    */   {
/*    */     try
/*    */     {
/* 25 */       if (_this == null) {
/* 26 */         _this = new ScoreBoardStage();
/*    */       }
/*    */     } catch (Exception e) {}
/* 29 */     return _this;
/*    */   }
/*    */   
/*    */   public ScoreBoardStage() throws Exception {
/* 33 */     super(ScoreBoard.class.getResource("/scoreboard/main/FXMLDocument.fxml"));
/* 34 */     getStage().setResizable(false);
/* 35 */     getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
/* 36 */     getStage().setTitle("Score Board");
/* 37 */     Scene scoreBoardScene = new Scene(getPane());
/* 38 */     scoreBoardScene.setFill(Color.TRANSPARENT);
/* 39 */     getStage().setScene(scoreBoardScene);
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\game\stages\ScoreBoardStage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */