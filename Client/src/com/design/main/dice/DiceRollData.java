package com.design.main.dice;

public enum DiceRollData {

    DICE_1("/data/images/dice-six-faces-one.png", 0),
    DICE_2("/data/images/dice-six-faces-two.png", 1),
    DICE_3("/data/images/dice-six-faces-three.png", 2),
    DICE_4("/data/images/dice-six-faces-four.png", 3),
    DICE_5("/data/images/dice-six-faces-five.png", 4),
    DICE_6("/data/images/dice-six-faces-six.png", 5);

    private String path;
    private int value;

    DiceRollData(String path, int value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public int getValue() {
        return value;
    }
}
