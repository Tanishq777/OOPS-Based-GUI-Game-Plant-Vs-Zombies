package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Plant {
    private SequentialTransition seqT2;
    Plant(ImageView pea)
    {
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(1));
        translate2.setToX(800f);
        translate2.setCycleCount(50);
        seqT2 = new SequentialTransition(pea,translate2);
        seqT2.play();
    }
    SequentialTransition getseq()
    {
        return seqT2;
    }
}
