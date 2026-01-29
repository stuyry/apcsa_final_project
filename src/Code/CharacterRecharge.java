package Code;

public class CharacterRecharge {

    public void Recharge() {
        System.out.println("Character used RECHARGE ! - Regaining 6 Magic Credits !"); //Format

        Battle.magicCharacterCreditsToApplyClamped = Math.clamp(Battle.character.getMagicCredits() + 6, 0, 10); //Apply
        Battle.character.setMagicCredits(Battle.magicCharacterCreditsToApplyClamped); //Apply

        //characterPoisonMagicTurnHolder += 0; //shouldn't impact anything
        Battle.applyTurnHolder = false;

        Battle.retryMagic = false;
    }
}
