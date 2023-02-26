package PlaySongDemo;

/**
 * This code will play any song assuming that file is in folder songfiles. 
 * 
 * Programmer Rick Mercer and Edan Uccetta
 */
import java.io.File;
import java.net.URI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlayAnMP3 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  private int songsPlayed = 0;

  @Override
  public void start(Stage stage) throws Exception {
	// Hi, it's Edan Uccetta. I'm here, changing the code around.
	  
    BorderPane pane = new BorderPane();
    String path = "songfiles/DanseMacabreViolinHook.mp3"; // Play Danse Macabre first.
    pane.setCenter( new Label(path));
    playASong(path);
    Scene scene = new Scene(pane, 500, 500); // 500 pixels wide, 500 pixels tall
    stage.setScene(scene);
    stage.show();
  }

  
  private void playASong(String path) {
   
    // Need a File and URI object so the path works on all OSs
    File file = new File(path);
    URI uri = file.toURI();
    System.out.println(uri);
    // Play one mp3 and and have code run when the song ends
    Media media = new Media(uri.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.play();
      
    mediaPlayer.setOnEndOfMedia(new Waiter());
    System.out.println("Enjoying the tunes?");
 
    }
  
  private class Waiter implements Runnable {
    @Override
    public void run() {
      songsPlayed++;
      System.out.println("Song ended, play song #" + songsPlayed);
      Platform.exit();
    }
  }
}