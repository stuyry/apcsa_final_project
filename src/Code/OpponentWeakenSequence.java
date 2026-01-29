package Code;

// import Code.Abilities.Magic;

public class OpponentWeakenSequence {
    public void Weaken() {
        System.out.println("Opponent Used WEAKEN !");
                         Battle.applyTurnHolder = false;

                         Battle.opp.setMagicCredits(Battle.opp.getMagicCredits() - Magic.Weaken.MagicDrain);
                         Battle.oppWeakenTurnHolder += 1;
    }
}
