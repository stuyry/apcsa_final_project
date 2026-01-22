package Code.Util.CharacterSequences;

import Code.Abilities.Magic;
import Code.Battle;

public class CharacterWeakenSeqeuence {

    public void Weaken() {
        if (Battle.character.getMagicCredits() < Magic.Weaken.MagicDrain) {
            System.out.println("Not Enough magic credits, please try again!");
        } else {
            System.out.println("Character used WEAKEN ! - Draining themselves of 3 Magic Credits !");
            System.out.println("Character inflicted Opponent with WEAKEN, decreasing their damage by 10 points BEFORE multiplication");
            Battle.retryMagic = false;
            Battle.applyTurnHolder = false;

            Battle.characterWeakenMagicTurnHolder += 1;
            Battle.character.setMagicCredits(Battle.character.getMagicCredits() - Magic.Weaken.MagicDrain);
            //lowerAtk = new Magic().getStickArmLowerAtk();

        }
    }
}
