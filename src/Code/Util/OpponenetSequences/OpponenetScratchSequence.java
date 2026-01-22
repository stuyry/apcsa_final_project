package Code.Util.OpponenetSequences;

import Code.Battle;
import Code.Abilities.Attack;
import Code.Util.ApplyBasedOnLuck;

public class OpponenetScratchSequence {

    public void Scratch() {
        System.out.println(
                "Opponent used SCRATCH !");
        System.out.print(
                "\n");

        Battle.damageMultiplier = Attack.Scratch.scratchMultipler;
        Battle.isNormalAttack = true;
        //character.setHP(protagonistHP.get() - 50);//(protagonistHP.get() - (int)(character.getDMG() * damageMultiplier));

        new ApplyBasedOnLuck().applyBasedOnLuck();
    }
}
