package Code;

public class OpponentRechargeSequence {

    public void Recharge() {
        System.out.println("Opponent Used RECHARGE !");
        Battle.applyTurnHolder = false;

        Battle.magicOpponentCreditsToApplyClamped = Math.clamp(Battle.opp.getMagicCredits() + 6, 0, 10);
        Battle.opp.setMagicCredits(Battle.magicOpponentCreditsToApplyClamped);

        Battle.oppRetry = false;
    }
}
