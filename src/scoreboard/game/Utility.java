 package scoreboard.game;
 
 import java.net.URL;
 import javafx.beans.property.StringProperty;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
import javafx.event.Event;
 import javafx.event.EventHandler;
 import javafx.scene.control.TextField;
 import javafx.scene.input.KeyEvent;
 import javafx.scene.text.Font;
 
 public class Utility{
     
   public static String appendZero(int num){
     if (num >= 10) {
       return String.valueOf(num);
     }
     return "0" + num;
   }
   
   public static String formatTime(int mins, int sec){
     return appendZero(mins) + ":" + appendZero(sec);
   }
   
    public static void addTextFieldMaxLimit(TextField text, final int limit) {
        text.textProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (text.getText().length() > limit) {
                    String s = text.getText().substring(0, limit);
                    text.setText(s);
                }
            }
        });
    }
   
   public static boolean checkNumeric(String value) {
     String number = value.replaceAll("\\s+", "");
     for (int j = 0; j < number.length(); j++) {
       if ((number.charAt(j) < '/') || (number.charAt(j) > '9')){
         return false;
       }
     }
     return true;
   }
   
   public static void limitToNumberAndMaxLimit(TextField text, final int limit) {
    text.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler(){
        @Override
        public void handle(Event event) {
            String character = ((KeyEvent)event).getCharacter();
            if (!Utility.checkNumeric(character)) {
              event.consume();
            }
        }
       
     });
     text.textProperty().addListener(new ChangeListener(){
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
         if (text.getText().length() > limit) {
           String s = text.getText().substring(0, limit);
           text.setText(s);
         }
        }
       
     });
   }
   
   public static boolean checkNullOrEmpty(String... str) {
     for (String s : str) {
       if ((s == null) || (s.trim().equals(""))) {
         return true;
       }
     }
     return false;
   }
   
   public static int stringToInt(String strInt) {
     return Integer.parseInt(strInt);
   }
   
   public static Font getFont(int size) {
     return Font.loadFont(Utility.class.getResource("/scoreboard/game/resources/DS-DIGIB.TTF").toExternalForm(), size);
   }
 }