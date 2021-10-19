package sample;

import java.awt.*;
import java.io.File;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
//import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.util.Duration;
import javafx.stage.Stage;

public class Scene1 implements Initializable {
    @FXML
    private Button new_game;
    @FXML
    private Button options;
    @FXML
    private Button resume;
    @FXML
    private Button exit;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;
    @FXML
    private Button login;
    @FXML
    private Label lblstatus;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button login_b;
    @FXML
    private Button login_back;

    Sound sound;
//    Stage stage;
//    Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

//    public void setstage(Stage stage,Scene scene)
//    {
//        this.stage=stage;
//        this.scene=scene;
//    }
    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screensize.getWidth(), screensize.getHeight());
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.6),kv);
        timeline.getKeyFrames().add(kf);
//        timeline.setCycleCount(2);  // how many times this frame should run
//        timeline.setCycleCount(Animation.INDEFINITE);  //
//        timeline.getKeyFrames().removeAll(kf);
//        timeline.setOnFinished(t -> {
//            parentContainer.getChildren().remove(root);
//        });
        timeline.play();
    }

    @FXML
    private void loadoptions(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene_options.fxml"));
        Scene scene = options.getScene();
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
    }

    @FXML
    private void resume(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene_options.fxml"));
        Scene scene = options.getScene();
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
       System.exit(0);
    }
    private Parent root_login;
    @FXML
    private void login(ActionEvent event) throws IOException {
        root_login = FXMLLoader.load(getClass().getResource("login.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root_login,screenBounds.getWidth(), screenBounds.getHeight());
        parentContainer.getChildren().add(root_login);
//        Timeline timeline = new Timeline();
//        KeyValue kv = new KeyValue(root_login.translateYProperty(), 0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(t -> {
//            parentContainer.getChildren().remove(anchorRoot);
//        });
//        timeline.play();
    }

    @FXML
    private void login_data(ActionEvent event) throws IOException {
        if (txtUserName.getText().equals("User") && txtPassword.getText().equals("123"))
            lblstatus.setText("Login Success");
        else
            lblstatus.setText("Login Failed");
    }
    @FXML
    private void login_back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scen1.fxml"));
        Scene scene = login_back.getScene();
        root.translateXProperty().set(scene.getWidth());
        StackPane parentContainer = (StackPane) login_back.getScene().getRoot();
        parentContainer.getChildren().add(root);
//        Timeline timeline = new Timeline();
//        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
//        Scene scene = backtogame.getScene();
//        root.translateXProperty().set(scene.getWidth());

//        StackPane parentContainer = (StackPane) backtogame.getScene().getRoot();

//        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
//        KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
//        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
//        timeline.getKeyFrames().add(kf);
//        timeline.setOnFinished(t -> {
//            parentContainer.getChildren().remove(anchorRoot);
//        });
//        timeline.play();
    }
}
