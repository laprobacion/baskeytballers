 package scoreboard.game.stages;
 
 import javafx.application.Platform;
 import javafx.event.Event;
 import javafx.event.EventHandler;
 import javafx.scene.Scene;
 import javafx.scene.image.Image;
 import javafx.scene.input.KeyEvent;
 import javafx.scene.paint.Color;
 import scoreboard.ScoreBoard;
 import scoreboard.control.FXMLControlController;
 import scoreboard.game.Game;
 

 public class MainControllerStage   extends GameStage {
   private static MainControllerStage _this;
   
   public static MainControllerStage getInstance() {
     try{
       if (_this == null) {
         _this = new MainControllerStage();
       }
     } catch (Exception e) {}
     return _this;
   }
   
   public MainControllerStage() throws Exception {
     super(MainControllerStage.class.getResource("/scoreboard/control/FXMLControl.fxml"));
     getStage().setResizable(false);
     getStage().getIcons().add(new Image(ScoreBoard.class.getResourceAsStream("/scoreboard/game/resources/Clock-Date-Time-icon.png")));
     getStage().setTitle("Control Board");
     Scene scene = new Scene(getPane());
     scene.setFill(Color.TRANSPARENT);
     getStage().setScene(scene);
     addShortCuts(scene);
     getStage().setOnCloseRequest(new EventHandler(){
         @Override
         public void handle(Event event) {
            Game.getInstance().getTimerThread().setShutdown(true);
            Platform.exit();
         }
       
     });
   }
   
   private void addShortCuts(Scene scene) {
        scene.setOnKeyPressed(new EventHandler(){
            @Override
            public void handle(Event event) {
                KeyEvent t = (KeyEvent)event;
                FXMLControlController controller = (FXMLControlController)MainControllerStage.this.getController();
                if (null != t.getCode()) {
                    switch (t.getCode()) {
                        case F5:
                            controller.resetShotClock();
                            break;
                        case F6:
                            controller.resetShotClock1();
                            break;
                        case F9:
                            controller.startStopClock();
                            break;
                        case B:
                            controller.buzzer();
                            break;
                        default:
                            break;
                    }
                }
            }
            
        });
   }
 }