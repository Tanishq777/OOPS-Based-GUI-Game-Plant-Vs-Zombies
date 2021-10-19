package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
//import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.util.Duration;

public class InGameOption implements Initializable {
    private static Sound sound;
    @FXML
    private Button backtogame;
    @FXML
    public StackPane parentContainer;
    @FXML
    private Button menu;
    @FXML
    private Button save;
//    @FXML
//    Sound sound;
    private static SequentialTransition plant,zomb;
    public static void getsound(Sound s)
    {
        sound=s;
    }
    public static void getresource(SequentialTransition p, SequentialTransition z)
    {
        plant=p;
        zomb=z;
    }
//    private StackPane parentContainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        plant.pause();
        zomb.pause();
    }

    @FXML
    private void backtogame(ActionEvent event) throws IOException {
        sound.play_();
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
//        Scene scene = backtogame.getScene();
//        root.translateXProperty().set(scene.getWidth());
//
        StackPane parentContainer = (StackPane) backtogame.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    @FXML
    public void menu(ActionEvent actionEvent) throws IOException {
        sound.play_();
        Parent root = FXMLLoader.load(getClass().getResource("Scen1.fxml"));
        Scene scene = menu.getScene();
        root.translateXProperty().set(scene.getWidth());
        StackPane parentContainer = (StackPane) menu.getScene().getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
    @FXML
    public void save(ActionEvent actionEvent) {
    }

}
