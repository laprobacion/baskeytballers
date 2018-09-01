 package scoreboard.game.stages;
 
 import java.net.URL;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.layout.Pane;
 import javafx.stage.Stage;
 
 
 
 public class GameStage{
   private Pane pane;
   private Stage stage;
   private boolean isLoaded;
   private FXMLLoader fxmlLoader;
   
   public GameStage(URL url) {
     try{
       this.fxmlLoader = new FXMLLoader();
       this.pane = ((Pane)this.fxmlLoader.load(url.openStream()));
       this.fxmlLoader.setLocation(url);
       this.stage = new Stage();
       this.isLoaded = false;
     } catch (Exception e) { e.printStackTrace();
     }
   }
   
   public Stage getStage() { return this.stage; }
   
   public boolean isIsLoaded() {
     return this.isLoaded;
   }
   
   public void setIsLoaded(boolean isLoaded) {
     this.isLoaded = isLoaded;
   }
   
   public Parent getPane() {
     return this.pane;
   }
   
   public Object getController() {
     return this.fxmlLoader.getController();
   }
 }
