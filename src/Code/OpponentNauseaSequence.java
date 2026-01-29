package Code;

// import Code.Abilities.Magic;

public class OpponentNauseaSequence {

    public void Nausea() {
        System.out.println("Opponent used NAUSEA !");

        Battle.opp.setMagicCredits(Battle.opp.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain);
        Battle.oppNauseaTurnHolder += 1;
        //System.out.println("VALUE APPLIED: " + oppNauseaTurnHolder); 
        Battle.applyTurnHolder = false;
    }
}
