package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;

public class Main extends Application {
    private MediaPlayer mediaPlayer1;
    private MediaView mediaView1;
    private Media media1;
//    Scene1 s1=new Scene1();
    Sound sound=new Sound(mediaPlayer1,mediaView1,media1);
    @Override
    public void start(Stage stage) throws Exception {
        Scene2.getsound(sound);
        InGameOption.getsound(sound);
        scene_options.getsound(sound);
        Parent root_main = FXMLLoader.load(getClass().getResource("Scen1.fxml"));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root_main, screensize.getWidth(), screensize.getHeight());
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.setTitle("Plants VS. Zombies");
        stage.show();
//        s1.setstage(stage,scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}