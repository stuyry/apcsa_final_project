package Code;

// import Code.Abilities.Attack;

public class OpponentJabSequence {

    public void Jab() {
        System.out.println("Opponent used JAB !");
        System.out.print("\n");

        Battle.damageMultiplier = Attack.Jab.jabMultiplier;
        Battle.isNormalAttack = true;

        new ApplyBasedOnLuck().applyBasedOnLuck();

        Battle.magicOpponentCreditsToApplyClamped = Math.clamp(Battle.opp.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
        Battle.opp.setMagicCredits(Battle.magicOpponentCreditsToApplyClamped);
    }
}
