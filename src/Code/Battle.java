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

    static int firstPick = -1;
    static int secondPick = -1;

    static int lowerDefense = 0;
    static int lowerAtk = 0;
    static int lowerLuck = 0;

    static long luckyLoopValue = 0;
    static long randomHolder = 0;
    static int readerHolder = 0;

    static double damageMultiplier = 1; //FOR TESTING PURPOSES

    public void applyBasedOnLuck() {
        
        System.out.println("Enter lucky numbers (1 - 10)"); 
        luckyLoopValue = (character.getLuck() / 10); //TODO: add magic values which will either be lost or applied
        if (luckyLoopValue < 10) { 
            while (luckyLoopValue > 0) {
                readerHolder = -1;
                if (luckyLoopValue == (character.getLuck() / 10)) {
                    randomHolder = new RandomNumber(10).getRandomNumber();
                }
                readerHolder = new Reader().getInputAsInt(10);

                if (readerHolder == randomHolder) {
                    System.out.println("LUCKY, move applied.");
                    break;
                }
                if (luckyLoopValue == 1 && readerHolder != randomHolder) {
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
            System.out.println ("Luck is maxed out! Move is automatically applied");
        }
    }

    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            turnNumber += 1;
            System.out.println("Turn # : " + turnNumber);

            System.out.println("Current HP: " + protagonistHP.get() + "");
            System.out.println("Opponent's HP: " + antagonistHP.get() + "\n");

            if (userTurn && !opponentTurn) {
                System.out.println("Pick Move: (1: Attack, 2: Magic, 3: Skip Turn)");
                firstPick = new Reader().getInputAsInt(3);

                System.out.println("RECEIVED: " + firstPick);
                
                switch(firstPick) {
                    case 1: 
                    System.out.println("Pick Move: (1: Scratch, 2: Jab, 3: HayMaker)");
                    secondPick = new Reader().getInputAsInt(3);

                    System.out.println("RECEIVED: " + secondPick);

                    switch(secondPick) {
                        case 1:
                            damageMultiplier = new Attack().getScratchMultiplier();
                        break;

                        case 2:
                            damageMultiplier = new Attack().getJabMultiplier();
                        break;
                            
                        case 3:
                            damageMultiplier = new Attack().getHayMakerMultiplier();
                        break;
                    }
                    applyBasedOnLuck();

                    break; //i got scared but I realized I was missing a break for the first case
                    case 2:
                    System.out.println("Pick Move: (1: Poison, 2: StickArms, 3: MagicSpellOfNausea)");
                    secondPick = new Reader().getInputAsInt(3);

                    System.out.println("RECEIVED: " + secondPick);

                    switch(secondPick) {
                        case 1:
                            lowerDefense = new Magic().getPoisonDefenseNegator(); 
                        case 2: 
                            lowerAtk = new Magic().getStickArmLowerAtk();
                        case 3:
                            lowerLuck = new Magic().getMagicSpellOfNauseaLowerLuck();
                    }
                    break;

                    case 3:
                        opponentTurn = true;
                    break;
                }
                //* new Attack().exampleAttack.getMultiplier()
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier)); //* ((opp.getDEF() - lowerDefense) / 100)));//character.getDMG());
                lowerDefense = 0;
                lowerAtk = 0;
                lowerLuck = 0;
                damageMultiplier = 1; 
                
            }

        }

        if (antagonistHP.get() <= 0) {
            System.out.print("YOU WIN");
        }


        // Early testing to figure out why suppliers weren't working (it was because I forgot the .get() **lesson learned lol)
        // System.out.println("This Is MY HP: " + character.getHP() + "");
        // System.out.print("This is the opponent's HP: " + opp.getHP() + "");
    }
}
