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

    static long magicCreditsToApplyClamped = character.getMagicCredits();

    static int characterFirstPick = -1;
    static int characterSecondPick = -1;

    static boolean retryMagic = true;

    // static int lowerDefense = 0;
    // static int lowerAtk = 0;
    // static int lowerLuck = 0;

    static long luckyLoopValue = 0; //used for lucky
    static long randomHolder = 0; //used for lucky
    static int readerHolder = 0; //used for lucky

    static int characterMagicTurnHolder = 0;
    static int oppMagicTurnHolder = 0;
    //used for applying magic turn after and compounding
    static boolean applyTurnHolder = true; //other part of fix  //used for applying magic

    static boolean isNormalAttack = false; //used for logic on when to apply magic

    //static int magicApplier = 0;

    static double damageMultiplier = 0; //used as a variable to pass down from Attack interface

    public void applyBasedOnLuck() {

        if (userTurn) {
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

    if (opponentTurn) {
        System.out.println("Enter lucky numbers (1 - 10)"); 
        luckyLoopValue = (10 - (opp.getLuck() / 10)); //TODO: add magic values which will either be lost or applied
        if (luckyLoopValue != 0) { 
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (10 - (opp.getLuck() / 10))) {
                    //caused an error lol

                    //System.out.println("TESTING: Reached applying the random value");
                    randomHolder = (long) new RandomNumber(10).getRandomNumber();
                    //System.out.println(randomHolder);

                    //100% works
                }
                readerHolder = new Reader().getInputAsInt(10);

                if (luckyLoopValue == 1 && readerHolder != randomHolder) { //reversed the logic oops
                    System.out.print("\n");
                    System.out.println("UNLUCKY, opponent's move was applied.");
                    break;
                }
                if (readerHolder == randomHolder) { //reversed the logic oopsie
                    System.out.print("\n");
                    System.out.println("LUCKY, opponent's move was not applied");
                    damageMultiplier = 0;
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

    public double getDefenseMultiplier() { //used to multiply against the attack/damage multiplier
        //ALL GOOD HERE!!
        //TODO: make specifically for Poison
        //TODO: remove test case


        //System.out.println("TESTING: get Defense Multiplier value (IF NEGATIVE): " + (double)(1 + (Math.abs((double)opp.getDEF() - ((double)Magic.Poison.lowerDefense * (double)characterMagicTurnHolder)) / 100.0))); //THIS WOULD NOT PRINT CORRECTLY, BUT TESTED AND THIS METHOD WORKS FINE
        if (userTurn) {
            return ((double) opp.getDEF() - ((double) Magic.Poison.lowerDefense * (double) characterMagicTurnHolder) < 0 ? 1 + (Math.abs((double) opp.getDEF() - ((double) Magic.Poison.lowerDefense * (double) characterMagicTurnHolder)) / 100.0) : 1 + ((double) opp.getDEF() - ((double) Magic.Poison.lowerDefense * (double) characterMagicTurnHolder)) / 100.0); 
        }
        //TODO: FINISH AFTER MAKING SEPERATE VARIABLES FOR TURNHOLDER AND FOR OPPONENT AND CHARACTER
        return ((double) character.getDEF() - ((double) Magic.Poison.lowerDefense * (double) oppMagicTurnHolder) < 0 ? 1 + (Math.abs((double) opp.getDEF() - ((double) Magic.Poison.lowerDefense * (double) oppMagicTurnHolder)) / 100.0) : 1 + ((double) opp.getDEF() - ((double) Magic.Poison.lowerDefense * (double) oppMagicTurnHolder)) / 100.0); 
    }

    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            // if (characterMagicTurnHolder == 1) {
            //     applyTurnHolder = true;
            // }
            turnNumber += 1;
            System.out.println("Amount of magic left: " + character.getMagicCredits());
            System.out.print("\n");
            System.out.println("Turn # : " + turnNumber);
            System.out.print("\n");

            System.out.println("Current HP: " + protagonistHP.get() + "");
            System.out.println("Opponent's HP: " + antagonistHP.get() + "\n");
            System.out.println("TESTING: Opponenet's Defense: " + opp.getDEF() + "\n");

            if (userTurn && !opponentTurn) {
                while(retryMagic) {
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
                            damageMultiplier = Attack.Scratch.scratchMultipler;
                            isNormalAttack = true;
                            retryMagic = false;
                            applyBasedOnLuck();
                        break;

                        case 2:
                            damageMultiplier = Attack.Jab.jabMultiplier;
                            isNormalAttack = true;
                            
                            magicCreditsToApplyClamped = Math.clamp(character.getMagicCredits() + 6, 0, 10);
                            character.setMagicCredits(magicCreditsToApplyClamped);

                            retryMagic = false;
                            applyBasedOnLuck();
                        break;
                            
                        case 3:
                            if (character.getMagicCredits() < Attack.HayMaker.MagicDrain) {
                                System.out.println ("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                retryMagic = false;
                            }
                            damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                            isNormalAttack = true;
                            character.setMagicCredits(character.getMagicCredits() - Attack.HayMaker.MagicDrain);
                            applyBasedOnLuck(); //TODO: either remove or allow it to let magic go to negative
                        break;
                    }
                    

                    break; //i got scared but I realized I was missing a break for the first case
                    case 2:
                    
                        System.out.println("Pick Move: (1: Poison, 2: StickArms, 3: MagicSpellOfNausea, 4: RECHARGE)");
                        characterSecondPick = new Reader().getInputAsInt(4);
                        // if (characterSecondPick == 1 && character.getMagicCredits() ) {
                        //if putting in switch cases no work then I will come back to this
                        // }
                    // from the while retry magic}
                    System.out.print("\n");
                    System.out.println("RECEIVED: " + characterSecondPick);
                    
                    switch(characterSecondPick) {
                        case 1:
                            if (character.getMagicCredits() < Magic.Poison.MagicDrain) {
                                System.out.println("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                retryMagic = false;
                            }
                            character.setMagicCredits(character.getMagicCredits() - Magic.Poison.MagicDrain);
                            //lowerDefense = new Magic().getPoisonDefenseNegator(); 
                            characterMagicTurnHolder += 1;
                            applyTurnHolder = false;
                            System.out.print("\n");
                            System.out.println("TESTING: Magic Turn Holder Value: " + characterMagicTurnHolder);
                        break;//I FORGOT ALL 3 BREAKS, THANK GOD I DEBUGGED THIS :/
                        case 2: 
                            if (character.getMagicCredits() < Magic.StickArms.MagicDrain) {
                                System.out.println("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                retryMagic = false;
                            }
                            character.setMagicCredits(character.getMagicCredits() - Magic.StickArms.MagicDrain);
                            //lowerAtk = new Magic().getStickArmLowerAtk();
                            characterMagicTurnHolder += 1;
                            applyTurnHolder = false;
                        break;
                        case 3:
                            if (character.getMagicCredits() < Magic.MagicSpellOfNausea.MagicDrain) {
                                System.out.println("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                retryMagic = false;
                            }
                            character.setMagicCredits(character.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain);
                            //lowerLuck = new Magic().getMagicSpellOfNauseaLowerLuck();
                            characterMagicTurnHolder += 1; //TODO: update for each magic attack
                            applyTurnHolder = false; // used so that if you play magic twice I can account for that by not applying right away (compound effect)
                        break;
                        case 4:
                            System.out.println("Character regained 6 magic credits!");
                            magicCreditsToApplyClamped = Math.clamp(character.getMagicCredits() + 6, 0, 10);
                            character.setMagicCredits(magicCreditsToApplyClamped);
                            
                            characterMagicTurnHolder += 0; //shouldn't impact anything
                            applyTurnHolder = false; 

                            retryMagic = false;
                        break;
                    }
                
                    break;

                    case 3:
                        opponentTurn = true;
                        userTurn = false;
                        retryMagic = false;
                    break;
                }
            }
                if (isNormalAttack && applyTurnHolder && characterMagicTurnHolder < 1) {//WHY I GET ERROR: applyTurnHolder becomes true at end all of the time, fixed??
                //* new Attack().exampleAttack.getMultiplier()
                System.out.println("TESTING: NO APPLICATION");
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier)); //* ((opp.getDEF() - lowerDefense) / 100)));//character.getDMG());
                }
                else if (isNormalAttack && applyTurnHolder && characterMagicTurnHolder >= 1) {
                    System.out.println("TESTING: APPLICATION !!");
                    opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier * getDefenseMultiplier()));
                    characterMagicTurnHolder = 0;
                    applyTurnHolder = false;
                }
                // lowerDefense = 0;
                // lowerAtk = 0;
                // lowerLuck = 0;
                damageMultiplier = 0; 
                isNormalAttack = false;
                applyTurnHolder = true;

                retryMagic = true;

                wasUserTurn = true;
                wasOpponentTurn = false;

                magicCreditsToApplyClamped = 0;
                
            }

            if (opponentTurn && !userTurn) { //TODO add while loop in random number to prevent 0
                System.out.println("Opponent's Turn");
                switch ((int) new RandomNumber(4).getRandomNumber()) { //random number being 0 caused issues
                    case 1:
                        System.out.println("Opponent used Scratch");
                        System.out.print("\n");
                        damageMultiplier = Attack.Scratch.scratchMultipler;
                        isNormalAttack = true;
                        //character.setHP(protagonistHP.get() - 50);//(protagonistHP.get() - (int)(character.getDMG() * damageMultiplier));
                        applyBasedOnLuck();
                    break;

                    case 2:
                        System.out.println("Opponent used Jab");
                        System.out.print("\n");
                        damageMultiplier = Attack.Jab.jabMultiplier;
                        isNormalAttack = true;
                        applyBasedOnLuck();
                    break;

                    case 3:
                        System.out.println("Opponent used Haymaker");
                        System.out.print("\n");
                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                        isNormalAttack = true;
                        applyBasedOnLuck();
                    break;
                    case 4:
                        System.out.println("Opponent used POISON !");
                        oppMagicTurnHolder += 1;
                        applyTurnHolder = false;
                    break;
                }
                
                if (isNormalAttack && applyTurnHolder && oppMagicTurnHolder < 1) {
                    character.setHP(protagonistHP.get() - (int)(opp.getDMG() * damageMultiplier));
                }

                else if (isNormalAttack && applyTurnHolder && oppMagicTurnHolder >= 1) {
                    character.setHP(protagonistHP.get() - (int)(opp.getDMG() * damageMultiplier * getDefenseMultiplier()));
                    oppMagicTurnHolder = 0;
                    applyTurnHolder = false;
                }

                isNormalAttack = false;
                applyTurnHolder = true;

                damageMultiplier = 0;

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
