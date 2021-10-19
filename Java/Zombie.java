package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Zombie {
    private SequentialTransition seqT;
    Zombie(ImageView zombie)
    {
        TranslateTransition translate = new TranslateTransition(Duration.seconds(50));
        translate.setToX(-800f);
        translate.setCycleCount(1);
        seqT = new SequentialTransition(zombie,translate);
        seqT.play();
    }
    SequentialTransition getseq()
    {
        return seqT;
    }
}
