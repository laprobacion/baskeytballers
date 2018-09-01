/*    */ package scoreboard.messagebox;
/*    */ 
/*    */ import java.net.URL;
/*    */ import java.util.ResourceBundle;
/*    */ import javafx.event.ActionEvent;
/*    */ import javafx.fxml.FXML;
/*    */ import javafx.fxml.Initializable;
/*    */ import javafx.scene.Scene;
/*    */ import javafx.scene.control.Button;
/*    */ import javafx.scene.control.Label;
/*    */ import javafx.scene.image.Image;
/*    */ import javafx.scene.image.ImageView;
/*    */ import javafx.stage.Stage;
/*    */ import scoreboard.actions.GameAction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FXMLMessageBoxController
/*    */   implements Initializable
/*    */ {
/*    */   @FXML
/*    */   private ImageView askImage;
/*    */   @FXML
/*    */   private ImageView errorImage;
/*    */   @FXML
/*    */   private Label messageLabel;
/*    */   @FXML
/*    */   private Button yesButton;
/*    */   @FXML
/*    */   private Button okButton;
/*    */   @FXML
/*    */   private Button noButton;
/*    */   private GameAction game;
/*    */   private int action;
/*    */   
/*    */   public void initialize(URL url, ResourceBundle rb)
/*    */   {
/*    */     try
/*    */     {
/* 45 */       this.game = new GameAction();
/* 46 */       this.askImage.setImage(new Image(getClass().getResourceAsStream("/scoreboard/game/resources/question.jpg")));
/* 47 */       this.errorImage.setImage(new Image(getClass().getResourceAsStream("/scoreboard/game/resources/error.jpg")));
/* 48 */     } catch (Exception e) { e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   @FXML
/* 53 */   private void yesAction(ActionEvent event) { switch (this.action) {
/* 54 */     case 1:  this.game.gameTimeReset();
/* 55 */       break;
/* 56 */     case 2:  this.game.resetTOLs();
/* 57 */       break;
/* 58 */     case 3:  this.game.resetFouls();
/* 59 */       break;
/* 60 */     case 4:  this.game.resetScores();
/* 61 */       break;
/* 62 */     case 5:  this.game.resetGame();
/*    */     }
/*    */     
/*    */     
/* 66 */     this.action = 0;
/* 67 */     ((Stage)this.yesButton.getScene().getWindow()).close();
/*    */   }
/*    */   
/*    */   @FXML
/*    */   private void noAction(ActionEvent event) {
/* 72 */     ((Stage)this.yesButton.getScene().getWindow()).close();
/*    */   }
/*    */   
/*    */   @FXML
/*    */   private void okAction(ActionEvent event) {
/* 77 */     ((Stage)this.yesButton.getScene().getWindow()).close();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setMessage(boolean isError, String message, int action)
/*    */   {
/* 85 */     if (isError) {
/* 86 */       this.errorImage.setVisible(true);
/* 87 */       this.askImage.setVisible(false);
/* 88 */       this.yesButton.setVisible(false);
/* 89 */       this.noButton.setVisible(false);
/* 90 */       this.okButton.setVisible(true);
/*    */     } else {
/* 92 */       this.errorImage.setVisible(false);
/* 93 */       this.askImage.setVisible(true);
/* 94 */       this.yesButton.setVisible(true);
/* 95 */       this.noButton.setVisible(true);
/* 96 */       this.okButton.setVisible(false);
/*    */     }
/* 98 */     this.messageLabel.setText(message);
/* 99 */     this.action = action;
/*    */   }
/*    */ }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\messagebox\FXMLMessageBoxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */