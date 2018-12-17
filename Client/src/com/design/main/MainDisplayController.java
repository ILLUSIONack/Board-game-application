package com.design.main;

import com.design.main.cards.CardData;
import com.design.main.cards.CardType;
import com.design.main.dice.DiceRollData;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainDisplayController {

    public ImageView secondDiceImage;
    public ImageView firstDiceImage;
    public ImageView spinner;

    public TextArea cardTypeAssignment;
    public Label spinnerLabel;

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

    public void onSpinnerClick(){
        TimerTask task = new TimerTask() {
            int counter = 0;
            @Override
            public void run() {
                if(counter == 33) {
                    cancel();
                }
                int x = random.ints(20, 30).iterator().nextInt();
                spinner.setRotate(spinner.getRotate() + x);
                counter++;

            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 20, 20);
    }

    private CardData current;

    public void onCardClick() {
        current = getCardData();
        cardTypeAssignment.setOpacity(0.0);
        spinnerLabel.setOpacity(0.0);
        cardTypeAssignment.setText(current.getAssignment());
        if(current.getType().equals(CardType.SPINNER)) {
            spinnerLabel.setText("Spin the spinner");
        } else {
            spinnerLabel.setText("");
        }
        TimerTask task = new TimerTask() {
            int tick = 0;
            @Override
            public void run() {
                if(tick == 20) {
                    cancel();
                }
                cardTypeAssignment.setOpacity(cardTypeAssignment.getOpacity() + 0.05);
                spinnerLabel.setOpacity(spinnerLabel.getOpacity() + 0.05);
                tick++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 20, 20);
    }

    private CardData getCardData() {
        return CardData.values()[random.nextInt(CardData.values().length)];
    }

}


