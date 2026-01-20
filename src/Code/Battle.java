package Code;

import Code.Abilities.Attack;
import Code.Abilities.Magic;
import java.util.function.Supplier;

//Class made for ease of implementation
public class Battle {
    static final Opponent opp = new Opponent();
    static final Character character = Main.getCharacterFromMain();
    static int turnNumber = 0;

    public Battle() {
        opp.applyCreditsTowardsAttributes();
    }
    //TODO: add turn counter
    static Supplier<Long> protagonistHP = () -> character.getHP();
    static Supplier<Long> antagonistHP = () -> opp.getHP();
    static boolean userTurn = true;
    static boolean opponentTurn = false;

    static boolean wasUserTurn = false;
    static boolean wasOpponentTurn = false;

    static int characterFirstPick = -1;
    static int characterSecondPick = -1;

    // static int lowerDefense = 0;
    // static int lowerAtk = 0;
    // static int lowerLuck = 0;

    static long luckyLoopValue = 0;
    static long randomHolder = 0;
    static int readerHolder = 0;

    static int magicTurnHolder = 0;
    static boolean applyTurnHolder = true; //other part of fix 

    static boolean isNormalAttack = false;

    //static int magicApplier = 0;

    static double damageMultiplier = 0; //FOR TESTING PURPOSES

    public void applyBasedOnLuck() {
        
        System.out.println("Enter lucky numbers (1 - 10)"); 
        luckyLoopValue = (character.getLuck() / 10); //TODO: add magic values which will either be lost or applied
        if (luckyLoopValue < 10) { 
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (character.getLuck() / 10)) {
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
                    damageMultiplier = 0;

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

    public double getDefenseMultiplier() { //used to multiply against the attack/damage multiplier
        //ALL GOOD HERE!!
        //TODO: make specifically for Poison
        //TODO: remove test case
        System.out.println("TESTING: get Defense Multiplier value (IF NEGATIVE): " + (double)(1 + (Math.abs((double)opp.getDEF() - ((double)new Magic().getPoisonDefenseNegator() * (double)magicTurnHolder)) / 100.0))); //THIS WOULD NOT PRINT CORRECTLY, BUT TESTED AND THIS METHOD WORKS FINE
        return ((double) opp.getDEF() - ((double) new Magic().getPoisonDefenseNegator() * (double) magicTurnHolder) < 0 ? 1 + (Math.abs((double) opp.getDEF() - ((double) new Magic().getPoisonDefenseNegator() * (double) magicTurnHolder)) / 100.0) : 1 + ((double) opp.getDEF() - ((double) new Magic().getPoisonDefenseNegator() * (double) magicTurnHolder)) / 100.0); 
    }

    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            // if (magicTurnHolder == 1) {
            //     applyTurnHolder = true;
            // }
            turnNumber += 1;
            System.out.print("\n");
            System.out.println("Turn # : " + turnNumber);
            System.out.print("\n");

            System.out.println("Current HP: " + protagonistHP.get() + "");
            System.out.println("Opponent's HP: " + antagonistHP.get() + "\n");
            System.out.println("TESTING: Opponenet's Defense: " + opp.getDEF() + "\n");

            if (userTurn && !opponentTurn) {
                System.out.println("Pick Move: (1: Attack, 2: Magic, 3: Skip Turn)");
                characterFirstPick = new Reader().getInputAsInt(3);

                System.out.println("RECEIVED: " + characterFirstPick);
                System.out.print("\n");
                
                switch(characterFirstPick) {
                    case 1: 
                    System.out.println("Pick Move: (1: Scratch, 2: Jab, 3: HayMaker)");
                    characterSecondPick = new Reader().getInputAsInt(3);

                    System.out.print("\n");
                    System.out.println("RECEIVED: " + characterSecondPick);

                    switch(characterSecondPick) {
                        case 1:
                            damageMultiplier = new Attack().getScratchMultiplier();
                            isNormalAttack = true;
                        break;

                        case 2:
                            damageMultiplier = new Attack().getJabMultiplier();
                            isNormalAttack = true;
                        break;
                            
                        case 3:
                            damageMultiplier = new Attack().getHayMakerMultiplier();
                            isNormalAttack = true;
                        break;
                    }
                    applyBasedOnLuck();

                    break; //i got scared but I realized I was missing a break for the first case
                    case 2:
                    System.out.println("Pick Move: (1: Poison, 2: StickArms, 3: MagicSpellOfNausea)");
                    characterSecondPick = new Reader().getInputAsInt(3);

                    System.out.print("\n");
                    System.out.println("RECEIVED: " + characterSecondPick);

                    switch(characterSecondPick) {
                        case 1:
                            //lowerDefense = new Magic().getPoisonDefenseNegator(); 
                            magicTurnHolder += 1;
                            applyTurnHolder = false;
                            System.out.print("\n");
                            System.out.println("TESTING: Magic Turn Holder Value: " + magicTurnHolder);
                        break;//I FORGOT ALL 3 BREAKS, THANK GOD I DEBUGGED THIS :/
                        case 2: 
                            //lowerAtk = new Magic().getStickArmLowerAtk();
                            magicTurnHolder += 1;
                            applyTurnHolder = false;
                        break;
                        case 3:
                            //lowerLuck = new Magic().getMagicSpellOfNauseaLowerLuck();
                            magicTurnHolder += 1;
                            applyTurnHolder = false; // used so that if you play magic twice I can account for that by not applying right away (compound effect)
                        break;
                    }
                    break;

                    case 3:
                        opponentTurn = true;
                        userTurn = false;
                    break;
                }

                if (isNormalAttack && applyTurnHolder && magicTurnHolder < 1) {//WHY I GET ERROR: applyTurnHolder becomes true at end all of the time, fixed??
                //* new Attack().exampleAttack.getMultiplier()
                System.out.println("TESTING: NO APPLICATION");
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier)); //* ((opp.getDEF() - lowerDefense) / 100)));//character.getDMG());
                }
                else if (isNormalAttack && applyTurnHolder && magicTurnHolder >= 1) {
                    System.out.println("TESTING: APPLICATION !!");
                    opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier * getDefenseMultiplier()));
                    magicTurnHolder = 0;
                    applyTurnHolder = false;
                }
                // lowerDefense = 0;
                // lowerAtk = 0;
                // lowerLuck = 0;
                damageMultiplier = 0; 
                isNormalAttack = false;
                applyTurnHolder = true;

                wasUserTurn = true;
                wasOpponentTurn = false;
            }

            if (opponentTurn && !userTurn) { //TODO add while loop in random number to prevent 0
                System.out.println("Opponent's Turn");
                switch ((int) new RandomNumber(3).getRandomNumber()) { //random number being 0 caused issues
                    case 1:
                        System.out.println("Opponent used Scratch");
                        System.out.print("\n");
                        character.setHP(protagonistHP.get() - 50);//(protagonistHP.get() - (int)(character.getDMG() * damageMultiplier));
                    break;

                    case 2:
                        System.out.println("Opponent used Jab");
                        System.out.print("\n");
                        character.setHP(protagonistHP.get() - 20);
                    break;

                    case 3:
                        System.out.println("Opponent used Haymaker");
                        System.out.print("\n");
                        character.setHP(protagonistHP.get() - 100);
                    break;
                }
                wasUserTurn = false;
                wasOpponentTurn = true;
            }
            
            if (wasUserTurn) {
                userTurn = false;
                opponentTurn = true;
                wasUserTurn = false;
            }
            else if (wasOpponentTurn) {
                userTurn = true;
                opponentTurn = false;
                wasOpponentTurn = false;
            }
        }

        if (antagonistHP.get() <= 0) {
            System.out.print("YOU WIN");
        }
        else {
            System.out.print("YOU LOSE");
        }


        // Early testing to figure out why suppliers weren't working (it was because I forgot the .get() **lesson learned lol)
        // System.out.println("This Is MY HP: " + character.getHP() + "");
        // System.out.print("This is the opponent's HP: " + opp.getHP() + "");
    }
}
