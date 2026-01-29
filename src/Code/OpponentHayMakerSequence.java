package Code;

// import Code.Abilities.Attack;

public class OpponentHayMakerSequence {

    public void HayMaker() {
        System.out.println("Opponent used HAYMAKER !");

        Battle.opp.setMagicCredits(Battle.opp.getMagicCredits() - Attack.HayMaker.MagicDrain);
        Battle.damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
        Battle.isNormalAttack = true;

        new ApplyBasedOnLuck().applyBasedOnLuck();
    }
}
