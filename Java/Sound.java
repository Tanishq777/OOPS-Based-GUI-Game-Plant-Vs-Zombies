package sample;

import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Sound {
    private MediaPlayer media;
    public Sound(MediaPlayer mediaPlayer1, MediaView mediaView1, Media media1) {
        this.media=mediaPlayer1;
        media1 = new Media(new File("C:/Users/Tanishq khaturia/Desktop/Project Material/project_v2/src/sample/MainSound.mp3").toURI().toString());
        media = new MediaPlayer(media1);
        mediaView1 = new MediaView(media);
        MediaPlayer finalMediaPlayer = media;
        media.setOnEndOfMedia(() -> finalMediaPlayer.seek(Duration.ZERO));
        media.setAutoPlay(true);
        media.setVolume(100);
    }
    void adjust(double num)
    {
        media.setVolume(num);
    }

    void stop_()
    {
        media.stop();
    }
    void play_()
    {
        media.play();
    }
    void pause_() {media.pause();}
    MediaPlayer mediaplayer()
    {
        return media;
    }
}
