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

/**
 * @author Furkan, Abid, Zakaria, Usman, Hamza
 * @version 1.5
 */
public class MainDisplayController {

    /**
     * Images views objects for the 2 dices and spinner
     */
    public ImageView secondDiceImage, firstDiceImage, spinner;

    /**
     * Text area for the assignment
     */
    public TextArea cardTypeAssignment;

    /**
     * Text for spinner display
     */
    public Label spinnerLabel;

    /**
     * Random number generator
     */
    private Random random = new Random();

    /**
     * Anti(spam) boolean
     */
    private boolean running = false;

    /**
     * Card data
     */
    private CardData current;

    /**
     * Executes on dice click
     */
    public void onDiceClick() {
        if(running) {
            return;
        }
        running = true;
        firstDiceImage.setCursor(Cursor.WAIT);
        secondDiceImage.setCursor(Cursor.WAIT);
        TimerTask task = new TimerTask() {
            int tick = 0;
            @Override
            public void run() {
                if (tick >= 15) {
                    firstDiceImage.setCursor(Cursor.DEFAULT);
                    secondDiceImage.setCursor(Cursor.DEFAULT);
                    running = false;
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

    /**
     * Fetches random data from dice data (enum)
     * @return
     */
    private DiceRollData getDiceData() {
        return DiceRollData.values()[random.nextInt(DiceRollData.values().length)];
    }

    /**
     * Executes on spin click
     */
    public void onSpinnerClick(){
        if(running) {
            return;
        }
        running = true;
        TimerTask task = new TimerTask() {
            int counter = 0;
            @Override
            public void run() {
                if(counter == 33) {
                    running = false;
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

    /**
     * Executes on card click
     */
    public void onCardClick() {
        if(running) {
            return;
        }
        running = true;
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
                    running = false;
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

    /**
     * Fetches random card (data)
     * @return
     */
    private CardData getCardData() {
        return CardData.values()[random.nextInt(CardData.values().length)];
    }

}


