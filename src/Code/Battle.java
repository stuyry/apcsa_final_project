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

    static int characterPoisonMagicTurnHolder = 0;
    static int characterStickMagicTurnHolder = 0;
    static int characterNauseaMagicTurnHolder = 0;

    static int oppPoisonTurnHolder = 0;
    static int oppNauseaTurnHolder = 0;
    //used for applying magic turn after and compounding
    static boolean applyTurnHolder = true; //other part of fix  //used for applying magic

    static boolean isNormalAttack = false; //used for logic on when to apply magic

    //static int magicApplier = 0;

    static double damageMultiplier = 0; //used as a variable to pass down from Attack interface

    public void applyBasedOnLuck() {

        if (userTurn) {
        System.out.println("Enter lucky numbers (1 - 10)"); 
        //System.out.println((character.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * characterNauseaMagicTurnHolder)) / 10);
        luckyLoopValue = ((character.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * oppNauseaTurnHolder)) / 10); //TODO: UPDATE WITH OPPONENT TURN HOLDER
        System.out.println("TEST: the turn holder (OPPONENT INFLICTED) value " + oppNauseaTurnHolder); //OPPONENT WORKS!!
        

        //TODO: add magic values which will either be lost or applied
        if (luckyLoopValue < 10) { 
            if (luckyLoopValue == 1) {
                System.out.println("OPPONENTS SPELL WORKED!");
            }
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
        luckyLoopValue = (10 - ((opp.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * characterNauseaMagicTurnHolder)) / 10)); //TODO: add magic values which will either be lost or applied
        System.out.println("TEST: the turn holder value " + characterNauseaMagicTurnHolder);
        if (luckyLoopValue != 0) { 
            if (luckyLoopValue == 6 || luckyLoopValue == 9 || luckyLoopValue == 4) {
                System.out.println("TEST: The Spell of Nausea worked!");
            }
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (10 - (opp.getLuck() / 10))) {
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


        //System.out.println("TESTING: get Defense Multiplier value (IF NEGATIVE): " + (double)(1 + (Math.abs((double)opp.getDEF() - ((double)Magic.Poison.lowerDefense * (double)characterPoisonMagicTurnHolder)) / 100.0))); //THIS WOULD NOT PRINT CORRECTLY, BUT TESTED AND THIS METHOD WORKS FINE
        if (userTurn) {//Pretty printed but not fully
            return ((double) opp.getDEF() -
             ((double) Magic.Poison.lowerDefense *
              (double) characterPoisonMagicTurnHolder) -
               ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * oppNauseaTurnHolder) < 0 ?
               
               (1.0 + (double)(Math.abs((double) opp.getDEF() - 
                ((double) Magic.Poison.lowerDefense * (double) characterPoisonMagicTurnHolder) - //REDO
                 ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)oppNauseaTurnHolder)) / 100.0))  :
                 
                 (1.0 - (double)(Math.abs((double) opp.getDEF() - 
                ((double) Magic.Poison.lowerDefense * (double) characterPoisonMagicTurnHolder) - //REDO
                 ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)oppNauseaTurnHolder)) / 100.0)) ); 
        }
        //TODO: FINISH AFTER MAKING SEPERATE VARIABLES FOR TURNHOLDER AND FOR OPPONENT AND CHARACTER
        //Pretty Printed
//REMOVE
else {
        // System.out.println((double) character.getDEF() - 
        // (((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) + 
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder)));

        // System.out.println(1 + (Math.abs((double) character.getDEF() -
        // (((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) +
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder))) / 100.0));

//REMOVE

        return ((double) character.getDEF() - 
        ((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) - 
        ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder) < 0 ? 
        
        1 + (Math.abs((double) character.getDEF() - //THE MATH IS WEIRD BECAUSE 0 - 40 = 0.4 + 1 = 1.4, but 0 -200 = 2 + 1 = 3 even though it should be 2/2.4 if both applied, that's messed up, but I guess I could add it to rules? //TODO: IMPORTANT
        ((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) - 
        ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder)) / 100.0) :
        
        1 - ((double) character.getDEF() - ((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder)
         - ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder)) / 100.0); 
}
    }



    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            // if (characterPoisonMagicTurnHolder == 1) {
            //     applyTurnHolder = true;
            // }
            turnNumber += 1;
            System.out.println("Amount of magic left: " + character.getMagicCredits());
            System.out.print("\n");
            System.out.println("Turn # : " + turnNumber);
            System.out.print("\n");

            System.out.println("Current HP: " + protagonistHP.get() + "");
            System.out.println("Opponent's HP: " + antagonistHP.get() + "\n");
            //System.out.println("TESTING: Opponenet's Defense: " + opp.getDEF() + "\n");
            System.out.println("MAGIC STATS: ");
            System.out.println("Character defense: " + (double) character.getDEF());
            System.out.println("Opponent defense: " + (double) opp.getDEF());
            System.out.println("NAUSEA VALUE CHARACTER: " + characterNauseaMagicTurnHolder);
            System.out.println("NAUSEA VALUE OPPONENT: " + oppNauseaTurnHolder);
            System.out.println("NAUSEA POST MULTIPLY -> CHARACTER WILL DEAL x : " + ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * oppNauseaTurnHolder));
            System.out.println("POISON VALUE OF OPPONENT " + oppPoisonTurnHolder);
            System.out.println("POSION POST MULTIPLY: " + (double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder);
            System.out.println("MULTIPLIER OF CHARACTER ATTACKING OPPONENT: " + (1.0 + (double)(Math.abs((double) opp.getDEF() - 
                ((double) Magic.Poison.lowerDefense * (double) characterPoisonMagicTurnHolder) - //REDO
                 ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)oppNauseaTurnHolder)) / 100.0)) );
            

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

                    switch(characterSecondPick) { //moves attack
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
                                damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                                isNormalAttack = true;
                                character.setMagicCredits(character.getMagicCredits() - Attack.HayMaker.MagicDrain);
                                applyBasedOnLuck();
                            }
                             //TODO: either remove or allow it to let magic go to negative
                        break;
                    }
                    

                    break; 
                    case 2: //CASE: MAGIC
                        System.out.println("Pick Move:" + "\n" + "[1] Poison  [2] Weaken  [3] Nausea  [4] RECHARGE)"); //Choose
                        characterSecondPick = new Reader().getInputAsInt(4); //Choose

                        System.out.print("\n"); //Format
                        System.out.println("RECEIVED: " + characterSecondPick); //Format
                    
                    switch(characterSecondPick) {
                        case 1:
                            if (character.getMagicCredits() < Magic.Poison.MagicDrain) {
                                System.out.println("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                retryMagic = false; //Boolean 
                                applyTurnHolder = false; //Boolean

                                characterPoisonMagicTurnHolder += 1; //Set
                                character.setMagicCredits(character.getMagicCredits() - Magic.Poison.MagicDrain); //Set

                                System.out.print("\n"); //Format
                                System.out.println("TESTING: Magic Turn Holder Value: " + characterPoisonMagicTurnHolder); //Format
                            }
                        
                            
                        break;
                        case 2: //NOT FINISHED
                            if (character.getMagicCredits() < Magic.StickArms.MagicDrain) { //NOT FINISHED
                                System.out.println("Not Enough magic credits, please try again!"); //NOT FINISHED
                                break; //NOT FINISHED
                            } //NOT FINISHED
                            else {
                                retryMagic = false;//NOT FINISHED
                            }
                            character.setMagicCredits(character.getMagicCredits() - Magic.StickArms.MagicDrain); //NOT FINISHED
                            //lowerAtk = new Magic().getStickArmLowerAtk();
                            
                            applyTurnHolder = false; //NOT FINISHED
                        break;
                        case 3:
                            if (character.getMagicCredits() < Magic.MagicSpellOfNausea.MagicDrain) {
                                System.out.println("Not Enough magic credits, please try again!");
                                break;
                            }
                            else {
                                
                                retryMagic = false; //boolean
                                applyTurnHolder = false; //boolean

                                characterNauseaMagicTurnHolder += 1; //Set
                                character.setMagicCredits(character.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain); //Set

        //                         System.out.println((double) character.getDEF() - 
        // ((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) - 
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder));

        // System.out.println(1 + (Math.abs((double) character.getDEF() -
        // ((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) - 
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder)) / 100.0));

                                //System.out.println("NAUSEA TURN HOLDER VALUE " + characterNauseaMagicTurnHolder + ""); //Format
                            }
                            
                        break;
                        case 4:
                            System.out.println("Character regained 6 magic credits!"); //Format

                            magicCreditsToApplyClamped = Math.clamp(character.getMagicCredits() + 6, 0, 10); //Apply
                            character.setMagicCredits(magicCreditsToApplyClamped); //Apply
                            
                            characterPoisonMagicTurnHolder += 0; //shouldn't impact anything
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
               
                if (isNormalAttack && applyTurnHolder && oppNauseaTurnHolder > 0 && characterPoisonMagicTurnHolder < 1 && characterNauseaMagicTurnHolder < 1) {
                    opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier * getDefenseMultiplier())); //FIXED ADDED LOWER SELF DEFENSE TO TS
                }
                else if (isNormalAttack && applyTurnHolder && characterPoisonMagicTurnHolder < 1 && characterNauseaMagicTurnHolder < 1) {//WHY I GET ERROR: applyTurnHolder becomes true at end all of the time, fixed??
                //* new Attack().exampleAttack.getMultiplier()
                //System.out.println("TESTING: NO APPLICATION");
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier)); //* ((opp.getDEF() - lowerDefense) / 100)));//character.getDMG());
                }

                

                else if (isNormalAttack && applyTurnHolder && (characterPoisonMagicTurnHolder >= 1 || characterNauseaMagicTurnHolder >= 1)) {
                    //System.out.println("TESTING: APPLICATION !!");
                    opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier * getDefenseMultiplier()));

                    characterPoisonMagicTurnHolder = 0;
                    characterNauseaMagicTurnHolder = 0;

                    //System.out.println("Did it go away: " + characterNauseaMagicTurnHolder); 
                    applyTurnHolder = false;
                }
                // lowerDefense = 0;
                // lowerAtk = 0;
                // lowerLuck = 0;
                // System.out.println(isNormalAttack);
                // System.out.println(applyTurnHolder);
                // System.out.println( (characterNauseaMagicTurnHolder < 1) );

                damageMultiplier = 0; 

                isNormalAttack = false;
                applyTurnHolder = true;

                retryMagic = true; //reset loop

                wasUserTurn = true; 
                wasOpponentTurn = false;

                magicCreditsToApplyClamped = 0; //TODO: add for opponent

            }

            if (opponentTurn && !userTurn) { //TODO add while loop in random number to prevent 0
                System.out.println("Opponent's Turn");
                switch ((int) new RandomNumber(5).getRandomNumber()) { //random number being 0 caused issues
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

                        oppPoisonTurnHolder += 1;
                        applyTurnHolder = false;
                    break;
                    case 5:
                        System.out.println("Opponent used NAUSEA !");

                        oppNauseaTurnHolder += 1;
                        //System.out.println("VALUE APPLIED: " + oppNauseaTurnHolder); 
                        applyTurnHolder = false;
                    break;
                }
                
                if (isNormalAttack && applyTurnHolder && oppPoisonTurnHolder < 1 && oppNauseaTurnHolder < 1) {
                    character.setHP(protagonistHP.get() - (int)(opp.getDMG() * damageMultiplier));
                }

                else if (isNormalAttack && applyTurnHolder && (oppPoisonTurnHolder >= 1  || oppNauseaTurnHolder >= 1)) {
                    character.setHP(protagonistHP.get() - (int)(opp.getDMG() * damageMultiplier * getDefenseMultiplier()));

                    applyTurnHolder = false;

                    oppNauseaTurnHolder = 0; //reset magic after compounded effects are applied.
                    oppPoisonTurnHolder = 0; 
                }

                isNormalAttack = false; //resets everything no matter what
                applyTurnHolder = true;

                damageMultiplier = 0;

                wasUserTurn = false; //sets for application of turns
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
        
    }
}
