package sample;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.TimerTask;

public class Sun extends TimerTask {
    private ImageView sun;
    private int i=0;
        Sun(ImageView sun)
        {
            this.sun=sun;
        }
        public void run()
        {
            TranslateTransition translate3 = new TranslateTransition(Duration.seconds(20));
            translate3.setToY(800f);
            translate3.setCycleCount(4);
//            TranslateTransition translate4 = new TranslateTransition(Duration.seconds(20));
//            translate4.setToX(100f);
//            translate3.setCycleCount(5);
//            sun.setOpacity(1);
//            ParallelTransition seq=new ParallelTransition(sun,translate3,translate4);
            SequentialTransition seqT3 = new SequentialTransition(sun, translate3);
//            //playing the transition
            seqT3.play();
////            sun.setX(sun.getX()+500);
//            SequentialTransition seqT4 = new SequentialTransition(sun, translate3);
//            ParallelTransition seq=new ParallelTransition(sun,seqT3,seqT4);
//            //playing the transition
//            seq.play();
//            seq.play();
//            i=i+1000;
        }
}
