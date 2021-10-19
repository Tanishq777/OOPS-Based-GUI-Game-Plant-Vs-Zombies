package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class scene_options implements Initializable {
    private static Sound sound;
    @FXML
    private Button exit;
    @FXML
    private Button yes,no;
    @FXML
    private Button about;
    @FXML
    private AnchorPane anchorRoot,anpane2;
    @FXML
    private StackPane parentContainer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//    Sound sound;
    public static void getsound(Sound s)
    {
        sound = s;
    }
    private int audio;
    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scen1.fxml"));
        Scene scene = exit.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) exit.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
    }

    @FXML
    private void music_y(ActionEvent event) throws IOException {
        sound.play_();
    }

    @FXML
    private void music_n(ActionEvent event) throws IOException {
        sound.stop_();
    }
    @FXML
    private void about(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screensize.getWidth(), screensize.getHeight());
//        anchorRoot.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
}
