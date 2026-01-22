package Code.Util.CharacterSequences;

import Code.Abilities.Attack;
import Code.Util.ApplyBasedOnLuck;
import Code.Battle;

public class CharacterScratchSequence {
    public void Scratch() {
        System.out.println("Character used SCRATCH !");
        Battle.damageMultiplier = Attack.Scratch.scratchMultipler;
        Battle.isNormalAttack = true;
        Battle.retryMagic = false;
        new ApplyBasedOnLuck().applyBasedOnLuck();
    }
}
