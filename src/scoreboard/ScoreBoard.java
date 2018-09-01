 package scoreboard;
 
 import javafx.application.Application;
 import javafx.collections.ObservableList;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.image.Image;
 import javafx.stage.Stage;
 import scoreboard.game.Game;
 
 
 
 
 
 
 
 
 public class ScoreBoard
   extends Application
 {
   private Game game;
   
   public void start(Stage mainStage)
     throws Exception
   {
     Parent main = (Parent)FXMLLoader.load(getClass().getResource("/scoreboard/FXMLMain.fxml"));
     Scene mainScene = new Scene(main);
     mainStage.setTitle("Default Settings");
     mainStage.setScene(mainScene);
     mainStage.show();
    mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
   }
   
 
 
   public static void main(String[] args)
   {
     launch(args);
   }
   
   public void stop() throws Exception
   {
     super.stop();
   }
 }


/* Location:              C:\Users\Frank\Downloads\ScoreBoard.jar!\scoreboard\ScoreBoard.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */