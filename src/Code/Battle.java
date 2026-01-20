package Code;

import Code.Abilities.Attack;
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

    static double damageMultiplier = 0; //FOR TESTING PURPOSES


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
                    break;

                    case 2:
                    System.out.println("Pick Move: (1: Poison, 2: StickArms, 3: MagicSpellOfNausea)");
                    secondPick = new Reader().getInputAsInt(3);

                    System.out.println("RECEIVED: " + secondPick);

                    switch(secondPick) {
                        case 1: 
                        case 2: 
                        case 3:
                    }
                    break;

                    case 3:
                        opponentTurn = true;
                    break;
                }
                //* new Attack().exampleAttack.getMultiplier()
                opp.setHP(antagonistHP.get() - (int)(character.getDMG() * damageMultiplier/* * lowerDefense / 10 */));//character.getDMG());
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
