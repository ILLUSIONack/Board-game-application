package com.design.main;

import javafx.scene.Cursor;
import javafx.scene.image.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainDisplayController {

    public ImageView secondDiceImage;
    public ImageView firstDiceImage;

    private Random random = new Random();


    public void onDiceClick() {
        firstDiceImage.setCursor(Cursor.WAIT);
        secondDiceImage.setCursor(Cursor.WAIT);
        TimerTask task = new TimerTask() {
            int tick = 0;
            @Override
            public void run() {
                if (tick >= 15) {
                    firstDiceImage.setCursor(Cursor.DEFAULT);
                    secondDiceImage.setCursor(Cursor.DEFAULT);
                    cancel();

                }
                firstDiceImage.setRotate(random.ints(-60, 55).iterator().nextInt());
                secondDiceImage.setRotate(random.ints(-70, 65).iterator().nextInt());
                firstDiceImage.setImage(new Image(getDiceData().getPath()));
                secondDiceImage.setImage(new Image(getDiceData().getPath()));
                tick++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 50, 50);
    }

    private DiceRollData getDiceData() {
        return DiceRollData.values()[random.nextInt(DiceRollData.values().length)];
    }



}


