package Code;

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

    public void battle() {
        while(!(protagonistHP.get() <= 0 || antagonistHP.get() <= 0)) {
            turnNumber += 1;
            System.out.println("Turn # : " + turnNumber);
            System.out.println("This Is MY HP: " + protagonistHP.get() + "");
            System.out.println("This is the opponent's HP: " + antagonistHP.get() + "\n");

            System.out.println("Character uses slash: ");
            opp.setHP(antagonistHP.get() - 10);//character.getDMG());

        }

        if (antagonistHP.get() <= 0) {
            System.out.print("YOU WIN");
        }


        // Early testing to figure out why suppliers weren't working (it was because I forgot the .get() **lesson learned lol)
        // System.out.println("This Is MY HP: " + character.getHP() + "");
        // System.out.print("This is the opponent's HP: " + opp.getHP() + "");
    }
}
