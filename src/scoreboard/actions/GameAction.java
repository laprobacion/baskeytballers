 package scoreboard.actions;
 
 import scoreboard.control.FXMLControlController;
 import scoreboard.game.stages.MainControllerStage;
 
 
 
 
 
 
 
 
 public class GameAction
 {
   private FXMLControlController controller;
   
   public GameAction()
   {
    this.controller = ((FXMLControlController)MainControllerStage.getInstance().getController());
   }
   
   public void gameTimeReset() { this.controller.gameTimeReset(); }
   
   public void resetFouls()
   {
     this.controller.resetFouls();
   }
   
   public void resetScores() {
     this.controller.resetScores();
   }
   
   public void resetTOLs() {
     this.controller.resetTOLs();
   }
   
   public void resetGame() {
     this.controller.resetGame();
   }
 }

