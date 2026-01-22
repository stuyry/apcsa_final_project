package Code.Util.OpponenetSequences;

import Code.Battle;
import Code.Abilities.Attack;
import Code.Util.ApplyBasedOnLuck;

public class OpponentHayMakerSequence {

    public void HayMaker() {
        System.out.println("Opponent used HAYMAKER !");

        Battle.opp.setMagicCredits(Battle.opp.getMagicCredits() - Attack.HayMaker.MagicDrain);
        Battle.damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
        Battle.isNormalAttack = true;

        new ApplyBasedOnLuck().applyBasedOnLuck();
    }
}
