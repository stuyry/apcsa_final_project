package Code.Util.OpponenetSequences;

import Code.Battle;
import Code.Abilities.Magic;

public class OpponentPoisonSequence {

    public void Poison() {
        System.out.println("Opponent used POISON !");

        Battle.opp.setMagicCredits(Battle.opp.getMagicCredits() - Magic.Poison.MagicDrain);
        Battle.oppPoisonTurnHolder += 1;
        Battle.applyTurnHolder = false;
    }
}
