package com.design.main.cards;

/**
 * User: hamza
 * Date: 17-12-2018
 * Project: Project-A
 */
public enum CardData {

    ASSIGNMENT_1("Go 10 steps forward.", CardType.REGULAR),
    ASSIGNMENT_2("Go 10 steps backwards.", CardType.SPINNER),
    ASSIGNMENT_3("If only 2 of your pawns have made casa,\n" +
            "+25 steps, else +10 steps.", CardType.REGULAR),
    ASSIGNMENT_4("Go straight to your casa.", CardType.JOKER),
    ASSIGNMENT_5("Go back to your starting point", CardType.REGULAR),
    ASSIGNMENT_6("If the pointer lands on red or yellow,\n then the player which belongs to that color can kill 1 pawn of choice,\n" +
            "if the pointer does not land on red or yellow\n the player may take +10 steps.", CardType.SPINNER),
    ASSIGNMENT_7("Put 1 of your pawns in play, else -10 steps.", CardType.REGULAR),
    ASSIGNMENT_8("Depending on which color the spinner lands,\n" +
            "the player himself can choose which pawn\n he wants to send home from that color.", CardType.SPINNER),
    ASSIGNMENT_9("If you have 3 pawns in play,\n +10 steps, else -10 steps.", CardType.REGULAR),
    ASSIGNMENT_10("Depending on which color the spinner lands,\n" +
            "that color may throw only 1 dice in their next turn.", CardType.SPINNER),
    ASSIGNMENT_11("If thrown more than 11 this turn,\n +10 steps, else -10 steps..", CardType.REGULAR),
    ASSIGNMENT_12("If the joker card has been played,\n +15 steps, else -10 steps.", CardType.REGULAR),
    ASSIGNMENT_13("If the pointer lands on blue or green,\n" +
            "then the player which belongs to that color can put 1 pawn in play,\n" +
            "if it does not land on blue or green the player may take + 10 steps.", CardType.SPINNER),
    ASSIGNMENT_14("Throw twice next turn.", CardType.SPINNER),
    ASSIGNMENT_15("If it is your only pawn in play and all your other pawns\n have reached their designated house,\n -30 steps, else -15 steps.", CardType.REGULAR),
    ASSIGNMENT_16("You have been killed.", CardType.REGULAR);;

    private String assignment;
    private CardType type;

    CardData(String assignment, CardType type) { this.assignment = assignment; this.type = type;}

    public String getAssignment() {
        return assignment;
    }

    public CardType getType() {
        return type;
    }

}
