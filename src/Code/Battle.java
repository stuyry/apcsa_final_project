package Code;

import Code.Abilities.Attack;
import Code.Abilities.Magic;
import Code.Util.ApplyBasedOnLuck;
import Code.Util.GetMultiplierValueBasedOnMagicAndDefense;
import Code.Util.CharacterSequences.CharacterHaymakerSequence;
import Code.Util.CharacterSequences.CharacterJabSequence;
import Code.Util.CharacterSequences.CharacterNauseaSequence;
import Code.Util.CharacterSequences.CharacterPoisonSequence;
import Code.Util.CharacterSequences.CharacterRecharge;
import Code.Util.CharacterSequences.CharacterScratchSequence;
import Code.Util.CharacterSequences.CharacterSkipTurn;
import Code.Util.CharacterSequences.CharacterWeakenSeqeuence;

import java.util.function.Supplier;

//Class made for ease of implementation
public class Battle {
    public static final Opponent opp = new Opponent();
    public static final Character character = Main.getCharacterFromMain();
    static int turnNumber = 0;

    public Battle() {
        opp.applyCreditsTowardsAttributes();
    }
    //TODO: add turn counter
    static Supplier<Long> protagonistHP = () -> character.getHP();
    static Supplier<Long> antagonistHP = () -> opp.getHP();

    public static boolean userTurn = true;
    public static boolean opponentTurn = false;

    public static boolean wasUserTurn = false;
    public static boolean wasOpponentTurn = false;

    public static long magicCharacterCreditsToApplyClamped = character.getMagicCredits();
    public static long magicOpponentCreditsToApplyClamped = opp.getMagicCredits();

    static int characterFirstPick = -1;
    static int characterSecondPick = -1;

    public static boolean retryMagic = true;
    static boolean oppRetry = true;

    // static int lowerDefense = 0;
    // static int lowerAtk = 0;
    // static int lowerLuck = 0;

     public static long luckyLoopValue = 0; //used for lucky
     public static long randomHolder = 0; //used for lucky
     public static int readerHolder = 0; //used for lucky

    public static int characterPoisonMagicTurnHolder = 0;
    public static int characterWeakenMagicTurnHolder = 0;
    public static int characterNauseaMagicTurnHolder = 0;

    public static int oppPoisonTurnHolder = 0;
    public static int oppNauseaTurnHolder = 0;
    public static int oppWeakenTurnHolder = 0;
    //used for applying magic turn after and compounding
    public static boolean applyTurnHolder = true; //other part of fix  //used for applying magic

    public static boolean isNormalAttack = false; //used for logic on when to apply magic

    //static int magicApplier = 0;

    public static double damageMultiplier = 0; //used as a variable to pass down from Attack interface

 

    



    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            // if (characterPoisonMagicTurnHolder == 1) {
            //     applyTurnHolder = true;
            // }
            turnNumber += 1;
            
            System.out.print("\n");
            System.out.println("Turn # : " + turnNumber);
            System.out.print("\n");

           // DEBUGGING NAUSEA 
             System.out.println("Current HP: " + protagonistHP.get() + "");
             System.out.println("Opponent's HP: " + antagonistHP.get() + "\n");
             System.out.print("\n");

             System.out.println("Amount of magic left: " + character.getMagicCredits());
            // //System.out.println("TESTING: Opponenet's Defense: " + opp.getDEF() + "\n");
            // System.out.println("MAGIC STATS: ");
            // System.out.println("Character defense: " + (double) character.getDEF());
            // System.out.println("Opponent defense: " + (double) opp.getDEF());
            // System.out.println("NAUSEA VALUE CHARACTER: " + characterNauseaMagicTurnHolder);
            // System.out.println("NAUSEA VALUE OPPONENT: " + oppNauseaTurnHolder);
            // System.out.println("NAUSEA POST MULTIPLY -> CHARACTER WILL DEAL x : " + ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * oppNauseaTurnHolder));
            // System.out.println("POISON VALUE OF OPPONENT " + oppPoisonTurnHolder);
            // System.out.println("POSION POST MULTIPLY: " + (double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder);
            // System.out.println("MULTIPLIER OF CHARACTER ATTACKING OPPONENT: " + (1.0 + (double)(Math.abs((double) opp.getDEF() - 
            //     ((double) Magic.Poison.lowerDefense * (double) characterPoisonMagicTurnHolder) - //REDO
            //      ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)oppNauseaTurnHolder)) / 100.0)) );

           // System.out.println("CHARACTER: Nausea applied? " + characterNauseaMagicTurnHolder);
            //System.out.println("CHARACTER: DID IT IMPACT HIS CHANCES? " +  "LUCK:" + opp.getLuck() + " NEW luck: " + (opp.getLuck() - (Magic.MagicSpellOfNausea.lowerLuck * characterNauseaMagicTurnHolder)));
            //System.out.println("OPPONENT MAGIC LEVEL " + opp.getMagicCredits());
            

            if (userTurn && !opponentTurn) {
                while(retryMagic) {
                System.out.println("Pick Move:" + "\n" + "[1] Attack  [2] Magic  [3] Skip Turn)");
                characterFirstPick = new Reader().getInputAsInt(3);

                System.out.println("RECEIVED: " + characterFirstPick);
                System.out.print("\n");
                
                switch(characterFirstPick) {
                    case 1: 
                    System.out.println("Pick Move: " + "\n" + "[1] Scratch  [2] Jab  [3] HayMaker)");
                    characterSecondPick = new Reader().getInputAsInt(3);

                    System.out.print("\n");
                    System.out.println("RECEIVED: " + characterSecondPick);

                    switch(characterSecondPick) { //moves attack
                        case 1:
                            new CharacterScratchSequence().Scratch();
                        break;

                        case 2:
                            new CharacterJabSequence().Jab();
                        break;
                            
                        case 3:
                            new CharacterHaymakerSequence().HayMaker();
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
                            new CharacterPoisonSequence().Poison();
                        break;
                        case 2: 
                            new CharacterWeakenSeqeuence().Weaken();
                        break;
                        case 3:
                            new CharacterNauseaSequence().Nausea();    
                        break;
                        case 4:
                            new CharacterRecharge().Recharge();
                        break;
                    }
                
                    break;

                    case 3:
                        new CharacterSkipTurn().Skip();
                    break;
                }
            }
                
                if (isNormalAttack && applyTurnHolder && (oppNauseaTurnHolder > 0  || oppWeakenTurnHolder > 0) && characterPoisonMagicTurnHolder < 1 && characterNauseaMagicTurnHolder < 1 && characterWeakenMagicTurnHolder < 1) {
                    opp.setHP(antagonistHP.get() - (int)( (character.getDMG() - (oppWeakenTurnHolder * Magic.Weaken.lowerAtk)) * damageMultiplier * new GetMultiplierValueBasedOnMagicAndDefense().getDefenseMultiplier())); //FIXED ADDED LOWER SELF DEFENSE TO TS
                }
                else if (isNormalAttack && applyTurnHolder && characterPoisonMagicTurnHolder < 1 && characterNauseaMagicTurnHolder < 1 && characterWeakenMagicTurnHolder < 1) {//WHY I GET ERROR: applyTurnHolder becomes true at end all of the time, fixed??
                //* new Attack().exampleAttack.getMultiplier()
                //System.out.println("TESTING: NO APPLICATION");
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier)); //* ((opp.getDEF() - lowerDefense) / 100)));//character.getDMG());
                }

                

                else if (isNormalAttack && applyTurnHolder && (characterPoisonMagicTurnHolder >= 1 || characterNauseaMagicTurnHolder >= 1 || characterWeakenMagicTurnHolder >= 1)) {
                    //System.out.println("TESTING: APPLICATION !!");
                    opp.setHP(antagonistHP.get() -  (int)((character.getDMG() - (oppWeakenTurnHolder * Magic.Weaken.lowerAtk)) * damageMultiplier * new GetMultiplierValueBasedOnMagicAndDefense().getDefenseMultiplier()));
                    characterWeakenMagicTurnHolder = 0;
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

                magicCharacterCreditsToApplyClamped = 0; //TODO: add for opponent

            }

            if (opponentTurn && !userTurn) { //TODO add while loop in random number to prevent 0
                System.out.println("Opponent's Turn");
                switch ((int) new RandomNumber(6).getRandomNumber()) { //random number being 0 caused issues
                    case 1:
                        System.out.println("Opponent used SCRATCH !");
                        System.out.print("\n");

                        damageMultiplier = Attack.Scratch.scratchMultipler;
                        isNormalAttack = true;
                        //character.setHP(protagonistHP.get() - 50);//(protagonistHP.get() - (int)(character.getDMG() * damageMultiplier));
                       new ApplyBasedOnLuck().applyBasedOnLuck();
                    break;

                    case 2:
                        System.out.println("Opponent used JAB !");
                        System.out.print("\n");

                        damageMultiplier = Attack.Jab.jabMultiplier;
                        isNormalAttack = true;

                        new ApplyBasedOnLuck().applyBasedOnLuck();

                        magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
                        opp.setMagicCredits(magicOpponentCreditsToApplyClamped);
                    break;

                    case 3:
                        
                        System.out.print("\n");
                        if (opp.getMagicCredits() - Attack.HayMaker.MagicDrain < 0) {
                            while (oppRetry) {
                            switch ((int) new RandomNumber(3).getRandomNumber()) {
                                case 1: //DOESNT MATTER IF I REMOVE BECAUSE WILL REDO AND SKIP OVER THIS
                                    if (opp.getMagicCredits() - 2 < 0) { //copied and pasted from above
                                        System.out.println("Opponent used HAYMAKER !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();
                                        oppRetry = false;
                                    }
                                break;
                                case 2:
                                    System.out.println("Opponent used JAB !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.Jab.jabMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();

                                        magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
                                        opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                        oppRetry = false;

                                break;
                                case 3:
                                    System.out.println("Opponent Used RECHARGE !");
                                    applyTurnHolder = false;

                                    magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + 6, 0, 10);
                                    opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                    oppRetry = false;
                                break;
                            }
                            
                        }
                        break;
                        }
                        System.out.println("Opponent used HAYMAKER !");

                        opp.setMagicCredits(opp.getMagicCredits() - Attack.HayMaker.MagicDrain);
                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                        isNormalAttack = true;

                       new ApplyBasedOnLuck().applyBasedOnLuck();
                    break;
                    case 4:
                        
                        if (opp.getMagicCredits() - Magic.Poison.MagicDrain < 0) {
                            while (oppRetry) {
                            switch ((int) new RandomNumber(3).getRandomNumber()) {
                                case 1:
                                    if (opp.getMagicCredits() - 2 < 0) { //copied and pasted from above
                                        System.out.println("Opponent used HAYMAKER !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();
                                        oppRetry = false;
                                    }
                                break;
                                case 2:
                                    System.out.println("Opponent used JAB !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.Jab.jabMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();

                                        magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
                                        opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                        oppRetry = false;

                                break;
                                case 3:
                                    System.out.println("Opponent Used RECHARGE !");
                                    applyTurnHolder = false;

                                    magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + 6, 0, 10);
                                    opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                    oppRetry = false;
                                break;
                            }
                            
                        }
                        break;
                        }
                        System.out.println("Opponent used POISON !");

                        opp.setMagicCredits(opp.getMagicCredits() - Magic.Poison.MagicDrain);
                        oppPoisonTurnHolder += 1;
                        applyTurnHolder = false;
                    break;
                    case 5:
                        
                        if (opp.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain < 0) {
                            while (oppRetry) {
                            switch ((int) new RandomNumber(3).getRandomNumber()) {
                                case 1:
                                    if (opp.getMagicCredits() - 2 < 0) { //copied and pasted from above
                                        System.out.println("Opponent used HAYMAKER !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();
                                        oppRetry = false;
                                    }
                                break;
                                case 2:
                                    System.out.println("Opponent used JAB !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.Jab.jabMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();

                                        magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
                                        opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                        oppRetry = false;

                                break;
                                case 3:
                                    System.out.println("Opponent Used RECHARGE !");
                                    applyTurnHolder = false;

                                    magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + 6, 0, 10);
                                    opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                    oppRetry = false;
                                break;
                            }
                            
                        }
                        break;
                        }

                        System.out.println("Opponent used NAUSEA !");

                        opp.setMagicCredits(opp.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain);
                        oppNauseaTurnHolder += 1;
                        //System.out.println("VALUE APPLIED: " + oppNauseaTurnHolder); 
                        applyTurnHolder = false;
                    break;
                    case 6:
                        if (opp.getMagicCredits() - Magic.Weaken.MagicDrain < 0) {
                            while (oppRetry) {
                            switch ((int) new RandomNumber(3).getRandomNumber()) {
                                case 1:
                                    if (opp.getMagicCredits() - 2 < 0) { //copied and pasted from above
                                        System.out.println("Opponent used HAYMAKER !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();
                                        oppRetry = false;
                                    }
                                break;
                                case 2:
                                    System.out.println("Opponent used JAB !");
                                        System.out.print("\n");

                                        damageMultiplier = Attack.Jab.jabMultiplier;
                                        isNormalAttack = true;

                                        new ApplyBasedOnLuck().applyBasedOnLuck();

                                        magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
                                        opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                        oppRetry = false;

                                break;
                                case 3:
                                    System.out.println("Opponent Used RECHARGE !");
                                    applyTurnHolder = false;

                                    magicOpponentCreditsToApplyClamped = Math.clamp(opp.getMagicCredits() + 6, 0, 10);
                                    opp.setMagicCredits(magicOpponentCreditsToApplyClamped);

                                    oppRetry = false;
                                break;
                            }
                            
                        }
                        break;
                        }
                         System.out.println("Opponent Used WEAKEN !");
                         applyTurnHolder = false;

                         opp.setMagicCredits(opp.getMagicCredits() - Magic.Weaken.MagicDrain);
                         oppWeakenTurnHolder += 1;
                     break;

                }
                
                if (isNormalAttack && applyTurnHolder && (characterNauseaMagicTurnHolder > 0 || characterWeakenMagicTurnHolder > 0) && oppPoisonTurnHolder < 1 && oppNauseaTurnHolder < 1 && oppWeakenTurnHolder < 1) {
                    character.setHP(protagonistHP.get() - (int)( (opp.getDMG() - (Magic.Weaken.lowerAtk * characterWeakenMagicTurnHolder)) * damageMultiplier * new GetMultiplierValueBasedOnMagicAndDefense().getDefenseMultiplier()));
                }
                else if (isNormalAttack && applyTurnHolder && oppPoisonTurnHolder < 1 && oppNauseaTurnHolder < 1) {
                    character.setHP(protagonistHP.get() - (int)(opp.getDMG() * damageMultiplier));
                }

                else if (isNormalAttack && applyTurnHolder && (oppPoisonTurnHolder >= 1  || oppNauseaTurnHolder >= 1)) {
                    character.setHP(protagonistHP.get() - (int)((opp.getDMG() - (Magic.Weaken.lowerAtk * characterWeakenMagicTurnHolder)) * damageMultiplier * new GetMultiplierValueBasedOnMagicAndDefense().getDefenseMultiplier()));

                    applyTurnHolder = false;

                    oppNauseaTurnHolder = 0; //reset magic after compounded effects are applied.
                    oppPoisonTurnHolder = 0; 
                    oppWeakenTurnHolder = 0;
                }

                isNormalAttack = false; //resets everything no matter what
                applyTurnHolder = true;

                damageMultiplier = 0;

                wasUserTurn = false; //sets for application of turns
                wasOpponentTurn = true;

                magicOpponentCreditsToApplyClamped = 0;
                oppRetry = true;
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
