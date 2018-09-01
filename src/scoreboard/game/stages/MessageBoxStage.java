/*    */ package scoreboard.game.stages;
/*    */ 
/*    */ import javafx.collections.ObservableList;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.paint.Color;
/*    */ import javafx.stage.Stage;
/*    */ import scoreboard.ScoreBoard;
/*    */ import scoreboard.messagebox.FXMLMessageBoxController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessageBoxStage
/*    */   extends GameStage
/*    */ {
/*    */   private static MessageBoxStage _this;
/*    */   
/*    */   public static MessageBoxStage getInstance()
/*    */   {
/*    */     try
/*    */     {
/* 26 */       if (_this == null)
/* 27 */         _this = new MessageBoxStage();
/*    */     } catch (Exception e) {
/* 29 */       e.printStackTrace(); }
/* 30 */     return _this;
/*    */   }
/*    */   
/*    */   public MessageBoxStage() throws Exception {
/* 34 */     super(ScoreBoard.class.getResource("/scoreboard/messagebox/FXMLMessageBox.fxml"));
/* 35 */     getStage().setResizable(false);
/* 36 */     getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
/* 37 */     getStage().setTitle("Message");
/* 38 */     Scene messageBoxScene = new Scene(getPane());
/* 39 */     messageBoxScene.setFill(Color.TRANSPARENT);
/* 40 */     getStage().setScene(messageBoxScene);
/*    */   }
/*    */   
/*    */   public void setMessage(boolean isError, String message, int action) {
/* 44 */     ((FXMLMessageBoxController)getController()).setMessage(isError, message, action);
/* 45 */     getStage().show();
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\game\stages\MessageBoxStage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */