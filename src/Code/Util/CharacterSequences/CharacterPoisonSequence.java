package Code.Util.CharacterSequences;

import Code.Abilities.Magic;
import Code.Battle;

public class CharacterPoisonSequence {

    public void Poison() {
        if (Battle.character.getMagicCredits() < Magic.Poison.MagicDrain) {
            System.out.println("Not Enough magic credits, please try again!");
        } else {
            System.out.println("Character used POISON ! - Draining themselves of 5 Magic Credits !");
            System.out.println("");
            Battle.retryMagic = false; //Boolean 
            Battle.applyTurnHolder = false; //Boolean

            Battle.characterPoisonMagicTurnHolder += 1; //Set
            Battle.character.setMagicCredits(Battle.character.getMagicCredits() - Magic.Poison.MagicDrain); //Set

            System.out.print("\n"); //Format
            // System.out.println("TESTING: Magic Turn Holder Value: " + characterPoisonMagicTurnHolder); //Format
        }
    }
}
