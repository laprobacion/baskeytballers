package scoreboard.game;

public class Constants
{
  public static final String TITLE_DEFAULT_SETTINGS = "Default Settings";
  public static final String TITLE_CONTROL = "Control Board";
  public static final String TITLE_SCORE_BOARD = "Score Board";
  public static final String TITLE_SHOT_CLOCK = "Shot Clock";
  public static final String TITLE_TIMEOUT = "Timeout";
  public static final String TITLE_MESSAGE = "Message";
  public static final String TITLE_ABOUT = "About";
  public static final String LOGO_ICON = "/scoreboard/game/resources/Clock-Date-Time-icon.png";
  public static final String BUZZER_ICON = "/scoreboard/game/resources/siren.png";
  public static final String ERROR_ICON = "/scoreboard/game/resources/error.jpg";
  public static final String ASK_ICON = "/scoreboard/game/resources/question.jpg";
  public static final String BUZZER_PATH = "/scoreboard/game/resources/buzzer.mp3";
  public static final String FXML_MAIN = "/scoreboard/FXMLMain.fxml";
  public static final String FXML_CONTROL = "/scoreboard/control/FXMLControl.fxml";
  public static final String FXML_TIMEOUT = "/scoreboard/timeout/FXMLTimeout.fxml";
  public static final String FXML_SCORE_BOARD = "/scoreboard/main/FXMLDocument.fxml";
  public static final String FXML_SHOT_CLOCK = "/scoreboard/shotclock/FXMLShotClock.fxml";
  public static final String FXML_MESSAGE = "/scoreboard/messagebox/FXMLMessageBox.fxml";
  public static final String FXML_ABOUT = "/scoreboard/about/FXMLABout.fxml";
  public static final String ERROR_ALL_REQUIRED = "All fields are required!";
  public static final String ERROR_NUMBER_FORMAT = "Some fields should be in number format.";
  public static final String ERROR_TIME_PER_PERIOD = "Time per period must be 1 to 99 only.";
  public static final String ERROR_SHOT_CLOCK = "Shot clock must be 1 to 99 only.";
  public static final String ERROR_FOUL_PENALTY = "Foul penalty must be 1 to 10 only.";
  public static final String ERROR_TIMEOUT_PER_PERIOD = "Timeout per period must be 1 to 10 only.";
  public static final String CAPTION_START_CLOCK = "Start (F9)";
  public static final String CAPTION_STOP_CLOCK = "Stop (F9)";
  public static final String CAPTION_START = "Start";
  public static final String CAPTION_STOP = "Stop";
  public static final String CAPTION_EDIT = "edit";
  public static final String CAPTION_OK = "ok";
  public static final String DEF_VAL_TIME = ":00";
  public static final String MESSAGE_RESET_GAME_TIME = "Are you sure you want to reset the time?";
  public static final String MESSAGE_RESET_TIMEOUT = "Are you sure you want to reset the timeouts for both team?";
  public static final String MESSAGE_GAME_TIMEOUT = "Timeout is already running.";
  public static final String MESSAGE_FOULS_RESET = "Are you sure you want to reset the fouls for both team?";
  public static final String MESSAGE_SCORE_RESET = "Are you sure you want to reset the scores for both team?";
  public static final String MESSAGE_GAME_RESET = "Are you sure you want to reset EVERYTHING?";
  public static final int ACTION_NONE = 0;
  public static final int ACTION_GAME_TIME_RESET = 1;
  public static final int ACTION_TIMEOUT_RESET = 2;
  public static final int ACTION_FOULS_RESET = 3;
  public static final int ACTION_SCORES_RESET = 4;
  public static final int ACTION_GAME_RESET = 5;
}
