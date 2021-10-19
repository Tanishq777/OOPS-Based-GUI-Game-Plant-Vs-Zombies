package sample;

//import java.awt.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.util.Duration;


public class Scene2 implements Initializable {

    private static Sound sound;
    @FXML
    private Button button,imgbut,but1,but2,but3,but4;
    @FXML
    private AnchorPane container;
    @FXML
    private ImageView zombie,peashooter,pea,sun,zicon;
    @FXML
    private GridPane Ground;
    @FXML
    private ImageView setimage;
    @FXML
    private Text suncounter;
    @FXML
    private Circle cir;
    @FXML
    private ProgressBar pr;


    SequentialTransition seqT,seqT2;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Plant p;
    Zombie z;
private Timeline translateAnimation;
    public static void getsound(Sound s)
    {
        sound=s;
    }
    /**
     * Initializes the controller class.
     */
    class Progress implements Runnable {
        ProgressBar prog;

        public Progress(ProgressBar pr) {
            prog=pr;
        }

        @Override
        public void run()
        {
            for (float i=0;i<1000;i++)
            {
                prog.setProgress(i/350);
                zicon.setX(-1*(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Thread th=new Thread(new Progress(pr));
        th.start();
//        pr.setProgress(1);
        Timer t=new Timer();
        Date d=new Date();
        TimerTask task=new Sun(sun);
        t.schedule(task,100);
        z=new Zombie(zombie);
        p=new Plant(pea);
//        TranslateTransition translate = new TranslateTransition(Duration.seconds(50));
//        translate.setToX(-800f);
//        translate.setCycleCount(1);
//        seqT = new SequentialTransition (zombie,translate);
        //playing the transition
//        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(1));
//        translate2.setToX(800f);
//        translate2.setCycleCount(50);
//        seqT2 = new SequentialTransition (pea,translate2);
//        seqT.play();
//        seqT2.play();
//        but1.setOnMousePressed(circleOnMousePressedEventHandler);
//        EventHandler<? super MouseEvent> drag1 = null;
//        but2.setOnMouseDragged(drag2);
//        but3.setOnMouseDragged(drag3);
        sun.setOnMouseClicked(e ->{
            sun.setOpacity(0);
            int c=Integer.parseInt(suncounter.getText())+25;
            suncounter.setText(c+"");
//

            EventHandler<MouseEvent> drag1 =
                    new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent t) {
                            double offsetX = t.getSceneX() - orgSceneX;
                            double offsetY = t.getSceneY() - orgSceneY;
                            double newTranslateX = orgTranslateX + offsetX;
                            double newTranslateY = orgTranslateY + offsetY;

                            ((Button)(t.getSource())).setTranslateX(newTranslateX);
                            ((Button)(t.getSource())).setTranslateY(newTranslateY);
                        }
                    };
            EventHandler<MouseEvent> click =
                    new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent t) {
                            orgSceneX = t.getSceneX();
                            orgSceneY = t.getSceneY();
                            orgTranslateX = ((Button)(t.getSource())).getTranslateX();
                            orgTranslateY = ((Button)(t.getSource())).getTranslateY();
                        }
                    };
//            but1.setOnMouseDragged(drag1);
            but1.setOnMouseDragged(drag1);
            but1.setOnMousePressed(click);
        });
    }
    @FXML
    private void loadThird(ActionEvent event) throws IOException {
        sound.pause_();
        InGameOption.getresource(z.getseq(),p.getseq());
        Parent root = FXMLLoader.load(getClass().getResource("In_Game_Option.fxml"));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screensize.getWidth(), screensize.getHeight());
        container.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 250, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void mouseclick(ActionEvent event) throws IOException {
        sound.pause_();
    }

    @FXML
    private void collectsun(ActionEvent event) throws IOException {
    }
    @FXML
    private void but2(ActionEvent event) throws IOException {
    }
    @FXML
    private void but3(ActionEvent event) throws IOException {
    }
    @FXML
    private void but4(ActionEvent event) throws IOException {
    }
    @FXML
    private void but1(ActionEvent event) throws IOException {
    }
    @FXML
    private void cir(ActionEvent event) throws IOException {
//            orgSceneX =cir.getTranslateX();
//            orgSceneY = cir.getTranslateY();
//            orgTranslateX = ((Circle)(event.getSource())).getTranslateX();
//            orgTranslateY = ((Circle)(event.getSource())).getTranslateY();
    }
    @FXML
    private void imageset(ActionEvent event) throws IOException {
        System.out.println(event.getEventType());
//        File file = new File("sunflower.gif");
//        Image image = new Image(file.toURI().toString());
//        setimage.setImage(image);
//        setimage.setImage(new ImageView("sunflower.gif"));
//        setimage.setOpacity(1);
    }

}
