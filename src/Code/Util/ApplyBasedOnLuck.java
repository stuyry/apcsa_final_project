package Code.Util;

import Code.Abilities.Magic;
import Code.Battle;
import Code.RandomNumber;
import Code.Reader;

public class ApplyBasedOnLuck {
    static boolean userTurn;
    static boolean opponentTurn;

    static long luckyLoopValue; //used for lucky
    static long randomHolder; //used for lucky
    static int readerHolder; //used for lucky

    //static Code.Character character; 
    //static Opponent opp;

    //not done
    static int oppNauseaTurnHolder;
    static int characterNauseaMagicTurnHolder;
    //static double damageMultiplier;
    
    public ApplyBasedOnLuck () {
        userTurn = Battle.userTurn;
        opponentTurn = Battle.opponentTurn;

        // luckyLoopValue = super.luckyLoopValue;
        // randomHolder = super.randomHolder;
        // readerHolder = super.readerHolder;

        luckyLoopValue = 0;
        randomHolder = 0;
        readerHolder = 0;

        //character = super.character;
        //opp = super.opp;

        oppNauseaTurnHolder = Battle.oppNauseaTurnHolder;
        characterNauseaMagicTurnHolder = Battle.characterNauseaMagicTurnHolder;
        //damageMultiplier = super.damageMultiplier;
    }
    public void applyBasedOnLuck() {

        if (userTurn) {
        System.out.println("Enter lucky numbers (1 - 10)"); 
        //System.out.println((character.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * characterNauseaMagicTurnHolder)) / 10);
        luckyLoopValue = ((Battle.character.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * oppNauseaTurnHolder)) / 10); //TODO: UPDATE WITH OPPONENT TURN HOLDER
        //System.out.println("TEST: the turn holder (OPPONENT INFLICTED) value " + oppNauseaTurnHolder); //OPPONENT WORKS!!
        

        //TODO: add magic values which will either be lost or applied
        if (luckyLoopValue < 10) { 
            if (luckyLoopValue == 1) {
                System.out.println("OPPONENTS SPELL WORKED!");
            }
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (Battle.character.getLuck() / 10)) {
                    randomHolder = (long) new RandomNumber(10).getRandomNumber();
                }
                readerHolder = new Reader().getInputAsInt(10);

                if (readerHolder == randomHolder) {
                    System.out.print("\n");
                    System.out.println("LUCKY, move applied.");
                    break;
                }
                if (luckyLoopValue == 1 && readerHolder != randomHolder) {
                    System.out.print("\n");
                    System.out.println("UNLUCKY, move was not applied");
                    Battle.damageMultiplier = 0;
                    break;
                }
                    luckyLoopValue -= 1;
            }

                luckyLoopValue = 0;
                readerHolder = -1;
                randomHolder = -1;
        }

        else {
            System.out.print("\n");
            System.out.println ("Luck is maxed out! Move is automatically applied");
        }
    }

    if (opponentTurn) {
        System.out.println("Enter lucky numbers (1 - 10)"); 
        luckyLoopValue = (10 - ((Battle.opp.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * characterNauseaMagicTurnHolder)) / 10)); //TODO: add magic values which will either be lost or applied
        //System.out.println("TEST: the turn holder value " + characterNauseaMagicTurnHolder);
        if (luckyLoopValue != 0) { 
            if (luckyLoopValue == 6 || luckyLoopValue == 9 || luckyLoopValue == 4) {
                System.out.println("TEST: The Spell of Nausea worked!");
            }
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (10 - (Battle.opp.getLuck() / 10))) {
                    //caused an error lol

                    //System.out.println("TESTING: Reached applying the random value");
                    randomHolder = (long) new RandomNumber(10).getRandomNumber();
                    //System.out.println(randomHolder);

                    //100% works
                }
                readerHolder = new Reader().getInputAsInt(10); //964

                if (luckyLoopValue == 1 && readerHolder != randomHolder) { //reversed the logic oops
                    System.out.print("\n");
                    System.out.println("UNLUCKY, opponent's move was applied.");
                    break;
                }
                if (readerHolder == randomHolder) { //reversed the logic oopsie
                    System.out.print("\n");
                    System.out.println("LUCKY, opponent's move was not applied");
                    Battle.damageMultiplier = 0;
                    break;
                }
                    luckyLoopValue -= 1;
            }

                luckyLoopValue = 0;
                readerHolder = -1;
                randomHolder = -1;
        }

        else {
            System.out.print("\n");
            System.out.println ("Opponent's luck is maxed out! Move is automatically applied");
        }
    }
}
}
